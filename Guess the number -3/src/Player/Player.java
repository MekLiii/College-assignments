package Player;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import Difficulty.Difficulty;
import logSystem.logSystem;

public class Player {
    private int trials = 0;
    private boolean hasGuessed = false;
    public String playerName = "";
    public String previousAttempts = "";

    logSystem log = new logSystem(playerName);

    

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

    public Player(String nick) {
        playerName = nick;
        previousAttempts = checkIfUserAlreadyExists(this.playerName);
        log.addLineToFile("Difficulty " + Difficulty.getDificuly());
        File file = new File(this.playerName + ".txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Cannot create file");
            }
        }
    }
    public String getName() {
        return playerName;
    }
    public void incrementTrials() {
        log.addLineToFile("player: " + playerName + " trials: " + trials);
        trials++;
    }
    public int getTrials() {
        return trials;
    }
    public void setHasGuessed(boolean hasGuessed) {
        this.hasGuessed = hasGuessed;
    }
    public boolean hasGuessed() {
        log.addLineToFile("player: " + playerName + " hasGuessed: " + hasGuessed);
        return hasGuessed;
    }
}
