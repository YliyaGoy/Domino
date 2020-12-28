package service;
import model.Deck;
import model.Domino;

import java.util.ArrayList;

public class DeckService {

    public Domino getRandomDomino(Deck deck) {
        Domino randomDice = deck.getDeck().get(interval(1,deck.getDeck().size()) - 1);
        deck.getDeck().remove(randomDice);
        return randomDice;
    }

    public ArrayList<Domino> bunch() {
        ArrayList<Domino> deck = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            for (int j = 0; j <= i; j++) {
                Domino domino = new Domino(-1, -1);
                domino.setLeftNumber(i);
                domino.setRightNumber(j);
                deck.add(domino);
            }
        }
        return deck;
    }

    public int interval(int min, int max) {
        max -= min;
        return (int)(Math.random() * ++max) + min;
    }
}


