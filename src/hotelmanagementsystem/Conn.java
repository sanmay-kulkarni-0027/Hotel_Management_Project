package hotelmanagementsystem;
import java.sql.*;
public class Conn {
     Connection c;
     Statement s;
     Conn()
     {
         try{
            
             
             Class.forName("com.mysql.jdbc.Driver");
             c=DriverManager.getConnection("jdbc:mysql://localhost:3306/HotelManagementSystem", "root", "Sanmay@2002");
             s=c.createStatement();
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
         
     }
   
    
}
