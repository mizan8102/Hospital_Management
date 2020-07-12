/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab_Info;

import HMS.Add_Dep;
import HMS.MyConnection;
import HMS.Sub_Bill;
import Pharmecy.Sub_Invoic;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mizanur Rahman
 */
public class Sub_test {
    Connection con=null;
  Statement st=null,st2=null;
    ResultSet rs=null,rs2=null;
void Myconnect(){

        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management","root","");
            st=con.createStatement();
            st2=con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
}
void selectedCombo(JComboBox jc)
    {
        try {
            jc.removeAllItems();
            Myconnect();
            String name="SELECT `name` FROM `test_exam`";
            jc.addItem("Select");
            rs=st.executeQuery(name);
            while(rs.next())
            {
                jc.addItem(rs.getString(1));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Sub_Invoic.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                
    }
     int autoid(){
        int a = 0;
        try {
            
            Myconnect();
            String m="SELECT `bid` FROM `test_bill` ORDER BY `bid` ASC";
            rs=st.executeQuery(m);
            while(rs.next()){
                a=rs.getInt(1);
                
                
            }
            a++;
        } catch (SQLException ex) {
            Logger.getLogger(Sub_Invoic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
     public void dataoperation(String m){
          try {
            Myconnect();
          
            int b=st.executeUpdate(m);
            if(b>0){
               //JOptionPane.showMessageDialog(new Add_Test(), " Succesfull!");
            }
            else{
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Add_Dep.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     void ShowDataInTable(String m,JTable table,JLabel jt){
         try {
             Myconnect();
             DefaultTableModel dt=(DefaultTableModel)table.getModel();
             dt.setRowCount(0);
             //
             rs=st.executeQuery(m);
             int i=0;
             double sq=0;
             while(rs.next()){
                 i++;
                 //int b=rs.getInt(3)*rs.getInt(4);
                 //String mm=setNameInTable();
                 dt.addRow(new Object[]{i,rs.getString(1),rs.getString(2)});
                 sq=sq+rs.getInt(2);
             }
             jt.setText(sq+"");
         } catch (SQLException ex) {
             Logger.getLogger(Sub_Invoic.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
    }
      String setNameInTable(String m){
       String mm=null;
        try {
           Myconnect();
            
            String name="SELECT `name` FROM `product_info` WHERE `id`='"+m+"'";
            rs2=st2.executeQuery(name);
            if(rs2.next())
            {
                mm=(rs2.getString(1));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Sub_Invoic.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return mm;
        
    }
       void SelectedTablevaluesetTable(String x,JComboBox jc){
        int p=0;
       int a=jc.getItemCount();
        for (int i = 0; i !=a; i++) {
            String m=jc.getItemAt(i).toString();
            if(m.contains(x))
            {
               p=i; 
                
            }
            
        }
        jc.setSelectedIndex(p);
       
        
        
    }
     void AddData(String m,JTable table){
        try { 
            DefaultTableModel dt=(DefaultTableModel)table.getModel();
        if(dt.getRowCount()>0){
            
             
                 Myconnect();
                 
                 int b=st.executeUpdate(m);
                 if(b>0){
                     //JOptionPane.showMessageDialog(new Bil_Detailsl(),"Bill Pritting Sucessful");
                 }
                 else{
                      JOptionPane.showMessageDialog(new Add_Test(),"Error!");
                 }
        }
        } catch (SQLException ex) {
                 Logger.getLogger(Sub_test.class.getName()).log(Level.SEVERE, null, ex);
             }
        
    }
    void printBill(final JPanel jPanel2){
        PrinterJob prJob=PrinterJob.getPrinterJob();
        prJob.setJobName("Bill Print");
        prJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if(pageIndex>0){
                    return Printable.NO_SUCH_PAGE;
                    
                    
                    
                }
                Graphics2D gp2d=(Graphics2D)graphics;
                gp2d.translate(pageFormat.getImageableX()*2,pageFormat.getImageableY()*2);
                gp2d.scale(0.8, 0.8);
                
                jPanel2.print(gp2d);
                
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           
            return Printable.PAGE_EXISTS;
            }
        });
        boolean pp=prJob.printDialog();
        if(pp){
            try {
                prJob.print();
            } catch (PrinterException ex) {
                Logger.getLogger(Sub_Bill.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
       //Bil_Detailsl bo=new Bil_Detailsl();
    }
}
