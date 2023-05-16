import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class AccountView extends JPanel implements ActionListener{
    private JFrame fr;
    private JPanel profile,details, buttons, inner1, inner2, inner3, inner4, blank, blank2, blank3, blank4;
    private JButton changepass, logout;
    private JLabel id, role, name, surname , pfp;
    
    public AccountView(){

        profile = new JPanel();
        buttons = new JPanel();
        details = new JPanel();
        id = new JLabel("11111111");
        role = new JLabel("Student");
        name = new JLabel("Name");
        surname = new JLabel("Surname");
        changepass = new JButton("Change Password");
        logout = new JButton("Log Out");
        inner1 = new JPanel();
        inner2 = new JPanel();
        inner3 = new JPanel();
        inner4 = new JPanel();
        blank = new JPanel();
        blank2 = new JPanel();
        blank3 = new JPanel();
        blank4 = new JPanel();
        
        //setting fontSize
        id.setFont(new Font("FC Friday", Font.PLAIN, 25));
        role.setFont(new Font("FC Friday", Font.PLAIN, 25));
        
        name.setFont(new Font("FC Friday", Font.PLAIN, 50));
        surname.setFont(new Font("FC Friday", Font.PLAIN, 50));
        
        //setting Jframe
        this.setLayout(new GridLayout(2, 1));
        
        //
        profile.setLayout(new GridLayout(1,2));
        //details.setLayout(new GridLayout(2,1));
        ImageIcon icon = new ImageIcon(new ImageIcon("C:\\Users\\Bamba\\Downloads\\raiden.jpg").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        Image scaleImage = icon.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        pfp = new JLabel(icon);
        
        
        inner1.setLayout(new GridLayout(2, 2));
        inner1.add(blank);
        inner1.add(blank2);
        inner1.add(id);
        inner1.add(role);
        
        inner2.setLayout(new GridLayout(2,2));
        inner2.add(name);
        inner2.add(surname);
        inner2.add(blank3);
        inner2.add(blank4);
        
        details.setLayout(new GridLayout(2,1));
        details.add(inner1);
        details.add(inner2);
        
        

        

        profile.add(pfp);
        profile.add(details);
        
        //buttons
        buttons.add(changepass);
        buttons.add(logout);
        
        
        //add to fr
        this.add(profile);
        this.add(buttons);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}