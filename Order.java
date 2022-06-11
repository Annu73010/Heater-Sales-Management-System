
package heater.sales.management.system;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Order extends JFrame{
    
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;
    static JPanel p1,p2;
    static JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    static JTextField t1,t2,t3,t4,t5,t6;
    static JButton submit , search , cancel;
    static JComboBox c;
    
    public Order(){
        
        JFrame frame = new JFrame();
        p1 = new JPanel();
        p2 = new JPanel();
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(p1);
        frame.setSize(1180,530);
        frame.setVisible(true);
        p1.setLayout(null);
        
        l1 = new JLabel("Order No.");
        l1.setFont(new Font("Tahoma",Font.BOLD,20));
        l2 = new JLabel("Order Date");
        l2.setFont(new Font("Tahoma",Font.BOLD,20));
        l3 = new JLabel("Vendor Code");
        l3.setFont(new Font("Tahoma",Font.BOLD,20));
        l4 = new JLabel("Vendor Name");
        l4.setFont(new Font("Tahoma",Font.BOLD,20));
        l5 = new JLabel("Vendor Address");
        l5.setFont(new Font("Tahoma",Font.BOLD,20));
        l6 = new JLabel("Vendor Contact");
        l6.setFont(new Font("Tahoma",Font.BOLD,20));
        l7 = new JLabel("Vendor Email");
        l7.setFont(new Font("Tahoma",Font.BOLD,20));
        l8 = new JLabel("ORDER DETAILS");
        l8.setFont(new Font("Tahoma",Font.BOLD,38));
        l8.setForeground(new java.awt.Color(128,0,0));
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
        c = new JComboBox();
        c.setFont(new Font("Dialog",Font.PLAIN,20));
        submit = new JButton("SUBMIT");
        submit.setFont(new Font("Tahoma",Font.BOLD,15));
        search = new JButton("SEARCH");
        search.setFont(new Font("Tahoma",Font.BOLD,15));
        cancel = new JButton("CANCEL");
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        p2.setBorder(new javax.swing.border.TitledBorder("Vendor"));
        
        l1.setBounds(50, 110, 150, 30);
        l2.setBounds(50, 170, 150, 30);
        l3.setBounds(50, 230, 150, 30);
        l4.setBounds(550,90,180,30);
        l5.setBounds(550,150,180,70);
        l6.setBounds(550,280,180,30);
        l7.setBounds(550,340,180,30);
        l8.setBounds(200, 20, 400, 45);
        t1.setBounds(230,110,250,30);
        t2.setBounds(230,170,250,30);
        c.setBounds(230,230,250,30);
        t3.setBounds(760,90,350,30);
        t4.setBounds(760,150,350,90);
        t5.setBounds(760,280,350,30);
        t6.setBounds(760,340,350,30);
        submit.setBounds(80,380,100,50);
        cancel.setBounds(250,380,100,50);
        p2.setBounds(540, 50, 580, 350);
       
        p1.add(l1);
        p1.add(l2);
        p1.add(l3);
        p1.add(l4);
        p1.add(l5);
        p1.add(l6);
        p1.add(l7);
        p1.add(l8);
        p1.add(t1);
        p1.add(t2);
        p1.add(c);
        p1.add(t3);
        p1.add(t4);
        p1.add(t5);
        p1.add(t6);
        p1.add(p2);
        p1.add(submit);
        p1.add(search);
        p1.add(cancel);
        
    }
    
    public static void main(String[] args){
        Order order = new Order();
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
        
          t2.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                char c = e.getKeyChar();
                if(Character.isDigit(c) || Character.isLetter(c)|| Character.isWhitespace(c) || Character.isISOControl(c))
                {
                    t2.setEditable(true);
                }
                else{
                    t2.setEditable(false);
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
        
          c.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent e){
            try{
                ps = con.prepareStatement("select *from vendor where code=?");
                ps.setInt(1, (Integer)c.getSelectedItem());
                rs = ps.executeQuery();
                
                if(rs.next()==true)
                {
                    t3.setText(rs.getString(2));
                    t4.setText(rs.getString(3));
                    t5.setText(String.valueOf(rs.getInt(4)));
                    t5.setText(rs.getString(5));
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
                      ps = con.prepareStatement("insert into order1 values(?,?,?)");
                      ps.setInt(1, Integer.parseInt(t1.getText()));
                      ps.setString(2,t2.getText());
                      ps.setInt(3, (Integer)c.getSelectedItem());
                      ps.executeQuery();
                      JOptionPane.showMessageDialog(null,"Record added successfully!!");
                  }
                  catch(Exception ev){
                      JOptionPane.showMessageDialog(null,"Compelete the fields!");
                  }
              }
          });
          
          cancel.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent e){
                  new Order().setVisible(false);
              }
          });
        
    }
    
}
