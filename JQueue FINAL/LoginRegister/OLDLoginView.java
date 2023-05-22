package LoginRegister;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author sudthirak
 */
public class OLDLoginView implements ActionListener{
    private JFrame fr;
    private JPanel panel, p2, p3, p4, p5, p6;
    private JTextField txt_user, txt_password;
    private JLabel user_name, password, login;
    private JButton signin, test, register;
    private String name;
    private String passwords;
    
    public OLDLoginView(){
        fr = new JFrame("Login");
        fr.setLayout(null);
                
        panel = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        
        login = new JLabel("LOGIN", SwingConstants.CENTER);
        
        user_name = new JLabel("User Name");
        
        password = new JLabel("Password");
        signin = new JButton("Sign In");
        register = new JButton("Reigister Now");
        
        txt_user = new JTextField(45);
        txt_password = new JTextField(45);
        

        // Login
        login.setFont(new Font("Arial", Font.BOLD, 40));
        login.setBounds(320, 200, 650, 50);
        
        // User
        user_name.setBounds(505, 300, 650, 25);
        user_name.setFont(new Font("Arial", Font.PLAIN, 20));    
        txt_user.setBounds(500, 330, 300, 35);
     
        // Password
        password.setBounds(505, 400, 650, 25);
        password.setFont(new Font("Arial", Font.PLAIN, 20));
        txt_password.setBounds(500, 430, 300, 35);

        //signin
        signin.setBounds(600, 550, 100, 40);
        signin.setFont(new Font("Arial", Font.PLAIN, 15));
        
        register.setBounds(575, 600, 150, 40);
        register.setFont(new Font("Arial", Font.PLAIN, 15));
        
        
        fr.add(login);
        
        fr.add(user_name);
        fr.add(txt_user);
        
        fr.add(password);
        fr.add(txt_password);
        
        fr.add(signin);
        fr.add(register);
        signin.addActionListener(this);
        register.addActionListener(this);
       
        fr.setSize(1300, 900);
        fr.setResizable(false);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(signin)){
            name = txt_user.getText();
            passwords = txt_password.getText();
            
            Connection connect = null;
            Statement state = null;
        
        try {           
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_login_register","root","123");
            state = connect.createStatement();
            ResultSet rec = state.executeQuery("select * from user_information where user_name ='"+name+"'and user_password ='"+passwords+"'");
          
            if(rec.next()){
                login.setText("Success");
            }
            
            
            rec.close();
        } 
        catch (ClassNotFoundException ex) {
            System.out.println("notfound");
        
        }       
        catch(Exception exception){
            exception.printStackTrace();
    }
            try {
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(OLDLoginView.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                state.close();
            } catch (SQLException ex) {
                Logger.getLogger(OLDLoginView.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        
        }
        else if(e.getSource().equals(register)){
            fr.dispose();
            new OLDRegisterView();
        }
        
        
    }


    
}