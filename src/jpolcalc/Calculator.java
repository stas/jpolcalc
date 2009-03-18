package jpolcalc;

import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment.*;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
 * Polynomial Calculator class
 * @author Stas SUSHKOV
 */
public class Calculator extends javax.swing.JFrame {

    // Input for our input for polinom #1
    JTextField pol1Input = new javax.swing.JTextField();

    // Input for our input for polinom #2
    JTextField pol2Input = new javax.swing.JTextField();

    // Components for our radio buttons
    JRadioButton plusRButton = new javax.swing.JRadioButton();
    JRadioButton minRButton = new javax.swing.JRadioButton();
    JRadioButton multRButton = new javax.swing.JRadioButton();
    JRadioButton difRButton = new javax.swing.JRadioButton();

    // Component for output
    JTextArea resultArea = new javax.swing.JTextArea();

    /**
     * Method creates the GUI for the calculator
     * Constructor for the inputs, and action button
     */
    public Calculator() {

        // Label for our input for polinom #1
        JLabel pol1Label = new javax.swing.JLabel();

        // Label for our input for polinom #2
        JLabel pol2Label = new javax.swing.JLabel();

        // Label for our radio buttons
        JLabel rbLabel = new javax.swing.JLabel();


        // RButtons labels & grouping
        rbLabel.setText("Selectați una din operații:");
        plusRButton.setText("Adunare");
        minRButton.setText("Scădere");
        multRButton.setText("Înmulțire");
        difRButton.setText("Împărțire");

        // Button Group for our radio buttons
        ButtonGroup rbGroup = new javax.swing.ButtonGroup();
            rbGroup.add(plusRButton);
            rbGroup.add(minRButton);
            rbGroup.add(multRButton);
            rbGroup.add(difRButton);

        // Components for our start button
        JButton startButton = new javax.swing.JButton();
        JLabel startLabel = new javax.swing.JLabel();

        // Set behaviour of the window to exit on close
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        // Set window title
        setTitle("CS.UT/PT-LAB2: Calculator polinomial");
        // Labels text
        pol1Label.setText("Scrieți polinomul #1:");
        pol2Label.setText("Scrieți polinomul #2:");

        // Label for results
        JLabel resultLabel = new javax.swing.JLabel();
        resultLabel.setText("Rezultatele calculului:");

        // RButtons labels & grouping
        rbLabel.setText("Selectați una din operații:");
        plusRButton.setText("Adunare");
        minRButton.setText("Scădere");
        multRButton.setText("Înmulțire");
        difRButton.setText("Împărțire");

        // Button text
        startLabel.setText("Pentru a calcula, apăsați „Start”.");
        startButton.setText("Start");

        // We create a new vertical layout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Start adding stuff to layout
        // Group horizontal alignment
        layout.setHorizontalGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(pol1Label)
                        .addComponent(pol2Label)
                        .addComponent(rbLabel)
                        .addComponent(startLabel)
                        .addComponent(resultLabel)
                    )
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(pol1Input)
                        .addComponent(pol2Input) // RadioButtons
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(plusRButton)
                            .addComponent(minRButton)
                            .addComponent(multRButton)
                            .addComponent(difRButton)
                        )
                        .addComponent(startButton)
                        .addComponent(resultArea)
                    )
        );
        // Group vertical alignment
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(pol1Label)
                    .addComponent(pol1Input)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(pol2Label)
                    .addComponent(pol2Input)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(rbLabel) // RadioButtons
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(plusRButton)
                        .addComponent(minRButton)
                        .addComponent(multRButton)
                        .addComponent(difRButton)
                    )
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(startLabel)
                    .addComponent(startButton)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(resultLabel)
                    .addComponent(resultArea)
                )
        );

        // Listener for our button
        startButton.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                Main();
            }
        });

        // Set-up positions
        pack();

        // Make it bigger
        setSize(600, 250);
        // And put it in the center of my screen
        setLocationRelativeTo(null);
    }

    /**
     * Method converts input (String) to a Polynomial object
     * @param   s is the String input which has to be converted to a Polynomial Object
     */
    public Polynomial doPolynomial(String s) {
        // Start a new null polynomial
        Polynomial p = new Polynomial(0, 0);
        
        // Temporary coefficient and degree
        int tempC; int tempD;
        String[] tempS;

        // Explode all the terms
        String[] newS = s.split("\\+");
            // Parse all the terms
            for( int i = 0; i < newS.length; i++) {
                // Split the coefficients and the degree
                tempS = newS[i].split("x\\^");
                    // Get the coefficient and the degree
                    tempC = Integer.valueOf(tempS[0]);
                    tempD = Integer.valueOf(tempS[1]);
                    // Add values to our polynomial
                    p = p.plus(new Polynomial(tempC, tempD));
            }
        return p;
    }

    /**
     * Main method, this runs the calculator
     */
    public void Main() {
        // Get our calcultor
        Calculator c = this;
        // Are we alive?
        boolean run = true;

        // Create polynomials
        Polynomial pol1 = new Polynomial(0, 0);
        Polynomial pol2 = new Polynomial(0, 0);
        // Result
        Polynomial r    = new Polynomial(0, 0);

        String input1 = c.pol1Input.getText();
        String input2 = c.pol2Input.getText();

        if (input1.isEmpty() || input2.isEmpty()) {
            // Die if empty imputs
            run = false;
        }
        else
            run = true;

        // Convert inputs to polynomials
        if (run) {
            pol1 = doPolynomial(input1);
            pol2 = doPolynomial(input2);

            // Get the current operation and execute it!
            if(c.plusRButton.isSelected()) {
                c.resultArea.setText("Se face adunarea:\n");
                r = pol1.plus(pol2);
                c.resultArea.append(r.toString());
                c.resultArea.append("\nTerminat");
            }
            else if(c.minRButton.isSelected()) {
                c.resultArea.setText("Se face scăderea:\n");
                r = pol1.minus(pol2);
                c.resultArea.append(r.toString());
                c.resultArea.append("\nTerminat");
            }
            else if(c.multRButton.isSelected()) {
                c.resultArea.setText("Se face înmulțirea:\n");
                r = pol1.times(pol2);
                c.resultArea.append(r.toString());
                c.resultArea.append("\nTerminat");
            }
            else if(c.difRButton.isSelected()) {
                c.resultArea.setText("Se face împărțirea:\n");
                r = pol1.division(pol2);
                c.resultArea.append(r.toString());
                c.resultArea.append("\nTerminat");
            }
        }
        else {
            c.resultArea.setText("Nu a fost introdus nimic sau nu a fost aleasă nici-o operație.\n");
            c.resultArea.append("\nTerminat");
        }
    };
}
