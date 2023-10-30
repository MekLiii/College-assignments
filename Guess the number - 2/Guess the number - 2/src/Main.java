import GameModes.SinglePlayer.GuessNumber;
import GameModes.SinglePlayer.SinglePlayerMain;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome");
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Single Player");
            System.out.println("2. Multiplayer");
            System.out.println("3. Quit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    SinglePlayerMain singlePlayer = new SinglePlayerMain();
                    break;
                case 2:
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
