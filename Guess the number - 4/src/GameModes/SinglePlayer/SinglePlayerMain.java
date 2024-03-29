package GameModes.SinglePlayer;

import logSystem.logSystem;

import java.util.Scanner;

import Player.Player;

public class SinglePlayerMain {
    Scanner scanner = new Scanner(System.in);
    public SinglePlayerMain(logSystem log){


        System.out.println("Welcome");
        while (true) {
            System.out.println("Choose a mode:");
            System.out.println("1. Guess number");
            System.out.println("2. Pass number, so computer can guess");
            System.out.println("3. Quit");

            int choice = scanner.nextInt();
            Player player = new Player("");


            switch (choice) {
                case 1:
                    GuessNumber guessNumber = new GuessNumber(log);
                    log.addLineToFile("mode: GuessNumber");
                    guessNumber.StartGame(player);
                    break;
                case 2:
                    PassNumber passNumber = new PassNumber(log);
                    log.addLineToFile("mode: PassNumber");
                    passNumber.StartGame();

                    break;
                case 3:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }


}
