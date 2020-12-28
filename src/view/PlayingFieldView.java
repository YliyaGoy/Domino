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
    DominoService dominoService = new DominoService();
    PlayingFieldService playingFieldService = new PlayingFieldService();
    PlayerService playerService = new PlayerService();
    PlayerView playerView = new PlayerView();
    DeckService deckService = new DeckService();
    StartGameView startGameView = new StartGameView();
    DeckView deckView = new DeckView();

    public void game() {
        LinkedList<Integer> allowedNumbers = new LinkedList<>();

        deck.setDeck(deckService.bunch());

        game.setPlayers(startGameView.createPlayers(deck));

        boolean firstMove = true;

        while (playingFieldService.finish()) {
            for (int player = 0; player < game.getPlayers().size(); player++) {
                System.out.println("Домино осталось : " + deck.getDeck().size());
                System.out.print("Колода: " );

                deckView.drawDeck(deck);

                System.out.println("Ход игрока " + (player + 1));

                if (firstMove) {
                    firstMove(allowedNumbers, game.getPlayers().get(player));
                } else {
                    otherMoves(allowedNumbers, game.getPlayers().get(player));
                }
                playerView.printAllPlayersDominoes(game.getPlayers());

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
        playingFieldService.putFirstDomino(table, allowedNumbers, player);
        System.out.println("Положил " + allowedNumbers.get(0) + " " + allowedNumbers.get(1));
    }

    private void otherMoves(LinkedList<Integer> allowedNumbers, Player player) {
        Domino put = playerService.allovedDomino(allowedNumbers, player.getPlayerDomino());
        while (put == null) {
            if (deck.getDeck().size() == 0) {
                System.out.println("Колода закончилась");
                return;
            }
            takeDomino(deck, player);
            put = playerService.allovedDomino(allowedNumbers, player.getPlayerDomino());
        }
        System.out.println("Положил " + dominoService.drawDomino(put));
        player.getPlayerDomino().remove(put);
        playingFieldService.putDomino(table, allowedNumbers, put);
        System.out.println();
    }

    private int defineWinner() {
        if (deck.getDeck().size() == 0) {
            System.out.println("Пустая колода");
            return playingFieldService.playerWithMinDeckSize();
        } else {
            if (playingFieldService.playerWithoutDomino()) {
                System.out.println("Нет домино");
                for (int i = 0; i < game.getPlayers().size(); i++) {
                    if (game.getPlayers().get(i).getPlayerDomino().size() == 0) {
                        return i;
                    }
                }
            } else {
                System.out.println("Наименьший");
                return playingFieldService.playerWithMinDeckSize();
            }
        }
        return -1;
    }

    private void drawTable() {
        for (Domino domino : table) {
            System.out.print("[" + domino.getLeftNumber()+ " " + domino.getRightNumber() + "] ");
        }
    }
    public void takeDomino(Deck deck, Player player) {
        Domino rnd = deckService.getRandomDomino(deck);
        System.out.println("Взял " + dominoService.drawDomino(rnd));
        player.getPlayerDomino().add(rnd);
    }
}

