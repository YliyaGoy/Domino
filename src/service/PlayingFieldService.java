package service;

import java.util.LinkedList;
import model.Deck;
import model.Domino;
import model.Player;
import model.PlayingField;

public class PlayingFieldService {
    Deck deck = new Deck();
    PlayingField game = new PlayingField();

    public boolean playerWithoutDomino() {
        for (int i = 0; i < game.getPlayers().size(); i++) {
            if (game.getPlayers().get(i).getPlayerDomino().size() == 0) {
                return true;
            }
        }
        return false;
    }

    public int playerWithMinDeckSize() {
        int minDeckSize = 28;
        int winner = -1;
        for (int i = 0; i < game.getPlayers().size(); i++) {
            int amountPlayerDominoes = game.getPlayers().get(i).getPlayerDomino().size();
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
        for (int i = 0; i < game.getPlayers().size(); i++) {
            if (game.getPlayers().get(i).getPlayerDomino().size() == 0) {
                return false;
            }
        }
        return true;
    }

    public void putFirstDomino(LinkedList<Domino> table, LinkedList<Integer> allowedNumbers, Player player) {
        int left;
        int right;
        Domino putDomino = new PlayerService().maxDomino(player.getPlayerDomino());
        left = putDomino.getLeftNumber();
        right = putDomino.getRightNumber();
        allowedNumbers.add(left);
        allowedNumbers.add(right);
        player.getPlayerDomino().remove(putDomino);
        table.add(putDomino);
    }

    public void takeDomino(Deck deck, Player player) {
        Domino rnd = new DeckService().getRandomDomino(deck);
        System.out.println("Взял " + new DominoService().drawDomino(rnd));
        player.getPlayerDomino().add(rnd);
    }

    public void putDomino(LinkedList< Domino> table, LinkedList<Integer> allowedNumbers, Domino putDomino) {
        if (new DominoService().leftInFirst(allowedNumbers, putDomino)) {
            allowedNumbers.set(0, putDomino.getRightNumber());
            table.addLast(putDomino);
        } else {
            if (new DominoService().leftInLast(allowedNumbers, putDomino)) {
                allowedNumbers.set(1,  putDomino.getRightNumber());
                table.addLast(new  Domino(putDomino.getRightNumber(), putDomino.getLeftNumber()));

            } else {
                if (new DominoService().rightInFirst(allowedNumbers, putDomino)) {
                    allowedNumbers.set(0,  putDomino.getLeftNumber());
                    table.addFirst(putDomino);
                } else {
                    if (new DominoService().rigthInSecond(allowedNumbers, putDomino)) {
                        allowedNumbers.set(1, putDomino.getLeftNumber());
                        table.addFirst(new Domino(putDomino.getRightNumber(), putDomino.getLeftNumber()));
                    }
                }
            }
        }
    }
}
