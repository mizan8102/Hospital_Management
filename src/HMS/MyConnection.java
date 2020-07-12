package HMS;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MyConnection {
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
void Myconnect(){

        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management","root","");
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
