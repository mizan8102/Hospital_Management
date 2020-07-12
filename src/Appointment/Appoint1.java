package Appointment;

import HMS.MyConnection;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Appoint1 {
  
       Connection con=null;
    PreparedStatement st=null;
ResultSet rs=null;

    void Myconnect(){

        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management","root","");
           
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
}  
  void DoctorIncombo(JComboBox combo) {
           try {
               combo.removeAllItems();
               combo.addItem("Select");
               Myconnect();
               String m="SELECT `fname` FROM `doctor_info`";
               st=con.prepareStatement(m);
              rs=st.executeQuery();
              while(rs.next()){
                  combo.addItem(rs.getString(1));
                  
              }
              
           } catch (SQLException ex) {
               Logger.getLogger(Appoint1.class.getName()).log(Level.SEVERE, null, ex);
           }
      } 
  
    void NameSet1(String a,JLabel label,JLabel label1,JLabel label2){
           try {
               String m="SELECT `fname`,`specialist`,`fess` FROM `doctor_info` WHERE `fname`=?";
               st=con.prepareStatement(m);
               st.setString(1, a);
               rs=st.executeQuery();
               while(rs.next()){
                   label.setText(rs.getString(1));
                   label1.setText(rs.getString(2));
                   label2.setText(rs.getString(3));
               }
           } catch (SQLException ex) {
               Logger.getLogger(Appoint1.class.getName()).log(Level.SEVERE, null, ex);
           }
    
    }
    void NameSet2(String a,JLabel label,JLabel label1,JLabel label2){
           try {
               String m="SELECT `fname`,`specialist`,`folow_fees` FROM `doctor_info` WHERE `fname`=?";
               st=con.prepareStatement(m);
               st.setString(1, a);
               rs=st.executeQuery();
               while(rs.next()){
                   label.setText(rs.getString(1));
                   label1.setText(rs.getString(2));
                   label2.setText(rs.getString(3));
               }
           } catch (SQLException ex) {
               Logger.getLogger(Appoint1.class.getName()).log(Level.SEVERE, null, ex);
           }
    
    }
    
    void patientData(String a,JLabel label1,JLabel label2,JLabel label3){
           try {
               String m="SELECT `fname`,`age`,`gender` FROM `patient_details` WHERE `pid`=?";
               st=con.prepareStatement(m);
               st.setString(1, a);
               rs=st.executeQuery();
               while(rs.next()){
                   label1.setText(rs.getString(1));
                   label2.setText(rs.getString(2));
                   label3.setText(rs.getString(3));
               }
           } catch (SQLException ex) {
               Logger.getLogger(Appoint1.class.getName()).log(Level.SEVERE, null, ex);
           }
        
    }
    void LocalTime(JTextField label1,JLabel label2){
        String m="";
        Calendar cal=new GregorianCalendar();
        int second=cal.get(Calendar.SECOND);
        int minute=cal.get(Calendar.MINUTE);
        int hour=cal.get(Calendar.HOUR);
        int am=cal.get(Calendar.AM_PM);
        if(am==1){
            m=" pm";
        }else{
            m=" am";
        }
        label1.setText(hour+":"+minute+":"+second+""+m);
        label2.setText(hour+":"+minute+":"+second+""+m);
    }
    
}
