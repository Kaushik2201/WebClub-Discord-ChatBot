
package wec.chat.bot;


import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    // ActionListener keeps track whechever there is any action taken by the user anywhere
    JButton next, close, signup;
    
    Login(){
        setLayout(null);
        setBounds(-7,0,1920,1080);
        getContentPane().setBackground(Color.black);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bg.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(-360,-225,1920,1080);
        add(image);
        
        
        JLabel text = new JLabel("LogIn OR SignUp to Continue");
        text.setBounds(1050,830,1200,90);
        text.setForeground(Color.white);
        text.setFont(new Font("serif", Font.PLAIN, 50));
        image.add(text);
        
        // Adding Button 
        next = new JButton("LOGIN");
        next.setBounds(1050, 930, 120, 50);
        next.setFont(new Font("arial", Font.BOLD, 20));
        next.setBackground(Color.WHITE);
        next.setForeground(Color.blue);
        image.add(next);
        next.addActionListener(this);
        
        close = new JButton("CLOSE");
        close.setBounds(1370, 930, 120, 50);
        close.setFont(new Font("arial", Font.BOLD, 20));
        close.setBackground(Color.WHITE);
        close.setForeground(Color.blue);
        image.add(close);
        close.addActionListener(this);
        
        signup = new JButton("SIGNUP");
        signup.setBounds(1210, 930, 120, 50);
        signup.setFont(new Font("arial", Font.BOLD, 20));
        signup.setBackground(Color.WHITE);
        signup.setForeground(Color.blue);
        image.add(signup);
        signup.addActionListener(this);
                
        setVisible(true);
        
        // Blinking effect of the text
       while(true){
            // Changing the visibility for blinking effect
            text.setVisible(false);
        
            try{
                Thread.sleep(500);  
        } catch(Exception e){
            e.printStackTrace();
      }
            text.setVisible(true);
            // The 2nd try and catch is used to show the text
            try{
                Thread.sleep(500);  
        } catch(Exception e){
            e.printStackTrace();
      }
    }
  }
    
    // Overriding actionperformed method
    public void actionPerformed(ActionEvent e){
        // Once the button is clicked it will perforn these 2 operationss
        /*setVisible(false);         // The old frame is hidden 
        new Login();  */              // The new login frame constructor called
        
        if(e.getSource() == close){
            setVisible(false);
            System.exit(0);
        }
        else if(e.getSource() == next){
            new LoginMain();
        }
        else if(e.getSource() == signup){
            new Signup();
        }
        
    }

    public static void main(String[] args) {
        new Login();
    }
    
}