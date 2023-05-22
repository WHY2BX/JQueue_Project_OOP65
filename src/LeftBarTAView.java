
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import javax.swing.*;

public class LeftBarTAView implements ActionListener, WindowListener, Runnable {

    private JFrame fr;

    private JPanel panelContainer;

    private JPanel blank, dash, forBtn, profile, mainSpace, nameSpace, idSpace, detialsSpace, roleSpace, pics, remainQBtn, queueBtn, accountBtn, assignBtn, scorebBtn, bbtn, mainPage;
    private JButton account, queue, assign, scoreb, remainQ;
    private JLabel id, name, role;

    private MainPageView main;
    private InterfaceAssignmentView iassignmentv;
    private BookingView bookingv;
    private AccountView accountv;

    //private Thread t1;
    private DataModel dataModel;

    private MainPageView gui;

    private RemainQueueView remainqv;

    private TaList talist;

    IndexPass pass;
    
    //Menu
    private JMenuBar bar;
    private JMenu file;
    private JMenuItem logout, time;
    
    
    //MDI
    private JDesktopPane desktopPane;
    private Thread thread;
    private Clock clock;
    private ClockViewMDI clockMDI;
    private JPanel clockContainer;

    public LeftBarTAView(DataModel dataModel, TaList talist) throws IOException {
        //panel zone
        this.dataModel = dataModel;
        this.talist = talist;

        
        fr = new JFrame();

        mainPage = new JPanel();
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
        accountBtn = new JPanel();
        remainQBtn = new JPanel();

        bbtn = new JPanel();

        //button zone
        account = new JButton("Profile");
        account.addActionListener(this);
        queue = new JButton("Queue");
        queue.addActionListener(this);
        assign = new JButton("Assignment");
        assign.addActionListener(this);
//        scoreb = new JButton("Scoreboard");
//        scoreb.addActionListener(this);
        remainQ = new JButton("Remain Queue");
        remainQ.addActionListener(this);

        //label zone
        id = new JLabel("65070238");
        name = new JLabel("Raiden Shogun");
        role = new JLabel("Role : Archon");

        //----------------------
        //this is just LEFT-BAR
        //assign image
        ImageIcon icon = new ImageIcon(new ImageIcon("/Users/sudthirak/Desktop/capoo.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        Image scaleImage = icon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);

        nameSpace.add(name);
        idSpace.add(id);
        roleSpace.add(role);

        //detials zone
        detialsSpace.setLayout(new GridLayout(3, 1));
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
//        scorebBtn.add(scoreb);
        remainQBtn.add(remainQ);

        bbtn.setLayout(new GridLayout(6, 1));
        bbtn.add(blank);
        bbtn.add(accountBtn);
        bbtn.add(queueBtn);
        bbtn.add(remainQBtn);
        bbtn.add(assignBtn);
//        bbtn.add(scorebBtn);

        forBtn.setLayout(new GridLayout(3, 1));
        forBtn.add(bbtn);
        
        bar = new JMenuBar();
        file = new JMenu("JQueue");
        logout = new JMenuItem("Logout");
        time = new JMenuItem("Clock");
        time.addActionListener(this);
        logout.addActionListener(this);
        
        desktopPane = new JDesktopPane();
        desktopPane.setVisible(true);
        
        thread = new Thread();
        clock = new Clock();
        
        //MenuBar zone
        bar.add(file);
        file.add(time);
        file.addSeparator();
        file.add(logout);
        fr.setJMenuBar(bar);
        
        //MDI zone
        clockMDI = new ClockViewMDI();
        clockContainer = new JPanel();
        clockContainer.setLayout(new BorderLayout());
        desktopPane.add(clockMDI);
        clockContainer.add(desktopPane);
             

        //dashboard zone ( details + button )
        dash.setLayout(new BorderLayout());
        dash.add(profile, BorderLayout.NORTH);
        dash.add(forBtn, BorderLayout.CENTER);

        //MainPage
        pass = new IndexPass();

        mainSpace = new MainPageView();
        iassignmentv = new InterfaceAssignmentView(dataModel);
        accountv = new AccountView();
        
        bookingv = new BookingView(talist, pass);
        remainqv = new RemainQueueView(talist, pass);
        //t1 = new Thread(bookingv);
        //t1.start();

        panelContainer = new JPanel(new CardLayout());
        panelContainer.add(mainSpace, "mainpage");
        panelContainer.add(iassignmentv, "assignment");
        panelContainer.add(accountv, "profile");
        panelContainer.add(bookingv, "queue");
        panelContainer.add(remainqv, "remainQ");
        
        //MDI
        panelContainer.add(clockContainer, "clock");

        //add to fr
        fr.setLayout(new BorderLayout());
        fr.add(dash, BorderLayout.WEST);
        fr.add(panelContainer, BorderLayout.CENTER);

        fr.addWindowListener(this);
        //default setting
        fr.setSize(1300, 900);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        int x = (screenSize.width - fr.getWidth()) / 2;
        int y = (screenSize.height - fr.getHeight()) / 2;

        fr.setLocation(x, y);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //t1.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(assign)) {

            CardLayout cardLayout = (CardLayout) panelContainer.getLayout();
            cardLayout.show(panelContainer, "assignment");

            System.out.println("lnwza");
        } else if (e.getSource().equals(account)) {

            CardLayout cardLayout = (CardLayout) panelContainer.getLayout();
            cardLayout.show(panelContainer, "profile");
            profile.revalidate();

        } else if (e.getSource().equals(queue)) {

            CardLayout cardLayout = (CardLayout) panelContainer.getLayout();
            cardLayout.show(panelContainer, "queue");

//        } else if (e.getSource().equals(scoreb)) {

        } else if (e.getSource().equals(remainQ)) {

            CardLayout cardLayout = (CardLayout) panelContainer.getLayout();
            cardLayout.show(panelContainer, "remainQ");

        }
        
        else if(e.getSource().equals(time)){
            
            CardLayout cardLayout = (CardLayout) panelContainer.getLayout();
            cardLayout.show(panelContainer, "clock");

        }
        else if(e.getSource().equals(logout)){
            fr.dispose();
            System.out.println("logout si isus");
            new LoginView();
            
        }

        fr.revalidate();
    }

    @Override
    public void windowOpened(WindowEvent e) {
        accountv.updateProfile();
        User user = null;
        File file = new File("User.dat");
        System.out.println("I am TA");
        if (file.exists()){
            try(FileInputStream fis = new FileInputStream("User.dat");
                ObjectInputStream ois = new ObjectInputStream(fis);      
            ){
                
                user = (User)ois.readObject();
                id.setText(user.getStudent_id());
                name.setText(user.getFullname());
                role.setText(user.getRole());
            } catch (FileNotFoundException ex) {
                java.util.logging.Logger.getLogger(LeftBarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(LeftBarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(LeftBarView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        File file = new File("/Users/sudthirak/NetBeansProjects/Project/user.dat");
        file.delete();
    }

    @Override
    public void windowClosed(WindowEvent e) {
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

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
