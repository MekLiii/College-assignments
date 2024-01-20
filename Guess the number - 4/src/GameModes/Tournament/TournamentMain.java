package GameModes.Tournament;

import GameModes.Multiplayer.MultiPlayerMain;
import Player.Player;

import java.util.List;

public class TournamentMain {
    private List<MultiPlayerMain> games;
    private Player champion;

    public TournamentMain(List<MultiPlayerMain> games) {
        this.games = games;
        this.champion = null;
    }

    public void setChampion(Player player) {
        if (this.champion != null) {
            this.champion.setChampion(false);
        }
        player.setChampion(true);
        this.champion = player;
    }

    public void startTournament() {
        for (MultiPlayerMain game : games) {
            game.startGame();
            Player gameWinner = game.getWinner();
            if (this.champion != null && this.champion.equals(gameWinner)) {
                this.champion = null;
            } else if (this.champion == null) {
                this.champion = gameWinner;
                this.champion.setChampion(true);
            }
        }
    }
}
