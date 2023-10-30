package GameModes.SinglePlayer;

import java.util.Random;
import java.util.Scanner;

public class PassNumber {
    int passedNumber = 0;
    int guessedNumber = 0;
    int min = 1;
    int max = 100;

    Scanner scanner = new Scanner(System.in);

    private int getRandomNumberFromScope() {

        Random random = new Random();
        int randomInt = random.nextInt(max - min + 1) + min;

       return randomInt;
    }
    private  void GuesTheNumber(int passedNumber ){
        int test = getRandomNumberFromScope();
        System.out.println(test == passedNumber);
    }

    public void StartGame(){
        System.out.print("Enter a number: ");
        System.out.println(scanner.nextInt());
        GuesTheNumber(passedNumber);

    }

}
