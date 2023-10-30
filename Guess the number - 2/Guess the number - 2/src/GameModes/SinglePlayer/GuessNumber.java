package GameModes.SinglePlayer;

import Player.Player;
import utils.utils;
import fileSystem.fileSysyem;

import java.util.Objects;
import java.util.Scanner;

public class GuessNumber {
    boolean numberIsGuessed = false;
    int guessedNumber = 0;
    int trials = 0;
    Scanner scanner = new Scanner(System.in);

   public  void StartGame() {
        System.out.print("Enter a nickname: ");
        Player player = new Player(scanner.nextLine());
        if (!Objects.equals(player.previousAttempts, "")) {
            System.out.println("Your previous attempts: " + player.previousAttempts);
        }


        int generatedNumber = utils.generateRandomNumberWithScope();

        while (!numberIsGuessed) {
            try {
                System.out.print("Guess the number, pass a number: ");
                guessedNumber = Integer.parseInt(scanner.nextLine());
                if (guessedNumber == generatedNumber) {
                    System.out.println("Correct number: " + generatedNumber);
                    fileSysyem.saveResultsInFile(player.playerName, trials);
                    numberIsGuessed = true;
                } else {
                    utils.checkIfNumberIsHigherOrLower(guessedNumber, generatedNumber);
                    System.out.println("Wrong number");
                    trials++;
                }
            } catch (NumberFormatException e) {
                System.out.println("Something went wrong with the program. Make sure you passed a number.");
            }
        }
    }
}
