package domino.service;

import domino.model.Domino;
import domino.model.Player;
import java.util.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by gorbunova_ju_p on 13.10.2020.
 */
public class DominoService {
    public static List<Domino> hand = new LinkedList<>();
    public static List<Domino> deck = new ArrayList<>();
    public static List<Player> players = new ArrayList<>();

    public void addDomino(Domino domino){ //докидывает домино в руку
        hand.add(domino);
    }

    public Domino remove(int index){
        /*удаление домино и запоминание, нужно для того,
        чтобы сделать проверку на домино которые еще могут быть на доске*/
        Domino domino = hand.get(index);
        hand.remove(index);
        return domino;
    }

    public void addHandDomino(){ //которые не выйдут на руки, они поадут в базар
        int i = getI();
        int j = 0;
        while (j <= i) {
            hand.add(deck.get(j));
            deck.remove(j);
            j++;
        }
    }

    public int findFirst(){ //первый игрок
        int i = 0;
        int count = 0;
        int first,second;
        while(i < players.size()){
            first = maxInHandOnePlayer(i);
            second = maxInHandOnePlayer(i + 1);
            if(first < second){
                count = i+1;
            }
            count = i;
            i++;
        }
        return count;
    }
    public int maxInHandOnePlayer(int d){
        int left,right,max = 0,min,left2,right2;

        List<Domino> pl = players.get(d).getHand();
        int i = 0;
        while (i < pl.size()) {
            Domino k = pl.get(i);
            left = k.getLeftNumber();
            right = k.getRightNumber();

            Domino g = pl.get(i+1);
            left2 = g.getLeftNumber();
            right2 = g.getRightNumber();

            max = right + left;
            min = right2 + left2;

            if(max < min){ max = min; }
            i++;
        }
        return max;
    }

    public int getI(){
        int i = 0;
        int count = players.size(); //кол-во игроков
        if(count == 2){
            i = 7;
        }
        if(count == 3){
            i = 6;
        }
        if(count == 4){
            i = 5;
        }
        return i;
    }

    public void deckBuilding(){
        for(int i = 0; i <= 6 ;i++){
            for(int j = 0; j <= i ; j++) {
                deck.add(new Domino(i,j));
            }
        }
        Collections.shuffle(deck, new Random());
    }
    public void suitable(){ //подходящая костяшка на стол
        int i = 0; //мне нужно знать какие на столе
        List<Domino> pl = players.get(i).getHand();
        if(pl.isEmpty()){
            for(int j = 0 ; j < pl.size() - 1; j++){
                if(){

                }
            }
        }
    }
    public boolean hasDominoInHand(Domino domino){ //конкретное домино в руке проверка
        return hand.contains(domino);
    }
}
