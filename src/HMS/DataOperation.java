
package HMS;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DataOperation {
    Connection con=null;
Statement st=null;

    public void Myconnect(){

        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management","root","");
            st=con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
}
   
    public void dataoperation(String m){
          try {
            Myconnect();
          
            int b=st.executeUpdate(m);
            if(b>0){
               
            }
            else{
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Add_Dep.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
