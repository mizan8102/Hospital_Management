
package Pharmecy;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;


public class Timeset {
    
    
    public void setTime(final JLabel label){
        Thread clock =new Thread(){
        @Override
        public void run(){
            String h="";
            for(;;){
                try {
                    Calendar cal=new GregorianCalendar();
                    int second=cal.get(Calendar.SECOND);
                    int minute=cal.get(Calendar.MINUTE);
                    int hour=cal.get(Calendar.HOUR);
                    int am=cal.get(Calendar.AM_PM);
                    if(am==1){
                        h="PM";
                    }
                    else{
                        h="AM";
                    }
                    //String a=cal.getCalendarType(Calendar.);
                   label.setText(hour+":"+minute+":"+second+" "+h);
                    sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Timeset.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        
        
        
        
        
        
        
        
        };
        clock.start();
        
    }
   
    
}
