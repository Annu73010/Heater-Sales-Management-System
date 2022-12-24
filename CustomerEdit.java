
package heater.sales.management.system;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerEdit{
    
   
    
    static JFrame frame;
    static JPanel panel;
    static JButton b1,b2,b3,b4;
    static JLabel l1,l2,l3,l4,l5,l6;
    static JComboBox c1;
    static JTextField t2,t3,t4,t5;
    

    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;
    public static void main(String[] args){
                
        
        c1 = new JComboBox();
        c1.setFont(new Font("Dialog",Font.PLAIN,20));
        panel = new JPanel();
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        
        frame.setVisible(true);
        panel.setLayout(null);
        frame.setSize(800,550);
        
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
        l6 = new JLabel("CUSTOMER EDIT DETAILS");
        l6.setFont(new Font("Tahoma",Font.BOLD,38));
        l6.setForeground(new java.awt.Color(128,0,0));
        b1 = new JButton("UPDATE");
        b1.setFont(new Font("Tahoma",Font.BOLD,15));
        b2 = new JButton("DELETE");
        b2.setFont(new Font("Tahoma",Font.BOLD,15));
        b3 = new JButton("SEARCH");
        b3.setFont(new Font("Tahoma",Font.BOLD,15));
        b4 = new JButton("CANCEL");
        b4.setFont(new Font("Tahoma",Font.BOLD,15));
        
        t2 = new JTextField();
        t2.setFont(new Font("Dialog",Font.PLAIN,20));
        t3 = new JTextField();
        t3.setFont(new Font("Dialog",Font.PLAIN,20));
        t4 = new JTextField();
        t4.setFont(new Font("Dialog",Font.PLAIN,20));
        t5 = new JTextField();
        t5.setFont(new Font("Dialog",Font.PLAIN,20));
        
        l1.setBounds(50, 110, 120, 30);
        l2.setBounds(50, 150, 120, 30);
        l3.setBounds(50, 190, 120, 30);
        l4.setBounds(50, 270, 120, 30);
        l5.setBounds(50, 310, 120, 30);
        l6.setBounds(200, 20, 500, 45);
        c1.setBounds(200, 110, 400, 30);
        b3.setBounds(620 ,110, 100, 30);
        t2.setBounds(200, 150, 520, 30);
        t3.setBounds(200, 190, 520, 70);
        t4.setBounds(200, 270, 520, 30);
        t5.setBounds(200, 310, 520, 30);
        b1.setBounds(180,390,100,50);
        b2.setBounds(340,390,100,50);
        b4.setBounds(500, 390, 100, 50);
        
        panel.add(l1);
        panel.add(l2);
        panel.add(l3);
        panel.add(l4);
        panel.add(l5);
        panel.add(l6);
        panel.add(c1);
        panel.add(t2);
        panel.add(t3);
        panel.add(t4);
        panel.add(t5);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        
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
                    t2.setEditable(true);
                }
                else{
                    t4.setText(null);
                }
            }
        });
        
        con = HeaterSalesManagementSystem.System();
        
                try{
                    
                    ps = con.prepareStatement("select code from customer");
                    rs = ps.executeQuery();
                    while(rs.next()){
                        c1.addItem(rs.getString(1));
                    }
                    
                }
                catch(Exception ev)
                {
                    ev.printStackTrace();
                }
                
                b3.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e){
                       try{
                           
                           ps = con.prepareStatement("select *from customer where code=?");
                           ps.setString(1, c1.getSelectedItem().toString());
                           rs = ps.executeQuery();
                           
                           if(rs.next()==true){
                               t2.setText(rs.getString(2));
                               t3.setText(rs.getString(3));
                               t4.setText(String.valueOf(rs.getInt(4)));
                               t5.setText(rs.getString(5));
                           }
                       }
                       catch(Exception ev){
                           ev.printStackTrace();
                       }
                    }
                });
                
                b1.addActionListener(new ActionListener()
                {
                  public void actionPerformed(ActionEvent e){
                      try{
                          
                          String code = c1.getSelectedItem().toString();
                          String name = t2.getText();
                          String addr = t3.getText();
                          int phn = Integer.parseInt(t4.getText());
                          String email = t5.getText();
                          ps = con.prepareStatement("update customer set name=?, addr=?, phn=?, email=? where code=?");

                          ps.setString(1, name);
                          ps.setString(2, addr);
                          ps.setInt(3, phn);
                          ps.setString(4,email);
                          ps.setString(5,code);

                          
                          int k = ps.executeUpdate();
                          if(k==1){
                              JOptionPane.showMessageDialog(null,"Updated successfully");
                              c1.addItem("");
                              t2.setText("");
                              t3.setText("");
                              t4.setText("");
                              t5.setText("");
                          }

                        
                          else{
                              JOptionPane.showMessageDialog(null, "failed!!!");
                          }
                      }
                      catch(Exception ev){
                          JOptionPane.showMessageDialog(null,"Complete the fields!");
                      }
                      
                  }
                });
                
                b2.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        try{
                            ps = con.prepareStatement("delete from customer where code=?");
                            ps.setString(1, c1.getSelectedItem().toString());
                            ps.executeQuery();
                            JOptionPane.showMessageDialog(null, "Record deleted successfully");
                        }
                        catch(Exception ev){
                            ev.printStackTrace();
                        }
                    }
                });
        
    }

}
