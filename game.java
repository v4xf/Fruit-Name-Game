import java.util.Scanner;
import java.util.Random;

public class game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] words = {"apple", "banana", "cherry", "grape", "orange", "strawberry", "watermelon"};
        String wordToGuess = words[random.nextInt(words.length)];

        int maxAttempts = 6;
        int attempts = 0;
        StringBuilder guessedWord = new StringBuilder(wordToGuess.length());
        for (int i = 0; i < wordToGuess.length(); i++) {
            guessedWord.append('_');
        }

        System.out.println("------WELCOME------");
        System.out.println("You have " + maxAttempts + " attempts to guess the word.");

        while (attempts < maxAttempts) {
            System.out.println("Current word: " + guessedWord.toString());

            System.out.print("Enter a letter guess: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            if (!Character.isLetter(guess)) {
                System.out.println("Please enter a valid letter.");
                continue;
            }

            if (wordToGuess.contains(String.valueOf(guess))) {
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == guess) {
                        guessedWord.setCharAt(i, guess);
                    }
                }
            } else {
                attempts++;
                System.out.println("Incorrect. Attempts left: " + (maxAttempts - attempts));
            }

            if (guessedWord.toString().equals(wordToGuess)) {
                System.out.println("");
                System.out.println("Congratulations :) \nYou've guessed the word: " + wordToGuess);
                System.out.println("");
                break;
            }
        }

        if (attempts >= maxAttempts) {
            System.out.println("");
            System.out.println("Game Over :( \nThe word was: " + wordToGuess);
            System.out.println("");
        }

        scanner.close();
    }
}
