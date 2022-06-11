
package heater.sales.management.system;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.Font;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserEdit extends JFrame{
    
    static JFrame frame;
    static JPanel p1;
    static JButton update, delete, cancel;
    static JLabel l1,l2,l3,l4;
    static JTextField t;
    static JPasswordField p;
    static JComboBox c;
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;
    
    public UserEdit(){
        
        frame = new JFrame();
        p1 = new JPanel();
       
        frame.setContentPane(p1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,480);
        frame.setVisible(true);
        p1.setLayout(null);
        
        l1 = new JLabel("User ID");
        l1.setFont(new Font("Tahoma",Font.BOLD,20));
        l2 = new JLabel("Password");
        l2.setFont(new Font("Tahoma",Font.BOLD,20));
        l3 = new JLabel("Description");
        l3.setFont(new Font("Tahoma",Font.BOLD,20));
        l4 = new JLabel("USER EDIT DETAILS");
        l4.setFont(new Font("Tahoma",Font.BOLD,38));
        l4.setForeground(new java.awt.Color(128,0,0));
        p = new JPasswordField();
        p.setFont(new Font("Dialog",Font.PLAIN,20));
        t = new JTextField();
        t.setFont(new Font("Dialog",Font.PLAIN,20));
        c = new JComboBox();
        c.setFont(new Font("Dialog",Font.PLAIN,20));
        update = new JButton("UPDATE");
        update.setFont(new Font("Tahoma",Font.BOLD,15));
        delete = new JButton("DELETE");
        delete.setFont(new Font("Tahoma",Font.BOLD,15));
        cancel = new JButton("CANCEL");
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        
        l1.setBounds(50,  110, 150, 30);
        l2.setBounds(50,  180, 150, 30);
        l3.setBounds(50,  250, 150, 30);
        l4.setBounds(200, 20, 400, 45);
        c.setBounds(200,  110, 520, 30);
        p.setBounds(200, 180, 520, 30);
        t.setBounds(200, 250, 520, 30);
        update.setBounds(150, 350, 100, 50);
        delete.setBounds(290, 350, 100, 50);
        cancel.setBounds(430, 350, 100, 50);
        
        p1.add(l1);
        p1.add(l2);
        p1.add(l3);
        p1.add(p);
        p1.add(t);
        p1.add(c);
        p1.add(l4);
        p1.add(update);
        p1.add(delete);
        p1.add(cancel);
        
    }
    
    public static void main(String[] args){
        
        new UserEdit();
        con = HeaterSalesManagementSystem.System();
        
        p.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                
                int l = p.getText().length();
                char c = e.getKeyChar();
                if(Character.isISOControl(c) || Character.isDigit(c) || Character.isLetter(c))
                {
                    p.setEditable(true);
                    if(l<=7)
                {
                    p.setEditable(true);
                        
                }
                else{
                    p.setEditable(false);
                    JOptionPane.showMessageDialog(null,"Password must be of 8");
                }
                }
                else{
                    p.setEditable(false);
                }                
            }
        });
        
        try{
            ps = con.prepareStatement("select id from user1");
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
                    ps = con.prepareStatement("select *from user1 where id=?");
                    ps.setInt(1, (Integer)c.getSelectedItem());
                    rs = ps.executeQuery();
                    if(rs.next()==true)
                    {
                        p.setText(rs.getString(2));
                        t.setText(rs.getString(3));
                    }
                }
                catch(Exception ev){
                    ev.printStackTrace();
                }
            }
        });
        
        update.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                try{
                    ps = con.prepareStatement("update user1 set password=?,description=? where id=?");
                    ps.setInt(3, (Integer)c.getSelectedItem());
                    ps.setString(1, p.getText());
                    ps.setString(2, t.getText());
                    
                    int k = ps.executeUpdate();
                    if(k==1){
                        JOptionPane.showMessageDialog(null,"Record updated successfully!!");
                        c.addItem("");
                        p.setText("");
                        t.setText("");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Failed!!");
                    }
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Complete the fields!");
                }
            }
        });
        
        delete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    ps = con.prepareStatement("delete from user1 where id=?");
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
                new UserEdit().setVisible(false);
            }
        });
        
    }
    
}
