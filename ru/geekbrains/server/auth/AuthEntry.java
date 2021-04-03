package ru.geekbrains.server.auth;

import java.util.Objects;

public class AuthEntry {
    private int id;
    private String login;
    private String password;
    private String nickname;

    public AuthEntry(int id,String login, String password, String nickname) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.nickname = nickname;
    }

    public int getId() { return id; }
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthEntry authEntry = (AuthEntry) o;
        return Objects.equals(login, authEntry.login) &&
                Objects.equals(password, authEntry.password) &&
                Objects.equals(nickname, authEntry.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, nickname);
    }
}
