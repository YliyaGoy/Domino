package model;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Domino> deck = new ArrayList<>();

    public ArrayList<Domino> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Domino> deck) {
        this.deck = deck;
    }

    public int size() {
        return deck.size();
    }
}
