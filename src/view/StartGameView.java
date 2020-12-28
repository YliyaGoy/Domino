package view;

import model.Deck;
import model.Player;
import service.CheckService;
import service.DistributorService;

import java.util.LinkedList;

public class StartGameView {
    DistributorService distributorService = new DistributorService();

    PlayerView playerView = new PlayerView();

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
        getMessage();
        while ((amountPlayers > 4) || (amountPlayers <= 1)) {
            amountPlayers = cs.intInput();
        }
        return amountPlayers;
    }
    public void getMessage(){
        System.out.print("Введите количество игроков: ");
    }

    private LinkedList<Player> create(Deck pm, int amountPlayers) {
        LinkedList<Player> playerServices = new LinkedList<>();
        for (int i = 0; i < amountPlayers; i++) {
            Player player = new Player();
            player.setPlayerDomino(distributorService.distribute(pm));
            playerServices.add(player);
        }
        playerView.printAllPlayersDominoes(playerServices);
        return playerServices;
    }
}
