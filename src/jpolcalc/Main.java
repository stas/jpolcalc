/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jpolcalc;

import java.awt.EventQueue;
import javax.swing.UIManager;

/**
 * Main class and caller for our new program window
 * @author stas
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
                new MainWindow().setVisible(true);
            }
        });
        
    }

    private javax.swing.JLabel Pol1Label;
    private javax.swing.JLabel Pol2Label;
    private javax.swing.JTextField Pol1Input;
    private javax.swing.JTextField Pol2Input;
    private javax.swing.JLabel startLabel;
    private javax.swing.JButton startButton;

}
