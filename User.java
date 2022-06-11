
package heater.sales.management.system;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User extends JFrame{
    
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;
    static JLabel l1,l2,l3,l4;
    static JTextField t1,t2;
    static JPasswordField p;
    static JButton submit, cancel;
    static JPanel p1;
    static JFrame frame;
    
    public User(){
        
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
        l4 = new JLabel("USER DETAILS");
        l4.setFont(new Font("Tahoma",Font.BOLD,38));
        l4.setForeground(new java.awt.Color(128,0,0));
        t1 = new JTextField();
        t1.setFont(new Font("Dialog",Font.PLAIN,20));
        p = new JPasswordField();
        p.setFont(new Font("Dialog",Font.PLAIN,20));
        t2 = new JTextField();
        t2.setFont(new Font("Dialog",Font.PLAIN,20));
        submit = new JButton("SUBMIT");
        submit.setFont(new Font("Tahoma",Font.BOLD,15));
        cancel = new JButton("CANCEL");
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        
        l4.setBounds(200, 20, 400, 45);
        l1.setBounds(50,  110, 150, 30);
        l2.setBounds(50,  180, 150, 30);
        l3.setBounds(50,  250, 150, 30);
        t1.setBounds(200,  110, 520, 30);
        p.setBounds(200, 180, 520, 30);
        t2.setBounds(200, 250, 520, 30);
        submit.setBounds(150, 350, 100, 50);
        cancel.setBounds(290, 350, 100, 50);
        
        p1.add(t1);
        p1.add(p);
        p1.add(t2);
        p1.add(l1);
        p1.add(l2);
        p1.add(l3);
        p1.add(l4);
        p1.add(submit);
        p1.add(cancel);
        
    }
    
    public static void main(String[] args){
        
        new User().setVisible(true);
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
        
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    ps = con.prepareStatement("insert into User1 values(?,?,?)");
                    ps.setInt(1,Integer.parseInt(t1.getText()));
                    ps.setString(2, p.getText());
                    ps.setString(3,t2.getText());
                    ps.executeQuery();
                    JOptionPane.showMessageDialog(null,"Record added successfully!!");
                }
                catch(Exception ev){
                    JOptionPane.showMessageDialog(null,"Complete the fields");
                }
            }
        });
        
        cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new User();
            }
        });
        
    }
    
}
