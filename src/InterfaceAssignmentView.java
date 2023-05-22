import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

    public class InterfaceAssignmentView extends JPanel {
        private JTable table;
        private DefaultTableModel tableModel;
        private JLabel statusLabel;
        private JButton enqueueButton;
        private JButton delworkButton;
        
        private Queue<String> work;
        
        private AssignmentList al;
        
        private Thread t1;
        
        private DataModel dataModel;
        
        private int workNumber=0;

    public InterfaceAssignmentView(DataModel dataModel) {
        
        this.dataModel = dataModel;
        
        
        
        al = new AssignmentList();
        //t1 = new Thread(AssignmentView);
        work = new LinkedList<>();

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 300));

        JPanel inputPanel = new JPanel();
        enqueueButton = new JButton("Add work");
        enqueueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                enqueue();
            }
        });
        inputPanel.add(enqueueButton);
        
        table = new JTable(dataModel.getTableModel());
        
        
        // Custom renderer for button column
        table.setAutoResizeMode(AUTO_RESIZE_ALL_COLUMNS);

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel statusPanel = new JPanel();
        statusLabel = new JLabel("No assignment.");
        statusPanel.add(statusLabel);

        delworkButton = new JButton("Delete assignment");
        delworkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                delwork();
            }
        });

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);
        add(delworkButton, BorderLayout.EAST);
    }

    private void enqueue() {
        String assignmentName = JOptionPane.showInputDialog(this, "Enter Assignment Name:");
        if (assignmentName != null && !assignmentName.isEmpty()) {
            String deadline = JOptionPane.showInputDialog(this, "Enter Deadline:");
            if (deadline != null && !deadline.isEmpty()) {
                    workNumber ++;
                    dataModel.addItem(workNumber,assignmentName,  deadline);
                    //al.add(new AssignmentDetails(workNumber, assignmentName, deadline));
                    work.add(workNumber + ", " + assignmentName + ", " + deadline);
                    updateStatus();
            }
        }
    }


    private JButton createBeingCheckedButton(Object[] rowData) {
        JButton button = new JButton("Being Checked");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            // action preform here but i dont know what
            }
        });
        button.addMouseListener(new MouseAdapter() {
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
                // Double-click event code here...
                String studentNumber = JOptionPane.showInputDialog(InterfaceAssignmentView.this, "Enter Student Number:");
                if (studentNumber != null && !studentNumber.isEmpty()) {
                    // delwork the corresponding row
                    int seatNumber = dataModel.getTableModel().getRowCount();
                    for (int i = 0; i < dataModel.getTableModel().getRowCount(); i++) {
                        if (dataModel.getTableModel().getValueAt(i, 1).equals(rowData[1])) {
                            dataModel.getTableModel().removeRow(i);
                            break;
                        }
                    }
                    updateStatus();

                    JOptionPane.showMessageDialog(InterfaceAssignmentView.this, "Seat Number: " + seatNumber + ", Student Number: " + studentNumber);
                }
            }
        }
    });
    return button;
}
    private void delwork() {
        if (dataModel.getTableModel().getRowCount() > 0) {
            dataModel.getTableModel().removeRow(0);
            work.poll();
            workNumber--;
            updateStatus();
        }
    }

    private void updateStatus() {
        if (work.isEmpty()) {
            statusLabel.setText("work is empty.");
            delworkButton.setEnabled(false);
        } else {
            statusLabel.setText("work size: " + work.size());
            delworkButton.setEnabled(true);
        }
    }

}