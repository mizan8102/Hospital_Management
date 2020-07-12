package HMS;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Loading1 {
   
    public static void main(String[] args) {
          Loading lp=new  Loading();
         lp.setVisible(true);
         for (int i = 0; i <=100; i++) {
            
                 try {
                     Thread.sleep(40);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(Loading1.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 //lp.number.setText(Integer.toString(i)+"%");
                 if(i==100){
                     lp.setVisible(false);
                      new HeadLogin().setVisible(true);
                 }
                 
    }
    }
    
}
