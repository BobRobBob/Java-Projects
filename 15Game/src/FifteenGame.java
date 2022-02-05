import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class FifteenGame extends JFrame {

    private int gameSize;
    private int diff;

    private LinkedList<Cell> gameBoard = new LinkedList<Cell>();
    private Cell blank;
    private int moves;

    public FifteenGame(int gameSize, int diff){
        super("Fifteen game");
        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.gameSize = gameSize;
        this.diff = diff;
        setLayout(new GridLayout(gameSize,gameSize,3,3));
        GameGenerator generator = new GameGenerator(this.gameSize, this.diff);

        //Skapa koordinater för cellerna
        int count = 0;
        int[] rowArray = new int[gameSize*gameSize];
        int[] colArray = new int[gameSize*gameSize];
        for(int i = 0; i < gameSize; i++){
            for(int j = 0; j < gameSize; j++){
                rowArray[count] = i;
                colArray[count] = j;
                count++;
            }
        }

        //Tilldela varje Cell ett tal och ursprungliga koordinater, spara även tomma rutans koordinater för referens
        count = 0;
        for(int i : generator) {
            if(i==0){
                blank = new Cell(i, rowArray[count], colArray[count], this);
                gameBoard.add(blank);
            } else
            gameBoard.add(new Cell(i, rowArray[count], colArray[count], this));
            count++;
        }

        int c = 1;
        for(int i = 0; i < (gameSize*gameSize); i++){
            add(gameBoard.get(c - 1));
            c++;
        }

        setVisible(true);
    }
//----Setters and Getters-----------------------------------
    public Cell getCell(){
        return this.blank;
    }
    public void setCell(Cell c){
        this.blank = c;
    }

    public void setMoves(){
        this.moves++;
    }

//----------------------------------------------------------
    //kontrollera om alla celler ligger i rätt ordning
    public boolean hasWon() {
        int comp = 1;
        for (Cell i : gameBoard) {
            if(comp == (gameSize*gameSize)){
                comp = 0;
            }
            if (i.getT() != comp) {
                return false;
            } else comp++;
        } return true;
    }
    //Dialogruta som visar att man vunnit, hur många moves som krävdes. Stänger även programmet
    public void wonMessage(){
        JOptionPane.showMessageDialog(this,"Congratulations you won!\n It took: " + moves + "moves");
        if(JOptionPane.OK_OPTION == 0){
            dispose();
        }
    }

    //----Main
    public static void main(String[] args){
        new SelectDifficulty();
    }

}
