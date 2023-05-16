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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

    public class InterfaceAssignmentView extends JPanel {
        private JTable table;
        private DefaultTableModel tableModel;
        private JLabel statusLabel;
        private JButton enqueueButton;
        private JButton dequeueButton;

        private Queue<String> queue;

    public InterfaceAssignmentView() {
        queue = new LinkedList<>();

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 300));

        JPanel inputPanel = new JPanel();
        enqueueButton = new JButton("Enqueue");
        enqueueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                enqueue();
            }
        });
        inputPanel.add(enqueueButton);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Queue Number");
        tableModel.addColumn("Seat Number");
        tableModel.addColumn("Student Number");
        tableModel.addColumn("Assignment Number");
        tableModel.addColumn("Being Checked by");
        table = new JTable(tableModel);

        // Custom renderer for button column
        table.setAutoResizeMode(AUTO_RESIZE_ALL_COLUMNS);
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (value instanceof JButton) {
                    JButton button = (JButton) value;
                    return button;
                } else {
                    return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                }
            }
        });

        table.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        int row = table.rowAtPoint(evt.getPoint());
        int col = table.columnAtPoint(evt.getPoint());
        if (col == 3) {
            JButton button = (JButton) table.getValueAt(row, col);
            button.doClick();
        }
    }
    });

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel statusPanel = new JPanel();
        statusLabel = new JLabel("Queue is empty.");
        statusPanel.add(statusLabel);

        dequeueButton = new JButton("Dequeue");
        dequeueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dequeue();
            }
        });

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);
        add(dequeueButton, BorderLayout.EAST);
    }

    private void enqueue() {
        String studentNumber = JOptionPane.showInputDialog(this, "Enter Student Number:");
        if (studentNumber != null && !studentNumber.isEmpty()) {
            String assignmentNumber = JOptionPane.showInputDialog(this, "Enter Assignment Number:");
            if (assignmentNumber != null && !assignmentNumber.isEmpty()) {
                String seatNumber = JOptionPane.showInputDialog(this, "Enter Seat Number:");
                if (seatNumber != null && !seatNumber.isEmpty()) {
                    int queueNumber = queue.size() + 1;
                    Object[] rowData = new Object[5];
                    rowData[0] = queueNumber;
                    rowData[1] = seatNumber;
                    rowData[2] = studentNumber;
                    rowData[3] = assignmentNumber;
                    rowData[4] = createBeingCheckedButton(rowData);
                    queue.add(rowData[0] + ", " + rowData[1] + ", " + rowData[2]);
                    tableModel.addRow(rowData);
                    updateStatus();
            }
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
                    // Dequeue the corresponding row
                    int seatNumber = (int) rowData[1];
                    queue.poll();
                    for (int i = 0; i < tableModel.getRowCount(); i++) {
                        if (tableModel.getValueAt(i, 1).equals(rowData[1])) {
                            tableModel.removeRow(i);
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
    private void dequeue() {
        if (tableModel.getRowCount() > 0) {
            queue.poll();
            tableModel.removeRow(0);
            updateStatus();
        }
    }

    private void updateStatus() {
        if (queue.isEmpty()) {
            statusLabel.setText("Queue is empty.");
            dequeueButton.setEnabled(false);
        } else {
            statusLabel.setText("Queue size: " + queue.size());
            dequeueButton.setEnabled(true);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Queue Interface");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        InterfaceAssignmentView queueInterface = new InterfaceAssignmentView();
        frame.getContentPane().add(queueInterface);
        frame.resize (500, 800);
        frame.setVisible(true);
    }
}