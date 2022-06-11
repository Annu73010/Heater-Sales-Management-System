
package heater.sales.management.system;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class Stock {
    
    static Connection con = HeaterSalesManagementSystem.System();
        static JFrame frame = new JFrame();
        static JPanel p1;
        static JButton b1,b2;
        static JTextField t1,t2,t3,t4,t5;
        static JLabel l1,l2,l3,l4,l5,l6;
        
    
    public static void main(String[] args){
        
        
        p1 = new JPanel();
        
        frame.setContentPane(p1);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,550);
        p1.setLayout(null);
        
        
        l1 = new JLabel("Item No.");
        l1.setFont(new Font("Tahoma",Font.BOLD,20));
        l2 = new JLabel("Model");
        l2.setFont(new Font("Tahoma",Font.BOLD,20));
        l3 = new JLabel("Company");
        l3.setFont(new Font("Tahoma",Font.BOLD,20));
        l4 = new JLabel("Quantity");
        l4.setFont(new Font("Tahoma",Font.BOLD,20));
        l5 = new JLabel("Description");
        l5.setFont(new Font("Tahoma",Font.BOLD,20));
        l6 = new JLabel("STOCK DETAILS");
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
        b1 = new JButton("SUBMIT"); 
        b1.setFont(new Font("Tahoma",Font.BOLD,15));
        b2 = new JButton("CANCEL");
        b2.setFont(new Font("Tahoma",Font.BOLD,15));
       
        l1.setBounds(50, 110, 120, 30);
        l2.setBounds(50, 150, 120, 30);
        l3.setBounds(50, 190, 120, 30);
        l4.setBounds(50, 230, 120, 30);
        l5.setBounds(50, 270, 120, 30);
        l6.setBounds(200, 20, 450, 45);
        t1.setBounds(200, 110, 520, 30);
        t2.setBounds(200, 150, 520, 30);
        t3.setBounds(200, 190, 520, 30);
        t4.setBounds(200, 230, 520, 30);
        t5.setBounds(200, 270, 520, 100);
        b1.setBounds(180, 390, 100, 50);
        b2.setBounds(340, 390, 100, 50);
       
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
        p1.add(b1);
        p1.add(b2);
        
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
        
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    PreparedStatement ps = con.prepareStatement("insert into stock values(?,?,?,?,?)");
                    ps.setInt(1, Integer.parseInt(t1.getText()));
                    ps.setString(2, t2.getText());
                    ps.setString(3, t3.getText());
                    ps.setInt(4, Integer.parseInt(t4.getText()));
                    ps.setString(5, t5.getText());
                    ps.executeQuery();
                    JOptionPane.showMessageDialog(null,"Information added successfully!!");
                }
                catch(Exception ev){
                   JOptionPane.showMessageDialog(null,"Complete the fields");
                }
                
            }
        });
        
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
            }

           
        });
    }
    
}
