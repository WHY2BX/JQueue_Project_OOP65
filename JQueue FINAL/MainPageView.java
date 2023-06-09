import java.awt.*;
import java.awt.Font;
import java.io.IOException;
import javax.swing.*;
import SideMenuPanel.SideMenuPanel;

public class MainPageView extends JPanel{
    
   //panel
    private JPanel panel,panel2, panel3, panel4, panel5, blank;
    
    //label
    private JLabel txt;
    
    //button
    private JButton q;
    
    //leftBar
    private LeftBarView leftBar;
    
    //private SideMenuPanel sp;
    
    public MainPageView() throws IOException{
        
        //sp = new SideMenuPanel(this);
        panel = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        
        txt = new JLabel("Welcome to JQUEUE");
        txt.setFont(new Font("FC Friday", Font.PLAIN, 45));
        //q = new JButton("Enter");
        
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(txt);
        
        panel2.setLayout(new GridBagLayout());
        panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //panel2.add(q);
        
        panel3.setLayout(new GridBagLayout());
        panel3.add(panel4);
        
        panel4.setLayout(new BorderLayout());
        panel4.add(panel5, BorderLayout.NORTH);
        
        panel5.setLayout(new GridLayout(2,1));
        panel5.add(panel);
        panel5.add(panel2);
        
        this.setLayout(new  BorderLayout());
        this.add(panel3);
        //sp.setSide(leftBar);
        
        //default setting
        this.setSize(1300,900);
        this.setVisible(true);
        
    }
}
