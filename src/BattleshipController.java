import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class BattleshipController {
    int guesses = 0;
    int guessesLeft = 15;
    int timeLeft = 60;
    BattleshipModel model;
    BattleshipView view;

    public int getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }

    public BattleshipModel getModel() {
        return model;
    }

    public int getGuessesLeft() {
        return guessesLeft;
    }

    public BattleshipController(BattleshipView view) {
        this.view = view;
        model = new BattleshipModel(view);
    }



    public void processGuess(String guess){
        String location = this.parseGuess(guess);
        if (!location.equals("-1")) {
            this.guesses++;
            this.guessesLeft--;
            this.view.updateGuesses(this.guessesLeft);

            if (guessesLeft == 14) {
                Timer timer = new Timer();
                timer.schedule(new TimerTask(){
                    @Override
                    public void run() {
                        view.updateTime(timeLeft);
                        timeLeft--;
                        if (timeLeft == -1){
                            timer.cancel();
                            view.displayMessage("Game Over! Time Elapsed!");
                            view.getGuessInput().setEnabled(false);
                        }
                    }
                },0, 1000);
            }
            boolean hit = model.fire(location);
            if (hit && this.getModel().getShipsSunk() == this.getModel().getNumShips()) {
                this.view.displayMessage("You sank all my battleships in " + this.guesses + " guesses!");
            }
            if (this.guessesLeft == 0 && this.getModel().getShipsSunk() != this.getModel().getNumShips()) {
                this.view.displayMessage("Game Over! You've used up all your guesses!");
                this.view.getGuessInput().setEnabled(false);

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
