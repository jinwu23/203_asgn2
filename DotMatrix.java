import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.awt.MouseInfo;





public class DotMatrix extends Observable{
    int x, y;
    ArrayList<Dot> dots = new ArrayList<>();
    private Observer observer;

    public DotMatrix() {}

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

    public void lineDots(){

    }




}
