import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class BattleshipView {
    JLayeredPane layeredPane;
    JTextArea messageLabel;
    JTextArea guessCounter;
    JTextArea guessTime;
    JTextField guessInput;
    ImageIcon ship = new ImageIcon("src/ship.png");
    ImageIcon miss = new ImageIcon("src/miss.png");

    public BattleshipView(JLayeredPane layeredPane, JTextArea messageLabel,
                          JTextArea guessCounter, JTextArea guessTime, JTextField guessInput) {
        this.layeredPane = layeredPane;
        this.messageLabel = messageLabel;
        this.guessCounter = guessCounter;
        this.guessInput = guessInput;
        this.guessTime = guessTime;

    }

    public JLayeredPane getLayeredPane() {
        return layeredPane;
    }

    public JTextField getGuessInput() {
        return guessInput;
    }

    public void displayMessage(String msg) {
        this.messageLabel.setText(msg);
    }

    public void displayShip(String guess) {
        JLabel shipLabel = new JLabel(ship);
        int row = guess.charAt(0) - '0';
        int col = guess.charAt(1) - '0';
        shipLabel.setBounds(172 +(95 * col), 97 + (95 * row), 94, 94);
        this.layeredPane.add(shipLabel, 0);
    }

    public void displayMiss(String guess) {
        JLabel missLabel = new JLabel(miss);
        int row = guess.charAt(0) - '0';
        int col = guess.charAt(1) - '0';
        missLabel.setBounds(170 +(95 * col), 95 + (95 * row), 100, 100);
        this.layeredPane.add(missLabel, 0);
    }

    public void updateGuesses(int guessesLeft) {
        this.guessCounter.setText("Guesses Remaining: " + guessesLeft);
    }

    public void updateTime(int timeLeft){
        this.guessTime.setText("Time remaining: " + timeLeft);
    }
}
