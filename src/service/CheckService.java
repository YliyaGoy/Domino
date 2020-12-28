package service;

import java.util.Scanner;

public class CheckService {
    public int intInput() throws NumberFormatException {
        Scanner scn = new Scanner(System.in);
        String number;

        while (!isInt(number = scn.nextLine())) {

            System.out.print("Введите количество игроков: ");
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
