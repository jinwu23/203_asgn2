import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * DotMatrix class
 * performs data handling for dots and lines
 * is Observable
 * @author Jin Wu
 */
public class DotMatrix extends Observable{
    int x, y;
    ArrayList<Dot> dots = new ArrayList<>();
    ArrayList<Line> lines = new ArrayList<>();
    private Observer observer;

    public DotMatrix() {}

    /**
     * Setter for X and Y
     * @param x
     * @param y
     */
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
        dots.add(new Dot(x, y, Color.BLACK));
        notifying();
    }

    @Override
    public void addObserver(Observer o){
        this.observer = o;
    }

    public void notifying(){
        this.observer.update(this, this);
    }

    public ArrayList<Dot> getDots(){
        return this.dots;
    }

    public ArrayList<Line> getLines(){ return this.lines; }

    /**
     * Creates two random dots (dot1, dot2)
     * calls cluster function in every dot in dots
     * notifies Observer
     */
    public void clusterDots(){
        Dot dot1 = new Dot((int)(Math.random() * ((DrawPanel)this.observer).getWidth()),
                (int)(Math.random() * ((DrawPanel)this.observer).getHeight()), Color.RED);
        Dot dot2 = new Dot((int)(Math.random() * ((DrawPanel)this.observer).getWidth()),
                (int)(Math.random() * ((DrawPanel)this.observer).getHeight()), Color.BLUE);
        for(Dot dot: dots){
            dot.cluster(dot1, dot2);
        }
        notifying();
    }
    /**
     * Creates lines from dot to dot and stores it in dots
     * notifies Observer
     */
    public void lineDots(){
        this.lines.clear();
        if(dots.isEmpty()){
            return;
        }
        for(Dot dot: dots){
            dot.setDiscovered(false);
        }
        Dot currDot = dots.get(0);
        while(currDot != null){
            currDot.setDiscovered(true);
            Dot nearestDot = getNearestDot(currDot);
            if(nearestDot != null){
                Line line = new Line(currDot.getX(), currDot.getY(), nearestDot.getX(), nearestDot.getY());
                this.lines.add(line);
            }
            currDot = nearestDot;
        }
        notifying();
    }

    /**
     * returns the nearest non-discovered dot
     * will return null if no dot is found
     * @param dot
     * @return
     */
    public Dot getNearestDot(Dot dot){
        Dot nearest = null;
        for(Dot listDot: dots){
            if(!listDot.getDiscovered()){
                if(nearest == null){
                    nearest = listDot;
                }
                else if(listDot.distanceFrom(dot) < nearest.distanceFrom(dot)){
                    nearest = listDot;
                }
            }
        }
        return nearest;
    }

}
