package view;

import model.Domino;
import model.Player;
import service.DominoService;
import service.PlayerService;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by gorbunova_ju_p on 13.10.2020.
 */

public class PlayerView  {
    DominoService dominoService =  new DominoService();

    public void printAllPlayersDominoes(List<Player> playerServices) {
        int p = 0;
        for (Player value : playerServices) {
            p++;
            System.out.print("Домино игрока " + p + ":");
            getPlayerDominoToString(value);
            System.out.println();
        }
    }
    public void getPlayerDominoToString(Player pl) {
        for (Domino playerDomino : pl.getPlayerDomino()) {
            System.out.print(dominoService.drawDomino(playerDomino));
        }
    }
}
