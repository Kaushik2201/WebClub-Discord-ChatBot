
package wec.chat.bot;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class Signup extends JFrame implements ActionListener{

    JTextField username;
    JPasswordField password;
    JButton login;
    JButton signin;
    
    Signup(){

        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        setBounds(600, 150, 550, 550);
        
        JLabel head = new JLabel("WEC Admin Signup Portal");
        head.setBounds(150, 60, 400, 40);
        head.setFont(new Font("Arial", Font.BOLD, 25));
        add(head);

        JLabel user = new JLabel("Username");
        user.setFont(new Font("Tahoma", Font.PLAIN, 20));
        user.setBounds(40, 200, 100, 30);
        add(user);
        
        // Setting up text field so that user can enter the data
        username = new JTextField();
        username.setBounds(150, 200, 200, 30);
        add(username);
        
        // Setting Password
        JLabel pass = new JLabel("Password");
        pass.setFont(new Font("Tahoma", Font.PLAIN, 20));
        pass.setBounds(40, 240, 100, 30);
        add(pass);
        
        // Setting up text field so that use can input data
        password = new JPasswordField();
        password.setBounds(150,240,200,33);
        add(password);
        
        // Setting up Both Buttons 
        // Login Button
        login = new JButton("Signup");
        login.setBounds(40,320,120,40);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        // Adding action listener to see is there is any action 
        login.addActionListener(this);
        add(login);
        
        // Cancel Button
        signin = new JButton("Back");
        signin.setBounds(180,320,120,40);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.addActionListener(this);
        add(signin);
        

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(30, 30, 100, 100);
        add(image);


        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == login){
            // Removing the values wht user has entered to check if they are correct
             String usern = username.getText();
            if(usern.equals("")){
            JOptionPane.showMessageDialog(null, "Username cannot be empty");
            return;
        }
            // getText returns wht user have entered
            String passw = password.getText();
            if(!passw.contains("@") || passw.length()<8){
            JOptionPane.showMessageDialog(null, "Weak Password");
            JOptionPane.showMessageDialog(null, "Must Contain @ and min 8 characters");
            return;
        }
            
            // Matching it with data in MySQL 
            try{
                Conn c = new Conn();
                // Hitting MySQL query with JAVA
                String query = "insert into login values ('"+usern+"', '"+passw+"')";
                // Usern and passw are variables so + is used to avoid concetenatin
                // Executing the query using statement s
                // Storing it into a ResultSet what ever is return by the executed query
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null, "Signup Success Login Now");
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
            setVisible(false);
            new LoginMain();
        }
            
            else if (ae.getSource() == signin){
                setVisible(false);
            }
    }

    public static void main(String[] args) {
        
        new Signup();
    }
}
