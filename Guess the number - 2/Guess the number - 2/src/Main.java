import Difficulty.Difficulty;
import GameModes.MultiPlayerMain;
import GameModes.SinglePlayer.SinglePlayerMain;
import Player.Player;
import logSystem.logSystem;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome");
        System.out.print("Enter a nickname: ");
        Player player = new Player(scanner.nextLine());
        logSystem log = new logSystem(player.playerName);
        log.createLogFile();

        if (!Objects.equals(player.previousAttempts, "")) {
            System.out.println("Your previous attempts: " + player.previousAttempts);
        }

        Difficulty choseDifficulty = new Difficulty();
        choseDifficulty.choseDifficulty();
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Single Player");
            System.out.println("2. Multiplayer");
            System.out.println("3. Quit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    SinglePlayerMain singlePlayer = new SinglePlayerMain(log);
                    log.addLineToFile("mode: singlePlayer");
                    break;
                case 2:
                    MultiPlayerMain multiPlayer = new MultiPlayerMain(log);
                    log.addLineToFile("mode: multiPlayer");
                    multiPlayer.startGame();
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
