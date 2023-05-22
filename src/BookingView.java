
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class BookingView extends JPanel implements ActionListener, Runnable {

    private JFrame fr;

    private JPanel panelContainer1;
    
    private JPanel statusContainer1, statusContainer2, statusContainer3, statusContainer4;

    private JPanel panel, headerSpace, forBtn, forPics, interPanel, anotherPane, updateBtn;
    private JLabel pics, name, remainQ1, remainQ2, remainQ3, remainQ4, header, ready, busy, ready2, busy2, ready3, busy3, ready4, busy4, taName1, taName2, taName3, taName4;
    private JButton book1, book2, book3, book4, book5, update;
    private JTable table;
    private JScrollPane scrollPane;
    private JInternalFrame fr1;

    private static TaList talist;

    private IndexPass pass;
    

    public BookingView(TaList talist, IndexPass pass) {

        this.talist = talist;
        this.pass = pass;
        
        

        //fr = new JFrame();
        panel = new JPanel();
        headerSpace = new JPanel();
        forBtn = new JPanel();
        forPics = new JPanel();
        interPanel = new JPanel();
        interPanel.setLayout(new FlowLayout());

        anotherPane = new JPanel();
        updateBtn = new JPanel();

        taName1 = new JLabel((talist.get(0)).getFullname());
        taName1.setHorizontalAlignment(SwingConstants.CENTER);
        taName2 = new JLabel((talist.get(1)).getFullname());
        taName2.setHorizontalAlignment(SwingConstants.CENTER);
        taName3 = new JLabel((talist.get(2)).getFullname());
        taName3.setHorizontalAlignment(SwingConstants.CENTER);
        taName4 = new JLabel((talist.get(3)).getFullname());
        taName4.setHorizontalAlignment(SwingConstants.CENTER);

        pics = new JLabel();
        pics.setHorizontalAlignment(SwingConstants.CENTER);
        forPics.add(pics);

        remainQ1 = new JLabel(talist.get(0).getRemainQ() + "/5");
        remainQ1.setHorizontalAlignment(SwingConstants.CENTER);
        remainQ2 = new JLabel(talist.get(1).getRemainQ() + "/5");
        remainQ2.setHorizontalAlignment(SwingConstants.CENTER);
        remainQ3 = new JLabel(talist.get(2).getRemainQ() + "/5");
        remainQ3.setHorizontalAlignment(SwingConstants.CENTER);
        remainQ4 = new JLabel(talist.get(3).getRemainQ() + "/5");
        remainQ4.setHorizontalAlignment(SwingConstants.CENTER);

        header = new JLabel("TA Queue");
        header.setFont(new Font("FC Friday", Font.PLAIN, 20));

        book1 = new JButton("Book TA#1");
        book2 = new JButton("Book TA#2");
        book3 = new JButton("Book TA#3");
        book4 = new JButton("Book TA#4");
        update = new JButton("Update");

        ready = new JLabel("ready");
        ready.setHorizontalAlignment(SwingConstants.CENTER);
        busy = new JLabel("Busy");
        busy.setHorizontalAlignment(SwingConstants.CENTER);
        
        ready2 = new JLabel("ready");
        ready2.setHorizontalAlignment(SwingConstants.CENTER);
        busy2 = new JLabel("Busy");
        busy2.setHorizontalAlignment(SwingConstants.CENTER);
        
        ready3 = new JLabel("ready");
        ready3.setHorizontalAlignment(SwingConstants.CENTER);
        busy3 = new JLabel("Busy");
        busy3.setHorizontalAlignment(SwingConstants.CENTER);
        
        ready4 = new JLabel("ready");
        ready4.setHorizontalAlignment(SwingConstants.CENTER);
        busy4 = new JLabel("Busy");
        busy4.setHorizontalAlignment(SwingConstants.CENTER);
        //offline = new JLabel("Offline");
        //offline.setHorizontalAlignment(SwingConstants.CENTER);
        
        statusContainer1 = new JPanel(new CardLayout());
        statusContainer1.add(ready, "ready");
        statusContainer1.add(busy, "busy");

        statusContainer2 = new JPanel(new CardLayout());
        statusContainer2.add(ready2, "ready");
        statusContainer2.add(busy2, "busy");
        
        statusContainer3 = new JPanel(new CardLayout());
        statusContainer3.add(ready3, "ready");
        statusContainer3.add(busy3, "busy");
        
        statusContainer4 = new JPanel(new CardLayout());
        statusContainer4.add(ready4, "ready");
        statusContainer4.add(busy4, "busy");
        
        //working zone
        book1.addActionListener(this);
        book2.addActionListener(this);
        book3.addActionListener(this);
        book4.addActionListener(this);
        update.addActionListener(this);

        forBtn.setLayout(new GridLayout(4, 1));
        forBtn.add(book1);
        forBtn.add(book2);
        forBtn.add(book3);
        forBtn.add(book4);

        updateBtn.add(update);

        table = new JTable();

        headerSpace.setLayout(new GridBagLayout());
        headerSpace.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        headerSpace.add(header);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Apply the custom cell renderer to all columns
        int columnCount = table.getColumnModel().getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        DefaultTableModel tableModel = new DefaultTableModel(
                new Object[][]{
                    {new ImageIcon("/Users/sudthirak/Desktop/capoo.png"), taName1, remainQ1, statusContainer1, book1},
                    {new ImageIcon("/Users/sudthirak/Desktop/capoo.png"), taName2, remainQ2, statusContainer2, book2},
                    {new ImageIcon("/Users/sudthirak/Desktop/capoo.png"), taName3, remainQ3, statusContainer3, book3},
                    {new ImageIcon("/Users/sudthirak/Desktop/capoo.png"), taName4, remainQ4, statusContainer4, book4}, //"C:\Users\Windows10\Downloads"
                },
                new Object[]{"pics", "Name", "Queue", "Status"}
        );

        //tableModel.setHorizontalAlignment(SwingConstants.CENTER);
        // Create table and set model
        table = new JTable();

        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (value instanceof JLabel) {
                    JLabel label = (JLabel) value;
                    return label;
                } else if (value instanceof JButton) {
                    JButton button = (JButton) value;
                    return button;
                } else if (value instanceof JPanel) {
                    JPanel panel = (JPanel) value;
                    return panel;
                } else {
                    return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                }
            }
        });

        table.setModel(tableModel);
        //table

        // Set custom renderer for the first column to display icons
        table.getColumnModel().getColumn(0).setPreferredWidth(60);
        table.getColumnModel().getColumn(0).setCellRenderer(new BookingView.IconRenderer());

        // SetHeight of row
        table.setRowHeight(200);
        // Create scroll pane and add table to it

        scrollPane = new JScrollPane(table);

        // Set the preferred size of the scroll pane
        scrollPane.setPreferredSize(new Dimension(380, 250));

        // Add the scroll pane to the frame
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(forBtn, BorderLayout.EAST);

        anotherPane.setLayout(new BorderLayout());
        anotherPane.add(panel, BorderLayout.CENTER);
        anotherPane.add(updateBtn, BorderLayout.SOUTH);

        this.setLayout(new BorderLayout());
        this.add(headerSpace, BorderLayout.NORTH);
        this.add(anotherPane, BorderLayout.CENTER);
        //fr.pack();
        //fr.setVisible(true);
        //fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void update() {

        int ta01 = talist.get(0).getRemainQ();
        int ta02 = talist.get(1).getRemainQ();
        int ta03 = talist.get(2).getRemainQ();
        int ta04 = talist.get(3).getRemainQ();

        remainQ1.setText(ta01 + "/5");
        remainQ1.setHorizontalAlignment(SwingConstants.CENTER);
        remainQ2.setText(ta02 + "/5");
        remainQ2.setHorizontalAlignment(SwingConstants.CENTER);
        remainQ3.setText(ta03 + "/5");
        remainQ3.setHorizontalAlignment(SwingConstants.CENTER);
        remainQ4.setText(ta04 + "/5");
        remainQ4.setHorizontalAlignment(SwingConstants.CENTER);

        remainQ1.revalidate();
        remainQ2.revalidate();
        remainQ3.revalidate();
        remainQ4.revalidate();

        table.repaint();
        
        if(ta01 == 5){
            CardLayout cardLayout = (CardLayout) statusContainer1.getLayout();
            cardLayout.show(statusContainer1, "busy");
        }
        if(ta02 == 5){
            CardLayout cardLayout = (CardLayout) statusContainer2.getLayout();
            cardLayout.show(statusContainer2, "busy");
        }
        if(ta03 == 5){
            CardLayout cardLayout = (CardLayout) statusContainer3.getLayout();
            cardLayout.show(statusContainer3, "busy");
        }
        if(ta04 == 5){
            CardLayout cardLayout = (CardLayout) statusContainer4.getLayout();
            cardLayout.show(statusContainer4, "busy");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) throws IndexOutOfBoundsException {
        if (e.getSource().equals(book1)) {
            pass.setIndex(0);
            new EnqueueView(talist, pass);
        } else if (e.getSource().equals(book2)) {
            pass.setIndex(1);
            new EnqueueView(talist, pass);
        } else if (e.getSource().equals(book3)) {
            pass.setIndex(2);
            new EnqueueView(talist, pass);
        } else if (e.getSource().equals(book4)) {
            pass.setIndex(3);
            new EnqueueView(talist, pass);
        } else if (e.getSource().equals(update)) {
            update();
            this.revalidate();

        }

    }

    @Override
    public void run() {
        this.revalidate();
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

    public static TaList getTaList() {
        return talist;
    }

}
