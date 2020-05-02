
package myproject;
import java.sql.*;
import javax.swing.JOptionPane;
import oracle.jdbc.pool.OracleDataSource;

public class connect {
   Connection cn;
   
    connect()
    {
        try
        {//Server
        Class.forName("com.mysql.jdbc.Driver");
        cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/compalintcell","root","123456");
        //Client
       /*
        OracleDataSource ods = new OracleDataSource();
ods.setURL("jdbc:oracle:thin:@//192.168.43.208:1521/xe"); // jdbc:oracle:thin@//[IP hostname]:[port]/[DB service name]
ods.setUser("system"); // [username]
ods.setPassword("123456"); // [password]
cn = ods.getConnection();
        */
        }
    catch(Exception e)
        {
        System.out.println("No Connection Established" + e);
        }
    }
 
}

