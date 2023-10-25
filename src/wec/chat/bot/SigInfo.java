
package wec.chat.bot;

import javax.swing.*;

import java.awt.*;

import java.sql.ResultSet;

import java.awt.event.*;


public class SigInfo extends JFrame implements ActionListener{
    
    JButton back, update;
    JTextField info;
    Choice sigs;
    
    SigInfo(){
    
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        setBounds(400, 200, 900, 500);
        
        JLabel head = new JLabel ("Update Sig Info");
        head.setFont(new Font("ARial", Font.BOLD, 35));
        head.setBounds(150, 50, 500, 40);
        add(head);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(40, 20, 100, 100);
        add(image);
        
        JLabel format = new JLabel ("Format to add ");
        format.setFont(new Font("ARial", Font.PLAIN, 25));
        format.setBounds(50, 150, 500, 40);
        add(format);
        
        JLabel f1 = new JLabel ("1)/2)/3)/4)(*Alphabetical order followed) Sig Name - Updated Info");
        f1.setFont(new Font("ARial", Font.PLAIN, 20));
        f1.setBounds(50, 200, 600, 40);
        add(f1);
        
        
        JLabel sig = new JLabel ("Select the sig :");
        sig.setFont(new Font("Arial", Font.PLAIN, 20));
        sig.setBounds(50, 270, 150, 30);
        add(sig);
        
        sigs = new Choice();  // The drop down is empty
        sigs.setBounds(200, 275, 350, 40);
        add(sigs);
        
                
        try{
            
            Conn conn = new Conn();
            String query = "select * from sigs";
            ResultSet rs = conn.s.executeQuery(query); // Returns everything present in the mentioned table as an obj rs of ResultSet class
            
            while(rs.next()){     // To check each and every value
                String siginfo = rs.getString("Name");
                if(!siginfo.equals("Core")){
                sigs.add(siginfo); 
            }// If the room is clean and vacant add it to dropdown
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel i = new JLabel ("Updated Info : ");
        i.setFont(new Font("Arial", Font.PLAIN, 20));
        i.setBounds(50, 320, 150, 30);
        add(i);
        
        
        info = new JTextField();
        info.setBounds(200, 320, 600, 30);
        add(info);
        
        update = new JButton();
        JLabel c = new JLabel("Update Info");
        c.setBounds(600, 180,200, 50);
        c.setFont(new Font("Arial", Font.PLAIN,20));
        c.setForeground(Color.black);
        update.add(c);
        update.setBounds(100, 380, 180, 30);
        update.setBackground(Color.green);
        update.setForeground(Color.white);
        add(update);
        update.addActionListener(this);
        
        back = new JButton();
        JLabel b = new JLabel("   Back");
        b.setBounds(400, 180,200, 50);
        b.setFont(new Font("Arial", Font.PLAIN,20));
        b.setForeground(Color.WHITE);
        back.add(b);
        back.setBounds(300, 380, 130, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        add(back);
        back.addActionListener(this);
        
        
        setVisible(true);
    }
    
    
     @Override
    public void actionPerformed(ActionEvent ae){
    
        if(ae.getSource() == update ){
            String infonew = info.getText();
            if(infonew.equals("")){
                JOptionPane.showMessageDialog(null, "Info cannot be empty");
                return;
            }
            String sigsele = sigs.getSelectedItem();
            
            try{
               Conn conn = new Conn();  // Creating the Connection 
               String query = "update sig set Info = '"+infonew+"' where Name = '"+sigsele+"'";
               conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Sig Info Updated");
               
               
           }
           catch(Exception e){
               e.printStackTrace();
           }
            
            setVisible(false);
            new Infopop();
        }
        
        else if (ae.getSource() == back ){
            setVisible(false);
        
        }
        
    }
    
    
    public static void main (String args[]){
        
        new SigInfo();
        
}
}
