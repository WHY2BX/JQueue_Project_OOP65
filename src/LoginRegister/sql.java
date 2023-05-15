
package LoginRegister;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class sql {
    public static void main(String[] args) {
        Connection connect = null;
        Statement state = null;
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_login_register","root","Ff050647123");
            state = connect.createStatement();
            ResultSet rec = state.executeQuery("select * from user_information");
            while(rec.next()){
                System.out.println(rec.getString("ID_user"));
         
            }
 
        } 
        catch (ClassNotFoundException ex) {
            System.out.println("notfound");
        
        }       
        catch(Exception e){
            e.printStackTrace();
    }
}
}
