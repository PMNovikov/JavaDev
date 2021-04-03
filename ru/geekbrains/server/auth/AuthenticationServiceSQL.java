package ru.geekbrains.server.auth;

import java.sql.*;
import java.util.Set;

public class AuthenticationServiceSQL {
    private static final String[][] defaultEntries = {
            {"l1", "p1", "Nickname1"},
            {"l2", "p2", "Nickname2"},
            {"l3", "p3", "Nickname3"}
    };

    private final String tableExists = "SELECT name FROM sqlite_master WHERE name=?";
    private final String getAuthUser = "select userID, login, password, nickName from users where login = ? and password = ?";
    private final String insertUser = "insert into users (login, password, nickName) values (?, ?, ?)";
    private final String createTableScript = "create table if not exists users (userID integer PRIMARY KEY AUTOINCREMENT, login text NOT NULL, password text NOT NULL, nickName text NOT NULL)";
    private final String updateNickName = "update users set nickName = ? where userID = ?";
    private final Connection conn;

    public AuthenticationServiceSQL() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        this.conn = DriverManager.getConnection("jdbc:sqlite:user.sqlite");
        createTable();

    }

    private void createTable() throws SQLException {
        if (isTableNotExists()){
            Statement stmt = null;
            PreparedStatement pstmt = null;
            try {
                stmt = conn.createStatement();
                stmt.execute(createTableScript);
                pstmt = conn.prepareStatement(insertUser);
                for (String[] line : defaultEntries ){
                    pstmt.setString(1, line[0]);
                    pstmt.setString(2, line[1]);
                    pstmt.setString(3, line[2]);
                    pstmt.addBatch();
                    pstmt.clearParameters();
                }
                int result[] = pstmt.executeBatch();
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
                if (pstmt != null){
                    pstmt.close();
                }
            }
        }

    }

    private boolean isTableNotExists() {
        boolean result = true;
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(tableExists);
            pstmt.setString(1, "users");
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result = false;
            }
            rs.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (pstmt != null){
                try {
                    pstmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return result;
    }

    public void changeNickName(int userID, String newNickName){
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(updateNickName);
            pstmt.setString(1, newNickName);
            pstmt.setInt(2, userID);
            pstmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (pstmt != null){
                try {
                    pstmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    public AuthEntry findUserByCredentials(String login, String password) {
        AuthEntry result = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            pstmt = conn.prepareStatement(getAuthUser);
            pstmt.setString(1, login);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if (rs.next()){
               result = new AuthEntry(rs.getInt("userID"), rs.getString("login"), rs.getString("password"), rs.getString("nickName"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return result;
    }

}
