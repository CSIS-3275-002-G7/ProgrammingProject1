import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.jar.JarEntry;

public class BattleshipFrame extends JFrame implements ActionListener {
    final int bgWidth = 1024;
    final int bgHeight = 863;
    JButton fireButton = new JButton("Fire!");
    JTextField guessInput = new JTextField();
    BattleshipController controller = new BattleshipController();
    BattleshipModel model = new BattleshipModel();

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
        model.generateShipLocations();


//        ImageIcon ship = new ImageIcon("src/ship.png");
//        JLabel shipLabel = new JLabel(ship);
//        shipLabel.setBounds(0, 0, 100, 100);
//        guessesLabel.setBounds(0, 0, 500, 430);
//        guessesLabel.setIcon(ship);



//
//        this.add(fireButton);
//        this.add(guessInput);
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, bgWidth, bgHeight);
//        layeredPane.add(shipLabel);
        layeredPane.add(interactionLabel);
        layeredPane.add(backgroundLabel);

//        layeredPane.setBackground(Color.BLUE);
//        layeredPane.add(backgroundLabel);
//        backgroundLabel.setIcon(board);
        this.setSize(new Dimension(bgWidth, bgHeight));
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);

        this.add(layeredPane);

//        this.setSize(new Dimension(1024, 863));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == fireButton) {
            String guess = controller.parseGuess(guessInput.getText());
//            JLabel addImage = new JLabel();
//            ImageIcon shipImage = new ImageIcon("src/ship.png");
//            addImage.setIcon(shipImage);
//            this.add(addImage);
//            this.revalidate();

        }
    }
}
