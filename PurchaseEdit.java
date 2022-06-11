
package heater.sales.management.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PurchaseEdit extends JFrame{
    
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;
    static JTextField t1,t2,t3,t4,t5,t6,t7;
    static JComboBox c;
    static JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    static JPanel p1;
    static JFrame frame;
    static JButton update, updateStock, delete, cancel;
    
    public PurchaseEdit(){
        
        frame = new JFrame();
        p1 = new JPanel();
       
        frame.setContentPane(p1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1180,660);
        frame.setVisible(true);
        p1.setLayout(null);
        
        l1 = new JLabel("ID");
        l1.setFont(new Font("Tahoma",Font.BOLD,20));
        l2 = new JLabel("Item No.");
        l2.setFont(new Font("Tahoma",Font.BOLD,20));
        l3 = new JLabel("Order No.");
        l3.setFont(new Font("Tahoma",Font.BOLD,20));
        l4 = new JLabel("Quantity");
        l4.setFont(new Font("Tahoma",Font.BOLD,20));
        l5 = new JLabel("Total");
        l5.setFont(new Font("Tahoma",Font.BOLD,20));
        l6 = new JLabel("Date");
        l6.setFont(new Font("Tahoma",Font.BOLD,20));
        l7 = new JLabel("Notes");
        l7.setFont(new Font("Tahoma",Font.BOLD,20));
        l8 = new JLabel("Stock Quantity");
        l8.setFont(new Font("Tahoma",Font.BOLD,20));
        l9 = new JLabel("PURCHASE EDIT DETAILS");
        l9.setFont(new Font("Tahoma",Font.BOLD,38));
        l9.setForeground(new java.awt.Color(128,0,0));
        c = new JComboBox();
        c.setFont(new Font("Dialog",Font.PLAIN,20));
        t1 = new JTextField();
        t1.setFont(new Font("Dialog",Font.PLAIN,20));
        t2 = new JTextField();
        t2.setFont(new Font("Dialog",Font.PLAIN,20));
        t3 = new JTextField();
        t3.setFont(new Font("Dialog",Font.PLAIN,20));
        t4 = new JTextField();
        t4.setFont(new Font("Dialog",Font.PLAIN,20));
        t5 = new JTextField();
        t5.setFont(new Font("Dialog",Font.PLAIN,20));
        t6 = new JTextField();
        t6.setFont(new Font("Dialog",Font.PLAIN,20));
        t7 = new JTextField();
        t7.setFont(new Font("Dialog",Font.PLAIN,20));
        update = new JButton("UPDATE");
        update.setFont(new Font("Tahoma",Font.BOLD,15));
        updateStock = new JButton("UPDATE STOCK QUANTITY");
        updateStock.setFont(new Font("Tahoma",Font.BOLD,15));
        delete = new JButton("DELETE");
        delete.setFont(new Font("Tahoma",Font.BOLD,15));
        cancel = new JButton("CANCEL");
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));    
        
        l9.setBounds(280, 20, 500, 45);
        l1.setBounds(50, 80, 150, 30);
        l2.setBounds(50, 140, 150, 30);
        l3.setBounds(50, 200, 150, 30);
        l4.setBounds(50, 260, 150, 30);
        l5.setBounds(50, 320, 150, 30);
        l6.setBounds(50, 380, 150, 30);
        l7.setBounds(50, 440, 150, 30);
        l8.setBounds(680, 260, 150, 30);
        c.setBounds(230, 80, 400, 30);
        t1.setBounds(230, 140, 400, 30);
        t2.setBounds(230, 200, 400, 30);
        t3.setBounds(230, 260, 400, 30);
        t4.setBounds(230, 320, 400, 30);
        t5.setBounds(230, 380, 400, 30);
        t6.setBounds(230, 440, 400, 70);
        t7.setBounds(850, 260, 300, 30);
        update.setBounds(30, 535, 100, 50);
        updateStock.setBounds(150, 535, 250, 50);
        delete.setBounds(420, 535, 100, 50);
        cancel.setBounds(540, 535, 100,50);
        
        p1.add(l9);
        p1.add(l1);
        p1.add(l2);
        p1.add(l3);
        p1.add(l4);
        p1.add(l5);
        p1.add(l6);
        p1.add(l7);
        p1.add(c);
        p1.add(t1);
        p1.add(t2);
        p1.add(t3);
        p1.add(t4);
        p1.add(t5);
        p1.add(t6);
        p1.add(update);
        p1.add(updateStock);
        p1.add(delete);
        p1.add(cancel);
        p1.add(l8);
        p1.add(t7);
        
    }
    
    public static void main(String[] args){
        
        new PurchaseEdit();      
        con = HeaterSalesManagementSystem.System();
        
         t1.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char c = e.getKeyChar();
                if(Character.isDigit(c) || Character.isISOControl(c))
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
              
               t3.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char c = e.getKeyChar();
                if(Character.isDigit(c) || Character.isISOControl(c))
                {
                    t3.setEditable(true);
                }
                else{
                    t3.setEditable(false);
                }
            }
        });
            
               
               t4.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char c = e.getKeyChar();
                if(Character.isDigit(c) || Character.isISOControl(c))
                {
                    t4.setEditable(true);
                }
                else{
                    t4.setEditable(false);
                }
            }
        });
               
               t5.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char c = e.getKeyChar();
                if(Character.isDigit(c) || Character.isLetter(c)|| Character.isWhitespace(c) || Character.isISOControl(c))
                {
                    t5.setEditable(true);
                }
                else{
                    t5.setEditable(false);
                }
            }
        });   
        
        try{
            ps = con.prepareStatement("select id from purchase");
            rs = ps.executeQuery();
            while(rs.next()){
                c.addItem(rs.getInt(1));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        c.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                try{
                    
                    ps = con.prepareStatement("select *from purchase where id=?");
                    ps.setInt(1,(Integer)c.getSelectedItem());
                    rs = ps.executeQuery();
                    if(rs.next()==true){
                        t1.setText(String.valueOf(rs.getInt(2)));
                        t2.setText(String.valueOf(rs.getInt(3)));
                        t3.setText(String.valueOf(rs.getInt(4)));
                        t4.setText(String.valueOf(rs.getInt(5)));
                        t5.setText(rs.getString(6));
                        t6.setText(rs.getString(7));     
                    }
                    ps.close();
                    rs.close();
                    
                }
                catch(Exception ev){
                    ev.printStackTrace();
                }
                try{ 
                    ps = con.prepareStatement("select * from stock where id=?");
                    ps.setInt(1,Integer.parseInt(t1.getText()));
                    rs = ps.executeQuery();
                    if(rs.next()==true){
                        t7.setText(String.valueOf(rs.getInt(4)));
                    }
                    
                }
                catch(Exception ex){
                  JOptionPane.showMessageDialog(null,"Complete the fields!");
                }
            }
        });
        
        updateStock.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    int a = Integer.parseInt(t3.getText()) + Integer.parseInt(t7.getText());
                    t7.setText(String.valueOf(a));
                    ps = con.prepareStatement("update stock set qty=? where id=?");
                    ps.setInt(1,Integer.parseInt(t7.getText()));
                    ps.setInt(2,(Integer)c.getSelectedItem());
                    int k = ps.executeUpdate();
                    if(k==1){
                        JOptionPane.showMessageDialog(null,"Stock quantity updated successfully");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Failed!!");
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
                    ps = con.prepareStatement("update purchase set item_no=?,order_no=?,qty=?,total=?,date1=?, notes=? where id=?");
                   
                    ps.setInt(1, Integer.parseInt(t1.getText()));
                    ps.setInt(2,Integer.parseInt(t2.getText()));
                    ps.setInt(3, Integer.parseInt(t3.getText()));
                    ps.setInt(4,Integer.parseInt(t4.getText()));
                    ps.setString(5, t5.getText());
                    ps.setString(6,t6.getText());
                    ps.setInt(7,(Integer)c.getSelectedItem());
                    int k = ps.executeUpdate();
                    if(k==1){
                        JOptionPane.showMessageDialog(null,"Record updated successfully!!");
                        c.addItem("");
                        t1.setText("");
                        t2.setText("");
                        t3.setText("");
                        t4.setText("");
                        t5.setText("");
                        t6.setText("");
                        t7.setText("");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Failed");
                    }
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        
        delete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    ps = con.prepareStatement("delete from purchase where id=?");
                    ps.setInt(1,(Integer)c.getSelectedItem());
                    ps.executeQuery();
                    c.addItem("");
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                    t7.setText("");
                    JOptionPane.showMessageDialog(null,"Record deleted successfully");
                }
                catch(Exception ev){
                    ev.printStackTrace();
                }
            }
        });
        
        cancel.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               new PurchaseEdit().setVisible(false);
           } 
        });
        
    }
}
