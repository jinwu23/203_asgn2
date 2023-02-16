import java.awt.*;
/**
 * Dot class
 * contains location of dot (x,y), color of the dot, and if it is discovered
 * @author Jin Wu
 */
public class Dot {
    int x, y;
    Color color;
    boolean discovered;
    // Constructor
    public Dot(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }
    /**
     * draw method for DrawPanel to call
     * @param g
     */
    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillOval(x - 5, y - 5, 10, 10);
    }
    /**
     * cluster method, will color a dot to whichever dot its closest to
     * @param dot1
     * @param dot2
     */
    public void cluster(Dot dot1, Dot dot2){
        if(distanceFrom(dot1) < distanceFrom(dot2)){
            this.color = dot1.color;
        }
        else{
            this.color = dot2.color;
        }
    }

    public void setDiscovered(boolean discovered){this.discovered = discovered;}
    public void changeColor(Color color){this.color = color;}
    public int getX(){return this.x;}
    public int getY(){return this.y;}
    public boolean getDiscovered(){return this.discovered;}

    // finds distance from dot to another
    double distanceFrom(Dot dot){
        return Math.sqrt(Math.pow(this.x - dot.x, 2) + Math.pow(this.y - dot.y, 2));
    }
}
