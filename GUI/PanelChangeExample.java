import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableCellRenderer;

public class PanelChangeExample extends JFrame {
    private JPanel panel1;
    private JPanel panel2;

    public PanelChangeExample() {
        setTitle("Panel Change Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));

        // Create panels
        panel1 = new JPanel();
        panel1.setBackground(Color.RED);
        panel2 = new JPanel();
        panel2.setBackground(Color.BLUE);

        // Create buttons
        JButton btnPanel1 = new JButton("Panel 1");
        JButton btnPanel2 = new JButton("Panel 2");

        // Add action listeners to buttons
        btnPanel1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(panel1);
                add(btnPanel1);
                add(btnPanel2);
                revalidate();
            }
        });

        btnPanel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(panel2);
                add(btnPanel1);
                add(btnPanel2);
                revalidate();
            }
        });

        // Set the initial content pane
        setContentPane(panel1);

        // Set layout and add buttons
        setLayout(new FlowLayout());
        add(btnPanel1);
        add(btnPanel2);

        pack();
        setVisible(true);
    }
    
    // Custom cell renderer for displaying icons in the table
    private static class IconRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel label = new JLabel();
            if (value instanceof ImageIcon) {
                label.setIcon((ImageIcon) value);
            }
            return label;
        }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PanelChangeExample();
            }
        });
        }
    }
}
