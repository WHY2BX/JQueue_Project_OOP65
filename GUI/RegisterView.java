
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author sudthirak
 */
public class RegisterView implements ActionListener{
    private JFrame fr;
    private JPanel p1, p2, p3, p4, p5, p6;
    private JTextField txt_user, txt_email;
    private JLabel register, user_name, pass, confirm, email;
    private JButton signin, back;
    private String username;
    private String password;
    private String emails;
    private JPasswordField txt_pass, txt_con;
    
    public RegisterView(){
        fr = new JFrame("Register");
        fr.setLayout(null);

        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        p6 = new JPanel();
        
        register = new JLabel("REGISTER", SwingConstants.CENTER);
        user_name = new JLabel("User Name");
        pass = new JLabel("Password");
        confirm = new JLabel("Confirm Password");
        email = new JLabel("E-mail");
        
        txt_user = new JTextField();
        txt_pass = new JPasswordField();
        txt_con = new JPasswordField();
        txt_email = new JTextField();
        
        signin = new JButton("Sign In");
        back = new JButton("Back to Login");
        
        //Register
        register.setBounds(320, 130, 650, 50);
        register.setFont(new Font("Arial", Font.BOLD, 40));
        
        //User
        user_name.setBounds(505, 230, 650, 25);
        user_name.setFont(new Font("Arial", Font.PLAIN, 20));
        txt_user.setBounds(500, 260, 300, 35);
        
        //Password
        pass.setBounds(505, 330, 650, 25);
        pass.setFont(new Font("Arial", Font.PLAIN, 20));
        txt_pass.setBounds(500, 360, 300, 35);
        
        //Confirm
        confirm.setBounds(505, 430, 650, 25);
        confirm.setFont(new Font("Arial", Font.PLAIN, 20));
        txt_con.setBounds(500, 460, 300, 35);
        
        //E-mail
        email.setBounds(505, 530, 650, 25);
        email.setFont(new Font("Arial", Font.PLAIN, 20));
        txt_email.setBounds(500, 560, 300, 35);
        
        //Signin
        signin.setBounds(600, 650, 100, 40);
        signin.setFont(new Font("Arial", Font.PLAIN, 15));
        
        //Back to Login
        back.setBounds(590, 700, 120, 40);
        back.setFont(new Font("Arial", Font.PLAIN, 15));
        
        back.addActionListener(this);
        signin.addActionListener(this);
        
        fr.add(register);
        
        fr.add(user_name);
        fr.add(txt_user);
        
        fr.add(pass);
        fr.add(txt_pass);
        
        fr.add(confirm);
        fr.add(txt_con);
        
        fr.add(email);
        fr.add(txt_email);
        
        fr.add(signin);
        fr.add(back);

        
        fr.setSize(1300, 900);
        Toolkit toolkit = Toolkit.getDefaultToolkit();  
        Dimension screenSize = toolkit.getScreenSize();  
        
        int x = (screenSize.width - fr.getWidth()) / 2;  
        int y = (screenSize.height - fr.getHeight()) / 2;  
        
        fr.setLocation(x, y);
        fr.setResizable(false);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        
    }

    private void Register(){
        username = String.valueOf(txt_user.getText());
        password = String.valueOf(txt_pass.getText());
        emails = txt_email.getText();
        int status = 0;
        PreparedStatement pstm = null;
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterView.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        try(Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_login_register","root","123");
            Statement state = connect.createStatement();    
            ResultSet rec = state.executeQuery("select * from user_information where user_email ='"+emails+"'");
            ){  if(username.equals("") || password.equals("") || String.valueOf(txt_con.getText()).equals("") || emails.equals("")){
                    JOptionPane.showConfirmDialog(null, "Please insert valid details", "Fail", JOptionPane.CLOSED_OPTION, 2);}
                else if(password.equals(String.valueOf(txt_con.getText())) == false){
                    JOptionPane.showConfirmDialog(null, "password is not corresponds", "Fail", JOptionPane.CLOSED_OPTION, 2);}
                else if(rec.next()){             
                    JOptionPane.showConfirmDialog(null, "This email is already used", "Fail", JOptionPane.CLOSED_OPTION, 2);}
                else{
                    String insert = "INSERT INTO user_information " +
                    "(user_name,user_password,user_email) " +
                    "VALUES (?,?,?)";
         
                    pstm = connect.prepareStatement(insert);
                    pstm.setString(1, username);
                    pstm.setString(2, password);
                    pstm.setString(3, emails);
                
                    status = pstm.executeUpdate();
            

                    if(status > 0){
                        JOptionPane.showConfirmDialog(null, "Register Completed", "Complete", JOptionPane.CLOSED_OPTION, 1);
                    }
                }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(signin)){
            Register();
        
        }
        else if(e.getSource().equals(back)){
            fr.dispose();
            new LoginView();
        }
        
        
        }
}
    
     