
import java.awt.*;

public class Position {

    private int x; //start column
    private int y; //start row
    private Shape shape;
    private Color color;

    public Position(Shape s, Color c){
        this.shape = s;
        this.color = c;
    }
    public Position(int y, int x, Color c){
        this.y = y;
        this.x = x;
        this.color = c;
    }



    //---Getters and Setters
    public void setX(int x){
        this.x = x;
    }
    public int getX(){
        return x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getY(){
        return y;
    }
    public Color getColor(){
        return color;
    }

}