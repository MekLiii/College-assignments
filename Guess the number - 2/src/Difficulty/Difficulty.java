package Difficulty;

import GameModes.SinglePlayer.SinglePlayerMain;

import java.util.Scanner;

public class Difficulty {
    Scanner scanner = new Scanner(System.in);
    public static int min = 1;
    public static int max = 100;
      public Difficulty(){
          System.out.println("Welcome");
      }
      public void choseDifficulty(){
        System.out.println("Choose an difficulty level:");
        System.out.println("1. easy");
        System.out.println("2. medium");
        System.out.println("3. hard");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("easy mode");
                break;
            case 2:
                System.out.println("medium mode");
                max = 10000;
                break;
            case 3:
                max = 1000000;
                System.out.println("hard mode");
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }
    }

}
