package Player;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Player {


    public String playerName = "";
    public String previousAttempts = "";

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
    }
}
