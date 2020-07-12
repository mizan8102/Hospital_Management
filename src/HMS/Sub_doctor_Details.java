/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HMS;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Sub_doctor_Details {
     Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    Statement st=null;
void Myconnect(){

        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management","root","");
            st=con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    int autoid(){
        int a = 0;
        try {
            
            Myconnect();
            String m="SELECT `did` FROM `doctor_info` ORDER BY `did` ASC";
            rs=st.executeQuery(m);
            while(rs.next()){
                a=rs.getInt(1);
                
                
            }
            a++;
        } catch (SQLException ex) {
            Logger.getLogger(Add_Dep.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
}
