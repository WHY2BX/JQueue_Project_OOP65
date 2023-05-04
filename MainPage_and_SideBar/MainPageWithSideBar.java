import SideMenuPanel.SideMenuPanel;
import java.awt.*;
import java.io.IOException;
import javax.swing.*;

public class MainPageWithSideBar extends JFrame{
//     private SideMenuPanel sp;
     private MainPage main;
     private LeftBar_2 side;
     private JPanel pl;
     public MainPageWithSideBar() throws IOException{
        pl = new JPanel();
        main = new MainPage();
        side = new LeftBar_2();

        this.setLayout(new BorderLayout());
        this.add(pl);
        this.add(main, BorderLayout.CENTER);
        this.add(side, BorderLayout.WEST);
         
        //default setting
        this.setSize(1300, 900);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
}
//        sp = new SideMenuPanel(this);
//        sp.setMain(main);
//        sp.setSide(side);
//        sp.setMinWidth(55);
//        sp.setMaxWidth(150);
//        sp.setMainAnimation(false);
//        //sp.setSpeed(4);
//        //sp.setResponsiveMinWidth(600);
//        
//     }
//    public void actionPerformed(java.awt.event.ActionEvent evt) {
//                menActionPerformed(evt);
//    }
//    private void menActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menActionPerformed
//        // TODO add your handling code here:
//        sp.onSideMenu();
//    }//GEN-LAST:event_menActionPerformed
//
//    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        sp.openMenu();
//    }//GEN-LAST:event_jButton2ActionPerformed
//
//    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        sp.closeMenu();        // TODO add your handling code here:
//    }//GEN-LAST:event_jButton1ActionPerformed
//
//}
