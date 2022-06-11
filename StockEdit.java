
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

public class StockEdit extends JFrame{
    
    static Connection conn;
    static PreparedStatement ps;
    static ResultSet rs;
    static JComboBox c;
    static JPanel p1;
    static JButton update,delete,cancel,search;
    static JLabel l1,l2,l3,l4,l5,l6;
    static JTextField t1,t2,t3,t4;
    
    public StockEdit(){
        
        JFrame frame = new JFrame();
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
        l6 = new JLabel("STOCK EDIT DETAILS");
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
        new StockEdit();
        
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
        
        conn = HeaterSalesManagementSystem.System();
        
        try{
            ps = conn.prepareStatement("select id from stock");
            rs = ps.executeQuery();
            while(rs.next()){
                c.addItem(rs.getInt(1));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
       search.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e){
                       try{
                           
                           ps = conn.prepareStatement("select *from stock where id=?");
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
                            ps = conn.prepareStatement("update stock set model=?,company=?,qty=?,description=? where id=?");
                            ps.setString(1,t1.getText());
                            ps.setString(2, t2.getText());
                            ps.setInt(3, Integer.parseInt(t3.getText()));
                            ps.setString(4,t4.getText());
                            ps.setInt(5, (Integer)c.getSelectedItem());

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
                                JOptionPane.showMessageDialog(null,"Failed!!");
                            }
                        }
                        catch(Exception ev){
                            JOptionPane.showMessageDialog(null,"Complete the fields!");
                        }
                    }
                });
       
        delete.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e)
           {
               try{
                   ps = conn.prepareStatement("delete from stock where id=?");
                   ps.setInt(1, (Integer)c.getSelectedItem());
                   ps.executeQuery();
                   c.addItem("");
                   t1.setText("");
                   t2.setText("");
                   t3.setText("");
                   t4.setText("");
                   JOptionPane.showMessageDialog(null,"Record deleted successfully");
               }
               catch(Exception ev){
                   ev.printStackTrace();
               }
           }
       });
        
        cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                new StockEdit().setVisible(false);
            }
        });
    }
    
}
