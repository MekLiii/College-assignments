package GameModes.SinglePlayer;

import java.util.Scanner;

public class SinglePlayerMain {
    Scanner scanner = new Scanner(System.in);
    public SinglePlayerMain(){


        System.out.println("Welcome");
        while (true) {
            System.out.println("Choose a mode:");
            System.out.println("1. Guess number");
            System.out.println("2. Pass number, so computer can guess");
            System.out.println("3. Quit");

            int choice = scanner.nextInt();


            switch (choice) {
                case 1:
                    GuessNumber guessNumber = new GuessNumber();
                    guessNumber.StartGame();
                    break;
                case 2:
                    PassNumber passNumber = new PassNumber();
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
