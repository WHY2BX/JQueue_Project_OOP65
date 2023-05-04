import java.awt.*;
import java.io.IOException;
import javax.swing.*;
public class LeftBar_2 extends JPanel{
    protected JPanel blank, dash, forBtn, profile, mainSpace, nameSpace, idSpace, detialsSpace, roleSpace, pics, queueBtn, assignBtn, scorebBtn, bbtn, mainPage;
    protected JButton queue ,assign, scoreb;
    protected JLabel id,  name, role;
    public LeftBar_2() throws IOException{
    //panel zone
        blank = new JPanel();
        dash = new JPanel();
        forBtn = new JPanel();
        pics = new JPanel();
        mainSpace = new JPanel();
        nameSpace = new JPanel();
        detialsSpace = new JPanel();
        idSpace = new JPanel();
        roleSpace = new JPanel();
        profile = new JPanel();
        queueBtn = new JPanel();
        assignBtn = new JPanel();
        scorebBtn = new JPanel();
        bbtn = new JPanel();
        
        //button zone
        queue = new JButton("Queue");
        assign = new JButton("Assignment");
        scoreb = new JButton("Scoreboard");
        
        //label zone
        id = new JLabel("65070238");
        name = new JLabel("Sirimongkol");
        role  = new JLabel("Role : Student");
        
        //----------------------
        
        //this is just LEFT-BAR
        //assign image
        ImageIcon icon = new ImageIcon(new ImageIcon("C:\\Users\\Bamba\\Downloads\\siri.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        Image scaleImage = icon.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        
        nameSpace.add(name);
        idSpace.add(id);
        roleSpace.add(role);
        
        //detials zone
        detialsSpace.setLayout(new GridLayout(3,1));
        detialsSpace.add(idSpace);
        detialsSpace.add(nameSpace);
        detialsSpace.add(roleSpace);
        
        pics.add(new JLabel(icon));   
        profile.setLayout(new BorderLayout());
        profile.add(pics, BorderLayout.WEST);
        profile.add(detialsSpace);
        
        //button zone
        queueBtn.add(queue);
        assignBtn.add(assign);
        scorebBtn.add(scoreb);
        
        bbtn.setLayout(new GridLayout(4, 1));
        bbtn.add(blank);
        bbtn.add(queueBtn);
        bbtn.add(assignBtn);
        bbtn.add(scorebBtn);
        
        forBtn.setLayout(new GridLayout(3, 1));
        forBtn.add(bbtn);
               
        //dashboard zone ( details + button )
        dash.setLayout(new BorderLayout());
        dash.add(profile, BorderLayout.NORTH);
        dash.add(forBtn, BorderLayout.CENTER);
        
        //MainPage

        //add to fr
        this.setLayout(new BorderLayout());
        this.add(dash, BorderLayout.WEST);
        this.add(mainSpace, BorderLayout.CENTER);
        
        //default setting
        this.setSize(1300, 900);
        this.setVisible(true);
    }
}
