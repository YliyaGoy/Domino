package model;

import java.util.LinkedList;

public class Player {

    private LinkedList<Domino> playerDomino;

    public LinkedList<Domino> getPlayerDomino() {
        return playerDomino;
    }

    public void setPlayerDomino(LinkedList<Domino> playerDomino) {
        this.playerDomino = playerDomino;
    }
}
