import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observer;

/**
 * @author Jin Wu
 * This is a program for a City Dot application using Java Swing
 */
public class Main extends JFrame implements ActionListener {
    DotMatrix matrix;
    boolean cluster, line;
    /**
     * The main method which sets the size of the application
     * and its visibility
     */
    public static void main(String[] args){
        Main main = new Main();
        main.setSize(800, 500);
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.setVisible(true);
    }
    /**
     * Constructor creates Frames and buttons for application
     */
    public Main(){
        super("My City App");
        /**
         * Left sidebar with Color dropdown menu
         * and Shape selection radio buttons
         */
        JPanel westPanel = new JPanel();
        JRadioButton clusterButton = new JRadioButton("Cluster - K - means");
        JRadioButton lineButton = new JRadioButton("Line - Nearest Neighbor");
        JButton runButton = new JButton("Run");
        GridLayout leftSidebarGrid = new GridLayout(7, 1);
        westPanel.setLayout(leftSidebarGrid);
        westPanel.add(clusterButton);
        westPanel.add(lineButton);
        westPanel.add(runButton);
        // center panel
        this.matrix = new DotMatrix();
        JPanel centerPanel = new DrawPanel(this.matrix);
        centerPanel.setBackground(Color.GRAY);
        this.matrix.addObserver((Observer) centerPanel);
        // frame
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        add(westPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
        clusterButton.addActionListener(this);
        lineButton.addActionListener(this);
        runButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        switch (e.getActionCommand()) {
            case "Cluster - K - means":
                if (!this.cluster) {
                    this.cluster = true;
                } else {
                    this.cluster = false;
                }
                break;
            case "Line - Nearest Neighbor":
                if (!this.line) {
                    this.line = true;
                } else {
                    this.line = false;
                }
                break;
            case "Run":
                if(this.cluster){
                    matrix.clusterDots();
                }
                if(this.line){
                    matrix.lineDots();
                }
                break;
        }
    }

}
