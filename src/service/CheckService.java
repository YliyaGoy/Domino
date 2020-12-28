package service;
import view.StartGameView;

import java.util.Scanner;

public class CheckService {
    StartGameView startGameView = new StartGameView();

    public int intInput() throws NumberFormatException {
        Scanner scn = new Scanner(System.in);
        String number;

        while (!isInt(number = scn.nextLine())) {
            startGameView.getMessage();
        }
        return Integer.parseInt(number);
    }

    private boolean isInt(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
