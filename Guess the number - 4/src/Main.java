import Difficulty.Difficulty;
import GameModes.MultiPlayerWithComputer.MultiPlayerWithComputer;
import GameModes.Multiplayer.MultiPlayerMain;
import GameModes.SinglePlayer.SinglePlayerMain;
import GameModes.Tournament.TournamentMain;
import Player.Player;
import logSystem.logSystem;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a nickname: ");
            Player player = new Player(scanner.nextLine());
            logSystem log = new logSystem(player.playerName);
            log.createLogFile();

            if (!Objects.equals(player.previousAttempts, "")) {
                System.out.println("Your previous attempts: " + player.previousAttempts);
            }

            while (true) {
                Difficulty choseDifficulty = new Difficulty();
                choseDifficulty.choseDifficulty();

                boolean continueGame = true;
                while (continueGame) {
                    System.out.println("Choose an option:");
                    System.out.println("1. Single Player");
                    System.out.println("2. Multiplayer with computer");
                    System.out.println("3. Multiplayer");
                    System.out.println("4. Go back to difficulty selection");
                    System.out.println("5. Tournament");
                    System.out.println("5. Quit");

                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            new SinglePlayerMain(log);
                            log.addLineToFile("mode: singlePlayer");
                            break;
                        case 2:
                            MultiPlayerWithComputer multiPlayer = new MultiPlayerWithComputer(log);
                            log.addLineToFile("mode: multiPlayer with computer");
                            multiPlayer.startGame();
                            break;
                        case 3:
                            new MultiPlayerMain(log);
                            log.addLineToFile("mode: multiPlayer");
                            break;
                        case 4:
                            System.out.println("Going back to difficulty selection");
                            continueGame = false;
                            break;
                            case 5:
                            System.out.println("Tournament");
                            System.out.println("Choose the type of tournament: ");
                            System.out.println("1. BO1");
                            System.out.println("2. BO3");
                            System.out.println("3. BO5");
                        
                            int tournamentType = scanner.nextInt();
                            List<MultiPlayerMain> games = new ArrayList<>();
                        
                            switch (tournamentType) {
                                case 1:
                                    games.add(new MultiPlayerMain(log));
                                    break;
                                case 2:
                                    for (int i = 0; i < 3; i++) {
                                        games.add(new MultiPlayerMain(log));
                                    }
                                    break;
                                case 3:
                                    for (int i = 0; i < 5; i++) {
                                        games.add(new MultiPlayerMain(log));
                                    }
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please select a valid option.");
                                    break;
                            }
                        
                            new TournamentMain(games);
                            break;
                        case 6:
                            System.out.println("Goodbye!");
                            System.exit(0);

                        default:
                            System.out.println("Invalid choice. Please select a valid option.");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong. Please try again.");
            System.out.println(e);
        }

    }
}
