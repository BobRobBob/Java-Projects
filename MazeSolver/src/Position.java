/**
 * Keeps track of position in the maze
 *
 *
 */

public class Position {
    private int x; //column
    private int y; //row

    public Position(int y, int x){
        this.x = x;
        this.y = y;
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

}
