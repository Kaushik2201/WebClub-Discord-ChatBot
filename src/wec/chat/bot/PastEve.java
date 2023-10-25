
package wec.chat.bot;

import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.sql.ResultSet;

import net.proteanit.sql.DbUtils;


public class PastEve extends JFrame implements ActionListener {
    
    JTable table;
    JScrollPane js;
    JButton delete, back;
    Choice events;
    
    PastEve(){
        
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        setBounds(450, 30, 800, 750);
        
        JLabel head = new JLabel("All Past events of WEC");
        head.setBounds(200, 30, 600, 30);
        head.setFont(new Font("Arial", Font.BOLD,30));
        add(head);
        
        table = new JTable();
        table.setBounds(5, 100, 775, 530);
        table.setBackground(Color.WHITE);
        table.getTableHeader().setBackground(Color.WHITE);
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 10));
        
        js = new JScrollPane(table);      
        js.setBounds(5, 100, 775, 530);
        js.setBackground(Color.white);
        add(js);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from pevents;");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            table.setAutoCreateRowSorter(true);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        events = new Choice();
        events.setBounds(10, 640, 650, 30);
        add(events);
        
        try{
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from pevents ");
            while(rs.next()){
                events.add(rs.getString("Name"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        delete = new JButton();
        JLabel c = new JLabel("Remove this Event");
        c.setBounds(600, 180,200, 50);
        c.setFont(new Font("Arial", Font.PLAIN,20));
        c.setForeground(Color.black);
        delete.add(c);
        delete.setBounds(350, 670, 220, 30);
        delete.setBackground(Color.green);
        delete.setForeground(Color.white);
        add(delete);
        delete.addActionListener(this);
        
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
            
        }
        
        else if(ae.getSource() == delete){
            
            String eve = events.getSelectedItem();
            
            try{
            Conn conn = new Conn();
            String query = "delete from pevents where Name = '"+eve+"'";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Event Deleted");
        }
        catch(Exception e){
            e.printStackTrace();
        }
            
            setVisible(false);
            
        }
    }
    
    public static void main (String args[]){
        new PastEve();
    }
}
