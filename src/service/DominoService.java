package service;

import model.Domino;

import java.util.*;

/**
 * Created by gorbunova_ju_p on 13.10.2020.
 */
public class DominoService {

    public String drawDomino(Domino domino) {
        return "[" + domino.getLeftNumber()+ " " + domino.getRightNumber() + "] ";
    }

    public boolean isAllowed(LinkedList<Integer> allowedNumbers, Domino d) {
        return (leftIsAllowed(allowedNumbers, d)) || (rightIsAllowed(allowedNumbers, d));
    }

    public boolean leftIsAllowed(LinkedList<Integer> allowedNumbers, Domino d) {
        return allowedNumbers.contains(d.getLeftNumber());
    }
    public boolean leftInFirst(LinkedList<Integer> allowedNumbers, Domino d) {
        return allowedNumbers.get(0) == (d.getLeftNumber());
    }

    public boolean leftInLast(LinkedList<Integer> allowedNumbers, Domino d) {
        return allowedNumbers.get(1) == (d.getLeftNumber());
    }

    public boolean rightIsAllowed(LinkedList<Integer> allowedNumbers, Domino d) {
        return allowedNumbers.contains(d.getRightNumber());
    }

    public boolean rightInFirst(LinkedList<Integer> allowedNumbers, Domino d) {
        return allowedNumbers.get(0) == (d.getRightNumber());
    }

    public boolean rigthInSecond(LinkedList<Integer> allowedNumbers, Domino d) {
        return allowedNumbers.get(1) == (d.getLeftNumber());
    }

    public boolean isDual(Domino domino) {
        return domino.getRightNumber() == domino.getRightNumber();
    }
}
