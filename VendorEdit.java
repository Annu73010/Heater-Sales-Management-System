
package heater.sales.management.system;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VendorEdit extends JFrame{
    
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;
    static JLabel l1,l2,l3,l4,l5,l6;
    static JTextField t1,t2,t3,t4;
    static JComboBox c;
    static JButton update,delete,cancel,search;
    static JFrame frame;
    static JPanel p1;
    
    public VendorEdit(){
        
        frame = new JFrame();
        p1 = new JPanel();
       
        frame.setContentPane(p1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,550);
        frame.setVisible(true);
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
        l6 = new JLabel("VENDOR EDIT DETAILS");
        l6.setFont(new Font("Tahoma",Font.BOLD,38));
        l6.setForeground(new java.awt.Color(128,0,0));
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
        update = new JButton("UPDATE"); 
        update.setFont(new Font("Tahoma",Font.BOLD,15));
        delete = new JButton("Delete");
        delete.setFont(new Font("Tahoma",Font.BOLD,15));
        search = new JButton("SEARCH");
        search.setFont(new Font("Tahoma",Font.BOLD,15));
        cancel = new JButton("CANCEL");
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
       
        l1.setBounds(50, 110, 120, 30);
        l2.setBounds(50, 150, 120, 30);
        l3.setBounds(50, 190, 120, 30);
        l4.setBounds(50, 230, 120, 30);
        l5.setBounds(50, 270, 120, 30);
        l6.setBounds(200, 20, 450, 45);
        c.setBounds(200, 110, 400, 30);
        t1.setBounds(200, 150, 520, 30);
        t2.setBounds(200, 190, 520, 30);
        t3.setBounds(200, 230, 520, 30);
        t4.setBounds(200, 270, 520, 100);
        update.setBounds(180,390,100,50);
        delete.setBounds(340,390,100,50);
        search.setBounds(620 ,110, 100, 30);
        cancel.setBounds(500,390,100,50);
        
        p1.add(l1);
        p1.add(l2);
        p1.add(l3);
        p1.add(l4);
        p1.add(l5);
        p1.add(l6);
        p1.add(c);
        p1.add(t1);
        p1.add(t2);
        p1.add(t3);
        p1.add(t4);
        p1.add(update);
        p1.add(delete);
        p1.add(search);
        p1.add(cancel);
        
    }
    
    public static void main(String[] args){
        new VendorEdit();
        con = HeaterSalesManagementSystem.System();
        
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
        
        try{
            ps = con.prepareStatement("select code from vendor");
            rs = ps.executeQuery();
            while(rs.next()){
                c.addItem(rs.getInt(1));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        search.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    ps = con.prepareStatement("select * from vendor where code=?");
                    ps.setInt(1,(Integer)c.getSelectedItem());
                    rs = ps.executeQuery();
                    if(rs.next()==true){
                        t1.setText(rs.getString(2));
                        t2.setText(rs.getString(3));
                        t3.setText(String.valueOf(rs.getInt(4)));
                        t4.setText(rs.getString(5));
                    }
                    
                }
                catch(Exception ev){
                   ev.printStackTrace();
                }
            }
        });
        
        update.addActionListener(new ActionListener()
                {
                  public void actionPerformed(ActionEvent e){
                      try{
                          
                          int code = (Integer)c.getSelectedItem();
                          String name = t1.getText();
                          String addr = t2.getText();
                          int phn = Integer.parseInt(t3.getText());
                          String email = t4.getText();
                          ps = con.prepareStatement("update vendor set name=?, addr=?, phn=?, email=? where code=?");

                          ps.setString(1, name);
                          ps.setString(2, addr);
                          ps.setInt(3, phn);
                          ps.setString(4,email);
                          ps.setInt(5,code);

                          
                          int k = ps.executeUpdate();
                          if(k==1){
                              JOptionPane.showMessageDialog(null,"Updated successfully");
                              c.addItem("");
                              t1.setText("");
                              t2.setText("");
                              t3.setText("");
                              t4.setText("");
                          }

                        
                          else{
                              JOptionPane.showMessageDialog(null, "failed!!!");
                          }
                      }
                      catch(Exception ev){
                         JOptionPane.showMessageDialog(null,"Complete the fields");
                      }
                  }
                });
        
         delete.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        try{
                            ps = con.prepareStatement("delete from vendor where code=?");
                            ps.setInt(1, (Integer)c.getSelectedItem());
                            ps.executeQuery();
                            JOptionPane.showMessageDialog(null, "Record deleted successfully");
                        }
                        catch(Exception ev){
                            ev.printStackTrace();
                        }
                    }
                });
         
         cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                new VendorEdit().setVisible(false);
            }
        });
    }
}
