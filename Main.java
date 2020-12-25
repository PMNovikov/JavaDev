import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner scanner;
    private static Random rnd;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        rnd = new Random();
        mainMenu();
    }

    public static void mainMenu(){
        int numGame;
        do {
            System.out.println("-======================-");
            System.out.println("|   Select the game:   |");
            System.out.println("| 1 - Guess the number |");
            System.out.println("| 2 - Guess the word   |");
            System.out.println("| 0 - Exit             |");
            System.out.println("-======================-");
            do {
                System.out.print("You choice: ");
                numGame = scanner.nextInt();
            } while (numGame < 0 || numGame > 2);
            if (numGame == 1) {
                startGameGuessNumber();
            } else if (numGame == 2) {
                startGameGuessWord();
            }
        } while (numGame != 0);
    }

    public static void startGameGuessNumber(){
        int answer;
        System.out.println("Start game \"Guess the Number\"");
        do {
            playGameGuessNumber(3);
            do {
                System.out.printf("Do you play again? (0 - No / 1 - Yes):");
                answer = scanner.nextInt();
            } while (answer < 0 || answer > 1);
        } while (answer == 1);
        System.out.println("Good by!");
    }

    public static void playGameGuessNumber(int maxTry){
        int number = rnd.nextInt(10);
        int enterNumber = 0;
        for (int i = 0; i < maxTry; i++){
            do {
                System.out.printf("Enter number from 0 to 9 (try %d from %d): ", i + 1, maxTry);
                enterNumber = scanner.nextInt();
            } while (enterNumber < 0 || enterNumber > 9);
            if (enterNumber > number){
                System.out.printf("The number is less then %d\n", enterNumber);
            } else if (enterNumber < number){
                System.out.printf("The number is greater then %d\n",enterNumber);
            } else {
                break;
            }
        }
        if (number == enterNumber){
            System.out.printf("Congratulations! You guessed the number %d!\n", number);
        } else {
            System.out.printf("Sorry! You haven't guessed the number %d.\n", number);
        }
    }

    public static void startGameGuessWord(){
        String[] arrayOfWord = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int numWord = rnd.nextInt(arrayOfWord.length);
        String word = arrayOfWord[numWord];

        System.out.println("Start game \"Guess the Word\"");
        System.out.println("-=========================-");
        System.out.println("I made a word. Try to guess it.");
        String youWord = "";
        do{
            System.out.print("You word: ");
            do {
                youWord = scanner.nextLine();
            } while (youWord.equals(""));
            if (!word.equals(youWord)){
                System.out.print("Wrong word: ");
                for (int i = 0; i < 15; i++){
                    if (i >= word.length() || i >= youWord.length()) {
                        System.out.print("#");
                    } else if (word.charAt(i) == youWord.charAt(i)){
                        System.out.print(word.charAt(i));
                    } else {
                        System.out.print("#");
                    }
                }
                System.out.println("");
            }
        } while (!word.equals(youWord));
        System.out.printf("Congratulations! You guessed the word %s!\n", word);
    }

}
