
package wec.chat.bot;

import javax.swing.*;

import java.awt.*;

import java.sql.ResultSet;

import java.awt.event.*;


public class Upevents extends JFrame implements ActionListener{
    
    JButton back, update , convert;
    JTextField info;
    Choice curreve;
    
    Upevents(){
    
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        setBounds(400, 200, 900, 500);
        
        JLabel head = new JLabel ("Upcomming Events");
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
        
        JLabel f1 = new JLabel ("Name of Event  Date -  of the event");
        f1.setFont(new Font("ARial", Font.PLAIN, 20));
        f1.setBounds(50, 200, 600, 40);
        add(f1);
        
        
        JLabel sig = new JLabel ("Current Events :");
        sig.setFont(new Font("Arial", Font.PLAIN, 20));
        sig.setBounds(50, 270, 150, 30);
        add(sig);
        
        curreve = new Choice();  // The drop down is empty
        curreve.setBounds(200, 275, 350, 40);
        add(curreve);
        
                
        try{
            
            Conn conn = new Conn();
            String query = "select * from upevents";
            ResultSet rs = conn.s.executeQuery(query); // Returns everything present in the mentioned table as an obj rs of ResultSet class
            
            while(rs.next()){     // To check each and every value
                String siginfo = rs.getString("Name");
                curreve.add(siginfo);  // If the room is clean and vacant add it to dropdown
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel i = new JLabel ("Add a new Event : ");
        i.setFont(new Font("Arial", Font.PLAIN, 20));
        i.setBounds(50, 320, 200, 30);
        add(i);
        
        
        info = new JTextField();
        info.setBounds(230, 320, 600, 30);
        add(info);
        
        update = new JButton();
        JLabel c = new JLabel("    Add ");
        c.setBounds(600, 180,200, 50);
        c.setFont(new Font("Arial", Font.PLAIN,20));
        c.setForeground(Color.BLACK);
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
        back.setBounds(300, 430, 130, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        add(back);
        back.addActionListener(this);
        
        convert = new JButton();
        JLabel ba = new JLabel("Event Done");
        ba.setBounds(400, 180,200, 50);
        ba.setFont(new Font("Arial", Font.PLAIN,20));
        ba.setForeground(Color.black);
        convert.add(ba);
        convert.setBounds(300, 380, 200, 30);
        convert.setBackground(Color.GREEN);
        convert.setForeground(Color.white);
        add(convert);
        convert.addActionListener(this);
        
        
        setVisible(true);
    }
    
    
     @Override
    public void actionPerformed(ActionEvent ae){
    
        if(ae.getSource() == update ){
            String neweve = info.getText();
            if(neweve.equals("")){
                
                JOptionPane.showMessageDialog(null, "Provide the event Info");
                return;
            }
            
            try{
               Conn conn = new Conn();  // Creating the Connection 
               String query = "insert into upevents values ('"+neweve+"')";
               conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Event Added");
               
               
           }
           catch(Exception e){
               e.printStackTrace();
           }
            setVisible(false);
            new Evepop();
        }
        
        else if (ae.getSource() == convert ){
            String doneeve = curreve.getSelectedItem();
            if(doneeve == null){
                JOptionPane.showMessageDialog(null, "No event to add");
                return;
            }
            
            try{
               Conn conn = new Conn();  // Creating the Connection 
               String query = "insert into pevents values ('"+doneeve+"')";
               String query2 = "DELETE FROM upevents WHERE Name = '"+doneeve+"';";
               conn.s.executeUpdate(query);
               conn.s.executeUpdate(query2);
               JOptionPane.showMessageDialog(null, "Event added to past events");
               
               
           }
           catch(Exception e){
               e.printStackTrace();
           }
            
            setVisible(false);
            new Evepop();
        
        }
        
        else if (ae.getSource() == back ){
            setVisible(false);
        
        }
        
    }
    
    
    public static void main (String args[]){
        
        new Upevents();
        
}
}
