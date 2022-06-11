
package heater.sales.management.system;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Purchase extends JFrame{
    
    static JFrame frame;
    static JPanel p1,p2,p3;
    static JComboBox c1,c2;
    static JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    static JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
    static JButton submit, updateStock, cancel;
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;
    
    public Purchase(){
        
        frame = new JFrame();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
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
        l8 = new JLabel("Model");
        l8.setFont(new Font("Tahoma",Font.BOLD,20));
        l9 = new JLabel("Company");
        l9.setFont(new Font("Tahoma",Font.BOLD,20));
        l10 = new JLabel("Stock Quantity");
        l10.setFont(new Font("Tahoma",Font.BOLD,20));
        l11 = new JLabel("Description");
        l11.setFont(new Font("Tahoma",Font.BOLD,20));
        l12 = new JLabel("Order Date");
        l12.setFont(new Font("Tahoma",Font.BOLD,20));
        l13 = new JLabel("Vendor Code");
        l13.setFont(new Font("Tahoma",Font.BOLD,20));
        l14 = new JLabel("PURCHASE DETAILS");
        l14.setFont(new Font("Tahoma",Font.BOLD,38));
        l14.setForeground(new java.awt.Color(128,0,0));
        t1 = new JTextField();
        t1.setFont(new Font("Dialog",Font.PLAIN,20));
        c1 = new JComboBox();
        c1.setFont(new Font("Dialog",Font.PLAIN,20));
        c2 = new JComboBox();
        c2.setFont(new Font("Dialog",Font.PLAIN,20));
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
        t8 = new JTextField();
        t8.setFont(new Font("Dialog",Font.PLAIN,20));
        t9 = new JTextField();
        t9.setFont(new Font("Dialog",Font.PLAIN,20));
        t10 = new JTextField();
        t10.setFont(new Font("Dialog",Font.PLAIN,20));
        t11 = new JTextField();
        t11.setFont(new Font("Dialog",Font.PLAIN,20));
        submit = new JButton("SUBMIT");
        submit.setFont(new Font("Tahoma",Font.BOLD,15));
        updateStock = new JButton("UPDATE STOCK QUANTITY");
        updateStock.setFont(new Font("Tahoma",Font.BOLD,15)); 
        cancel = new JButton("CANCEL");
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));    
        p2.setBorder(new javax.swing.border.TitledBorder("Stock"));
        p3.setBorder(new javax.swing.border.TitledBorder("Order"));
        
        l14.setBounds(70, 20, 390, 45);
        l1.setBounds(50, 80, 150, 30);
        l2.setBounds(50, 140, 150, 30);
        l3.setBounds(50, 200, 150, 30);
        l4.setBounds(50, 260, 150, 30);
        l5.setBounds(50, 320, 150, 30);
        l6.setBounds(50, 380, 150, 30);
        l7.setBounds(50, 440, 150, 70);
        l8.setBounds(550, 70, 150, 30);
        l9.setBounds(550, 140, 150, 30);
        l10.setBounds(550, 210, 150, 30);
        l11.setBounds(550, 280, 150, 30);
        l12.setBounds(550, 470, 150, 30);
        l13.setBounds(550, 520, 150, 30);
        t1.setBounds(230, 80, 250, 30);
        c1.setBounds(230, 140, 250, 30);
        c2.setBounds(230, 200, 250, 30);
        t2.setBounds(230, 260, 250, 30);
        t3.setBounds(230, 320, 250, 30);
        t4.setBounds(230, 380, 250, 30);
        t5.setBounds(230, 440, 250, 70);
        t6.setBounds(720, 70, 410, 30);
        t7.setBounds(720, 140, 410, 30);
        t8.setBounds(720, 210, 410, 30);
        t9.setBounds(720, 280, 410, 100);
        t10.setBounds(720, 470, 410, 30);
        t11.setBounds(720, 520, 410, 30);
        submit.setBounds(30, 535, 100, 50);
        updateStock.setBounds(150, 535, 250, 50);
        cancel.setBounds(420, 535, 100, 50);
        p2.setBounds(540, 20, 610, 390);
        p3.setBounds(540, 430, 610, 150);
        
        p1.add(l1);
        p1.add(l2);
        p1.add(l3);
        p1.add(l4);
        p1.add(l5);
        p1.add(l6);
        p1.add(l7);
        p1.add(t1);
        p1.add(c1);
        p1.add(c2);
        p1.add(t2);
        p1.add(t3);
        p1.add(t4);
        p1.add(t5);
        p1.add(submit);
        p1.add(updateStock);
        p1.add(cancel);
        p1.add(l14);
        p1.add(l8);
        p1.add(l9);
        p1.add(l10);
        p1.add(l11);
        p1.add(t6);
        p1.add(t7);
        p1.add(t8);
        p1.add(t9);
        p1.add(p2);
        p1.add(l12);
        p1.add(l13);
        p1.add(t10);
        p1.add(t11);
        p1.add(p3);
        
    }
    
     public static void main(String[] args){
            
            new Purchase();
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
                if(Character.isDigit(c) || Character.isLetter(c)|| Character.isWhitespace(c) || Character.isISOControl(c))
                {
                    t4.setEditable(true);
                }
                else{
                    t4.setEditable(false);
                }
            }
        });   
               
            try{
                ps = con.prepareStatement("select id from stock");
                rs = ps.executeQuery();
                while(rs.next()){
                    c1.addItem(rs.getInt(1));
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
            c1.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent e){
                    try{
                        ps = con.prepareStatement("select * from stock where id=?");
                        ps.setInt(1, (Integer)c1.getSelectedItem());
                        rs = ps.executeQuery();
                        if(rs.next()==true){
                            t6.setText(rs.getString(2));
                            t7.setText(rs.getString(3));
                            t8.setText(String.valueOf(rs.getInt(4)));
                            t9.setText(rs.getString(5));
                        }
                    }
                    catch(Exception ev){
                        ev.printStackTrace();
                    }
                }
            });
            
            try{
                ps = con.prepareStatement("select id from order1");
                rs = ps.executeQuery();
                while(rs.next()){
                    c2.addItem(rs.getInt(1));
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
            c2.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent e){
                    try{
                        ps = con.prepareStatement("select * from order1 where id=?");
                        ps.setInt(1, (Integer)c2.getSelectedItem());
                        rs = ps.executeQuery();
                        if(rs.next()==true){
                            t10.setText(rs.getString(2));
                            t11.setText(String.valueOf(rs.getInt(3)));
                        }
                    }
                    catch(Exception ev){
                        ev.printStackTrace();
                    }
                }
            });
            
            submit.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    try{
                        ps = con.prepareStatement("insert into purchase values(?,?,?,?,?,?,?)");
                        ps.setInt(1,Integer.parseInt(t1.getText()));
                        ps.setInt(2,(Integer)c1.getSelectedItem());
                        ps.setInt(3,(Integer)c2.getSelectedItem());
                        ps.setInt(4, Integer.parseInt(t2.getText()));
                        ps.setInt(5,Integer.parseInt(t3.getText()));
                        ps.setString(6,t4.getText());
                        ps.setString(7,t5.getText());
                        ps.executeQuery();
                        JOptionPane.showMessageDialog(null,"Record added successfully!!");
                    }
                    catch(Exception ev){
                        JOptionPane.showMessageDialog(null,"Complete the fields!");
                    }
                }
            });
            
            updateStock.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    
                    int c = Integer.parseInt(t2.getText()) + Integer.parseInt(t8.getText());
                    t8.setText(String.valueOf(c));
                    try{
                        ps = con.prepareStatement("update stock set qty=? where id=?");
                        ps.setInt(2,(Integer)c1.getSelectedItem());
                        ps.setInt(1,Integer.parseInt(t8.getText()));
                        
                        int k = ps.executeUpdate();
                        if(k==1){
                            JOptionPane.showMessageDialog(null,"Stock quantity updated successfully!");
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
            
            cancel.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    new Purchase().setVisible(false);
                }
            });
            
        }
    
}
