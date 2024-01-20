package GameModes.Multiplayer;

import GameModes.SinglePlayer.GuessNumber;
import Player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import logSystem.logSystem;

public class MultiPlayerMain {
    private List<Player> players;
    private Scanner scanner = new Scanner(System.in);
    private logSystem log;
    private Player leader;
    public Player winner;

    public MultiPlayerMain(logSystem log){
        this.log = log;
        this.leader = null;
        players = new ArrayList<>();
        System.out.println("Welcome to Multiplayer Mode");
        System.out.println("Enter the number of players:");
        int numPlayers = scanner.nextInt();
        for(int i = 0; i < numPlayers; i++){
            System.out.println("Enter name for player " + (i+1) + ":");
            String playerName = scanner.next();
            players.add(new Player(playerName));
        }
        
        startGame();
    }
    public void setLeader(Player player) {
        if (this.leader != null) {
            this.leader.setLeader(false);
        }
        player.setLeader(true);
        this.leader = player;
    }
    public Player getWinner(){
        return winner;
    }
    public void startGame(){
        boolean allGuessed;
        do {
            allGuessed = true;
            for(Player player : players){
                if (!player.hasGuessed()) {
                    System.out.println(player.getName() + "'s turn.");
                    GuessNumber guessNumber = new GuessNumber(log); // Create a new GuessNumber object for each player
                    boolean isGuessed = guessNumber.StartGame(player);
                    player.incrementTrials(); // Increment trials every time a guess is made
                    if(isGuessed){
                        System.out.println(player.getName() + " has guessed the number correctly!");
                        player.setHasGuessed(true);
                    } else {
                        allGuessed = false;
                    }
                }
            }
        } while (!allGuessed);
    
        Player winner = players.get(0);
        for (Player player : players) {
            if (player.getTrials() < winner.getTrials()) {
                winner = player;
                this.winner = winner;
            }
        }
        log.addLineToFile("winner: " + winner.getName());
        System.out.println("The winner is " + winner.getName() + " with " + winner.getTrials() + " trials!");
    }
}