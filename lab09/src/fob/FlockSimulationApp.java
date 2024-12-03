package fob;
import javax.swing.JFrame;

public class FlockSimulationApp extends JFrame {
    public FlockSimulationApp() {
        super("2D Flock of Birds Simulation");
        this.add(new FlockPanel());
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
