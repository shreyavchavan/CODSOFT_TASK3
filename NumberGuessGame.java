import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 50;
        int attemptsLimit = 5;
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Guess a number between " + minRange + " and " + maxRange + ".");
            System.out.println("You have " + attemptsLimit + " attempts.");

            while (attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the number correctly in ");
                    score++;
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < generatedNumber) {
                    System.out.println("low! Try again.");
                } else {
                    System.out.println("high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You have used all your attempts. The number was: " + generatedNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = sc.next().toLowerCase();

            if (!playChoice.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Game Over. Your score is: " + score);
    }
}
