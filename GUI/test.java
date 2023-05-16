import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableCellRenderer;

public class test extends JFrame {
    private JTable table;
    private JScrollPane scrollPane;

    public test() {
        setTitle("Table Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));

        // Create table model with sample data
        DefaultTableModel tableModel = new DefaultTableModel(
                new Object[][]{
                        {new ImageIcon("C:\\Users\\Bamba\\Downloads\\xioal.png"), "John", 25},
                        {new ImageIcon("C:\\Users\\Bamba\\Downloads\\xioal.png"), "Alice", 30},
                        {new ImageIcon("C:\\Users\\Bamba\\Downloads\\xioal.png"), "Bob", 35},
                        {new ImageIcon("C:\\Users\\Bamba\\Downloads\\xioal.png"), "Linda", 40}
                },
                new Object[]{"Icon", "Name", "Age"}
        );

        // Create table and set model
        table = new JTable(tableModel);

        // Set custom renderer for the first column to display icons
        table.getColumnModel().getColumn(0).setCellRenderer(new IconRenderer());

        // Create scroll pane and add table to it
        scrollPane = new JScrollPane(table);

        // Set the preferred size of the scroll pane
        scrollPane.setPreferredSize(new Dimension(380, 250));

        // Add the scroll pane to the frame
        add(scrollPane);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new test();
            }
        });
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
    }
}
