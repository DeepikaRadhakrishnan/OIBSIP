package com.ProjectPackage;
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();

	        int totalScore = 0;
	        int round = 1;
	        String playAgain;

	        System.out.println(" Welcome to the Guess the Number Game!");

	        do {
	            int numberToGuess = rand.nextInt(100) + 1; // Number between 1 to 100
	            int attempts = 5;
	            int points = 100;
	            boolean guessedCorrectly = false;

	            System.out.println("\n Round " + round);
	            System.out.println("You have to select a number between 1 and 100 \nYou have " + attempts + " attempts.");

	            for (int i = 1; i <= attempts; i++) {
	                System.out.print("Attempt " + i + ": Enter your guess: ");
	                int guess = sc.nextInt();

	                if (guess == numberToGuess) {
	                    System.out.println(" Correct! You've guessed the number in " + i + " attempts.");
	                    points -= (i - 1) * 20; // Deduct points for each wrong attempt
	                    totalScore += points;
	                    guessedCorrectly = true;
	                    break;
	                } else if (guess < numberToGuess) {
	                    System.out.println(" Too low!");
	                } else {
	                    System.out.println(" Too high!");
	                }
	            }

	            if (!guessedCorrectly) {
	                System.out.println(" You failed! The correct number was: " + numberToGuess);
	                points = 0;
	            }

	            System.out.println("Points earned this round: " + points);
	            System.out.println("Total Score: " + totalScore);

	            System.out.print("\nDo you want to play another round? (yes/no): ");
	            sc.nextLine(); // clear buffer
	            playAgain = sc.nextLine().toLowerCase();
	            round++;

	        } while (playAgain.equals("yes"));

	        System.out.println("\n Game Over! Your final score is: " + totalScore);
	        System.out.println("Thank you for playing!");

	        sc.close();
	    }
}	
