package jpolcalc;

import java.awt.EventQueue;
import javax.swing.UIManager;

/**
 * Main window class - starts calculator window
 * @author  Stas SUSHKOV
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Born a new runnable
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                // L&F, be nice on chosing look
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                }
                catch(Exception e) {
                    e.printStackTrace();
                }

                // Create our window and set it visible
                new Calculator().setVisible(true);
            }
        });
        
    }

}
