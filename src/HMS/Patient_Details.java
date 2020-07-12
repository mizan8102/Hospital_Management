/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HMS;

import com.toedter.calendar.JCalendar;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mizanur Rahman
 */
public class Patient_Details extends javax.swing.JFrame {

    /**
     * Creates new form Patient_Details
     */
    public Patient_Details() {
        initComponents();
         String m="SELECT `Room_no` FROM `room`";
        roomNoset(m,txtbed);
        String n="SELECT `fname` FROM `refference`";
        roomNoset(n,txtref);
        String c="SELECT `fname` FROM `doctor_info`";
        roomNoset(c,txtdoc);
        txtpid.setText(""+autoid());
        String s="SELECT `pid`,`fname`,`sname`,`age`,`gender`,`merital`,`date`,`address`,`active`,`city`,`ptype`,`room`,`doctor`,`ref` FROM `patient_details`";
   tableShow(s);
    
    }

       Connection con=null;
Statement st=null;
PreparedStatement pst=null;
ResultSet rs=null,rs2=null;
    
    void roomNoset(String m,JComboBox jb){
        try {
            jb.removeAllItems();
            jb.addItem("Select");
            Myconnection1();
           
            rs=st.executeQuery(m);
            while(rs.next()){
                jb.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Patient_Details.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     String setNameInTable(String m){
       String mm=null;
        try {
            Myconnect();
            
            String name="SELECT `fname` FROM `doctor_info` WHERE `did`='"+m+"'";
            rs2=st.executeQuery(name);
            if(rs2.next())
            {
                mm=(rs2.getString(1));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Patient_Details.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return mm;
        
    }
     void Myconnection1(){

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
            String m="SELECT `pid`FROM `patient_details` ORDER BY `pid` ASC";
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
        
     
      void Myconnect(){

        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management","root","");
           
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

      }
      void SelectedTablevaluesetTable(String x,JComboBox j){
        int p=0;
       int a=j.getItemCount();
        for (int i = 0; i !=a; i++) {
          String m=j.getItemAt(i).toString();
            if(m.contains(x))
            {
               p=i; 
                
            }
            
        }
        j.setSelectedIndex(p);
       
        
        
    }
       void Show(){
        try {
            mc.Myconnect();
            String id=txtpid.getText().toString();
            String m=" SELECT *FROM `patient_details` WHERE `pid`=?";
            mc.pst=mc.con.prepareStatement(m);
            mc.pst.setString(1, id);
            mc.rs=mc.pst.executeQuery();
            if(mc.rs.next()){
                txtpname.setText(mc.rs.getString(2));
               txtpname2.setText(mc.rs.getString(3));
              SelectedTablevaluesetTable(mc.rs.getString(5),txtpgen );
               txtpage.setText(mc.rs.getString(4));
               txtcity.setText(mc.rs.getString(10));
               SelectedTablevaluesetTable(mc.rs.getString(6),txtmerit);
               txtaddr.setText(mc.rs.getString(8));
                SelectedTablevaluesetTable(mc.rs.getString(9),txtact);
                 SelectedTablevaluesetTable(mc.rs.getString(11),txttype);
                  SelectedTablevaluesetTable(mc.rs.getString(12),txtbed);
                  String mmn=setNameInTable(mc.rs.getString(13));
                   SelectedTablevaluesetTable(mmn,txtdoc);
                    SelectedTablevaluesetTable(mc.rs.getString(14),txtref);
              
               SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
           String mm=sd.format(mc.rs.getDate(7));
        ((JTextField)txtdate.getDateEditor().getUiComponent()).setText(mm);
        byte getimg[]=mc.rs.getBytes(15);
        ImageIcon im=new ImageIcon(new ImageIcon(getimg).getImage().getScaledInstance(picture.getWidth(),picture.getHeight(), Image.SCALE_SMOOTH));
        picture.setIcon(im);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Appointment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      void refadpatient(String m){
        try {
             int a=0;
            Myconnection1();
            String n="SELECT `patient` FROM `refference` WHERE `fname`='"+m+"'";
            rs=st.executeQuery(n);
            if(rs.next()){
                a=rs.getInt(1);
                a++;
            }
            String o="UPDATE `refference` SET `patient`='"+a+"' WHERE `fname`='"+m+"'";
            st.executeUpdate(o);
            
        } catch (SQLException ex) {
            Logger.getLogger(Patient_Details.class.getName()).log(Level.SEVERE, null, ex);
        }
          
      } 
      void addpatient(String m){
        try {
             
  
        
                
    
             int a=0;
            Myconnection1();
            String n="SELECT `patient` FROM `chart_patient` WHERE `cudate` LIKE  '%"+m+"%'";
            rs=st.executeQuery(n);
            if(rs.next()){
                a=rs.getInt(1);
                a++;
            }
            String o="UPDATE `chart_patient` SET `patient`='"+a+"'  WHERE `cudate` LIKE'%"+m+"%'";
            st.executeUpdate(o);
            
        } catch (SQLException ex) {
            Logger.getLogger(Patient_Details.class.getName()).log(Level.SEVERE, null, ex);
        }
          
      } 
       
       
      void add(){
          if(filepath!=null){
              
          
          String nameid="";
          String  t="";
          try {
            // TODO add your handling code here:
            mc.Myconnect();
            //Myconnect();
            String id=txtpid.getText().toString();
            String fname=txtpname.getText();
            String sname=txtpname2.getText().toString();
            String email=txtpage.getText().toString();
            String mobile=txtpgen.getSelectedItem().toString();
            String spec=txtmerit.getSelectedItem().toString();
            String add=txtaddr.getText().toString();
            String active=txtact.getSelectedItem().toString();
            String city=txtcity.getText().toString(); 
            String salary=txttype.getSelectedItem().toString();
            SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
            String mm=sd.format(txtdate.getDate());
            String room=txtbed.getSelectedItem().toString();
            if(room=="Select"){
                t="0";
                //JOptionPane.show
            }
            else{
                t=room;
            }
            //int doc=txtdoc.getSelectedIndex();
            String doc=txtdoc.getSelectedItem().toString();
           String h="SELECT `did` FROM `doctor_info` WHERE `fname`='"+doc+"'";
            rs=pst.executeQuery(h);
            if(rs.next()){
                nameid=rs.getString(1);
            }
            String ref=txtref.getSelectedItem().toString();
             InputStream is = new FileInputStream(filepath);
             //String m="INSERT INTO `doctor_info` VALUES ('"+id+"','"+fname+"','"+sname+"','"+email+"','"+mobile+"','"+spec+"','"+address+"','"+fess+"','"+sche+"','"+salary+"','"+mm+"','"+is+"')";
           String m="INSERT INTO `patient_details` VALUES (?,?,?,?,?,?,?,?,?,?,?,'"+t+"',?,?,?)";
            mc.pst=mc.con.prepareStatement(m);
            mc.pst.setString(1, id);
            mc.pst.setString(2, fname);
            mc.pst.setString(3, sname);
             mc.pst.setString(4, email);
              mc.pst.setString(5, mobile);
               mc.pst.setString(6, spec);
                mc.pst.setString(7, mm);
                 mc.pst.setString(8, add);
                  mc.pst.setString(9, active);
                   mc.pst.setString(10,city);
                   mc.pst.setString(11, salary);
                   //mc.pst.setString(12, room);
                   mc.pst.setString(12, nameid);
                   mc.pst.setString(13, ref);
                   mc.pst.setBlob(14, is);
                   int a=mc.pst.executeUpdate();
          //int a=st.executeUpdate(m);
                   if(a>0){
                      
                       JOptionPane.showMessageDialog(this, "Added Succesfull!");
                       refadpatient(ref);
                        //JCalendar d=new JCalendar();
         SimpleDateFormat sid=new SimpleDateFormat("yyyy-MM");
            String g=sid.format(txtdate.getDate());
                       addpatient(g);
                        Cl_panel();
                        
                   }
                   else{
                       JOptionPane.showMessageDialog(this, "not Added!");
                   }
                   
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Appointment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Appointment.class.getName()).log(Level.SEVERE, null, ex);
        } 
          catch(NullPointerException nr){
              JOptionPane.showMessageDialog(this, "Please!fill up form!");
          }
          }
          else{
              
              
              
          String nameid="";
          String  t="";
          try {
            // TODO add your handling code here:
            mc.Myconnect();
            //Myconnect();
            String id=txtpid.getText().toString();
            String fname=txtpname.getText();
            String sname=txtpname2.getText().toString();
            String email=txtpage.getText().toString();
            String mobile=txtpgen.getSelectedItem().toString();
            String spec=txtmerit.getSelectedItem().toString();
            String add=txtaddr.getText().toString();
            String active=txtact.getSelectedItem().toString();
            String city=txtcity.getText().toString(); 
            String salary=txttype.getSelectedItem().toString();
            SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
            String mm=sd.format(txtdate.getDate());
            String room=txtbed.getSelectedItem().toString();
            if(room=="Select"){
                t="0";
                //JOptionPane.show
            }
            else{
                t=room;
            }
            //int doc=txtdoc.getSelectedIndex();
            String doc=txtdoc.getSelectedItem().toString();
           String h="SELECT `did` FROM `doctor_info` WHERE `fname`='"+doc+"'";
            rs=pst.executeQuery(h);
            if(rs.next()){
                nameid=rs.getString(1);
            }
            String ref=txtref.getSelectedItem().toString();
             //InputStream is = new FileInputStream(filepath);
             //String m="INSERT INTO `doctor_info` VALUES ('"+id+"','"+fname+"','"+sname+"','"+email+"','"+mobile+"','"+spec+"','"+address+"','"+fess+"','"+sche+"','"+salary+"','"+mm+"','"+is+"')";
           String m="INSERT INTO `patient_details`(`pid`,`fname`,`sname`,`age`,`gender`,`merital`,`date`,`address`,`active`,`city`,`ptype`,`room`,`doctor`,`ref`) VALUES (?,?,?,?,?,?,?,?,?,?,?,'"+t+"',?,?)";
            mc.pst=mc.con.prepareStatement(m);
            mc.pst.setString(1, id);
            mc.pst.setString(2, fname);
            mc.pst.setString(3, sname);
             mc.pst.setString(4, email);
              mc.pst.setString(5, mobile);
               mc.pst.setString(6, spec);
                mc.pst.setString(7, mm);
                 mc.pst.setString(8, add);
                  mc.pst.setString(9, active);
                   mc.pst.setString(10,city);
                   mc.pst.setString(11, salary);
                   //mc.pst.setString(12, room);
                   mc.pst.setString(12, nameid);
                   mc.pst.setString(13, ref);
                   //mc.pst.setBlob(14, is);
                   int a=mc.pst.executeUpdate();
          //int a=st.executeUpdate(m);
                   if(a>0){
                      
                       JOptionPane.showMessageDialog(this, "Added Succesfull!");
                       refadpatient(ref);
                        //JCalendar d=new JCalendar();
         SimpleDateFormat sid=new SimpleDateFormat("yyyy-MM");
            String g=sid.format(txtdate.getDate());
                       addpatient(g);
                        Cl_panel();
                        
                   }
                   else{
                       JOptionPane.showMessageDialog(this, "not Added!");
                   }
                   
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Appointment.class.getName()).log(Level.SEVERE, null, ex);
        } 
          catch(NullPointerException nr){
              JOptionPane.showMessageDialog(this, "Please!fill up form!");
          }
          }
        
     }
     MyConnection mc=new MyConnection();
     void Cl_panel(){
          txtpid.setText(""+autoid());
          txtpname.setText("");
          txtpname2.setText("");
          txtpage.setText("");
          txtpgen.setSelectedIndex(0);
          txtmerit.setSelectedIndex(0);
          txtaddr.setText("");
          txtact.setSelectedIndex(0);
          txtcity.setText("");
          txtdoc.setSelectedIndex(0);
          txtref.setSelectedIndex(0);
          txtbed.setSelectedIndex(0);
          txttype.setSelectedIndex(0);
          picture.setIcon(null);
          filepath=null;
          
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtpname = new javax.swing.JTextField();
        txtpname2 = new javax.swing.JTextField();
        txtpage = new javax.swing.JTextField();
        txtcity = new javax.swing.JTextField();
        txtaddr = new javax.swing.JTextField();
        txtpid = new javax.swing.JTextField();
        txtpgen = new javax.swing.JComboBox();
        txttype = new javax.swing.JComboBox();
        txtbed = new javax.swing.JComboBox();
        txtref = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtdoc = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        txtmerit = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        txtact = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        picture = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtdate = new com.toedter.calendar.JDateChooser();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jDesktopPane4 = new javax.swing.JDesktopPane();
        picture3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel54 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(40, 162, 197));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setToolTipText("Please select ");
        jTabbedPane1.setOpaque(true);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Myanmar Text", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("Room NO:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(640, 380, 90, 50);

        jLabel3.setFont(new java.awt.Font("Myanmar Text", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 51));
        jLabel3.setText("Second Name:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(190, 294, 160, 40);

        jLabel4.setFont(new java.awt.Font("Myanmar Text", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 51));
        jLabel4.setText("Age:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(190, 340, 140, 40);

        jLabel5.setFont(new java.awt.Font("Myanmar Text", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 51));
        jLabel5.setText("Gender");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(190, 394, 150, 40);

        jLabel6.setFont(new java.awt.Font("Myanmar Text", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 51));
        jLabel6.setText("Refference:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(640, 490, 110, 40);

        jLabel7.setFont(new java.awt.Font("Myanmar Text", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 51));
        jLabel7.setText("Date:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(190, 514, 130, 40);

        jLabel8.setFont(new java.awt.Font("Myanmar Text", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 51));
        jLabel8.setText("Address:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(190, 564, 120, 40);

        jLabel9.setFont(new java.awt.Font("Myanmar Text", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 51));
        jLabel9.setText("City:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(630, 240, 110, 40);

        jLabel10.setFont(new java.awt.Font("Myanmar Text", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 51));
        jLabel10.setText("Patient Type:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(630, 280, 120, 40);

        jLabel11.setFont(new java.awt.Font("Myanmar Text", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 51));
        jLabel11.setText("(For Indoor Patient Only)");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(640, 330, 250, 30);

        jLabel12.setFont(new java.awt.Font("Myanmar Text", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 51));
        jLabel12.setText("Patient Id:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(190, 170, 120, 40);

        jLabel15.setFont(new java.awt.Font("Myanmar Text", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 51));
        jLabel15.setText("First Name:");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(190, 234, 160, 40);

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(190, 212, 1180, 10);

        txtpname.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtpname.setForeground(new java.awt.Color(51, 0, 51));
        jPanel1.add(txtpname);
        txtpname.setBounds(330, 230, 230, 40);

        txtpname2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtpname2.setForeground(new java.awt.Color(51, 0, 51));
        jPanel1.add(txtpname2);
        txtpname2.setBounds(330, 290, 230, 40);

        txtpage.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtpage.setForeground(new java.awt.Color(51, 0, 51));
        jPanel1.add(txtpage);
        txtpage.setBounds(330, 340, 230, 40);

        txtcity.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtcity.setForeground(new java.awt.Color(51, 0, 51));
        jPanel1.add(txtcity);
        txtcity.setBounds(750, 230, 230, 40);

        txtaddr.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtaddr.setForeground(new java.awt.Color(51, 0, 51));
        jPanel1.add(txtaddr);
        txtaddr.setBounds(330, 560, 230, 40);

        txtpid.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtpid.setForeground(new java.awt.Color(51, 0, 51));
        txtpid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtpidMouseClicked(evt);
            }
        });
        jPanel1.add(txtpid);
        txtpid.setBounds(330, 160, 230, 40);

        txtpgen.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtpgen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Male", "Female", "Others" }));
        txtpgen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpgenActionPerformed(evt);
            }
        });
        jPanel1.add(txtpgen);
        txtpgen.setBounds(330, 390, 230, 40);

        txttype.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txttype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Indoor", "Outdoor" }));
        jPanel1.add(txttype);
        txttype.setBounds(750, 280, 230, 40);

        txtbed.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(txtbed);
        txtbed.setBounds(750, 380, 230, 40);

        txtref.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtref.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Merit", "Unmerit" }));
        jPanel1.add(txtref);
        txtref.setBounds(750, 490, 230, 40);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ADD PATIENT");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(750, 160, 150, 40);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HMS/picture/icons8_logout_rounded_up_30px_2.png"))); // NOI18N
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel16);
        jLabel16.setBounds(1310, 70, 30, 30);

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Log out");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(1300, 90, 50, 30);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HMS/picture/icons8_home_30px.png"))); // NOI18N
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel18);
        jLabel18.setBounds(1250, 60, 30, 40);

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("HOME");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(1240, 94, 50, 20);

        txtdoc.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtdoc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Merit", "Unmerit" }));
        jPanel1.add(txtdoc);
        txtdoc.setBounds(750, 440, 230, 40);

        jLabel23.setFont(new java.awt.Font("Myanmar Text", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 51));
        jLabel23.setText("Doctor Name:");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(640, 440, 120, 40);

        txtmerit.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtmerit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Merit", "Unmerit" }));
        jPanel1.add(txtmerit);
        txtmerit.setBounds(330, 450, 230, 40);

        jLabel24.setFont(new java.awt.Font("Myanmar Text", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 51));
        jLabel24.setText("Merital Status:");
        jPanel1.add(jLabel24);
        jLabel24.setBounds(190, 454, 130, 40);

        txtact.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtact.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Yes", "No" }));
        jPanel1.add(txtact);
        txtact.setBounds(330, 610, 230, 40);

        jLabel25.setFont(new java.awt.Font("Myanmar Text", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 51));
        jLabel25.setText("Active Status:");
        jPanel1.add(jLabel25);
        jLabel25.setBounds(190, 610, 130, 40);

        jDesktopPane1.setLayer(picture, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picture, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picture, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jDesktopPane1);
        jDesktopPane1.setBounds(1110, 260, 210, 210);

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Select Picture");
        jButton2.setToolTipText("Select");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(1170, 490, 120, 30);
        jPanel1.add(txtdate);
        txtdate.setBounds(330, 510, 230, 40);

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("DELETE PATIENT");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(1090, 160, 160, 40);

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("UPDATE PATIENT");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(920, 160, 160, 40);

        jButton9.setBackground(new java.awt.Color(0, 0, 0));
        jButton9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Clear");
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9);
        jButton9.setBounds(1260, 160, 100, 40);

        jButton10.setBackground(new java.awt.Color(0, 0, 0));
        jButton10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Search");
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10);
        jButton10.setBounds(560, 160, 100, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HMS/picture/Add_patient.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1370, 730);

        jTabbedPane1.addTab("Add Patients", jPanel1);

        jPanel2.setLayout(null);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HMS/picture/icons8_search_30px_1.png"))); // NOI18N
        jLabel13.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel2.add(jLabel13);
        jLabel13.setBounds(580, 160, 40, 40);

        txtsearch.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtsearch.setForeground(new java.awt.Color(51, 0, 51));
        txtsearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtsearchMouseClicked(evt);
            }
        });
        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsearchKeyPressed(evt);
            }
        });
        jPanel2.add(txtsearch);
        txtsearch.setBounds(620, 160, 320, 40);

        jButton8.setBackground(new java.awt.Color(0, 0, 0));
        jButton8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HMS/picture/DepartmentPicture/icons8_refresh_25px.png"))); // NOI18N
        jButton8.setText("Refresh");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8);
        jButton8.setBounds(1210, 153, 120, 30);

        jLabel48.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel48MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel48);
        jLabel48.setBounds(1180, 60, 40, 50);

        jLabel53.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel53MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel53);
        jLabel53.setBounds(1260, 60, 40, 50);

        jDesktopPane4.setLayer(picture3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane4Layout = new javax.swing.GroupLayout(jDesktopPane4);
        jDesktopPane4.setLayout(jDesktopPane4Layout);
        jDesktopPane4Layout.setHorizontalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picture3, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane4Layout.setVerticalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picture3, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jDesktopPane4);
        jDesktopPane4.setBounds(240, 130, 160, 140);

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient ID", "Name", "Secondd Name", "Age", "Gender", "Merital", "Date", "Address", "Active", "City", "Patient Type", "Room NO", "Doctor name", "Refference"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setGridColor(new java.awt.Color(102, 153, 255));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 280, 1340, 360);

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HMS/picture/view_patient.jpg"))); // NOI18N
        jPanel2.add(jLabel54);
        jLabel54.setBounds(0, 0, 1370, 730);

        jTabbedPane1.addTab("View All Patients", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        setBounds(0, 0, 1386, 774);
    }// </editor-fold>//GEN-END:initComponents

    private void txtpgenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpgenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpgenActionPerformed

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
        new HeadLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        // TODO add your handling code here:
        
        this.dispose();
    }//GEN-LAST:event_jLabel18MouseClicked
    
    String filepath;
    Patient_Details2 pd2=new Patient_Details2();
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JFileChooser jf=new JFileChooser();
        jf.showOpenDialog(null);
        File f=jf.getSelectedFile();
        filepath=f.getAbsolutePath();
        pd2.setImagetoLabel(filepath, picture);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed

    private void jLabel48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel48MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel48MouseClicked

    private void jLabel53MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel53MouseClicked
        // TODO add your handling code here:
         new HeadLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel53MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        add();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        Cl_panel();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        Show();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void txtpidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtpidMouseClicked
        // TODO add your handling code here:
txtpid.setText("");
    }//GEN-LAST:event_txtpidMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try{
         mc.Myconnect();
            String id=txtpid.getText().toString();
            String m="DELETE FROM `patient_details` WHERE `pid`=?";
            mc.pst=mc.con.prepareStatement(m);
            mc.pst.setString(1, id);
             int a=mc.pst.executeUpdate();
          //int a=st.executeUpdate(m);
                   if(a>0){
                      
                       JOptionPane.showMessageDialog(this, "Delete Succesfull!");
                        Cl_panel();
                   }
                   else{
                       JOptionPane.showMessageDialog(this, "not Delete!");
                   }
        } catch (SQLException ex) {
            Logger.getLogger(Appointment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String nameid="";
        if(filepath==null){
            //JOptionPane.showMessageDialog(this, filepath);
            try{
             Myconnect();
            String id=txtpid.getText().toString();
            String fname=txtpname.getText();
            String sname=txtpname2.getText().toString();
            String email=txtpage.getText().toString();
            String mobile=txtpgen.getSelectedItem().toString();
            String spec=txtmerit.getSelectedItem().toString();
            String add=txtaddr.getText().toString();
            String active=txtact.getSelectedItem().toString();
            String city=txtcity.getText().toString(); 
            String salary=txttype.getSelectedItem().toString();
           
            String room=txtbed.getSelectedItem().toString();
           String doc=txtdoc.getSelectedItem().toString();
           String h="SELECT `did` FROM `doctor_info` WHERE `fname`='"+doc+"'";
            rs=pst.executeQuery(h);
            if(rs.next()){
                nameid=rs.getString(1);
            }
            String ref=txtref.getSelectedItem().toString();
             
            String m="UPDATE `patient_details` SET `fname`='"+fname+"',`sname`='"+sname+"',`age`='"+email+"',`gender`='"+mobile+"',`merital`='"+spec+"',`address`='"+add+"',`active`='"+active+"',`city`='"+city+"',`ptype`='"+salary+"',`room`='"+room+"',`doctor`='"+nameid+"',`ref`='"+ref+"' WHERE `pid`='"+id+"'";
           pst=con.prepareStatement(m);
           
           int a=pst.executeUpdate();
           if(a>0){
              JOptionPane.showMessageDialog(this, "Update successfull!");
              Cl_panel();
           }
           else{
               JOptionPane.showMessageDialog(this, "Not Update!");
           }
           
           
        } catch (SQLException ex) {
            Logger.getLogger(Appointment.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch(NullPointerException nr){
            JOptionPane.showMessageDialog(this, "Please!Fill this form!");
        }
            
            
        }
        else{
        try{
            // TODO add your handling code here:
            //UpdateOperation();
            //Cl_panel()
            Myconnect();
            String id=txtpid.getText().toString();
            String fname=txtpname.getText();
            String sname=txtpname2.getText().toString();
            String email=txtpage.getText().toString();
            String mobile=txtpgen.getSelectedItem().toString();
            String spec=txtmerit.getSelectedItem().toString();
            String add=txtaddr.getText().toString();
            String active=txtact.getSelectedItem().toString();
            String city=txtcity.getText().toString(); 
            String salary=txttype.getSelectedItem().toString();
           
            String room=txtbed.getSelectedItem().toString();
            String doc=txtdoc.getSelectedItem().toString();
            
           String h="SELECT `did` FROM `doctor_info` WHERE `fname`='"+doc+"'";
            rs=pst.executeQuery(h);
            if(rs.next()){
                nameid=rs.getString(1);
            }
            String ref=txtref.getSelectedItem().toString();
             InputStream is = new FileInputStream(filepath);
            String m="UPDATE `patient_details` SET `fname`='"+fname+"',`sname`='"+sname+"',`age`='"+email+"',`gender`='"+mobile+"',`merital`='"+spec+"',`address`='"+add+"',`active`='"+active+"',`city`='"+city+"',`ptype`='"+salary+"',`room`='"+room+"',`doctor`='"+nameid+"',`ref`='"+ref+"',`pic`=? WHERE `pid`='"+id+"'";
           pst=con.prepareStatement(m);
           pst.setBlob(1, is);
           int a=pst.executeUpdate();
           if(a>0){
              JOptionPane.showMessageDialog(this, "Update successfull!");
              Cl_panel();
           }
           else{
               JOptionPane.showMessageDialog(this, "Not Update!");
           }
           
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Appointment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Appointment.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch(NullPointerException nr){
            JOptionPane.showMessageDialog(this, "Please!Fill this form!");
        }
            
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    void tableShow(String m){
        try {
            Myconnect();
            DefaultTableModel dt=(DefaultTableModel)jTable1.getModel();
            dt.setRowCount(0);
            pst=con.prepareStatement(m);
            rs=pst.executeQuery();
            while(rs.next()){
                
                dt.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14)});
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Appointment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void txtsearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtsearchMouseClicked
        // TODO add your handling code here:
        
     
    }//GEN-LAST:event_txtsearchMouseClicked

    private void txtsearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyPressed
        // TODO add your handling code here:
        
        
            try{
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                Myconnection1();
            DefaultTableModel dt=(DefaultTableModel)jTable1.getModel();
            dt.setRowCount(0);
            String n=txtsearch.getText().toString();
           String m="SELECT `pid`,`fname`,`sname`,`age`,`gender`,`merital`,`date`,`address`,`active`,`city`,`ptype`,`room`,`doctor`,`ref`,`pic` FROM `patient_details` where `pid`='"+n+"'";
        
            
          rs=st.executeQuery(m);
           if(rs.next()){
                
                dt.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14)});
                byte getImg[]=rs.getBytes(15);
                 ImageIcon im=new ImageIcon(new ImageIcon(getImg).getImage().getScaledInstance(picture3.getWidth(),picture3.getHeight(), Image.SCALE_SMOOTH));
              picture3.setIcon(im);
                
            }
        }
        } catch (SQLException ex) {
            Logger.getLogger(Appointment.class.getName()).log(Level.SEVERE, null, ex);
        }
            catch(NullPointerException eh){
                System.out.print(eh);
            }
        
    }//GEN-LAST:event_txtsearchKeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
          try {
            // TODO add your handling code here:
            mc.Myconnect();
            DefaultTableModel dt=(DefaultTableModel)jTable1.getModel();
            String a=(dt.getValueAt(jTable1.getSelectedRow(),0).toString());
            String m="SELECT `pic` FROM `patient_details` WHERE `pid`=?";
            
            mc.pst=mc.con.prepareStatement(m);
            mc.pst.setString(1, a);
            mc.rs=mc.pst.executeQuery();
            if(mc.rs.next()){
                
                byte getimg[]=mc.rs.getBytes(1);
                ImageIcon im=new ImageIcon(new ImageIcon(getimg).getImage().getScaledInstance(picture3.getWidth(),picture3.getHeight(), Image.SCALE_SMOOTH));
              picture3.setIcon(im);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Appointment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
         String s="SELECT `pid`,`fname`,`sname`,`age`,`gender`,`merital`,`date`,`address`,`active`,`city`,`ptype`,`room`,`doctor`,`ref` FROM `patient_details`";
   tableShow(s);
   picture3.setIcon(null);
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Patient_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Patient_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Patient_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Patient_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Patient_Details().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel picture;
    private javax.swing.JLabel picture3;
    private javax.swing.JComboBox txtact;
    private javax.swing.JTextField txtaddr;
    private javax.swing.JComboBox txtbed;
    private javax.swing.JTextField txtcity;
    private com.toedter.calendar.JDateChooser txtdate;
    private javax.swing.JComboBox txtdoc;
    private javax.swing.JComboBox txtmerit;
    private javax.swing.JTextField txtpage;
    private javax.swing.JComboBox txtpgen;
    private javax.swing.JTextField txtpid;
    private javax.swing.JTextField txtpname;
    private javax.swing.JTextField txtpname2;
    private javax.swing.JComboBox txtref;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JComboBox txttype;
    // End of variables declaration//GEN-END:variables
}
