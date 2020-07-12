
package Lab_Info;

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
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Subpres {
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
void selectedCombo(JComboBox jc,String name)
    {
        try {
            jc.removeAllItems();
            Myconnect();
            //String name="SELECT `name` FROM `test_exam`";
            jc.addItem("Select");
            rs=st.executeQuery(name);
            while(rs.next())
            {
                jc.addItem(rs.getString(1)+" --"+rs.getString(2));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Sub_Invoic.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                
    }
void selectedCombo2(JComboBox jc,String name)
    {
        try {
            jc.removeAllItems();
            Myconnect();
            //String name="SELECT `name` FROM `test_exam`";
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
            String m="SELECT `presid` FROM `presid` ORDER BY `presid` ASC";
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

void patienDatashow(String m,JLabel j,JLabel jb,JLabel jbc){
           try {
               Myconnect();
              
               rs=st.executeQuery(m);
               if(rs.next()){
                   j.setText(rs.getString(1));
                   jb.setText(rs.getString(2));
                   jbc.setText(rs.getString(3));
               }
           } catch (SQLException ex) {
               Logger.getLogger(Subpres.class.getName()).log(Level.SEVERE, null, ex);
           }
    
}

void ShowDataInTable(String m,JTable table){
         try {
             Myconnect();
             DefaultTableModel dt=(DefaultTableModel)table.getModel();
             dt.setRowCount(0);
             //
             rs=st.executeQuery(m);
             int i=0;
             //double sq=0;
             while(rs.next()){
                 i++;
                 //int b=rs.getInt(3)*rs.getInt(4);
                 //String mm=setNameInTable();
                 dt.addRow(new Object[]{i,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
                // sq=sq+rs.getInt(2);
             }
             //jt.setText(sq+"");
         } catch (SQLException ex) {
             Logger.getLogger(Sub_Invoic.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
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
