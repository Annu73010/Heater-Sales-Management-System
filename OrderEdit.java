
package heater.sales.management.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class OrderEdit extends JFrame{
    
    static JComboBox c;
    static JLabel l1,l2,l3,l4;
    static JPanel p1;
    static JTextField t1,t2;
    static JButton update, delete, cancel;
    static PreparedStatement ps;
    static ResultSet rs;
    static Connection conn;
    
    public OrderEdit(){
        
        p1 = new JPanel();
       
        setContentPane(p1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,480);
        setVisible(true);
        p1.setLayout(null);
        
        l1 = new JLabel("Order No.");
        l1.setFont(new Font("Tahoma",Font.BOLD,20));
        l2 = new JLabel("Order Date");
        l2.setFont(new Font("Tahoma",Font.BOLD,20));
        l3 = new JLabel("Vendor Code");
        l3.setFont(new Font("Tahoma",Font.BOLD,20));
        l4 = new JLabel("ORDER EDIT DETAILS");
        l4.setFont(new Font("Tahoma",Font.BOLD,38));
        l4.setForeground(new java.awt.Color(128,0,0));
        c = new JComboBox();
        c.setFont(new Font("Dialog",Font.PLAIN,20));
        t1 = new JTextField();
        t1.setFont(new Font("Dialog",Font.PLAIN,20));
        t2 = new JTextField();
        t2.setFont(new Font("Dialog",Font.PLAIN,20));
        update = new JButton("UPDATE");
        update.setFont(new Font("Tahoma",Font.BOLD,15));
        delete = new JButton("DELETE");
        delete.setFont(new Font("Tahoma",Font.BOLD,15));
        cancel = new JButton("CANCEL");
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
       
        l1.setBounds(50,  110, 150, 30);
        l2.setBounds(50,  180, 150, 30);
        l3.setBounds(50,  250, 150, 30);
        l4.setBounds(200, 20, 450, 45);
        c.setBounds(200,  110, 520, 30);
        t1.setBounds(200, 180, 520, 30);
        t2.setBounds(200, 250, 520, 30);
        update.setBounds(150, 350, 100, 50);
        delete.setBounds(290, 350, 100, 50);
        cancel.setBounds(430, 350, 100, 50);
        
        p1.add(l1);
        p1.add(l2);
        p1.add(l3);
        p1.add(c);
        p1.add(t1);
        p1.add(t2);
        p1.add(update);
        p1.add(delete);
        p1.add(cancel);
        p1.add(l4);
        
    }
    
    public static void main(String[] args){
        
        new OrderEdit();
        conn = HeaterSalesManagementSystem.System();
        
        t1.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char c = e.getKeyChar();
                if(Character.isDigit(c) || Character.isLetter(c)|| Character.isWhitespace(c) || Character.isISOControl(c))
                {
                    t1.setEditable(true);
                }
                else{
                    t1.setEditable(false);
                }
            }
        });
        
        t2.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char c = e.getKeyChar();
                if(Character.isDigit(c) || Character.isISOControl(c))
                {
                    t2.setEditable(true);
                }
                else{
                    t2.setEditable(false);
                }
            }
        });
        
        try{
            ps = conn.prepareStatement("select id from order1");
            rs = ps.executeQuery();
            while(rs.next())
            {
                c.addItem(rs.getInt(1));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        c.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                try{
                    ps = conn.prepareStatement("select *from order1 where id=?");
                    ps.setInt(1, (Integer)c.getSelectedItem());
                    rs = ps.executeQuery();
                    if(rs.next()==true){
                        t1.setText(rs.getString(2));
                        t2.setText(String.valueOf(rs.getInt(3)));
                    }
                }
                catch(Exception ev){
                    ev.printStackTrace();
                }
            }
        });
        
        update.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    ps = conn.prepareStatement("update order1 set date1=?,v_code=? where id=?");
                    ps.setString(1, t1.getText());
                    ps.setInt(2,Integer.parseInt(t2.getText()));
                    ps.setInt(3,(Integer)c.getSelectedItem());
                    
                    int k = ps.executeUpdate();
                    if(k==1){
                        JOptionPane.showMessageDialog(null,"Record updated successfully!!");
                        c.addItem("");
                        t1.setText("");
                        t2.setText("");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Failed!!");
                    }
                }
                catch(Exception ev){
                    JOptionPane.showMessageDialog(null,"Complete the fields!");
                }
            }
        });
        
        delete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    ps = conn.prepareStatement("delete from order1 where id=?");
                    ps.setInt(1,(Integer)c.getSelectedItem());
                    ps.executeQuery();
                    JOptionPane.showMessageDialog(null,"Record deleted successfully!!");
                }
                catch(Exception ev){
                    ev.printStackTrace();
                }
            }
        });
        
        cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new OrderEdit().setVisible(false);
            }
        });
        
    }
    
}
