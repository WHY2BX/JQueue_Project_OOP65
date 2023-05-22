import java.awt.Font;
import java.awt.GridBagLayout;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.JLabel;


public class Clock extends JLabel implements Runnable {

    @Override
    public void run() {
        while (true) {
            Calendar d = Calendar.getInstance();
            int sec = d.get(Calendar.SECOND);
            int min = d.get(Calendar.MINUTE);
            int hour = d.get(Calendar.HOUR_OF_DAY);
            
//            setLayout(new GridBagLayout());
//            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            setFont(new Font("Arial", Font.BOLD, 50));
            setText("          "+String.format("%02d:%02d:%02d", hour, min, sec));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();

            }

        }
    }
}