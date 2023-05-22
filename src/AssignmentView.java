
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

    public class AssignmentView extends JPanel{
        
        private JFrame fr;
        
        private JTable table;
        private DefaultTableModel tableModel;
        private JLabel statusLabel, header;
        private JButton enqueueButton;
        private JButton dequeueButton;
        private JPanel headerSpace;

        private Queue<String> queue;
        
        private Thread t1;
        
        private DataModel dataModel;

    public AssignmentView(DataModel dataModel) {
        
        fr = new JFrame();
        
        this.dataModel = dataModel;
        
        queue = new LinkedList<>();
        
        headerSpace = new JPanel();
        
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 300));

        table = new JTable(dataModel.getTableModel());
        
        
        // Custom renderer for button column
        
        header = new JLabel("Assignment");
        header.setFont(new Font("FC Friday", Font.PLAIN, 20));
        
        headerSpace.setLayout(new GridBagLayout());
        headerSpace.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        headerSpace.add(header);
        
        

        JScrollPane scrollPane = new JScrollPane(table);
        
        
        JPanel statusPanel = new JPanel();
        statusLabel = new JLabel("No Assignment.");
        statusPanel.add(statusLabel);

        
        
        add(headerSpace, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);
        
        fr.add(this);
        fr.pack();
        fr.setVisible(true);
    }

    private void updateStatus() {
        if (queue.isEmpty()) {
            statusLabel.setText("No Assignment.");
            dequeueButton.setEnabled(false);
        } else {
            statusLabel.setText("Assignment remain : " + queue.size());
            dequeueButton.setEnabled(true);
        }
    }

}