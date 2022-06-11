
package heater.sales.management.system;
import java.awt.Color;
import javax.swing.*;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main extends JFrame{
    
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;
    static JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    
    public Main(){
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1300,720);
        
    }
    
    public static void main(String[] args){
        Main m = new Main();
        m.setVisible(true);
    }
    
}
