import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BattleshipFrame extends JFrame implements ActionListener {
    final int bgWidth = 1024;
    final int bgHeight = 863;
    JButton fireButton = new JButton("Fire!");
    JTextField guessInput = new JTextField();
    JTextArea messageLabel = new JTextArea();
    JTextArea guessCounter = new JTextArea();
    JTextArea guessTime = new JTextArea();
    JLayeredPane layeredPane = new JLayeredPane();
    BattleshipView view = new BattleshipView(layeredPane, messageLabel,
            guessCounter, guessTime, guessInput);
    BattleshipController controller = new BattleshipController(view);

    BattleshipFrame(){
        ImageIcon board = new ImageIcon("src/board.jpg");
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setOpaque(true);
        backgroundLabel.setBounds(0, 0, bgWidth, bgHeight);
        backgroundLabel.setIcon(board);

        JLabel interactionLabel = new JLabel();
        fireButton.setBounds(900, 50, 40, 20);
        fireButton.setMargin(new Insets(0, 0, 0,0));
        fireButton.setFont(new Font("Arial", Font.BOLD, 10));
        fireButton.addActionListener(this);
        guessInput.setBounds(790, 50, 100, 20);
        interactionLabel.setBounds(0, 0, bgWidth, bgHeight);
        interactionLabel.add(fireButton);
        interactionLabel.add(guessInput);

        messageLabel.setBounds(100, 50,700, 30);
        messageLabel.setMargin(new Insets(0, 0, 0, 0));
        messageLabel.setFont(new Font("Arial", Font.BOLD, 20));
        messageLabel.setOpaque(false);
        messageLabel.setForeground(Color.LIGHT_GRAY);
        messageLabel.setText("Make your first guess");

        guessCounter.setBounds(765, 20, 200, 20);
        guessCounter.setMargin(new Insets(0, 0, 0,0));
        guessCounter.setFont(new Font("Arial", Font.BOLD, 15));
        guessCounter.setOpaque(false);
        guessCounter.setForeground(Color.LIGHT_GRAY);
        guessCounter.setText("Guesses Remaining: " + this.controller.getGuessesLeft());

        guessTime.setBounds(465, 20, 200, 20);
        guessTime.setMargin(new Insets(0, 0, 0,0));
        guessTime.setFont(new Font("Arial", Font.BOLD, 15));
        guessTime.setOpaque(false);
        guessTime.setForeground(Color.LIGHT_GRAY);
        guessTime.setText("Time Remaining: " + controller.getTimeLeft());

        layeredPane.setBounds(0, 0, bgWidth, bgHeight);
        layeredPane.add(guessCounter);
        layeredPane.add(guessTime);
        layeredPane.add(messageLabel);
        layeredPane.add(interactionLabel);
        layeredPane.add(backgroundLabel);

        this.setSize(new Dimension(bgWidth, bgHeight));
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);
        this.add(layeredPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == fireButton) {
            controller.processGuess(guessInput.getText());
        }
    }
}
