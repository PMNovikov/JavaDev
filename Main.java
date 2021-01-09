import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        startGame(5);

    }

    static void startGame(int fieldSize){
        char[][] field = new char[fieldSize][fieldSize];
        initFields(field);
        showField(field);
        do {
            handlePlayerMove(field);
            showField(field);

            if (checkFinal(field, 'X')) {
                break;
            }

            System.out.println();

            //handleAIMove(field);
            handleAIMoveNew(field);
            showField(field);

            if (checkFinal(field, 'O')) {
                break;
            }

        } while (true);

    }

    static void handlePlayerMove(char[][] field) {
        int x, y;
        do {
            System.out.println("Please choose coordinates [X, Y]...");
            x = chooseCoordinate('X', field.length);
            y = chooseCoordinate('Y', field.length);
        } while (!isEmptyCell(field, x, y));
        field[x][y] = 'X';
    }

    static void handleAIMove(char[][] field) {
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(field.length);
            y = random.nextInt(field.length);
        } while (!isEmptyCell(field, x, y));
        field[x][y] = 'O';
    }

    static void handleAIMoveNew(char[][] field) {
        //check horizontal user win
        if (!checkHandleAIMove(field)){
            handleAIMove(field);
        }
    }
    static boolean checkHandleAIMove(char[][] field){
        return (checkHandleAIMoveDiagonals(field) || checkHandleAIMoveHorizontal(field));
    }

    static boolean checkHandleAIMoveDiagonals(char[][] field){
        int osnDiagCount = 0;
        int dopDiagCount = 0;
        for (int i=0; i<field.length; i++){
            if (field[i][i] == 'X'){
                osnDiagCount++;
            }else if (field[i][i] =='O'){
                osnDiagCount -= field.length;
            }
            if (field[i][field.length - i -1] == 'X')
            {
                dopDiagCount++;
            }else if (field[i][field.length - i -1] == 'O'){
                dopDiagCount -= field.length;
            }
        }
        if (osnDiagCount > 0 || dopDiagCount > 0)
        {
            for (int i=0; i<field.length; i++){
                if (osnDiagCount > 0){
                   if (field[i][i] == emptyChar()){
                       field[i][i] = 'O';
                       return true;
                   }
                }else {
                    if (field[i][field.length - i - 1] == emptyChar()){
                        field[i][field.length - i - 1] = 'O';
                        return true;
                    }

                }

            }
        }
        return false;
    }

    static boolean checkHandleAIMoveHorizontal(char[][] field) {
        //check horizontal user win
        for (int i=0; i<field.length; i++){
            int horizontalCount = 0;
            int verticalCount = 0;
            for (int j=0; j< field[i].length; j++){
                if (field[i][j] == 'X'){
                    horizontalCount++;
                }else if (field[i][j] == 'O'){
                    horizontalCount -= field.length;
                }
                if (field[j][i] == 'X'){
                    verticalCount++;
                }else if (field[j][i] == 'O'){
                    verticalCount -= field.length;
                }

            }
            if (horizontalCount > 0) {
                //In this line set computer sign
                for (int j=0; j<field.length; j++){
                    if (isEmptyCell(field, i, j)){
                        field[i][j] = 'O';
                        return true;
                    }
                }
            } else if (verticalCount > 0) {
                //In this column set computer sign
                for (int j = 0; j < field.length; j++) {
                    if (isEmptyCell(field, j, i)) {
                        field[j][i] = 'O';
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static boolean checkFinal(char[][] field, char sign) {
        if (checkWin(field, sign)) {
            String name = sign == 'X' ? "Player" : "Computer";
            System.out.printf("Congrats!!! %s is winner!%n", name);
            return true;
        }
        if (!checkEmptyCell(field)) {
            System.out.println("There is draw!!!");
            return true;
        }
        return false;
    }

    static boolean checkWin(char[][] field, char sign){
        boolean winHorizontal;
        boolean winVertical;
        boolean winDiagonalOsn = true;
        boolean winDiagonalDop = true;
        for (int i = 0; i < field.length; i++) {
            winHorizontal = true;
            winVertical = true;
            for (int j = 0; j < field[i].length; j++){
                winHorizontal &= field[i][j] == sign;
                winVertical &= field[j][i] == sign;
            }
            if (winHorizontal || winVertical){
                return true;
            }
            winDiagonalOsn &= field[i][i] == sign;
            winDiagonalDop &= field[i][field[i].length - i -1] == sign;
        }
        if (winDiagonalOsn || winDiagonalDop){
            return true;
        }
        return false;
    }

    //Return true if count of empty cell > 0
    static boolean checkEmptyCell(char[][] field) {
        for (int i = 0; i < field.length; i++){
            for (int j = 0; j < field[i].length; j++){
                if (field[i][j] == emptyChar()){
                    return true;
                }
            }
        }
        return false;
    }

    static char emptyChar(){
        return '-';
    }

    static int chooseCoordinate(char sign, int fieldSize){
        Scanner scanner = new Scanner(System.in);
        int coordinate;

        do {
            System.out.printf("Please enter %s-coordinate [Range 1..%d]...%n", sign, fieldSize);
            coordinate = scanner.nextInt() - 1;
        } while (coordinate < 0 || coordinate >= fieldSize);

        return coordinate;

    }

    static boolean isEmptyCell(char[][] field, int x ,int y){
        return field[x][y] == emptyChar();
    }

    static void initFields(char[][] field){
        for (int i = 0; i < field.length;i++){
            for (int j = 0; j < field[i].length; j++){
                field[i][j] = emptyChar();
            }
        }
    }

    static void showField(char[][] field){
        System.out.print("  ");
        for (int i = 0; i < field.length;i++) {
            System.out.print((i+1));
        }
        System.out.println();
        for (int i = 0; i < field.length;i++){
            System.out.print((i+1) + " ");
            for (int j = 0; j < field[i].length; j++){
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }
}
