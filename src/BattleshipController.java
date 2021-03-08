import java.util.Arrays;
import java.util.List;

public class BattleshipController {
    int guesses = 0;
    BattleshipModel model;
    BattleshipView view;

    public BattleshipModel getModel() {
        return model;
    }

    public BattleshipController(BattleshipView view) {
        this.view = view;
        model = new BattleshipModel(view);
    }

    public void processGuess(String guess){
        String location = this.parseGuess(guess);
        if (!location.equals("-1")) {
            this.guesses++;
            boolean hit = model.fire(location);
            if (hit && this.getModel().getShipsSunk() == this.getModel().getNumShips()) {
                this.view.displayMessage("You sank all my battleships in " + this.guesses + " guesses!");
            }
        }
    }

    public String parseGuess(String guess){
        List<Character> alphabet = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G');

        if (guess == null || guess.length() != 2) {
            this.view.displayMessage("Oops, please enter a letter and a number on the board.");
            return "-1";
        } else {
            char firstChar = guess.charAt(0);
            int row = alphabet.indexOf(firstChar);
            int column = guess.charAt(1) - '0';
            return row + Integer.toString(column);
        }
    }
}
