package service;
import model.Deck;
import model.Domino;

import java.util.LinkedList;

public class DistributorService {
    public LinkedList<Domino> distribute(Deck deck) { //обычная раздача
        int randomIndex;
        LinkedList<Domino> dom = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            randomIndex = interval(0, deck.getDeck().size() - 1);
            dom.add(deck.getDeck().get(randomIndex));
            deck.getDeck().remove(randomIndex);
        }
        return dom;
    }

    public int interval(int min, int max) {
        max -= min;
        return (int)(Math.random() * ++max) + min;
    }
}
