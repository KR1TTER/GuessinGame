/*
 *==================================================
 * CS141
 * LAB 4: Guessing Game
 * authors: Jack Pate, Aaron Tripp, Daniel Grijalva
 *==================================================
 * Description: This program is supposed to allow a
 * user to play a guessing game in which the program
 * thinks up an integer and allows the user to make
 * guesses until the answer is guessed right.
 *==================================================
 */

import java.util.*;

public class GuessingGame {

    public static final int LIMIT = 100;

    // main method
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        int Guesses = 0;
        int totalGuesses = 0;
        int totalGames = 0;
        int bestGame = 1000;
        String answer = "";
        intro();
        boolean end = false;

        while(!end) {
            Guesses = playGame(s, r, totalGuesses);
            totalGuesses += Guesses;
            if (Guesses < bestGame) {
                bestGame = Guesses;
            }totalGames++;

            System.out.print("Do you want to play again? ");
            answer = s.next();
            if (answer.startsWith("y") || answer.startsWith("Y")) {
                end = false;
            }else if (answer.startsWith("n") || answer.startsWith("N")) {
                end = true;
            }
        }
        results(totalGuesses, totalGames, bestGame);
    }

    // Introduces the user to the game.
    public static void intro() {
        System.out.println("This program allows you to play a guessing game.");
        System.out.println("I will think of a number between 1 and ");
        System.out.println("100 and will allow you to guess until");
        System.out.println("you get it.  For each guess, I will tell you");
        System.out.println("whether the right answer is higher or lower");
        System.out.println("than your guess.");
    }

    // Tells the user to make a guess and keeps track of
    // how many guesses it takes til the right answer.
    public static int playGame(Scanner s, Random r, int totalGuesses) {
        System.out.println();
        System.out.println("I'm thinking of a number between 1 and " + LIMIT + "...");
        int num = r.nextInt(LIMIT) + 1;
        int numGuess = 0;
        boolean end = false;

        while (!end) {
            System.out.print("Your guess? ");
            int guess = s.nextInt();
            numGuess++;
            totalGuesses += numGuess;

            if (guess == num) {
                if (numGuess == 1) {
                    System.out.println("You got it right in 1 guess.");
                    end = true;
                    break;
                }
                System.out.println("You got it right in " + numGuess + " guesses");
                end = true;
            }else if (guess > LIMIT || guess < 1) {
                System.out.println("Answer is out of range");
            }else if (guess > num) {
                System.out.println("It's lower.");
            }else{
                System.out.println("It's higher.");
            }
        }
        return numGuess;
    }

    // Displays the results of the games and guesses.
    public static void results(int totalGuesses, int totalGames, int bestGame) {
        System.out.println();
        System.out.println("Overall results:");
        System.out.println("    total games   = " + totalGames);
        System.out.println("    total guesses = " + totalGuesses);
        System.out.print("    guesses/game  = ");
        System.out.printf("%.1f", (double)totalGuesses / totalGames);
        System.out.println();
        System.out.println("    best game     = " + bestGame);
    }
}