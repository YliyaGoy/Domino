package view;

import model.Player;
import service.PlayerService;
import java.util.List;

public class PlayerView {
    public void printAllPlayersDominoes(List<Player> playerServices) {
        int p = 0;
        for (Player value : playerServices) {
            p++;
            System.out.print("Домино игрока " + p + ":");
            new PlayerService().getPlayerDominoToString(value);
            System.out.println();
        }
    }
}
