import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class FifteenGame extends JFrame {

    private GameGenerator generator = new GameGenerator(4);
    private LinkedList<Cell> gameBoard = new LinkedList<Cell>();
    private int[] rowArray = new int[16];
    private int[] colArray = new int[16];
    private Cell blank;
    private int moves;

    public FifteenGame(){
        super("Fifteen game");
        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4,4,3,3));

        //Skapa koordinater för cellerna
        int count = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                rowArray[count] = i;
                colArray[count] = j;
                count++;
            }
        }

        //Tilldela varje Cell ett tal och ursprungliga koordinater, spara även tomma rutans koordinater
        count = 0;
        for(int i : generator) {
            if(i==0){
                blank = new Cell(i, rowArray[count], colArray[count], this, count);
                gameBoard.add(blank);
            } else
            gameBoard.add(new Cell(i, rowArray[count], colArray[count], this, count));
            count++;
        }

        int c = 1;
        for(int i = 0; i < 16; i++){
            add(gameBoard.get(c - 1));
            c++;
        }

        //Lägg till varje cell till framen
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
    public LinkedList<Cell> getGameBoard(){
        return this.gameBoard;
    }
//----------------------------------------------------------
    //kontrollera om alla celler ligger i rätt ordning
    public boolean hasWon() {
        int comp = 1;
        boolean r = false;
        for (Cell i : gameBoard) {
            if(comp == 16){
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
        new FifteenGame();
    }
    
}
