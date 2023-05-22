
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.*;

public class AccountView extends JPanel implements Runnable, ActionListener {

    private JFrame fr;
    private JPanel profile, details, buttons, inner1, inner2, inner3, inner4, blank, blank2, blank3, blank4;
    private JButton changepass, logout, refresh;
    private JLabel id, role, name, surname, pfp;
    private User user;

    public AccountView() {

        profile = new JPanel();
        buttons = new JPanel();
        details = new JPanel();
        id = new JLabel();
        role = new JLabel();
        name = new JLabel();
        surname = new JLabel();
        changepass = new JButton("Change Password");
        logout = new JButton("Log Out");
        refresh = new JButton("Refresh Page.");
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
        profile.setLayout(new GridLayout(1, 2));
        //details.setLayout(new GridLayout(2,1));
        ImageIcon icon = new ImageIcon(new ImageIcon("/Users/sudthirak/Desktop/capoo.png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        Image scaleImage = icon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        pfp = new JLabel(icon);

        inner1.setLayout(new GridLayout(2, 2));
        inner1.add(blank);
        inner1.add(blank2);
        inner1.add(id);
        inner1.add(role);

        inner2.setLayout(new GridLayout(2, 2));
        inner2.add(name);
        inner2.add(surname);
        inner2.add(blank3);
        inner2.add(blank4);

        details.setLayout(new GridLayout(2, 1));
        details.add(inner1);
        details.add(inner2);

        profile.add(pfp);
        profile.add(details);

        //buttons
//        buttons.add(changepass);
//        refresh.addActionListener(this);
//        buttons.add(refresh);

        //logout.addActionListener(this);
        //add to fr
        this.add(profile);
        this.add(buttons);

        
    }

    public void updateProfile() {
        User user = null;
        File file = new File("User.dat");
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream("User.dat"); ObjectInputStream ois = new ObjectInputStream(fis);) {
                user = (User) ois.readObject();
                id.setText(user.getStudent_id());
                name.setText(user.getFullname());
                role.setText(user.getRole());
            } catch (FileNotFoundException ex) {
                java.util.logging.Logger.getLogger(LeftBarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IOException | ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(LeftBarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
        this.revalidate();
    }

    @Override
    public void run() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
