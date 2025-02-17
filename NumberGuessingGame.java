import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 5;
        int score = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess the number between " + minRange + " and " + maxRange + ".");
        
        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            while (attempts < attemptsLimit && !guessedCorrectly) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "/" + attemptsLimit + "): ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    guessedCorrectly = true;
                    score++;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
            }
            
            System.out.print("Would you like to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }
        
        System.out.println("Thank you for playing! Your score: " + score);
        scanner.close();
    }
}