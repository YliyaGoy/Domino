package view;

import model.Deck;
import model.Player;
import service.CheckService;
import service.DistributorService;

import java.util.LinkedList;

public class StartGameView {

    private LinkedList<Player> players(Deck deck, int amountPlayers) {
        LinkedList<Player> players;
        players = create(deck, amountPlayers);
        return players;
    }

    public LinkedList<Player> createPlayers(Deck deck){
        return players(deck, countPlayers());
    }

    private int countPlayers() {
        CheckService cs = new CheckService();
        int amountPlayers = 0; //кол-во игроков
        System.out.print("Введите количество игроков: ");
        while ((amountPlayers > 5) || (amountPlayers <= 1)) {
            amountPlayers = cs.intInput();
        }
        return amountPlayers;
    }

    private LinkedList<Player> create(Deck pm, int amountPlayers) {
        LinkedList<Player> playerServices = new LinkedList<>();
        for (int i = 0; i < amountPlayers; i++) {
            Player player = new Player();
            player.setPlayerDomino(new DistributorService().distribute(pm));
            playerServices.add(player);
        }
        new PlayerView().printAllPlayersDominoes(playerServices);
        return playerServices;
    }
}

