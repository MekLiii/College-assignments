import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {

    private static int generateRandomNumberWithScope() {
        int min = 0;
        int max = 100;
        return (int) (Math.random() * (max - min) + min);
    }

    private static void checkIfNumberIsHigherOrLower(int guessedNumber, int generatedNumber) {
        if (guessedNumber > generatedNumber) {
            System.out.println("Tip: Generated number is lower");
        } else if (guessedNumber < generatedNumber) {
            System.out.println("Tip: Generated number is higher");
        }
    }

    private static void saveResultsInFile(String fileName, int attempts) {
        String filePath = fileName + ".txt";
        try (FileWriter fileWriter = new FileWriter(filePath, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(Integer.toString(attempts) + ",");
        } catch (IOException e) {
            System.err.println("Something went wrong with saving result");
        }
    }

    private static String checkIfUserAlreadyExists(String nickname) {
        String previousAttempts = "";
        String filePath = nickname + ".txt";
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("Welcome again " + nickname);
            Path path = Paths.get(filePath);
            try {
                List<String> lines = Files.readAllLines(path);
                previousAttempts = String.join("", lines);
                return previousAttempts;
            } catch (IOException e) {
                System.err.println("Cannot read file");
            }
        }
        System.out.println("Welcome new player " + nickname);
        return "";
    }

    public static void main(String[] args) {
        boolean numberIsGuessed = false;
        int guessedNumber = 0;
        int trials = 0;
        Scanner scanner = new Scanner(System.in);

        class Player {
            public String playerName = "";
            public String previousAttempts = "";

            public Player(String nick) {
                playerName = nick;
                previousAttempts = checkIfUserAlreadyExists(this.playerName);
            }
        }

        System.out.print("Enter a nickname: ");
        Player player = new Player(scanner.nextLine());
        if (!Objects.equals(player.previousAttempts, "")) {
            System.out.println("Your previous attempts: " + player.previousAttempts);
        }

        int generatedNumber = generateRandomNumberWithScope();

        while (!numberIsGuessed) {
            try {
                System.out.print("Guess the number, pass a number: ");
                guessedNumber = Integer.parseInt(scanner.nextLine());
                if (guessedNumber == generatedNumber) {
                    System.out.println("Correct number: " + generatedNumber);
                    saveResultsInFile(player.playerName, trials);
                    numberIsGuessed = true;
                } else {
                    checkIfNumberIsHigherOrLower(guessedNumber, generatedNumber);
                    System.out.println("Wrong number");
                    trials++;
                }
            } catch (NumberFormatException e) {
                System.out.println("Something went wrong with the program. Make sure you passed a number.");
            }
        }
        scanner.close();
    }
}
