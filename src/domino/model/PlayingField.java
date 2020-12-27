package domino.model;

import java.util.ArrayList;
import java.util.LinkedList;

public class PlayingField {

    private ArrayList<Domino> bones;

    public PlayingField(ArrayList<Domino> bones) {
        this.bones = bones;
    }

    public ArrayList<Domino> getBones() {
        return bones;
    }

    public void setBones(ArrayList<Domino> bones) {
        this.bones = bones;
    }
}
