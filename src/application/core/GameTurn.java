package application.core;

import model.players.Player;

import java.util.ArrayList;
import java.util.List;

public class GameTurn {
    private int round;
    private final List<Player> turns;
    private final List<Player> original;

    public GameTurn(List<Player> players, Player startingPlayer) {
        this.round = 0;
        this.original = players;
        int startingIndex = players.indexOf(startingPlayer);
        this.turns = new ArrayList<>();
        this.turns.add(startingPlayer);
        for (int i = 1; i <= 3; i++) {
            int nextIndex = (startingIndex + i) % players.size();
            Player nextPlayer = players.get(nextIndex);
            this.turns.add(nextPlayer);
        }
    }

    public int next() {
        Player player = this.turns.remove(0);
        this.turns.add(player);
        this.round++;
        return this.original.indexOf(player);
    }

    public Player peek() {
        return this.turns.get(0);
    }

    public List<Player> peek3() {
        return new ArrayList<>(this.turns.subList(0, 3));
    }


    public int getRound() {
        return round;
    }
}
