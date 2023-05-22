
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

public class RemainQueueView extends JPanel implements JQueueRunnable, ActionListener {

    private JFrame fr;

    private JTable table;
    private DefaultTableModel tableModel;
    private JLabel statusLabel, header;
    private JButton enqueueButton;
    private JButton dequeueButton, update, delete;
    private JPanel headerSpace, panel, updateBtn;

    private Queue<String> queue;

    //private BookingView bv;
    private EnqueueView ev;

    private DataModel_2 dataModel2;

    private TaList talist;
    private int x;

    private IndexPass pass;
    private int index;

    public RemainQueueView(TaList talist, IndexPass pass) {

        this.talist = talist;
        this.pass = pass;

        fr = new JFrame();

        dataModel2 = new DataModel_2();

        queue = new LinkedList<>();

        panel = new JPanel();
        updateBtn = new JPanel();

        headerSpace = new JPanel();

        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(400, 300));

        table = new JTable(dataModel2.getTableModel());

        // Custom renderer for button column
        header = new JLabel("Assignment");
        header.setFont(new Font("FC Friday", Font.PLAIN, 20));

        headerSpace.setLayout(new GridBagLayout());
        headerSpace.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        headerSpace.add(header);

        x = (talist.get(0).getQueue().size()) - 1;
        if (x > 0) {
            Student s = talist.get(x).getQueue().get(x).getStudent();
            String taName = talist.get(x).getFullname();
            dataModel2.addItem(s.getFullname(), talist.get(x).getQueue().get(x).getAssignName(), talist.get(x).getQueue().get(x).getTableNum(), taName);
        }

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel statusPanel = new JPanel();
        statusLabel = new JLabel("No Assignment.");
        statusPanel.add(statusLabel);

        panel.add(headerSpace, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        //add(statusPanel, BorderLayout.SOUTH);

        update = new JButton("Update");
        update.addActionListener(this);
        delete = new JButton("Delete");
        delete.addActionListener(this);
        updateBtn.add(update);
        updateBtn.add(delete);

        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.CENTER);
        this.add(updateBtn, BorderLayout.SOUTH);

    }

    public void update() {
        index = pass.getIndex();
        x = (talist.get(index).getQueue().size()) - 1;

        Student s = talist.get(index).getQueue().get(x).getStudent();
        String taName = talist.get(index).getFullname();
        dataModel2.addItem(s.getFullname(), talist.get(index).getQueue().get(x).getAssignName(), talist.get(index).getQueue().get(x).getTableNum(), taName);
    }

    @Override
    public void run() {
        fr.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(update)) {
            update();
        }
        else if (e.getSource().equals(delete)) {
            int row = table.getSelectedRow();
            
            String assign = table.getModel().getValueAt(row, 1).toString();  
            String ta = table.getModel().getValueAt(row, 3).toString();
            System.out.println(ta);
            int newindexTa = talist.getIndexOf(ta);
            
            System.out.println(newindexTa);
            
            BookingList q = talist.get(newindexTa).getQueue();
            
            //int newindexAssign = talist.get(newindexTa).getQueue().getIndexOf(assign);
            
            talist.get(newindexTa).getQueue().remove(0);
            
            q.forEach();   
            
            dataModel2.getTableModel().removeRow(row);
            talist.get(newindexTa).delRemainQ();
            
            table.repaint();
            this.revalidate();
        }
    }

}
