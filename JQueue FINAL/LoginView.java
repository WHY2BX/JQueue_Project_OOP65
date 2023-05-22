
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
import java.io.*;

/**
 *
 * @author sudthirak
 */
public class LoginView implements ActionListener, WindowListener, SqlInterface {

    private JFrame fr;
    private JPanel panel, p2, p3, p4, p5, p6;
    private JTextField txt_user;
    private JLabel user_name, password, login;
    private JButton signin, test, register;
    private String name;
    private String passwords;
    private JPasswordField txt_password;
    private boolean is_Ta;
    private String emailcheck;

    public LoginView() {
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
        fr.getRootPane().setDefaultButton(signin);
        register = new JButton("Reigister Now");

        txt_user = new JTextField(45);
        txt_password = new JPasswordField(45);

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

        fr.addWindowListener(this);
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

    public void is_TA() {
        emailcheck = "";

        try (Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_login_register", "root", "pass1234"); Statement state = connect.createStatement(); ResultSet rec1 = state.executeQuery("select user_email from user_information where user_name ='" + name + "'and user_password ='" + passwords + "'");) {
            if (rec1.next()) {
                emailcheck = rec1.getString("user_email");
                System.out.println(rec1.getString("user_email"));
            }

            if (emailcheck.equals("65070233@kmitl.ac.th") || (emailcheck.equals("65070241@kmitl.ac.th")) || (emailcheck.equals("65070238@kmitl.ac.th"))) {
                is_Ta = true;
            } else {
                is_Ta = false;
            }
            System.out.println(is_Ta);
        } catch (SQLException ex) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void connect() {
        name = txt_user.getText();
        passwords = String.valueOf(txt_password.getText());
        this.is_TA();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_login_register", "root", "pass1234"); Statement state = connect.createStatement(); ResultSet rec = state.executeQuery("select * from user_information where user_name ='" + name + "'and user_password ='" + passwords + "'");) {
            if (name.equals("") || passwords.equals("")) {
                JOptionPane.showConfirmDialog(null, "Please insert valid details", "Fail", JOptionPane.CLOSED_OPTION, 2);
            } else if (rec.next()) {
                fr.dispose();
                DataModel dataModel = new DataModel();
                TaList talist = new TaList();
                if (is_Ta == true) {
                    new LeftBarTAView(dataModel, talist);      // Thisssssss
                    new AssignmentView(dataModel);
                    System.out.println("is_Ta =" + is_Ta);
                    System.out.println("I am TA");
                } else if (is_Ta == false) {
                    new LeftBarView(dataModel, talist);
                    System.out.println("is_Ta =" + is_Ta);
                    System.out.println("I am Student");
                }
            } else {
                JOptionPane.showConfirmDialog(null, "Username or Password is wrong", "Fail", JOptionPane.CLOSED_OPTION, 2);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(signin)) {
            connect();
        } else if (e.getSource().equals(register)) {
            fr.dispose();
            new RegisterView();
        }

    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {
        this.is_TA();
        User user = new User();
        if(emailcheck.length() >=8){
        if(is_Ta == true){
           user.setStudent_id(emailcheck.substring(0, 8));
           user.setRole("Ta");
           user.setFullname(name);
        }
        else{
           user.setStudent_id(emailcheck.substring(0, 8));
           user.setRole("Student");
           user.setFullname(name);
        }
        }
        try(FileOutputStream fout = new FileOutputStream("User.dat");
            ObjectOutputStream oout = new ObjectOutputStream(fout);    
            ){oout.writeObject(user);  
        } catch (IOException ex) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
