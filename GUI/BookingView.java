import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class BookingView extends JPanel{
    private JFrame fr;
    private JPanel panel;
    private JLabel pics, name, remainQ;
    private JButton book1, book2, book3, book4;
    private JTable table;
    private JScrollPane scrollPane;
    
    
    public BookingView() {
        
        fr = new JFrame();
        
        panel = new JPanel();
        
        pics = new JLabel();
        name = new JLabel();
        remainQ = new JLabel();
        
        book1 = new JButton();
        book2 = new JButton();
        book3 = new JButton();
        book4 = new JButton();
        
        table = new JTable(); 
        
        scrollPane = new JScrollPane();
        
        
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
        table.getColumnModel().getColumn(0).setCellRenderer(new BookingView.IconRenderer());

        // Create scroll pane and add table to it
        scrollPane = new JScrollPane(table);
        

        // Set the preferred size of the scroll pane
        scrollPane.setPreferredSize(new Dimension(380, 250));

        // Add the scroll pane to the frame
        fr.add(scrollPane);
        
        fr.add(table);
        fr.pack();
        fr.setVisible(true);

        
        
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
    
    public static void main(String[] args) {
        new BookingView();
    }
}
