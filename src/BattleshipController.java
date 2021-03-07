import java.util.Arrays;
import java.util.List;

public class BattleshipController {
    int guesses = 0;
    BattleshipModel model = new BattleshipModel();

    public BattleshipModel getModel() {
        return model;
    }

    public BattleshipController() {
    }

    public void processGuess(String guess){
        String location = this.parseGuess(guess);
        if (location != "-1") {
            this.guesses++;
            boolean hit = model.fire(location);
            if (hit && model.shipsSunk == model.numShips) {
                System.out.println("You sank all my battleships, in " + this.guesses + " guesses");
            }
        }
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
