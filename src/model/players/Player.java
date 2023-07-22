package model.players;

import model.tiles.HandTiles;
import model.tiles.PlayerTableTiles;
import model.tiles.Tile;
import model.tiles.Tiles;
import utils.TileUtils;

import java.util.List;
import java.util.Objects;

public class Player{
    protected final String name;
    protected HandTiles hand;
    private final PlayerTableTiles table;

    public Player(String name, List<Tile> hand) {
        this.name = name;
        this.hand = new HandTiles(hand);
        this.table = new PlayerTableTiles();
    }

    public String getName() {
        return name;
    }

    public Tiles getHand() {
        return hand;
    }

    public Tiles getTable() {
        return table;
    }

    public void setHand(HandTiles tiles) {
        this.hand = tiles;
    }

    public void addTile(Tile tile) {
        this.hand.add(tile);
    }

    public void plays(Tile tile) {
        this.hand.remove(tile);
        TileUtils.resetEntity(tile);
        this.table.add(tile);
    }

    public void action() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '}';
    }
}
