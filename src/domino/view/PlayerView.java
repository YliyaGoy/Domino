package domino.view;

import domino.model.Player;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gorbunova_ju_p on 13.10.2020.
 */
public class PlayerView { //доступ к сепрвисам и игрокам

    private List<Player> players;
    private static final Pattern PLAYER_PATTERN = Pattern.compile("^[a-zA-Z]$"); //reader

    private Scanner scan = new Scanner(System.in);

    public String get() {
        return "Niсkname: ";
    }

    public boolean validate(String input){
        Matcher matcher = PLAYER_PATTERN.matcher(input);
        return PLAYER_PATTERN.matcher(input).matches();
    }
    public void addGroup() { //добавление пользователя
        System.out.println("Enter nickname:");
        String name = scan.nextLine();
        players.add();
    }


}
