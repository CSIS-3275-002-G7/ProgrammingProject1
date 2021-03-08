import javax.swing.*;

public class BattleshipView {
    JLayeredPane layeredPane;
    JTextArea messageLabel;
    ImageIcon ship = new ImageIcon("src/ship.png");
    ImageIcon miss = new ImageIcon("src/miss.png");

    public BattleshipView(JLayeredPane layeredPane, JTextArea messageLabel) {
        this.layeredPane = layeredPane;
        this.messageLabel = messageLabel;
    }

    public void displayMessage(String msg) {
        this.messageLabel.setText(msg);
    }

    public void displayShip(String guess) {
        JLabel shipLabel = new JLabel(ship);
        int row = guess.charAt(0) - '0';
        int col = guess.charAt(1) - '0';
        shipLabel.setBounds(172 +(95 * col), 97 + (95 * row), 100, 100);
        this.layeredPane.add(shipLabel, 0);
    }

    public void displayMiss(String guess) {
        JLabel missLabel = new JLabel(miss);
        int row = guess.charAt(0) - '0';
        int col = guess.charAt(1) - '0';
        missLabel.setBounds(170 +(95 * col), 95 + (95 * row), 100, 100);
        this.layeredPane.add(missLabel, 0);
    }
}
