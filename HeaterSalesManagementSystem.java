
package heater.sales.management.system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class HeaterSalesManagementSystem {


    public static Connection System(){
        Connection conn = null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver loaded");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","root","root");
            System.out.println("Connection established");
        }
        catch(ClassNotFoundException ex){
            System.out.println("Driver not loaded");
        }
        catch(SQLException ex){
            System.out.println("Connection not established");
        }
        return conn;
    }
    
}
