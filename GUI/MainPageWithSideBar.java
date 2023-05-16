import SideMenuPanel.SideMenuPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class MainPageWithSideBar extends JFrame implements ActionListener{
//     private SideMenuPanel sp;
     private MainPageView main;
     private LeftBarView side;
     private JPanel pl;
     private InterfaceAssignmentView iv;
     
     public MainPageWithSideBar() throws IOException{
        pl = new JPanel();
        main = new MainPageView();
        side = new LeftBarView();
        iv = new InterfaceAssignmentView();

        this.setLayout(new BorderLayout());
        this.add(pl);
        this.add(iv, BorderLayout.CENTER);
        this.add(side, BorderLayout.WEST);
         
        //default setting
        this.setSize(1300, 900);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
     
     
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }



}

