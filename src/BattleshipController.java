import java.util.Arrays;
import java.util.List;

public class BattleshipController {
    int guesses = 0;

    public BattleshipController() {
    }

    public void processGuess(String guess){
        
    }

    public String parseGuess(String guess){
        List<Character> alphabet = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G');

        if (guess == null || guess.length() != 2) {
            System.out.println("Oops, please enter a letter and a number on the board.");
            return "-1";
        } else {
            char firstChar = guess.charAt(0);
            int row = alphabet.indexOf(firstChar);
            int column = guess.charAt(1) - '0';
            String g = Integer.toString(row) + Integer.toString(column);
            System.out.println(g);
            return g;
        }
    }
}
