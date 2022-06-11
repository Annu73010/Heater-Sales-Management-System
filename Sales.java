
package heater.sales.management.system;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.Font;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Sales {
    
    static JFrame frame;
    static JPanel p1,p2,p3;
    static JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15;
    static JComboBox c1,c2;
    static JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18;
    static JButton submit, updateStock, cancel;
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;
    
    public Sales(){
        
        frame = new JFrame();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        frame.setContentPane(p1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(1260,720);
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
        l10 = new JLabel("Customer Name");
        l10.setFont(new Font("Tahoma",Font.BOLD,20));
        l11 = new JLabel("Customer Address");
        l11.setFont(new Font("Tahoma",Font.BOLD,20));
        l12 = new JLabel("Customer Contact No.");
        l12.setFont(new Font("Tahoma",Font.BOLD,20));
        l13 = new JLabel("Customer Email");
        l13.setFont(new Font("Tahoma",Font.BOLD,20));
        l14 = new JLabel("Model");
        l14.setFont(new Font("Tahoma",Font.BOLD,20));
        l15 = new JLabel("Company");
        l15.setFont(new Font("Tahoma",Font.BOLD,20));
        l16 = new JLabel("Quantity");
        l16.setFont(new Font("Tahoma",Font.BOLD,20));
        l17 = new JLabel("Description");
        l17.setFont(new Font("Tahoma",Font.BOLD,20));
        l18 = new JLabel("SALES DETAILS");
        l18.setFont(new Font("Tahoma",Font.BOLD,38));
        l18.setForeground(new java.awt.Color(128,0,0));
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
        t12 = new JTextField();
        t12.setFont(new Font("Dialog",Font.PLAIN,20));
        t13 = new JTextField();
        t13.setFont(new Font("Dialog",Font.PLAIN,20));
        t14 = new JTextField();
        t14.setFont(new Font("Dialog",Font.PLAIN,20));
        t15 = new JTextField();
        t15.setFont(new Font("Dialog",Font.PLAIN,20));
        submit = new JButton("SUBMIT");
        submit.setFont(new Font("Tahoma",Font.BOLD,15));
        updateStock = new JButton("UPDATE STOCK QUANTITY");
        updateStock.setFont(new Font("Tahoma",Font.BOLD,15)); 
        cancel = new JButton("CANCEL");
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));    
        p2.setBorder(new javax.swing.border.TitledBorder("Customer"));
        p3.setBorder(new javax.swing.border.TitledBorder("Stock"));
        
        l18.setBounds(90, 20, 430, 45);
        l1.setBounds(50, 80, 180, 30);
        l2.setBounds(50, 140, 180, 30);
        l3.setBounds(50, 200, 180, 30);
        l4.setBounds(50, 260, 180, 30);
        l5.setBounds(50, 320, 180, 30);
        l6.setBounds(50, 380, 180, 30);
        l7.setBounds(50, 440, 180, 30);
        l8.setBounds(50, 500, 180, 30);
        l9.setBounds(50, 560, 180, 30);
        l10.setBounds(550, 70, 230, 30);
        l11.setBounds(550, 140, 230, 30);
        l12.setBounds(550, 210, 230, 30);
        l13.setBounds(550, 280, 230, 30);
        l14.setBounds(550, 350, 230, 30);
        l15.setBounds(550, 420, 230, 30);
        l16.setBounds(550, 520, 230, 30);
        l17.setBounds(550, 590, 230, 30);
        t1.setBounds(230, 80, 250, 30);
        c1.setBounds(230, 140, 250, 30);
        c2.setBounds(230, 200, 250, 30);
        t2.setBounds(230, 260, 250, 30);
        t3.setBounds(230, 320, 250, 30);
        t4.setBounds(230, 380, 250, 30);
        t5.setBounds(230, 440, 250, 30);
        t6.setBounds(230, 500, 250, 30);
        t7.setBounds(230, 560, 250, 30);
        t8.setBounds(780, 70, 410, 30);
        t9.setBounds(780, 140, 410, 30);
        t10.setBounds(780, 210, 410, 30);
        t11.setBounds(780, 280, 410, 30);
        t12.setBounds(780, 350, 410, 30);
        t13.setBounds(780, 420, 410, 30);
        t14.setBounds(780, 520, 410, 30);
        t15.setBounds(780, 590, 410, 30);
        submit.setBounds(30, 610, 100, 50);
        updateStock.setBounds(150, 610, 250, 50);
        cancel.setBounds(420, 610, 100, 50);
        p2.setBounds(530, 20, 680, 460);
        p3.setBounds(530, 490, 680, 150);
        
        p1.add(l1);
        p1.add(l2);
        p1.add(l3);
        p1.add(l4);
        p1.add(l5);
        p1.add(l6);
        p1.add(l7);
        p1.add(l8);
        p1.add(l9);
        p1.add(l10);
        p1.add(l11);
        p1.add(l12);
        p1.add(l13);
        p1.add(l14);
        p1.add(l15);
        p1.add(l16);
        p1.add(l17);
        p1.add(l18);
        p1.add(t1);
        p1.add(c1);
        p1.add(c2);
        p1.add(t2);
        p1.add(t3);
        p1.add(t4);
        p1.add(t5);
        p1.add(t6);
        p1.add(t7);
        p1.add(t8);
        p1.add(t9);
        p1.add(t10);
        p1.add(t11);
        p1.add(t12);
        p1.add(t13);
        p1.add(t14);
        p1.add(t15);
        p1.add(p2);
        p1.add(p3);
        p1.add(submit);
        p1.add(updateStock);
        p1.add(cancel);
        
    }
    
    public static void main(String[] args){
        
        new Sales();
        con = HeaterSalesManagementSystem.System();
       
       try{
           ps = con.prepareStatement("select code from customer");
           rs = ps.executeQuery();
           while(rs.next()){
               c1.addItem(rs.getString(1));
           }
       }
       catch(Exception ev){
           ev.printStackTrace();
       }
       
       try{
           ps = con.prepareStatement("select id from stock");
           rs = ps.executeQuery();
           while(rs.next()){
               c2.addItem(rs.getInt(1));
           }
       }
       catch(Exception ev){
            ev.printStackTrace();
        }
        
       c1.addItemListener(new ItemListener(){
           public void itemStateChanged(ItemEvent e){
               try{
                   ps = con.prepareStatement("select *from customer where code=?");
                   ps.setString(1,c1.getSelectedItem().toString());
                   rs = ps.executeQuery();
                   if(rs.next()==true){
                       t8.setText(rs.getString(2));
                       t9.setText(rs.getString(3));
                       t10.setText(String.valueOf(rs.getInt(4)));
                       t11.setText(rs.getString(5));
                   }
               }
               catch(Exception ev){
                   ev.printStackTrace();
               }
           }
       });
       
       c2.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent e){
                    try{
                        ps = con.prepareStatement("select * from stock where id=?");
                        ps.setInt(1, (Integer)c2.getSelectedItem());
                        rs = ps.executeQuery();
                        if(rs.next()==true){
                            t12.setText(rs.getString(2));
                            t13.setText(rs.getString(3));
                            t14.setText(String.valueOf(rs.getInt(4)));
                            t15.setText(rs.getString(5));
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
                        ps = con.prepareStatement("insert into sales values(?,?,?,?,?,?,?,?,?)");
                        ps.setInt(1,Integer.parseInt(t1.getText()));
                        ps.setString(2,c1.getSelectedItem().toString());
                        ps.setInt(3,(Integer)c2.getSelectedItem());
                        ps.setInt(4, Integer.parseInt(t2.getText()));
                        ps.setInt(5,Integer.parseInt(t3.getText()));
                        ps.setInt(6,Integer.parseInt(t4.getText()));
                        ps.setInt(7,Integer.parseInt(t5.getText()));
                        ps.setInt(8,Integer.parseInt(t6.getText()));
                        ps.setString(9,t7.getText());
                        ps.executeQuery();
                        JOptionPane.showMessageDialog(null,"Record added successfully!!");
                    }
                    catch(Exception ev){
                       JOptionPane.showMessageDialog(null,"Complete the fields!");
                    }
                }
            });
            
            t2.addKeyListener(new KeyAdapter(){
                public void keyReleased(KeyEvent e){
                    int stock_qty = Integer.parseInt(t14.getText());
                    int sale_qty = Integer.parseInt(t2.getText());
                    if(sale_qty<=stock_qty){
                        t2.setEditable(true);
                    }
                    else{
                        t2.setText(null);
                        JOptionPane.showMessageDialog(null,"Quantity is not available in our stock!");
                    }
                }
            });
        
            t3.addKeyListener(new KeyAdapter(){
                public void keyReleased(KeyEvent e){
                   t4.setText(String.valueOf(Integer.parseInt(t2.getText()) * Integer.parseInt(t3.getText())));
                   
                }
            });
            
            t5.addKeyListener(new KeyAdapter(){
                public void keyReleased(KeyEvent ev){
                    int amount = Integer.parseInt(t4.getText());
                    int discount = Integer.parseInt(t5.getText());
                    if(discount<amount){
                        int c = amount - discount;
                        t6.setText(String.valueOf(c));
                    }
                    else{
                        t6.setText(null);
                        JOptionPane.showMessageDialog(null,"Discount cannot be greater than amount");
                        t5.setText(null);
//                        t5.setFocusable(true);
                    }
                }
            });
            
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
                if(Character.isDigit(c) || Character.isLetter(c)|| Character.isWhitespace(c) || Character.isISOControl(c))
                {
                    t7.setEditable(true);
                }
                else{
                    t7.setEditable(false);
                }
            }
        });       
                  
            updateStock.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    
                    int c = Integer.parseInt(t14.getText()) - Integer.parseInt(t2.getText());
                    t14.setText(String.valueOf(c));
                    try{
                        ps = con.prepareStatement("update stock set qty=? where id=?");
                        ps.setInt(1,Integer.parseInt(t14.getText()));
                        ps.setInt(2,(Integer)c2.getSelectedItem());
                        
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
