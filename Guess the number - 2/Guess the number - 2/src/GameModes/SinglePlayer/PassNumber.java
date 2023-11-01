package GameModes.SinglePlayer;

import Difficulty.Difficulty;
import logSystem.logSystem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PassNumber {


    int min = Difficulty.min;
    int max = Difficulty.max;
    int passedNumber = 0;
    Scanner scanner = new Scanner(System.in);
    private static int findMidValue(int num1, int num2) {
        return (num1 + num2) / 2;
    }
    private logSystem log;
    public PassNumber(logSystem Log){
        this.log = Log;
    }
    private void GuessTheNumber(int target) {
        int low = min;
        int high = max;
        int attempts = 0;

        while (low <= high) {
            int mid = findMidValue(low, high);
            attempts++;

            if (mid == target) {
                System.out.println("Guessed the number " + target + " in " + attempts + " attempts.");
                log.addLineToFile("Computer guessed the number " + target + " in " + attempts + " attempts.");
                return;
            } else if (mid < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("The number " + target + " was not found in the specified range.");
    }


    public void StartGame(){
        System.out.print("Enter a number: ");
        passedNumber = scanner.nextInt();
        log.addLineToFile("Passed number: " + passedNumber);
        GuessTheNumber(passedNumber);

    }

}
