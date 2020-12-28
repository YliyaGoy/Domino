package service;

import model.Domino;
import model.Player;

import java.util.LinkedList;
import java.util.List;

public class PlayerService {
    public void getPlayerDominoToString(Player pl) {
        for (Domino playerDomino : pl.getPlayerDomino()) {
            System.out.print(new DominoService().drawDomino(playerDomino));
        }
    }

    public Domino maxDomino(List<Domino> playerDomino) {
        DominoService diceService = new DominoService();
        Domino model = null;
        int numbersSum = 0;
        int maxNumbersSum = 0;
        int maxSumWithoutDual = 11; //дубли
        for (Domino domino : playerDomino) {
            if (diceService.isDual(domino))
                numbersSum += maxSumWithoutDual + domino.getLeftNumber();
            else
                numbersSum += domino.getLeftNumber()+ domino.getRightNumber();
            if (maxNumbersSum < numbersSum) {
                maxNumbersSum = numbersSum;
                model = domino;
            }
            numbersSum = 0;
        }
        return model;
    }

    public void addDomino(Player pm, Domino d) {
        pm.getPlayerDomino().add(d);
    }

    public Domino allovedDomino(LinkedList<Integer> allowedNumbers, LinkedList<Domino> playerDominoes) {
        for (Domino domino : playerDominoes) {
            if (new DominoService().isAllowed(allowedNumbers, domino)) {
                return domino;
            }
        }
        return null;
    }
}
