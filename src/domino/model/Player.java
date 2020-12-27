package domino.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Player { //максимально 4 игрока, если раздавать по 7 фишек

    private String name;
    private List<Domino> hand;

    public Player(String name,List<Domino> hand){
        this.hand = new LinkedList<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Domino> getHand() {
        return hand;
    }

    public void setHand(List<Domino> hand) {
        this.hand = hand;
    }
}
