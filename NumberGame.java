package CodSoft;
import java.util.Random;
import java.util.Scanner;

public class NumGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random(); 
        int lowerBound = 1;
        int upperBound = 100;
        int attemptsLimit = 10;
        int rounds = 0;
        int totalAttempts = 0;
        System.out.println("Welcome to the Number Game!");
        
        do {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            System.out.println("Round " + (rounds + 1) + ": Guess a number between " + lowerBound + " and " + upperBound);

            int attempts = 0;
            boolean correctGuess = false;
            
            while (attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    correctGuess = true;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }
            if (!correctGuess) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + targetNumber);
            } else {
                totalAttempts += attempts;
                rounds++;
                System.out.println("Your score for this round: " + attempts + " attempts");
            }
            System.out.print("Do you want to play again? (yes/no): ");
        } while (scanner.next().equalsIgnoreCase("yes"));
        System.out.println("Game Over! You played " + rounds + " rounds and your average score was " + (totalAttempts / rounds) + " attempts per round.");
        scanner.close();
    }
}
