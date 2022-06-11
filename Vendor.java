
package heater.sales.management.system;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Vendor extends JFrame{
        
    static Connection conn;
    static PreparedStatement ps;
    static JFrame frame;
    static JPanel p1;
    static JTextField t1,t2,t3,t4,t5;
    static JLabel l1,l2,l3,l4,l5,l6;
    static JButton submit,cancel;
    
    public Vendor(){
        
        frame = new JFrame();
        p1 = new JPanel();
       
        frame.setContentPane(p1);
        frame.setVisible(true);
        frame.setSize(800,550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p1.setLayout(null);
        
        l1 = new JLabel("Code");
        l1.setFont(new Font("Tahoma",Font.BOLD,20));
        l2 = new JLabel("Name");
        l2.setFont(new Font("Tahoma",Font.BOLD,20));
        l3 = new JLabel("Address");
        l3.setFont(new Font("Tahoma",Font.BOLD,20));
        l4 = new JLabel("Contact");
        l4.setFont(new Font("Tahoma",Font.BOLD,20));
        l5 = new JLabel("Email");
        l5.setFont(new Font("Tahoma",Font.BOLD,20));
        l6 = new JLabel("VENDOR DETAILS");
        l6.setFont(new Font("Tahoma",Font.BOLD,38));
        l6.setForeground(new java.awt.Color(128,0,0));
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
        submit = new JButton("SUBMIT");
        submit.setFont(new Font("Tahoma",Font.BOLD,18));
        cancel = new JButton("CANCEL");
        cancel.setFont(new Font("Tahoma",Font.BOLD,18));
       
        l1.setBounds(50, 110, 120, 30);
        l2.setBounds(50, 150, 120, 30);
        l3.setBounds(50, 190, 120, 30);
        l4.setBounds(50, 270, 120, 30);
        l5.setBounds(50, 310, 120, 30);
        l6.setBounds(200, 20, 450, 45);
        t1.setBounds(200, 110, 520, 30);
        t2.setBounds(200, 150, 520, 30);
        t3.setBounds(200, 190, 520, 70);
        t4.setBounds(200, 270, 520, 30);
        t5.setBounds(200, 310, 520, 30);
        submit.setBounds(180,390,100,50);
        cancel.setBounds(340,390,100,50);
       
        p1.add(l1);
        p1.add(l2);
        p1.add(l3);
        p1.add(l4);
        p1.add(l5);
        p1.add(l6);
        p1.add(t1);
        p1.add(t2);
        p1.add(t3);
        p1.add(t4);
        p1.add(t5);
        p1.add(submit);
        p1.add(cancel);
       
    }
    
    public static void main(String[] args){
        new Vendor();
        conn = HeaterSalesManagementSystem.System();
        
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
                if(Character.isLetter(c)|| Character.isWhitespace(c) || Character.isISOControl(c))
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
                if(Character.isLetter(c)|| Character.isWhitespace(c) || Character.isISOControl(c))
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
                    t4.setText(null);
                }
            }
        });
        
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    ps = conn.prepareStatement("insert into vendor values(?,?,?,?,?)");
                    ps.setInt(1,Integer.parseInt(t1.getText()));
                    ps.setString(2,t2.getText());
                    ps.setString(3,t3.getText());
                    ps.setInt(4, Integer.parseInt(t4.getText()));
                    ps.setString(5,t5.getText());
                    ps.executeQuery();
                    JOptionPane.showMessageDialog(null,"Record added successfully!!");
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                }
                catch(Exception ev){
                    JOptionPane.showMessageDialog(null,"Complete the fields!");
                }
                
            }
        });
        
        cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Vendor().setVisible(false);
            }
        });
    }
    
}
