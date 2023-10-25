
package wec.chat.bot;

import javax.swing.*;

import java.awt.*;


import java.awt.event.*;
import java.sql.ResultSet;


public class Con extends JFrame implements ActionListener {
    
    JTextField tfname;
    JButton make, back;
    String curcon = "";
    
    Con(){
        
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        setBounds(500, 200, 600, 400);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(10, 20, 100, 100);
        add(image);
        
        JLabel currcon = new JLabel ("Current Convenor - ");
        currcon.setFont(new Font("ARial", Font.BOLD, 25));
        currcon.setBounds(20, 150, 500, 40);
        add(currcon);
        
        try{
               Conn conn = new Conn();  // Creating the Connection 
               String query = "select * from con";
               ResultSet rs = conn.s.executeQuery(query);
               while(rs.next()){
                   curcon = rs.getString("Name");
               }
                              
           }
           catch(Exception e){
               e.printStackTrace();
           }
        
        JLabel s = new JLabel ();
        s.setText(curcon);
        s.setFont(new Font("ARial", Font.BOLD, 25));
        s.setBounds(250, 150, 500, 40);
        add(s);
        
        JLabel head = new JLabel ("Convenor of the club");
        head.setFont(new Font("ARial", Font.BOLD, 25));
        head.setBounds(150, 50, 500, 40);
        add(head);
        
        JLabel name = new JLabel ("Name of new Convenor: ");
        name.setFont(new Font("ARial", Font.PLAIN, 20));
        name.setBounds(20, 200, 500, 40);
        add(name);
        
        tfname = new JTextField();
        tfname.setBounds(250, 200, 300, 40);
        add(tfname);
        
        make = new JButton();
        JLabel c = new JLabel("Change");
        c.setBounds(60, 230,200, 50);
        c.setFont(new Font("Arial", Font.PLAIN,20));
        c.setForeground(Color.BLACK);
        make.add(c);
        make.setBounds(60, 270, 140, 40);
        make.setBackground(Color.green);
        make.setForeground(Color.white);
        add(make);
        make.addActionListener(this);
        
        back = new JButton();
        JLabel b = new JLabel("   Back");
        b.setBounds(400, 180,200, 50);
        b.setFont(new Font("Arial", Font.PLAIN,20));
        b.setForeground(Color.WHITE);
        back.add(b);
        back.setBounds(230, 270, 130, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        add(back);
        back.addActionListener(this);
        
        
        setVisible(true);
    }
    
     @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == make){
            String newname = tfname.getText();
            if(newname.length() == 0){
                JOptionPane.showMessageDialog(null, "Name Connot be Empty");
                return;
            }
            
            try{
               Conn conn = new Conn();  // Creating the Connection 
               String query = "drop table con";
               String query2 = "create table con (Name varchar(200));";
               String query3 = "insert into con values ('"+newname+"');";
               conn.s.executeUpdate(query);
               conn.s.executeUpdate(query2);
               conn.s.executeUpdate(query3);
               JOptionPane.showMessageDialog(null, "Convenor Changed");
               
               
           }
           catch(Exception e){
               e.printStackTrace();
           }
            
            setVisible(false);
    }
        
        else if (ae.getSource() == back ){
            setVisible(false);
        
        }
            
            
    }
    
    public static void main (String args[]){
        new Con();
    }
}
