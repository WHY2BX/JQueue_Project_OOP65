import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
public class LeftBarView implements ActionListener{
    private JFrame fr;
    private JPanel blank, dash, forBtn, profile, mainSpace, nameSpace, idSpace, detialsSpace, roleSpace, pics, queueBtn, accountBtn, assignBtn, scorebBtn, bbtn, mainPage;
    private JButton account, queue ,assign, scoreb;
    private JLabel id,  name, role;
    
    private MainPageView main;
    private JPanel pl;
    private InterfaceAssignmentView iv;
    
    //private Thread t1;
   
    //private MainPageView gui;
    
    public LeftBarView() throws IOException{
    //panel zone
        
        
    
        //t1 = new Thread(gui);
        
    
        fr = new JFrame();
        
        mainPage = new JPanel();
        blank = new JPanel();
        dash = new JPanel();
        forBtn = new JPanel();
        pics = new JPanel();
        
        //mainSpace = new JPanel();
        nameSpace = new JPanel();
        detialsSpace = new JPanel();
        idSpace = new JPanel();
        roleSpace = new JPanel();
        profile = new JPanel();
        
        queueBtn = new JPanel();
        assignBtn = new JPanel();
        scorebBtn = new JPanel();
        accountBtn = new JPanel();
        
        bbtn = new JPanel();
        
        
        //button zone
        
        account = new JButton("Profile");
        account.addActionListener(this);
        queue = new JButton("Queue");
        queue.addActionListener(this);
        assign = new JButton("Assignment");
        assign.addActionListener(this);
        scoreb = new JButton("Scoreboard");
        scoreb.addActionListener(this);
        
        //label zone
        id = new JLabel("65070238");
        name = new JLabel("Raiden Shogun");
        role  = new JLabel("Role : Archon");
        
        //----------------------
        
        //this is just LEFT-BAR
        //assign image
        ImageIcon icon = new ImageIcon(new ImageIcon("C:\\Users\\Bamba\\Downloads\\raiden.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
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
        accountBtn.add(account);
        queueBtn.add(queue);
        assignBtn.add(assign);
        scorebBtn.add(scoreb);
        
        bbtn.setLayout(new GridLayout(5, 1));
        bbtn.add(blank);
        bbtn.add(accountBtn);
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
        fr.setLayout(new BorderLayout());
        fr.add(dash, BorderLayout.WEST);
        fr.add(mainSpace = new MainPageView() , BorderLayout.CENTER);
        
        //default setting
        fr.setSize(1300, 900);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //t1.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(queue)){
            fr.remove(mainSpace);
            fr.add(mainSpace = new InterfaceAssignmentView());
            fr.revalidate();
        }
        
        else if(e.getSource().equals(account)){
            fr.remove(mainSpace);
            fr.add(mainSpace = new AccountView());
            fr.revalidate();
        }
        
        else if(e.getSource().equals(assign)){
            fr.remove(mainSpace);
            fr.add(mainSpace = new InterfaceAssignmentView());
            fr.revalidate();
        }
        
        else if(e.getSource().equals(scoreb)){
            fr.remove(mainSpace);
            fr.add(mainSpace = new InterfaceAssignmentView());
            fr.revalidate();
        }
    }

}
