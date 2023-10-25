
package wec.chat.bot;


import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.sql.ResultSet;

import net.proteanit.sql.DbUtils;


public class Sig extends JFrame implements ActionListener {
    
    JTable table;
    JScrollPane js;
    JButton remove, back, removeall;
    Choice members;
    String signame = ARPopup.selectedsig;  
    String sigss = signame.toLowerCase();
    String st = "";
    
    Sig(){
        
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        setBounds(450, 30, 800, 750);
        
        JLabel head = new JLabel("All members of Sig - "+signame);
        head.setBounds(150, 30, 600, 34);
        head.setFont(new Font("Arial", Font.BOLD,30));
        add(head);
        
        table = new JTable();
        table.setBounds(5, 104, 775, 530);
        table.setBackground(Color.WHITE);
        table.getTableHeader().setBackground(Color.WHITE);
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 10));
        
        js = new JScrollPane(table);      
        js.setBounds(5, 104, 775, 530);
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
        
        
        members = new Choice();
        members.setBounds(10, 640, 650, 30);
        add(members);
        
        try{
            
            Conn c = new Conn();
            String query = ("select Name from "+st);
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                members.add(rs.getString("Name"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        remove = new JButton();
        JLabel c = new JLabel("Remove Member");
        c.setBounds(600, 180,200, 50);
        c.setFont(new Font("Arial", Font.PLAIN,20));
        c.setForeground(Color.black);
        remove.add(c);
        remove.setBounds(330, 670, 250, 30);
        remove.setBackground(Color.green);
        remove.setForeground(Color.white);
        add(remove);
        remove.addActionListener(this);
        
        
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
        
        if(st.equals("members")){
            
        removeall = new JButton();
        JLabel ba = new JLabel("Remove All");
        ba.setBounds(200, 180,200, 50);
        ba.setFont(new Font("Arial", Font.PLAIN,20));
        ba.setForeground(Color.black);
        removeall.add(ba);
        removeall.setBounds(150, 670, 150, 30);
        removeall.setBackground(Color.green);
        removeall.setForeground(Color.white);
        add(removeall);
        removeall.addActionListener(this);
        }
        
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
            new ARPopup();
            
        }
        
        else if(ae.getSource() == remove){
            String ms = members.getSelectedItem();
            
            
            if(st.equals("membersaldo")){
            try{
               Conn conn = new Conn();  // Creating the Connection 
               String query = "DELETE FROM membersaldo WHERE Name = '"+ms+"';";
               conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Member Removed");
               
               
           }
           catch(Exception e){
               e.printStackTrace();
           }
            }
            
            
            else if(st.equals("membersgdsc")){
                try{
               Conn conn = new Conn();  // Creating the Connection 
               String query = "DELETE FROM membersgdsc WHERE Name = '"+ms+"';";
               conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Member Removed");
               
               
           }
           catch(Exception e){
               e.printStackTrace();
           }
            }
            
            else if(st.equals("membersintel")){
            try{
               Conn conn = new Conn();  // Creating the Connection 
               String query = "DELETE FROM membersintel WHERE Name = '"+ms+"';";
               conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Member Removed");
               
               
           }
           catch(Exception e){
               e.printStackTrace();
           }
            }
            
            else if(st.equals("memberssys")){
                try{
               Conn conn = new Conn();  // Creating the Connection 
               String query = "DELETE FROM memberssys WHERE Name = '"+ms+"';";
               conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Member Removed");
               
               
           }
           catch(Exception e){
               e.printStackTrace();
           }
            }
            
            else if(st.equals("members")){
                try{
               Conn conn = new Conn();  // Creating the Connection 
               String query = "DELETE FROM members WHERE Name = '"+ms+"';";
               conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Member Removed");
               
               
           }
           catch(Exception e){
               e.printStackTrace();
           }
            }
            setVisible(false);
            new Addpop();
            
        }
        
        else if(ae.getSource() == removeall){
            try{
               Conn conn = new Conn();  // Creating the Connection 
               String query = "drop table members";
               String query2 = "create table members (Name varchar(200), Position varchar(30));";
               conn.s.executeUpdate(query);
               conn.s.executeUpdate(query2);
               JOptionPane.showMessageDialog(null, "All Members Removed");
               
               
           }
           catch(Exception e){
               e.printStackTrace();
           }
            
            setVisible(false);
        }
    }
    
    public static void main (String args[]){
        new Sig();
    }
}
