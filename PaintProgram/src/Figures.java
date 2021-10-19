import java.awt.*;
import java.io.Serializable;

/**
 * Creates a figure containing a
 * Graphics2d shape with attached color
 *
 */
public class Figures implements Serializable {
    private final Shape shape;
    private final Color color;

    /**
     * Constructor for new figure with shape and color.
     *
     * @param s the figure shape
     * @param c the figure color
     */
    //----Constructor-----------------------------------
    public Figures(Shape s, Color c){
        this.shape = s;
        this.color = c;
    }
    //--------------------------------------------------

    //----Getters and setters---------------------------
    public Color getColor(){
        return color;
    }
    public Shape getShape(){
        return shape;
    }
    //---------------------------------------------------
}
