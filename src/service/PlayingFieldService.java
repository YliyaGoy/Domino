package service;

import model.Deck;
import model.Domino;
import model.Player;
import model.PlayingField;

import java.util.LinkedList;

public class PlayingFieldService {
    Deck deck = new Deck();
    PlayingField playingField = new PlayingField();
    DominoService dominoService = new DominoService();
    PlayerService playerService = new PlayerService();
    Domino domino = new Domino(-1,-1);

    public boolean playerWithoutDomino() {
        for (int i = 0; i < playingField.getPlayers().size(); i++) {
            if (playingField.getPlayers().get(i).getPlayerDomino().size() == 0) {
                return true;
            }
        }
        return false;
    }

    public int playerWithMinDeckSize() {
        int minDeckSize = 28;
        int winner = -1;
        for (int i = 0; i < playingField.getPlayers().size(); i++) {
            int amountPlayerDominoes = playingField.getPlayers().get(i).getPlayerDomino().size();
            if (amountPlayerDominoes < minDeckSize) {
                minDeckSize = amountPlayerDominoes;
                winner = i;
            }
        }
        return winner;
    }

    public boolean finish() {
        if (deck.getDeck().size() == 0) {
            return false;
        }
        for (int i = 0; i < playingField.getPlayers().size(); i++) {
            if (playingField.getPlayers().get(i).getPlayerDomino().size() == 0) {
                return false;
            }
        }
        return true;
    }

    public void putFirstDomino(LinkedList<Domino> table, LinkedList<Integer> allowedNumbers, Player player) {
        int left;
        int right;
        Domino putDomino = playerService.maxDomino(player.getPlayerDomino());
        left = putDomino.getLeftNumber();
        right = putDomino.getRightNumber();
        allowedNumbers.add(left);
        allowedNumbers.add(right);
        player.getPlayerDomino().remove(putDomino);
        table.add(putDomino);
    }

    public void putDomino(LinkedList< Domino> table, LinkedList<Integer> allowedNumbers, Domino putDomino) {
        if (dominoService.leftInFirst(allowedNumbers, putDomino)) {
            allowedNumbers.set(0, putDomino.getRightNumber());
            table.addLast(putDomino);
        } else if (dominoService.leftInLast(allowedNumbers, putDomino)) {
            allowedNumbers.set(1,putDomino.getRightNumber());
            table.addLast(new Domino(putDomino.getRightNumber(), putDomino.getLeftNumber()));
        } else if (dominoService.rightInFirst(allowedNumbers, putDomino)) {
            allowedNumbers.set(0,  putDomino.getLeftNumber());
            table.addFirst(putDomino);
        } else if (dominoService.rigthInSecond(allowedNumbers, putDomino)) {
            allowedNumbers.set(1,putDomino.getLeftNumber());
            table.addFirst(new Domino(putDomino.getRightNumber(), putDomino.getLeftNumber()));
        }
    }
}
