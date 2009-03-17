/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jpolcalc;

import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment.*;
import javax.swing.JRadioButton;
/**
 * Application main window class.
 * @author stas
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * The main window constructor
     */
    public MainWindow() {
        // Inputs for our input for polinom #1
        JTextField Pol1Input = new javax.swing.JTextField();
        JLabel Pol1Label = new javax.swing.JLabel();

        // Inputs for our input for polinom #2
        JTextField Pol2Input = new javax.swing.JTextField();
        JLabel Pol2Label = new javax.swing.JLabel();

        // Components for our radio buttons
        JLabel rbLabel = new javax.swing.JLabel();
        JRadioButton plusRButton = new javax.swing.JRadioButton();
        JRadioButton minRButton = new javax.swing.JRadioButton();
        JRadioButton sumRButton = new javax.swing.JRadioButton();
        JRadioButton divRButton = new javax.swing.JRadioButton();

        // RButtons labels & grouping
        rbLabel.setText("Selectați una din operații:");
        plusRButton.setText("Adunare");
        minRButton.setText("Scădere");
        sumRButton.setText("Înmulțire");
        divRButton.setText("Împărțire");

        ButtonGroup rbGroup = new javax.swing.ButtonGroup();
        rbGroup.add(plusRButton);
        rbGroup.add(minRButton);
        rbGroup.add(sumRButton);
        rbGroup.add(divRButton);

        // Components for our start button
        JButton startButton = new javax.swing.JButton();
        JLabel startLabel  = new javax.swing.JLabel();

        // Set behaviour of the window to exit on close
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        // Set window title
        setTitle("CS.UT/PT-LAB2: Calculator polinomial");
        // Labels text
        Pol1Label.setText("Scrieți polinomul #1:");
        Pol2Label.setText("Scrieți polinomul #2:");

        // RButtons labels & grouping
        rbLabel.setText("Selectați una din operații:");
        plusRButton.setText("Adunare");
        minRButton.setText("Scădere");
        sumRButton.setText("Înmulțire");
        divRButton.setText("Împărțire");

        // Button text
        startLabel.setText("Pentru a calcula, apăsați „Start”.");
        startButton.setText("Start");
        // Listener for our button
        startButton.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });

        // We create a new vertical layout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Start adding stuff to layout
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(Pol1Label)
                    .addComponent(Pol2Label)
                    .addComponent(rbLabel)
                    .addComponent(startLabel)
                    )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(Pol1Input)
                    .addComponent(Pol2Input)
                    // RadioButtons
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(plusRButton)
                        .addComponent(minRButton)
                        .addComponent(sumRButton)
                        .addComponent(divRButton)
                        )
                        
                    .addComponent(startButton)
                    )
        );
        
        layout.setVerticalGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Pol1Label)
                        .addComponent(Pol1Input)
                        )
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Pol2Label)
                        .addComponent(Pol2Input)
                        )
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(rbLabel)
                        // RadioButtons
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(plusRButton)
                            .addComponent(minRButton)
                            .addComponent(sumRButton)
                            .addComponent(divRButton)
                            )

                        )
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(startLabel)
                        .addComponent(startButton)
                        )
        );

        // Set-up positions
        pack();

        // Make it bigger
        setSize(600, 200);
        // And put it in the center of my screen
        setLocationRelativeTo(null);
    }

}
