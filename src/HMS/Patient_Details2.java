
package HMS;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Patient_Details2 {
    
    void setImagetoLabel(String file,JLabel label){
        
       ImageIcon im=new ImageIcon(new ImageIcon(file).getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_SMOOTH));
        label.setIcon(im);
    }
}
