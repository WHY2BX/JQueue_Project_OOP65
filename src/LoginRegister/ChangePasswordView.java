package LoginRegister;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author sudthirak
 */
public class ChangePasswordView implements ActionListener{
    private JFrame fr;
    private JPanel p1, p2, p3, p4, p5, p6;
    private JTextField txt_old, txt_new, txt_con, txt_email;
    private JLabel change, old, new_pass, confirm, email;
    private JButton save;
    private String newpass;
    public ChangePasswordView (){
        fr = new JFrame("Change Password");
        fr.setLayout(null);

        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        p6 = new JPanel();
        
        change = new JLabel("Change Password", SwingConstants.CENTER);
        old = new JLabel("Old Password");
        new_pass = new JLabel("New Password");
        confirm = new JLabel("Confirm Password");
        email = new JLabel("E-mail");
        
        txt_old = new JTextField();
        txt_new = new JTextField();
        txt_con = new JTextField();
        txt_email = new JTextField();
        
        save = new JButton("Save");
        
        
        //Change
        change.setBounds(325, 130, 650, 50);
        change.setFont(new Font("Arial", Font.BOLD, 40));
        
        //Old Password
        old.setBounds(505, 230, 650, 25);
        old.setFont(new Font("Arial", Font.PLAIN, 20));
        txt_old.setBounds(500, 260, 300, 35);
        
        //New Password
        new_pass.setBounds(505, 330, 650, 25);
        new_pass.setFont(new Font("Arial", Font.PLAIN, 20));
        txt_new.setBounds(500, 360, 300, 35);
        
        //Confirm
        confirm.setBounds(505, 430, 650, 25);
        confirm.setFont(new Font("Arial", Font.PLAIN, 20));
        txt_con.setBounds(500, 460, 300, 35);
        
        //E-mail
        email.setBounds(505, 530, 650, 25);
        email.setFont(new Font("Arial", Font.PLAIN, 20));
        txt_email.setBounds(500, 560, 300, 35);
        
        //Save
        save.setBounds(600, 650, 100, 40);
        save.setFont(new Font("Arial", Font.PLAIN, 15));
        save.addActionListener(this);
        
        fr.add(change);
        
        fr.add(old);
        fr.add(txt_old);
        
        fr.add(new_pass);
        fr.add(txt_new);
        
        fr.add(confirm);
        fr.add(txt_con);
        
        fr.add(email);
        fr.add(txt_email);
        
        fr.add(save);

       
        fr.setSize(1300, 900);
        fr.setResizable(false);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource().equals(save)){
            newpass = txt_new.getText();
            int status = 0;
            Connection connect = null;
            Statement state = null;
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_login_register","root","Ff050647123");
                    state = connect.createStatement();
                    if(newpass.equals(txt_con.getText())){
                        
                        
                        
                    }
                
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ChangePasswordView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ChangePasswordView.class.getName()).log(Level.SEVERE, null, ex);
                }
                
       
    }
}
}
