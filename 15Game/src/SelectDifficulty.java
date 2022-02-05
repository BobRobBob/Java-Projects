import com.sun.jdi.connect.Connector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectDifficulty extends JFrame implements ActionListener {

    private int diff = 5;
    private int size = 3;
    private String diffText = "Easy";
    private JLabel southText = new JLabel();
    private FifteenGame board;

    public SelectDifficulty(){

        super("Fifteen game");
        setSize(400,200);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        this.board = board;

        //Introduction panel
        JPanel north =  new JPanel();
        JLabel northText = new JLabel();
        northText.setText("Welcome to Puzzle game, choose difficulty and board size.\n");
        north.add(northText);

        //Selection panel for Difficulty and Board size
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(2, 1));

        //Difficulty
        JPanel centerDiff = new JPanel();
        JLabel centerTextDiff = new JLabel();
        centerTextDiff.setText("Choose difficulty:     ");
        centerDiff.add(centerTextDiff);


        JButton easy = new JButton();
        easy.setText("Easy");
        easy.addActionListener(this);

        JButton medium = new JButton();
        medium.setText("Medium");
        medium.addActionListener(this);

        JButton hard = new JButton();
        hard.setText("Hard");
        hard.addActionListener(this);

        centerDiff.add(easy);
        centerDiff.add(medium);
        centerDiff.add(hard);

        //Selection panel for Board size
        JPanel centerBoard = new JPanel();
        JLabel centerTextBoard = new JLabel();
        centerTextBoard.setText("Choose Board size:          ");
        centerBoard.add(centerTextBoard);

        JButton three = new JButton();
        three.setText("3 X 3");
        three.addActionListener(this);

        JButton four = new JButton();
        four.setText("4 X 4");
        four.addActionListener(this);

        JButton five = new JButton();
        five.setText("5 X 5");
        five.addActionListener(this);

        centerBoard.add(three);
        centerBoard.add(four);
        centerBoard.add(five);

        center.add(centerDiff);
        center.add(centerBoard);

        //Panel showing made selections and button for starting the game
        JPanel south = new JPanel();
        southText.setText("DIFFICULTY: " + diffText + "      BOARD SIZE: " + size + " X " + size + "         ");
        south.add(southText);

        JButton startGame = new JButton();
        startGame.setText("Start Game!");
        startGame.addActionListener(this);

        south.add(startGame);


        add(north, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(south, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        if ((action == "Easy") || (action == "Medium") || (action == "Hard")) {
            switch (action) {
                case "Easy":
                    diff = 5;
                    diffText = "Easy";
                    break;
                case "Medium":
                    diff = 11;
                    diffText = "Medium";
                    break;
                case "Hard":
                    diff = 1000;
                    diffText = "Hard";
                    break;
            }
            southText.setText("DIFFICULTY: " + diffText + "      BOARD SIZE: " + size + " X " + size + "         ");
        }
        if ((action == "3 X 3") || (action == "4 X 4") || (action == "5 X 5")) {
            switch (action) {
                case "3 X 3":
                    size = 3;
                    break;
                case "4 X 4":
                    size = 4;
                    break;
                case "5 X 5":
                    size = 5;
                    break;
            }
            southText.setText("DIFFICULTY: " + diffText + "      BOARD SIZE: " + size + " X " + size + "         ");
        }
        if(action == "Start Game!"){
            setVisible(false);
            new FifteenGame(size,diff);
            dispose();
        }
    }

}
