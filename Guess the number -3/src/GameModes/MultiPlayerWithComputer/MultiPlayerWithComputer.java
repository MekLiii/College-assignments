package GameModes.MultiPlayerWithComputer;

import Difficulty.Difficulty;

import java.util.Random;
import java.util.Scanner;
import logSystem.logSystem;

public class MultiPlayerWithComputer {
    private boolean playerTurn;
    private final Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    logSystem log;

    public MultiPlayerWithComputer(logSystem Log) {
        playerTurn = random.nextBoolean();
        this.log = Log;
    }

    private void switchTurn() {
        playerTurn = !playerTurn;
    }

    public void startGame() {
        System.out.println("Welcome in multiplayer");
        System.out.println(playerTurn ? "You start first" : "Computer starts first");
        playGame();
    }

    private void playGame() {
        int targetNumber = random.nextInt(Difficulty.max) + 1;
        int currentPlayerGuess = 0;
        int computerGuess;

        while (true) {
            if (playerTurn) {
                System.out.println("Your turn. Guess the number" + " " + "from " +Difficulty.min + " " + "to " + Difficulty.max);
                 currentPlayerGuess = scanner.nextInt();

                if (currentPlayerGuess < targetNumber) {
                    System.out.println("Number is higher");
                }
                if(currentPlayerGuess > targetNumber) {
                    System.out.println("Number is lower");
                }

                if (currentPlayerGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number.");
                    log.addLineToFile("Player guessed the number. " + targetNumber );
                    break;
                }
            } else {
                System.out.println("Computer's turn.");
                computerGuess = random.nextInt(Difficulty.max) + 1;
                System.out.println("Computer guess: " + computerGuess );

                if (computerGuess == targetNumber) {
                    System.out.println("Computer guessed the number. You lost.");
                    log.addLineToFile("Computer guessed the number. " + targetNumber );
                    break;
                }
            }

            switchTurn();
        }
    }
}
