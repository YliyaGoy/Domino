package domino.view;

import domino.model.Player;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gorbunova_ju_p on 13.10.2020.
 */
public class DominoView { //спрашивает какую следующую фишку положить на стол

    private static final Pattern PLAYER_PATTERN = Pattern.compile("\\d"); //reader

    public String getDominoNum() {
        return "Enter number domino: ";
    }

    public boolean validate(String input){
        Matcher matcher = PLAYER_PATTERN.matcher(input);
        return PLAYER_PATTERN.matcher(input).matches();
    }


}
