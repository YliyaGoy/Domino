package view;

import model.Deck;
import model.Domino;
import model.Player;
import model.PlayingField;
import service.*;


import java.util.LinkedList;

public class PlayingFieldView {

    Deck deck = new Deck();
    PlayingField game = new PlayingField();
    LinkedList<Domino> table = new LinkedList<>();

    public void game() {
        LinkedList<Integer> allowedNumbers = new LinkedList<Integer>();

        deck.setDeck(new DeckService().bunch());
        game.setPlayers(new StartGameView().createPlayers(deck));

        boolean firstMove = true;

        while (new PlayingFieldService().finish()) {
            for (int player = 0; player < game.getPlayers().size(); player++) {
                System.out.println( "Домино осталось : " + deck.getDeck().size());
                System.out.print("Колода: " );

                new DeckService().drawDeck(deck);

                System.out.println("Ход игрока " + (player + 1));

                if (firstMove) {
                    firstMove(allowedNumbers, game.getPlayers().get(player));
                } else {
                    otherMoves(allowedNumbers, game.getPlayers().get(player));
                }

                new PlayerView().printAllPlayersDominoes(game.getPlayers());

                System.out.println();
                System.out.print("Возможный ход : ");
                System.out.println((allowedNumbers.get(0) + " " + allowedNumbers.get(1)));
                drawTable();

                firstMove = false;
            }
        }
        System.out.println("Победил игрок " + (defineWinner() + 1));
    }
    private void firstMove(LinkedList<Integer> allowedNumbers, Player player) {
        new PlayingFieldService().putFirstDomino(table, allowedNumbers, player);
        System.out.println("Положил " + allowedNumbers.get(0) + " " + allowedNumbers.get(1));
    }

    private void otherMoves(LinkedList<Integer> allowedNumbers, Player player) {
        Domino put = new PlayerService().allovedDomino(allowedNumbers, player.getPlayerDomino());
        while (put == null) {
            if (deck.getDeck().size() == 0) {
                System.out.println("Колода закончилась");
                return;
            }
            new PlayingFieldService().takeDomino(deck, player);
            put = new PlayerService().allovedDomino(allowedNumbers, player.getPlayerDomino());
        }
        System.out.println("Положил " + new DominoService().drawDomino(put));
        player.getPlayerDomino().remove(put);
        new PlayingFieldService().putDomino(table, allowedNumbers, put);
        System.out.println();
    }

    private int defineWinner() {
        if (deck.getDeck().size() == 0) {
            System.out.println("Пустая колода");
            return new PlayingFieldService().playerWithMinDeckSize();
        } else {
            if (new PlayingFieldService().playerWithoutDomino()) {
                System.out.println("Нет домино");
                for (int i = 0; i < game.getPlayers().size(); i++) {
                    if (game.getPlayers().get(i).getPlayerDomino().size() == 0) {
                        return i;
                    }
                }
            } else {
                System.out.println("Наименьший");
                return new PlayingFieldService().playerWithMinDeckSize();
            }
        }
        return -1;
    }

    private void drawTable() {
        for (Domino domino : table) {
            System.out.print("[" + domino.getLeftNumber()+ " " + domino.getRightNumber() + "] ");
        }
    }
}

