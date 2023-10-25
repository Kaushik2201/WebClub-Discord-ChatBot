
package wec.chat.bot;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;



public class LoginMain extends JFrame implements ActionListener{

    JTextField username;
    JPasswordField password;
    JButton login;
    JButton signin;
    JButton clear;
    public static String usern;
    
    LoginMain(){

        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        setBounds(600, 150, 550, 550);

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
        login = new JButton("Login");
        login.setBounds(40,320,120,40);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        // Adding action listener to see is there is any action 
        login.addActionListener(this);
        add(login);
        
        // Cancel Button
        signin = new JButton("Signup");
        signin.setBounds(180,320,120,40);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.addActionListener(this);
        add(signin);
        
        // Setting up claer Button
        clear = new JButton("Close");
        clear.setBounds(110,380,100,40);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(30, 30, 100, 100);
        add(image);

        JLabel head = new JLabel("WEC Admin Login Portal");
        head.setBounds(150, 60, 300, 40);
        head.setFont(new Font("Arial", Font.BOLD, 25));
        add(head);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == login){
            // Removing the values wht user has entered to check if they are correct
             usern = username.getText();
            // getText returns wht user have entered
            String passw = password.getText();
            
            // Matching it with data in MySQL 
            try{
                Conn c = new Conn();
                // Hitting MySQL query with JAVA
                String query = "select * from login where username = '" + usern + "' and password = '" + passw +"'";
                // Usern and passw are variables so + is used to avoid concetenatin
                // Executing the query using statement s
                // Storing it into a ResultSet what ever is return by the executed query
                ResultSet rs = c.s.executeQuery(query);
                
                // Checking wht is returned by re
                if(rs.next()){
                    // If password and username are correct
                    setVisible(false);       // Close current frame
                    new Dashboard();          // Open next frame Dashboard frame
                }
                else{
                    // If password or username is incorrect
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    password.setText("");
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
            
            else if(ae.getSource() == signin){
                
                setVisible(false);
                new Signup();
            }
            
            else if(ae.getSource() == clear){
                setVisible(false);
            }
    }

    public static void main(String[] args) {
        
        new LoginMain();
    }
}
