import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

/**
 *
 * @author sudthirak
 */
public class ClockViewMDI extends JInternalFrame {

    private Clock clock;
    private Thread t;

    public ClockViewMDI() {

        clock = new Clock();
        t = new Thread(clock);
        t.start();
        this.add(clock);

        this.setResizable(true);
        this.setClosable(false);
        this.setIconifiable(true);
//        this.setMaximizable(true);

        this.setSize(500, 300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ClockViewMDI();
    }
}