import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EnqueueView extends JFrame implements ActionListener {

    private JFrame fr;
    private JPanel p1, p2, p3, p4, p5, p6, p7;
    private JLabel header, pic, name, desktext;
    private JComboBox assign;
    private JTextField deskid;
    private JButton button;
    int max = 12;
    private JInternalFrame inter;
    private TaList taList;
    private Student s0;
    private int index;
    private IndexPass pass;

    public EnqueueView(TaList taList, IndexPass pass) {
        //fr = new JFrame("Enqueue");

        s0 = new Student("2B", "65070241", "Student");

        this.index = pass.getIndex();

        pass.setIndex(index);
        this.taList = taList;

        inter = new JInternalFrame();
        this.setLayout(new GridLayout(7, 1));
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        p6 = new JPanel();
        p7 = new JPanel();
        header = new JLabel("You're booking...");
        name = new JLabel(taList.get(index).getFullname());
        assign = new JComboBox();

        for (int i = 1; i <= max; i++) {
            assign.addItem("Assignment" + " " + i);
        }

        button = new JButton("Book");
        button.addActionListener(this);
        ImageIcon icon = new ImageIcon(new ImageIcon("/Users/sudthirak/Desktop/capoo.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
        Image scaleImage = icon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        pic = new JLabel(icon);
        deskid = new JTextField(25);
        desktext = new JLabel("Table Number");
        deskid.setHorizontalAlignment(JTextField.CENTER);

        p1.add(header);
        p2.add(pic);
        p3.add(name);
        p4.add(assign);
        p5.add(desktext);
        p6.add(deskid);
        p7.add(button);

        this.add(p1);
        this.add(p2);
        this.add(p3);
        this.add(p4);
        this.add(p5);
        this.add(p6);
        this.add(p7);

        this.setSize(400, 550);
        this.setResizable(false);
        this.setVisible(true);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        int x = (screenSize.width - this.getWidth()) / 2;
        int y = (screenSize.height - this.getHeight()) / 2;

        this.setLocation(x, y);
        //this.add(inter);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public TaList getTaList() {
        return this.taList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(button)) {

            String assignName = assign.getSelectedItem() + "";
            String tableNum = deskid.getText() + "";
            taList.get(index).getQueue().add(new BookingDetails(s0, assignName, tableNum));
            taList.get(index).addRemainQ();
            JOptionPane.showConfirmDialog(null, "Booking Complete", "Completed", JOptionPane.PLAIN_MESSAGE, 1);
            this.dispose();
            //System.out.println(taList.get(index).getQueue().get(index).getAssignName());
            System.out.println("eiei");

        }
    }
}