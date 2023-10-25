
package wec.chat.bot;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.sql.*;

public class ARPopupB extends JFrame implements ActionListener {
    
    Choice sig;
    JButton submit, back , cancel;
    public static String selectedsig;
    
    ARPopupB(){
        
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        setBounds(600, 200, 500,300);
        
        sig = new Choice();  // The drop down is empty
        sig.setBounds(50, 80, 350, 30);
        add(sig);
        
                
        try{
            
            Conn conn = new Conn();
            String query = "select * from sigs";
            ResultSet rs = conn.s.executeQuery(query); // Returns everything present in the mentioned table as an obj rs of ResultSet class
            
            while(rs.next()){     // To check each and every value
                String siginfo = rs.getString("Name");
                sig.add(siginfo);  // If the room is clean and vacant add it to dropdown
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        submit = new JButton();
        JLabel c = new JLabel("Select");
        c.setBounds(600, 180,200, 50);
        c.setFont(new Font("Arial", Font.PLAIN,30));
        c.setForeground(Color.WHITE);
        submit.add(c);
        submit.setBounds(150, 150, 180, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        add(submit);
        submit.addActionListener(this);
        
        back = new JButton();
        JLabel a = new JLabel("DashBoard");
        a.setBounds(300, 200,200, 30);
        a.setFont(new Font("Arial", Font.PLAIN,20));
        a.setForeground(Color.WHITE);
        back.add(a);
        back.setBounds(300, 200, 160, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        add(back);
        back.addActionListener(this);
        
        cancel = new JButton();
        JLabel b = new JLabel("  Close");
        b.setBounds(600, 180,200, 50);
        b.setFont(new Font("Arial", Font.PLAIN,20));
        b.setForeground(Color.WHITE);
        cancel.add(b);
        cancel.setBounds(150, 200, 130, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        add(cancel);
        cancel.addActionListener(this);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
         if(ae.getSource() ==  submit){
             selectedsig = sig.getSelectedItem();
             setVisible(false);
             new Addmem();
         }
         
        else if(ae.getSource() ==  back){
             setVisible(false);
         }
         
         else if(ae.getSource() ==  cancel){
             setVisible(false);
         }
    }
    
    
    public static void main (String args []){
    
        new ARPopupB();
    }
}
