
package wec.chat.bot;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class AddpopB extends JFrame implements ActionListener {
    JButton yes, no;
    
    AddpopB(){
        setLayout(null);
        setBounds(550,250,500,300);
        getContentPane().setBackground(Color.white);
        
        JLabel heading = new JLabel("DO YOU WANT TO ADD MORE ?");
        heading.setBounds(50, 60, 400, 100);
        heading.setFont(new Font("Arial", Font.BOLD, 25));
        add(heading);
        
        yes = new JButton("YES");
        yes.setBounds(60, 150, 120, 30);
        yes.setForeground(Color.white);
        yes.setBackground(Color.black);
        add(yes);
        yes.addActionListener(this);
        
        no = new JButton("NO");
        no.setBounds(200, 150, 120, 30);
        no.setForeground(Color.white);
        no.setBackground(Color.black);
        add(no);
        no.addActionListener(this);
        
                
                
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == yes){
            setVisible(false);
            new ARPopupB();
        }
        else if(ae.getSource() == no){
           setVisible(false);
        }
    }
    
    public static void main(String args[]){
        new AddpopB();
    }
}
