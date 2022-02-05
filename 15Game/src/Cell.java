import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cell extends JButton implements ActionListener {

    private int self;
    private int row;
    private int col;
    private FifteenGame board; //För att komma åt listan med celler i "huvudobjektet"
    private int pos;

    //Konstruktor
    public Cell(int a, int b, int c, FifteenGame f){
        addActionListener(this); //lyssnar efter klick på sig själv
        this.self = a;
        this.row = b;
        this.col = c;
        this.board = f;
        if(self == 0){
            setText("");
        } else
        setText(String.valueOf(a));

    }

    @Override
    public void actionPerformed(ActionEvent e){
        //Ta fram tomma cellen för att kontrollera om det går att flytta denna cellen
        Cell blank = board.getCell();
            if((blank.row == this.row) && (Math.abs(blank.col - this.col) == 1)){
                //Gör en swap
                blank.setText(String.valueOf(e.getActionCommand()));
                setText("");
                //Ändra värdet på blankcellen i fifteengame
                board.setCell(this);
                board.setMoves();
                if(board.hasWon()){
                    board.wonMessage();
                }
            } else if((blank.col == this.col) && (Math.abs(blank.row - this.row) == 1)){
                //Gör en swap
                blank.setText(String.valueOf(e.getActionCommand()));
                setText("");
                //Ändra värdet på blankcellen i fifteengame
                board.setCell(this);
                board.setMoves();
                if(board.hasWon()) {
                    board.wonMessage();
                }
            } else
                Toolkit.getDefaultToolkit().beep();
    }
//----Getters and Setters----------------------------------
    //Get the text from a cell button
    public int getT(){
        if(getText() == ""){
            return 0;
        } else
        return Integer.parseInt(getText());
    }
//----------------------------------------------------------
}


