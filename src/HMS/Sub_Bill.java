
package HMS;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Sub_Bill {
    
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
    void findphar(JLabel label,String a){
           try {
               Myconnect();
               String m="SELECT `due` FROM `pharmecy_bill` WHERE `pid`='"+a+"'";
               rs=st.executeQuery(m);
               if(rs.next()){
                   label.setText(rs.getString(1));
               }
           } catch (SQLException ex) {
               Logger.getLogger(Sub_Bill.class.getName()).log(Level.SEVERE, null, ex);
           }
        
        
        
        
    }
   void findlab(JLabel label,String a){
           try {
               Myconnect();
               String m="SELECT `due` FROM `test_bill` WHERE `pid`='"+a+"'";
               rs2=st2.executeQuery(m);
               if(rs2.next()){
                   label.setText(rs2.getString(1));
               }
           } catch (SQLException ex) {
               Logger.getLogger(Sub_Bill.class.getName()).log(Level.SEVERE, null, ex);
           }
        
        
        
        
    }
   
    void dataoperation(String m){
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
    
    void ShowDataTable(JTable table,String bil,JLabel label){
        int a,b,c;
           try {
               
               DefaultTableModel dt=(DefaultTableModel)table.getModel();
               dt.setRowCount(0);
               Myconnect();
               String m="SELECT `particular`,`quant`,`price` FROM `part_record` WHERE `bil_id`='"+bil+"'";
               rs=st.executeQuery(m);
               int i=0;
               int st=0;
               while(rs.next()){
                   i++;
                    a=rs.getInt(2);
                    b=rs.getInt(3);
                    c=a*b;
                    st=st+c;
                   dt.addRow(new Object[]{i,rs.getString(1),rs.getString(2),rs.getString(3),c});
               }
               label.setText(""+st);
               
           } catch (SQLException ex) {
               Logger.getLogger(Sub_Bill.class.getName()).log(Level.SEVERE, null, ex);
           }
        
        
    }
     void SelectedTablevaluesetTable(String x,JComboBox combo){
        int p=0;
       int a=combo.getItemCount();
        for (int i = 0; i !=a; i++) {
            String m=combo.getItemAt(i).toString();
            if(m.contains(x))
            {
               p=i; 
                
            }
            
        }
        combo.setSelectedIndex(p);
       
        
        
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
                      JOptionPane.showMessageDialog(new Bil_Detailsl(),"Error!");
                 }
        }
        } catch (SQLException ex) {
                 Logger.getLogger(Sub_Bill.class.getName()).log(Level.SEVERE, null, ex);
             }
        
    }
    
    void UpPhar(String id){
        
           try {
               Myconnect();
               String m="UPDATE `pharmecy_bill` SET `due`=0 WHERE `pid`='"+id+"'";
               st.executeUpdate(m);
           } catch (SQLException ex) {
               Logger.getLogger(Sub_Bill.class.getName()).log(Level.SEVERE, null, ex);
           }
       
        
        
    }
     void Uplab(String id){
        
           try {
               Myconnect();
               String m="UPDATE `test_bill` SET `due`=0 WHERE `pid`='"+id+"'";
               st2.executeUpdate(m);
           } catch (SQLException ex) {
               Logger.getLogger(Sub_Bill.class.getName()).log(Level.SEVERE, null, ex);
           }
       
        
        
    }
}
