package wec.chat.bot;

import javax.swing.*;

import java.awt.*;

import java.util.Date;


import java.awt.event.*;

import java.text.SimpleDateFormat;



public class Dashboard extends JFrame implements ActionListener {
    JButton add, delete, siginfo, upevents, pevents, logout, webs , con;
    String username = LoginMain.usern;
    
    Dashboard(){
        
        setLayout(null);
        
        setBounds(-7,0,1920,1080);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/back.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(-7,35,1920,1080);
        add(image);
        
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1920, 40);
        mb.setBackground(Color.WHITE);
        add(mb);
        

        
        JMenu time = new JMenu("   "+getFormattedDate());
        time.setFont(new Font("Arial", Font.PLAIN,25));
        time.setForeground(Color.BLUE);
        mb.add(time);
        
        
        
        
        JLabel head = new JLabel ("Hello " + username + " welcome to Wec Admin Portal");
        head.setBounds(30, 50,1800, 70);
        head.setForeground(Color.WHITE);
        head.setFont(new Font("Tahoma", Font.BOLD, 30));
        image.add(head);  
         
        JLabel addmem = new JLabel ("Add New Memebers");
        addmem.setBounds(50, 180, 500, 50);
        addmem.setFont(new Font("Arial", Font.PLAIN,40));
        addmem.setForeground(Color.WHITE);
        image.add(addmem);
        
        
        add = new JButton();
        JLabel c = new JLabel("Add Here");
        c.setBounds(600, 180,200, 50);
        c.setFont(new Font("Arial", Font.PLAIN,30));
        c.setForeground(Color.WHITE);
        add.add(c);
        add.setBounds(600, 180, 180, 50);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        image.add(add);
        add.addActionListener(this);
        
        JLabel remove = new JLabel ("Remove Members");
        remove.setBounds(50, 280, 500, 50);
        remove.setFont(new Font("Arial", Font.PLAIN,40));
        remove.setForeground(Color.WHITE);
        image.add(remove);
        
        delete = new JButton();
        JLabel a = new JLabel("Remove");
        a.setBounds(600, 280,200, 50);
        a.setFont(new Font("Arial", Font.PLAIN,30));
        a.setForeground(Color.WHITE);
        delete.add(a);
        delete.setBounds(600, 280, 180, 50);
        delete.setBackground(Color.black);
        delete.setForeground(Color.white);
        image.add(delete);
        delete.addActionListener(this);
        
        JLabel sig = new JLabel ("Update Sig Info");
        sig.setBounds(50, 380, 550, 50);
        sig.setFont(new Font("Arial", Font.PLAIN,40));
        sig.setForeground(Color.WHITE);
        image.add(sig);
        
        siginfo = new JButton();
        JLabel b = new JLabel("Update");
        b.setBounds(600, 380,200, 50);
        b.setFont(new Font("Arial", Font.PLAIN,30));
        b.setForeground(Color.WHITE);
        siginfo.add(b);
        siginfo.setBounds(600, 380, 180, 50);
        siginfo.setBackground(Color.black);
        siginfo.setForeground(Color.white);
        image.add(siginfo);
        siginfo.addActionListener(this);
        
        JLabel upeve = new JLabel ("Add Upcomming events");
        upeve.setBounds(50, 480, 500, 50);
        upeve.setFont(new Font("Arial", Font.PLAIN,40));
        upeve.setForeground(Color.WHITE);
        image.add(upeve);
        
        upevents = new JButton();
        JLabel ad = new JLabel("Add Now");
        ad.setBounds(600, 480,200, 50);
        ad.setFont(new Font("Arial", Font.PLAIN,30));
        ad.setForeground(Color.WHITE);
        upevents.add(ad);
        upevents.setBounds(600, 480, 180, 50);
        upevents.setBackground(Color.black);
        upevents.setForeground(Color.white);
        image.add(upevents);
        upevents.addActionListener(this);
        
        JLabel peve = new JLabel ("Update past events");
        peve.setBounds(50, 580, 500, 50);
        peve.setFont(new Font("Arial", Font.PLAIN,40));
        peve.setForeground(Color.WHITE);
        image.add(peve);
        
        pevents = new JButton();
        JLabel g = new JLabel("Update");
        g.setBounds(600, 580,200, 50);
        g.setFont(new Font("Arial", Font.PLAIN,30));
        g.setForeground(Color.WHITE);
        pevents.add(g);
        pevents.setBounds(600, 580, 180, 50);
        pevents.setBackground(Color.black);
        pevents.setForeground(Color.white);
        image.add(pevents);
        pevents.addActionListener(this);
        
        logout = new JButton();
        JLabel p = new JLabel("Logout");
        p.setLayout(null);
        p.setBounds(250, 680,200, 50);
        p.setFont(new Font("Arial", Font.PLAIN,30));
        p.setForeground(Color.WHITE);
        logout.add(p);
        logout.setBounds(200, 680, 130, 50);
        logout.setBackground(Color.red);
        logout.setForeground(Color.WHITE);
        image.add(logout);
        logout.addActionListener(this);
        
        webs = new JButton();
        JLabel govtt = new JLabel("Go to WEC Website");
        govtt.setLayout(null);
        govtt.setBounds(250, 680,350, 50);
        govtt.setFont(new Font("Arial", Font.PLAIN,30));
        govtt.setForeground(Color.black);
        webs.add(govtt);
        webs.setBounds(450, 680, 350, 50);
        webs.setBackground(Color.GREEN);
        webs.setForeground(Color.white);
        image.add(webs);
        webs.addActionListener(this);
        
        
        con = new JButton();
        JLabel connn = new JLabel("Change Convenor");
        connn.setLayout(null);
        connn.setBounds(650, 680,350, 50);
        connn.setFont(new Font("Arial", Font.PLAIN,30));
        connn.setForeground(Color.black);
        con.add(connn);
        con.setBounds(850, 680, 350, 50);
        con.setBackground(Color.GREEN);
        con.setForeground(Color.white);
        image.add(con);
        con.addActionListener(this);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image i5 = i4.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(1400, 30, 100, 100);
        image.add(image2);
        
        
        setVisible(true);
    }
    
    public void openWebPage(String url){
   try {         
     java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
   }
   catch (java.io.IOException e) {
       System.out.println(e.getMessage());
   }
}
    @Override
    public void actionPerformed(ActionEvent ae){
        
        
        if(ae.getSource() == add ){
            new ARPopupB();
        }
        
        else if(ae.getSource() == delete ){            
            new ARPopup();
            
        }
        
        else if(ae.getSource() == siginfo ){
           new SigInfo();
        }
        
        else if(ae.getSource() == upevents ){
            new Upevents();
        }
        
        else if(ae.getSource() == pevents ){
            new PastEve();
        }
        
        else if(ae.getSource() == logout ){
            JOptionPane.showMessageDialog(null, "Thank You");
            System.exit(0);
        }
        
        else if(ae.getSource() == webs ){
            openWebPage("https://webclub.nitk.ac.in/#/");
        }
        
        
        else if(ae.getSource() == con ){
            new Con();
        }
        
        
        
    }
    
    
    private static String getFormattedDate() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(" EEEE, dd-MM-yyyy");
        return dateFormat.format(now);
    }
    
    public static void main(String args[]){
        new Dashboard();
}
}    
