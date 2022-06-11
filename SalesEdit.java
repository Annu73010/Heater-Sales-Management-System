
package heater.sales.management.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SalesEdit {
    
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;
    static JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    static JComboBox c;
    static JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    static JPanel p1;
    static JFrame frame;
    static JButton update, updateStock, delete, cancel, total;
    
    public SalesEdit(){
        
        frame = new JFrame();
        p1 = new JPanel();
       
        frame.setContentPane(p1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100,720);
        frame.setVisible(true);
        p1.setLayout(null);
        
        l1 = new JLabel("ID");
        l1.setFont(new Font("Tahoma",Font.BOLD,20));
        l2 = new JLabel("Customer Code");
        l2.setFont(new Font("Tahoma",Font.BOLD,20));
        l3 = new JLabel("Item No.");
        l3.setFont(new Font("Tahoma",Font.BOLD,20));
        l4 = new JLabel("Quantity");
        l4.setFont(new Font("Tahoma",Font.BOLD,20));
        l5 = new JLabel("Rate");
        l5.setFont(new Font("Tahoma",Font.BOLD,20));
        l6 = new JLabel("Amount");
        l6.setFont(new Font("Tahoma",Font.BOLD,20));
        l7 = new JLabel("Discount");
        l7.setFont(new Font("Tahoma",Font.BOLD,20));
        l8 = new JLabel("Net Amount");
        l8.setFont(new Font("Tahoma",Font.BOLD,20));
        l9 = new JLabel("Date");
        l9.setFont(new Font("Tahoma",Font.BOLD,20));
        l11 = new JLabel("Stock Quantity");
        l11.setFont(new Font("Tahoma",Font.BOLD,20));
        l12 = new JLabel("SALES EDIT DETAILS");
        l12.setFont(new Font("Tahoma",Font.BOLD,38));
        l12.setForeground(new java.awt.Color(128,0,0));
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
        t8 = new JTextField();
        t8.setFont(new Font("Dialog",Font.PLAIN,20));
        t9 = new JTextField();
        t9.setFont(new Font("Dialog",Font.PLAIN,20));
        t10 = new JTextField();
        t10.setFont(new Font("Dialog",Font.PLAIN,20));
        update = new JButton("UPDATE");
        update.setFont(new Font("Tahoma",Font.BOLD,15));
        updateStock = new JButton("UPDATE STOCK QUANTITY");
        updateStock.setFont(new Font("Tahoma",Font.BOLD,15));
        delete = new JButton("DELETE");
        delete.setFont(new Font("Tahoma",Font.BOLD,15));
        cancel = new JButton("CANCEL");
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        total = new JButton("TOTAL QUANTITY");
        total.setFont(new Font("Tahoma",Font.BOLD,15));
 
        l12.setBounds(280, 20, 500, 45);
        l1.setBounds(50, 80, 180, 30);
        l2.setBounds(50, 140, 180, 30);
        l3.setBounds(50, 200, 180, 30);
        l4.setBounds(50, 260, 180, 30);
        l5.setBounds(50, 320, 180, 30);
        l6.setBounds(50, 380, 180, 30);
        l7.setBounds(50, 440, 180, 30);
        l8.setBounds(50, 500, 180, 30);
        l9.setBounds(50, 560, 180, 30);
        l11.setBounds(550, 260, 230, 30);
        c.setBounds(250, 80, 250, 30);
        t1.setBounds(250, 140, 250, 30);
        t2.setBounds(250, 200, 250, 30);
        t3.setBounds(250, 260, 250, 30);
        t4.setBounds(250, 320, 250, 30);
        t5.setBounds(250, 380, 250, 30);
        t6.setBounds(250, 440, 250, 30);
        t7.setBounds(250, 500, 250, 30);
        t8.setBounds(250, 560, 250, 30);
        t9.setBounds(760, 180, 270, 30);
        t10.setBounds(760, 260, 270, 30);
        update.setBounds(30, 610, 100, 50);
        updateStock.setBounds(150, 610, 250, 50);
        delete.setBounds(420, 610, 100, 50);
        cancel.setBounds(540, 610, 100,50);
        total.setBounds(550, 170, 180, 50);

        
        p1.add(l1);
        p1.add(l2);
        p1.add(l3);
        p1.add(l4);
        p1.add(l5);
        p1.add(l6);
        p1.add(l7);
        p1.add(l8);
        p1.add(l9);
        p1.add(total);
        p1.add(l11);
        p1.add(l12);
        p1.add(c);
        p1.add(t1);
        p1.add(t2);
        p1.add(t3);
        p1.add(t4);
        p1.add(t5);
        p1.add(t6);
        p1.add(t7);
        p1.add(t8);
        p1.add(t9);
        p1.add(t10);
        p1.add(update);
        p1.add(updateStock);
        p1.add(delete);
        p1.add(cancel);
        
    }
    
     public static void main(String[] args){
            
            new SalesEdit();
            con = HeaterSalesManagementSystem.System();
            
               t1.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e){
                String valid = "^[A-Z0-9]{0,9}$";
                Pattern pattern = Pattern.compile(valid);
                Matcher match = pattern.matcher(t1.getText());
                if(!match.matches()){
                    JOptionPane.showMessageDialog(null,"Customer code is incorrect");
                    t1.setText(null);
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
                if(Character.isDigit(c) || Character.isISOControl(c))
                {
                    t5.setEditable(true);
                }
                else{
                    t5.setEditable(false);
                }
            }
        });
                
                 t6.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char c = e.getKeyChar();
                if(Character.isDigit(c) || Character.isISOControl(c))
                {
                    t6.setEditable(true);
                }
                else{
                    t6.setEditable(false);
                }
            }
        });
            
                t7.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char c = e.getKeyChar();
                if(Character.isDigit(c) || Character.isISOControl(c))
                {
                    t7.setEditable(true);
                }
                else{
                    t7.setEditable(false);
                }
            }
        });  
               
                  t8.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char c = e.getKeyChar();
                if(Character.isDigit(c) || Character.isLetter(c)|| Character.isWhitespace(c) || Character.isISOControl(c))
                {
                    t8.setEditable(true);
                }
                else{
                    t8.setEditable(false);
                }
            }
        });   
                
                t3.addKeyListener(new KeyAdapter(){
                public void keyReleased(KeyEvent e){
                    int stock_qty = Integer.parseInt(t10.getText());
                    int sale_qty = Integer.parseInt(t3.getText());
                    if(sale_qty<=stock_qty){
                        t3.setEditable(true);
                    }
                    else{
                        t3.setText(null);
                        JOptionPane.showMessageDialog(null,"Quantity is not available in our stock!");
                    }
                }
            });
        
            t4.addKeyListener(new KeyAdapter(){
                public void keyReleased(KeyEvent e){
                   t5.setText(String.valueOf(Integer.parseInt(t3.getText()) * Integer.parseInt(t4.getText())));
                   
                }
            });
            
            t6.addKeyListener(new KeyAdapter(){
                public void keyReleased(KeyEvent ev){
                    int amount = Integer.parseInt(t5.getText());
                    int discount = Integer.parseInt(t6.getText());
                    if(discount<amount){
                        int c = amount - discount;
                        t7.setText(String.valueOf(c));
                    }
                    else{
                        t7.setText(null);
                        JOptionPane.showMessageDialog(null,"Discount cannot be greater than amount");
                        t6.setText(null);
//                        t5.setFocusable(true);
                    }
                }
            });
                
            updateStock.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    
                    int c = Integer.parseInt(t10.getText()) - Integer.parseInt(t3.getText());
                    t10.setText(String.valueOf(c));
                    try{
                        ps = con.prepareStatement("update stock set qty=? where id=?");
                        ps.setInt(1,Integer.parseInt(t10.getText()));
                        ps.setInt(2,Integer.parseInt(t2.getText()));
                        
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
            
              update.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    ps = con.prepareStatement("update sales cust_code=?,item_no=?,qty=?,rate=?,amount=?,discount=?,net_amount=?,date1=? where id=?");
                   
                    ps.setInt(1, Integer.parseInt(t1.getText()));
                    ps.setInt(2,Integer.parseInt(t2.getText()));
                    ps.setInt(3, Integer.parseInt(t3.getText()));
                    ps.setInt(4,Integer.parseInt(t4.getText()));
                    ps.setInt(5, Integer.parseInt(t5.getText()));
                    ps.setInt(6, Integer.parseInt(t6.getText()));
                    ps.setInt(7,Integer.parseInt(t7.getText()));
                    ps.setString(8, t8.getText());
                    ps.setInt(9,(Integer)c.getSelectedItem());
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
                        t8.setText("");
                        t9.setText("");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Failed");
                    }
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"Complete the fields!");
                }
            }
        });
            
        }
    
}
