package GameModes.SinglePlayer;

import logSystem.logSystem;
import utils.utils;

import java.util.Scanner;

import Player.Player;

public class GuessNumber {
    boolean numberIsGuessed = false;
    int guessedNumber = 0;
    int trials = 0;
    Scanner scanner = new Scanner(System.in);
    logSystem log;
    public  GuessNumber(logSystem log){
        this.log = log;
    }
   public  boolean StartGame(Player player) {


        int generatedNumber = utils.generateRandomNumberWithScope();

        while (!numberIsGuessed) {
            try {
                System.out.print("Guess the number, pass a number: ");
                guessedNumber = Integer.parseInt(scanner.nextLine());
                player.incrementTrials();
                if (guessedNumber == generatedNumber) {
                    System.out.println("Correct number: " + generatedNumber);
                    log.addLineToFile("Correct number: " + generatedNumber);
                    numberIsGuessed = true;
                } else {
                    utils.checkIfNumberIsHigherOrLower(guessedNumber, generatedNumber);
                    System.out.println("Wrong number");
                    log.addLineToFile("Wrong number");
                    trials++;
                }
            } catch (NumberFormatException e) {
                System.out.println("Something went wrong with the program. Make sure you passed a number.");
            }
        }
        return numberIsGuessed;
    }
}
