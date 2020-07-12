package Appointment;

import com.toedter.calendar.JCalendar;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Mizanur Rahman
 */
public class Appoint extends javax.swing.JFrame {
    public Appoint() {
        initComponents();
        ap.DoctorIncombo(jComboBox2);
         cuDate();
         ap.LocalTime(jTextField1, jLabel18);
    }
Appoint1  ap=new Appoint1 ();
 void cuDate(){
         JCalendar d=new JCalendar();
         SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
            String mm=sd.format(d.getDate());
       jLabel20.setText(mm);
       jTextField5.setText(mm);
        
    }
 
     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txtapp = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtpname = new javax.swing.JLabel();
        txtpage = new javax.swing.JLabel();
        txtpgen = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtdname = new javax.swing.JLabel();
        txtddesi = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        txtfees = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        txtother = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1370, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1370, 40);

        jPanel2.setBackground(new java.awt.Color(0, 19, 44));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add Patients");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusable(false);
        jButton1.setOpaque(false);
        jPanel2.add(jButton1);
        jButton1.setBounds(60, 0, 120, 30);

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("View Appointment");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusable(false);
        jButton2.setOpaque(false);
        jPanel2.add(jButton2);
        jButton2.setBounds(180, 0, 160, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 40, 1370, 30);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(50, 122, 182), 2, true));
        jPanel5.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(49, 122, 182));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("New Appointment (OPD-Output Patients Department)");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel6);
        jPanel6.setBounds(2, 2, 560, 50);

        jLabel2.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        jLabel2.setText("Booking Date:");
        jPanel5.add(jLabel2);
        jLabel2.setBounds(60, 200, 120, 30);

        jTextField1.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        jPanel5.add(jTextField1);
        jTextField1.setBounds(180, 250, 330, 30);

        jLabel3.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        jLabel3.setText("Booking Time:");
        jPanel5.add(jLabel3);
        jLabel3.setBounds(60, 250, 90, 30);

        jLabel4.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        jLabel4.setText("Appointment Day:");
        jPanel5.add(jLabel4);
        jLabel4.setBounds(60, 300, 120, 30);

        jLabel5.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        jLabel5.setText("Appointment Time:");
        jPanel5.add(jLabel5);
        jLabel5.setBounds(60, 400, 120, 30);

        jTextField2.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        jPanel5.add(jTextField2);
        jTextField2.setBounds(180, 300, 330, 30);

        jTextField3.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        jPanel5.add(jTextField3);
        jTextField3.setBounds(180, 350, 330, 30);

        jTextField4.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        jPanel5.add(jTextField4);
        jTextField4.setBounds(180, 400, 330, 30);

        jTextField5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel5.add(jTextField5);
        jTextField5.setBounds(180, 200, 330, 30);

        jLabel7.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        jLabel7.setText("Appointment Date:");
        jPanel5.add(jLabel7);
        jLabel7.setBounds(60, 350, 120, 30);

        jComboBox2.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Consultation", "Following" }));
        jComboBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel5.add(jComboBox2);
        jComboBox2.setBounds(180, 110, 180, 30);

        jLabel8.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        jLabel8.setText("Doctor Name:");
        jPanel5.add(jLabel8);
        jLabel8.setBounds(60, 110, 120, 30);

        txtapp.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        txtapp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "New Patient", "Following Patient" }));
        txtapp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(txtapp);
        txtapp.setBounds(180, 70, 180, 30);

        jLabel9.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        jLabel9.setText("Appointment Type:");
        jPanel5.add(jLabel9);
        jLabel9.setBounds(60, 70, 120, 30);

        jLabel6.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        jLabel6.setText("Patient ID:");
        jPanel5.add(jLabel6);
        jLabel6.setBounds(60, 150, 120, 30);

        jTextField6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField6KeyPressed(evt);
            }
        });
        jPanel5.add(jTextField6);
        jTextField6.setBounds(180, 150, 330, 30);

        jLabel38.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        jLabel38.setText("Any Others Fees:");
        jPanel5.add(jLabel38);
        jLabel38.setBounds(60, 450, 120, 30);

        jTextField7.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        jPanel5.add(jTextField7);
        jTextField7.setBounds(180, 450, 330, 30);

        jPanel3.add(jPanel5);
        jPanel5.setBounds(60, 30, 560, 490);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(49, 122, 182), 2, true));
        jPanel7.setLayout(null);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Appointment/appoint.png"))); // NOI18N
        jPanel7.add(jLabel10);
        jLabel10.setBounds(60, 10, 90, 60);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(49, 122, 182));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Mobile:01645316379,E-mail:mizan81025@gmail.com");
        jPanel7.add(jLabel11);
        jLabel11.setBounds(0, 110, 230, 30);

        jLabel12.setForeground(new java.awt.Color(255, 153, 0));
        jLabel12.setText("------------------------------------------------------------------------------------------------------------------------------------------------");
        jPanel7.add(jLabel12);
        jLabel12.setBounds(0, 310, 590, 14);

        jLabel13.setFont(new java.awt.Font("Algerian", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(49, 122, 182));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Hope Hospital Pvt.Ltd");
        jPanel7.add(jLabel13);
        jLabel13.setBounds(0, 70, 230, 30);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(49, 122, 182));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Bangodda Bazar,Nangolkot,comilla");
        jPanel7.add(jLabel14);
        jLabel14.setBounds(0, 90, 230, 30);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel15.setText("Invoice Time:");
        jPanel7.add(jLabel15);
        jLabel15.setBounds(410, 30, 100, 20);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel16.setText("Invoice Number:");
        jPanel7.add(jLabel16);
        jLabel16.setBounds(400, 50, 90, 20);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel17.setText("Invoice Date:");
        jPanel7.add(jLabel17);
        jLabel17.setBounds(410, 10, 80, 20);

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel7.add(jLabel18);
        jLabel18.setBounds(490, 30, 70, 20);

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel7.add(jLabel19);
        jLabel19.setBounds(490, 50, 80, 20);

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPanel7.add(jLabel20);
        jLabel20.setBounds(490, 10, 70, 20);

        jLabel21.setForeground(new java.awt.Color(255, 153, 0));
        jLabel21.setText("------------------------------------------------------------------------------------------------------------------------------------------------");
        jPanel7.add(jLabel21);
        jLabel21.setBounds(0, 130, 590, 14);

        txtpname.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtpname.setText("Patients Details");
        jPanel7.add(txtpname);
        txtpname.setBounds(20, 160, 160, 30);

        txtpage.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        txtpage.setText("Age:");
        jPanel7.add(txtpage);
        txtpage.setBounds(50, 190, 30, 13);

        txtpgen.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        txtpgen.setText("Gender:");
        jPanel7.add(txtpgen);
        txtpgen.setBounds(60, 210, 40, 13);

        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel25.setText("Patients Details");
        jPanel7.add(jLabel25);
        jLabel25.setBounds(20, 140, 80, 13);

        jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel26.setText("Doctor Details");
        jPanel7.add(jLabel26);
        jLabel26.setBounds(250, 140, 80, 13);

        txtdname.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtdname.setText("Patients Details");
        jPanel7.add(txtdname);
        txtdname.setBounds(250, 160, 160, 30);

        txtddesi.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jPanel7.add(txtddesi);
        txtddesi.setBounds(250, 180, 100, 30);

        jLabel29.setForeground(new java.awt.Color(255, 153, 0));
        jLabel29.setText("------------------------------------------------------------------------------------------------------------------------------------------------");
        jPanel7.add(jLabel29);
        jLabel29.setBounds(0, 230, 590, 14);

        jLabel30.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel30.setText("Appointment Time:");
        jPanel7.add(jLabel30);
        jLabel30.setBounds(20, 290, 110, 14);

        jLabel31.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel31.setText("(Appointment Details)");
        jPanel7.add(jLabel31);
        jLabel31.setBounds(250, 240, 130, 13);

        jLabel32.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel32.setText("Appointment Date:");
        jPanel7.add(jLabel32);
        jLabel32.setBounds(20, 260, 110, 14);

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Appointment/png-clipart-barcode-universal-product-code-2d-code-qr-code-others-angle-label.jpg"))); // NOI18N
        jPanel7.add(jLabel33);
        jLabel33.setBounds(450, 160, 90, 30);

        jLabel34.setText("A3474893473");
        jPanel7.add(jLabel34);
        jLabel34.setBounds(450, 190, 80, 14);

        jLabel35.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel35.setText("Appointment Date:");
        jPanel7.add(jLabel35);
        jLabel35.setBounds(130, 260, 110, 14);

        jLabel36.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel36.setText("Appointment Time:");
        jPanel7.add(jLabel36);
        jLabel36.setBounds(130, 290, 110, 14);

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Consultation Invoice");
        jLabel37.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel7.add(jLabel37);
        jLabel37.setBounds(230, 320, 180, 30);

        jLabel39.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel39.setText("Any Others Fee");
        jPanel7.add(jLabel39);
        jLabel39.setBounds(70, 420, 160, 20);

        jLabel40.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel40.setText("Doctor Consultation Fee");
        jPanel7.add(jLabel40);
        jLabel40.setBounds(70, 390, 160, 20);

        jLabel41.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel41.setText("--------------------------------------");
        jPanel7.add(jLabel41);
        jLabel41.setBounds(200, 390, 160, 20);

        jLabel42.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel42.setText("-----------------------------------------------------");
        jPanel7.add(jLabel42);
        jLabel42.setBounds(340, 460, 220, 20);

        jLabel43.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel43.setText("--------------------------------------");
        jPanel7.add(jLabel43);
        jLabel43.setBounds(200, 420, 160, 20);

        jLabel44.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel44.setText("jLabel44");
        jPanel7.add(jLabel44);
        jLabel44.setBounds(360, 470, 60, 30);

        txtfees.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jPanel7.add(txtfees);
        txtfees.setBounds(360, 390, 70, 20);

        jLabel46.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel46.setText("TAKA");
        jPanel7.add(jLabel46);
        jLabel46.setBounds(400, 420, 90, 20);

        jLabel47.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel47.setText("Total:");
        jPanel7.add(jLabel47);
        jLabel47.setBounds(310, 470, 60, 30);

        jLabel48.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel48.setText("Age:");
        jPanel7.add(jLabel48);
        jLabel48.setBounds(20, 190, 30, 13);

        jLabel49.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel49.setText("Gender:");
        jPanel7.add(jLabel49);
        jLabel49.setBounds(20, 210, 40, 13);
        jPanel7.add(txtother);
        txtother.setBounds(360, 420, 70, 20);

        jLabel51.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jLabel51.setText("TAKA");
        jPanel7.add(jLabel51);
        jLabel51.setBounds(400, 390, 90, 20);

        jPanel3.add(jPanel7);
        jPanel7.setBounds(690, 0, 580, 560);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 70, 1370, 560);

        jPanel4.setBackground(new java.awt.Color(5, 72, 125));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1370, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(0, 630, 1370, 80);

        setSize(new java.awt.Dimension(1298, 741));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox2PopupMenuWillBecomeInvisible
       String m=txtapp.getSelectedItem().toString();
       if(m=="Select"){
           JOptionPane.showMessageDialog(this,"Please! Select Patients Type.");
       }else{
           String a=jComboBox2.getSelectedItem().toString();
        if(m.contains("New Patient")){
             ap.NameSet1(a, txtdname, txtddesi,txtfees); 
        
        
        }else{
            ap.NameSet2(a, txtdname, txtddesi,txtfees); 
        }
       }
        
       
        
    }//GEN-LAST:event_jComboBox2PopupMenuWillBecomeInvisible

    private void jTextField6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            String a=jTextField6.getText().toString();
            ap.patientData(a, txtpname, txtpage,txtpgen);
        }
        
    }//GEN-LAST:event_jTextField6KeyPressed

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
            java.util.logging.Logger.getLogger(Appoint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Appoint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Appoint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Appoint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Appoint().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JComboBox txtapp;
    private javax.swing.JLabel txtddesi;
    private javax.swing.JLabel txtdname;
    private javax.swing.JLabel txtfees;
    private javax.swing.JLabel txtother;
    private javax.swing.JLabel txtpage;
    private javax.swing.JLabel txtpgen;
    private javax.swing.JLabel txtpname;
    // End of variables declaration//GEN-END:variables
}
