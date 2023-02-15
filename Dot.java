import java.awt.*;

public class Dot {
    int x, y;
    Color color;
    public Dot(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillOval(x - 5, y - 5, 10, 10);
    }

    public void cluster(Dot dot1, Dot dot2){
        if(distanceFrom(dot1) < distanceFrom(dot2)){
            this.color = dot1.color;
        }
        else{
            this.color = dot2.color;
        }
    }

    public void changeColor(Color color){this.color = color;}
    public int getX(){return this.x;}
    public int getY(){return this.y;}

    double distanceFrom(Dot dot){
        return Math.sqrt(Math.pow(this.x - dot.x, 2) + Math.pow(this.y - dot.y, 2));
    }
}
