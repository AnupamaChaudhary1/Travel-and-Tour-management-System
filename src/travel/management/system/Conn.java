package travel.management.system;
import java.sql.*;

public class Conn {
    Connection c;
    Statement stmt;
    
    Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagementsystem","root","7potato#$*9");
            stmt=c.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    
    }
    
}
