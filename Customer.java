
package heater.sales.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer extends JFrame{
    static Connection con;
    public static void main(String[] args){
        new Customer().setVisible(true);
        con = HeaterSalesManagementSystem.System();
    }
    
    JLabel l1,l2,l3,l4,l5,l6,label;
    JTextField t1,t2,t3,t4,t5;
    JButton submit,cancel;
    JPanel panel = new JPanel();
   
    public Customer(){
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        panel.setLayout(null);
        setSize(800,550);
        
        label = new JLabel();
        label.setFont(new Font("Tahoma",Font.BOLD,20));
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
        l6 = new JLabel("CUSTOMER DETAILS");
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
        submit.setFont(new Font("Tahoma",Font.BOLD,15));
        cancel = new JButton("CANCEL");
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        
        label.setBounds(800, 110, 120, 30);
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
        panel.add(label);
        panel.add(l1);
        panel.add(l2);
        panel.add(l3);
        panel.add(l4);
        panel.add(l5);
        panel.add(l6);
        panel.add(t1);
        panel.add(t2);
        panel.add(t3);
        panel.add(t4);
        panel.add(t5);
        panel.add(submit);
        panel.add(cancel);
        
        t1.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent e){
                String valid = "^[A-Z0-9]{0,9}$";
                Pattern pattern = Pattern.compile(valid);
                Matcher match = pattern.matcher(t1.getText());
                if(!match.matches()){
                    JOptionPane.showMessageDialog(null,"Code naming is incorrect");
                    t1.setText(null);
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
          
//           t5.addKeyListener(new KeyAdapter(){
//            public void keyReleased(KeyEvent e){
//                String valid = "^[a-zA-Z0-9]{0,30}@[a-zA-Z]{0-10}.[a-zA-Z]$";
//                Pattern pattern = Pattern.compile(valid);
//                Matcher match = pattern.matcher(t5.getText());
//                if(!match.matches()){
//                    JOptionPane.showMessageDialog(null,"email naming is incorrect");
//                    t5.setText(null);
//                }   
//            }
//        });
        
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                    
                    try{
                       
                    PreparedStatement ps;
                    ps = con.prepareStatement("insert into customer values(?,?,?,?,?)");
                    ps.setString(1,(t1.getText()));
                    ps.setString(2,t2.getText());
                    ps.setString(3,t3.getText());
                    ps.setInt(4,Integer.parseInt(t4.getText()));
                    ps.setString(5,t5.getText());
                    ps.executeQuery();
                    JOptionPane.showMessageDialog(null, "Account created successfully");
                     
                }
                catch(SQLException e)
                {
                    JOptionPane.showMessageDialog(null,"Complete the fields!!");
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,"complete the Contact field!");
                }
                    catch(NullPointerException x){
                        x.printStackTrace();
                    }
            }
        });
        
        cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Customer().setVisible(false);
            }
        });
    }
    
    
}
