import java.awt.*;

/**
 * Line class to hold data for a single line
 * and how to draw it
 * @author Jin Wu
 */
public class Line {
    int x1, x2, y1, y2;
    // Constructor
    public Line(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    /**
     * draw method for DrawPanel to call
     * @param g
     */
    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.drawLine(x1, y1, x2, y2);
    }
}
