import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * DrawPanel class
 * performs graphic handling
 * is Observer
 * @author Jin Wu
 */
public class DrawPanel extends JPanel implements Observer, MouseListener {
    DotMatrix dotMatrix;
    ArrayList<Dot> dots;
    ArrayList<Line> lines;
    public DrawPanel(DotMatrix dotMatrix) {
        super();
        this.dotMatrix = dotMatrix;
        addMouseListener(this);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(this.dots != null){
            for(Dot dot: this.dots){
                dot.draw(g);
            }
        }
        if(this.lines != null){
            for(Line line: this.lines){
                line.draw(g);
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        this.dots = ((DotMatrix)o).getDots();
        this.lines = ((DotMatrix)o).getLines();
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.dotMatrix.setXY(e.getX(), e.getY());
        System.out.println(e.getX() + ", " +e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}


}
