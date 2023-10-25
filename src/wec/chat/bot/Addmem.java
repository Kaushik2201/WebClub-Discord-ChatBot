
package wec.chat.bot;


import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.sql.ResultSet;

import net.proteanit.sql.DbUtils;


public class Addmem extends JFrame implements ActionListener {
    
    JTable table;
    JScrollPane js;
    JButton add, back;
    String signame = ARPopupB.selectedsig;  
    String sigss = signame.toLowerCase();
    String st = "";
    String z = ARPopupB.selectedsig;
    JTextField stdname;
    JLabel stdsig;
    
    Addmem(){
        
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        setBounds(450, 30, 800, 750);
        
        JLabel head = new JLabel("All members of Sig - "+signame);
        head.setBounds(150, 30, 600, 34);
        head.setFont(new Font("Arial", Font.BOLD,30));
        add(head);
        
        JLabel supp = new JLabel("How to Add");
        supp.setBounds(30, 110, 600, 34);
        supp.setFont(new Font("Arial", Font.PLAIN,30));
        add(supp);
        
        JLabel name = new JLabel("Name(Student) - Position in Name Field");
        name.setBounds(30, 140, 600, 34);
        name.setFont(new Font("Arial", Font.PLAIN,25));
        add(name);
        
        JLabel signames = new JLabel("Name of Sig is selected");
        signames.setBounds(30, 170, 600, 34);
        signames.setFont(new Font("Arial", Font.PLAIN,25));
        add(signames);
        
        table = new JTable();
        table.setBounds(5, 230, 775, 300);
        table.setBackground(Color.WHITE);
        table.getTableHeader().setBackground(Color.WHITE);
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 10));
        
        js = new JScrollPane(table);      
        js.setBounds(5, 230, 775, 300);
        js.setBackground(Color.white);
        add(js);
        
        try{
            Conn conn = new Conn();
            
             if(sigss.contains("algo") || sigss.contains("algorithms")){
                 st = "membersaldo";
             }
             
             else if(sigss.contains("devlopment") || sigss.contains("gdsc") || sigss.contains("dev")){
                 st = "membersgdsc";
             }
             
             
             else if(sigss.contains("intel") || sigss.contains("'intelligence'") ){
                 st = "membersintel";
             }
             
             else if(sigss.contains("sys") || sigss.contains("system") || sigss.contains("systems")){
                 st = "memberssys";
             }
             
             else if(sigss.contains("core")){
                 st = "members";
             }
             
             String query = ("select Name from "+st);
             ResultSet rs = conn.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            table.setAutoCreateRowSorter(true);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel n = new JLabel ("Name in the given format");
        n.setBounds(20, 550, 300, 30);
        n.setFont(new Font("Arial", Font.PLAIN,18));
        add(n);
        
        stdname = new JTextField();
        stdname.setBounds(270, 550, 350, 30);
        add(stdname);
        
        JLabel sigsss = new JLabel ("Sig / Core : ");
        sigsss.setBounds(20, 600, 100, 30);
        sigsss.setFont(new Font("Arial", Font.PLAIN,18));
        add(sigsss);
        
        stdsig = new JLabel (z);
        stdsig.setBounds(115, 600, 200, 30);
        stdsig.setFont(new Font("Arial", Font.PLAIN,18));
        add(stdsig);
        
        add = new JButton();
        JLabel c = new JLabel("Add Member");
        c.setBounds(600, 180,200, 50);
        c.setFont(new Font("Arial", Font.PLAIN,20));
        c.setForeground(Color.black);
        add.add(c);
        add.setBounds(400, 670, 180, 30);
        add.setBackground(Color.green);
        add.setForeground(Color.white);
        add(add);
        add.addActionListener(this);
        
        back = new JButton();
        JLabel b = new JLabel("   Back");
        b.setBounds(600, 180,200, 50);
        b.setFont(new Font("Arial", Font.PLAIN,20));
        b.setForeground(Color.WHITE);
        back.add(b);
        back.setBounds(600, 670, 130, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        add(back);
        back.addActionListener(this);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(30, 0, 100, 100);
        add(image);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() ==  back ){
            setVisible(false);
            new ARPopupB();
            
        }
        
        else if(ae.getSource() == add){
            String ms = stdname.getText();
            if(ms.equals("")){
                JOptionPane.showMessageDialog(null, "Member Name cannot be Empty");
                return;
            }
            String ss = stdsig.getText();
            
            
            if(st.equals("membersaldo")){
            try{
               Conn conn = new Conn();  // Creating the Connection 
               String query = "insert into membersaldo values ('"+ms+"','"+ss+"');";
               conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Member Added");
               
               
           }
           catch(Exception e){
               e.printStackTrace();
           }
            }
            
            
            else if(st.equals("membersgdsc")){
                try{
               Conn conn = new Conn();  // Creating the Connection 
               String query = "insert into membersgdsc values ('"+ms+"','"+ss+"');";
               conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Member Added");
               
               
           }
           catch(Exception e){
               e.printStackTrace();
           }
            }
            
            else if(st.equals("membersintel")){
            try{
               Conn conn = new Conn();  // Creating the Connection 
               String query = "insert into membersintel values ('"+ms+"','"+ss+"');";
               conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Member Added");
               
               
           }
           catch(Exception e){
               e.printStackTrace();
           }
            }
            
            else if(st.equals("memberssys")){
                try{
               Conn conn = new Conn();  // Creating the Connection 
               String query = "insert into memberssys values ('"+ms+"','"+ss+"');";
               conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Member Added");
               
               
           }
           catch(Exception e){
               e.printStackTrace();
           }
            }
            
            else if(st.equals("members")){
                try{
               Conn conn = new Conn();  // Creating the Connection 
               String query = "insert into members values ('"+ms+"','"+ss+"');";
               conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Member Added");
               
               
           }
           catch(Exception e){
               e.printStackTrace();
           }
            }
            
            setVisible(false);
            new AddpopB();
            
        }
    }
    
    public static void main (String args[]){
        new Addmem();
    }
}
