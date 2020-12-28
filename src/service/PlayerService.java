package service;

import model.Domino;
import model.Player;

import java.util.LinkedList;
import java.util.List;

public class PlayerService {
    DominoService dominoService =  new DominoService();
    DominoService diceService = new DominoService();

    public Domino maxDomino(List<Domino> playerDomino) {
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
            if (dominoService.isAllowed(allowedNumbers, domino)) {
                return domino;
            }
        }
        return null;
    }
}
