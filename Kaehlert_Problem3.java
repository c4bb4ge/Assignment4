/* Assignment 4, Problem 3
 * Jordan Kaehlert
 * 
 * Simple calculator that can add, subtract, multiply, and divide integers. Features a "clear" button (labeled a "C" on the calculator).
 * NOTE: Uses mXparser to evaluate mathematical expressions in strings. https://mathparser.org/
 * 
 * To run: javac -cp ".;MathParser.org-mXparser-v.5.2.1/bin/jdk8/MathParser.org-mXparser.jar" Kaehlert_Problem3.java
 *          java -cp ".;MathParser.org-mXparser-v.5.2.1/bin/jdk8/MathParser.org-mXparser.jar" Kaehlert_Problem3
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.mariuszgromada.math.mxparser.*;

/* Class for calculator JFrame */
class Calculator extends JFrame implements ActionListener{

    boolean isCallSuccessful = License.iConfirmNonCommercialUse("Jordan Kaehlert");     // confirming non-commercial use of mXparser

    JTextField screen;

    /* Constructor to create calculator JFrame */
    public Calculator (String title){

        super(title);
        Font font1 = new Font("Dialog", Font.PLAIN, 40);    // font size for calculator buttons
        Font font2 = new Font("Dialog", Font.PLAIN, 20);    // font size for calculator "screen"

        JPanel buttons = new JPanel();      // create a panel for the calculator's buttons
        buttons.setLayout(new GridLayout(4,4));      // create a 5x4 grid layout for the buttons
       
        JButton b0 = new JButton("0");                          // create each button, set their sizes, and set their fonts
        b0.setPreferredSize(new Dimension(100, 100));
        b0.setFont(font1);
        JButton b1 = new JButton("1");
        b1.setPreferredSize(new Dimension(100, 100));
        b1.setFont(font1);
        JButton b2 = new JButton("2");
        b2.setPreferredSize(new Dimension(100, 100));
        b2.setFont(font1);
        JButton b3 = new JButton("3");
        b3.setPreferredSize(new Dimension(100, 100));
        b3.setFont(font1);
        JButton b4 = new JButton("4");
        b4.setPreferredSize(new Dimension(100, 100));
        b4.setFont(font1);
        JButton b5 = new JButton("5");
        b5.setPreferredSize(new Dimension(100, 100));
        b5.setFont(font1);
        JButton b6 = new JButton("6");
        b6.setPreferredSize(new Dimension(100, 100));
        b6.setFont(font1);
        JButton b7 = new JButton("7");
        b7.setPreferredSize(new Dimension(100, 100));
        b7.setFont(font1);
        JButton b8 = new JButton("8");
        b8.setPreferredSize(new Dimension(100, 100));
        b8.setFont(font1);
        JButton b9 = new JButton("9");
        b9.setPreferredSize(new Dimension(100, 100));
        b9.setFont(font1);
        JButton mult = new JButton("X");
        mult.setPreferredSize(new Dimension(100, 100));
        mult.setFont(font1);
        JButton div = new JButton("/");
        div.setPreferredSize(new Dimension(100, 100));
        div.setFont(font1);
        JButton add = new JButton("+");
        add.setPreferredSize(new Dimension(100, 100));
        add.setFont(font1);
        JButton sub = new JButton("-");
        sub.setPreferredSize(new Dimension(100, 100));
        sub.setFont(font1);
        JButton clr = new JButton("C");
        clr.setPreferredSize(new Dimension(100, 100));
        clr.setFont(font1);
        JButton eql = new JButton("=");
        eql.setPreferredSize(new Dimension(100, 100));
        eql.setFont(font1);

        buttons.add(b7);      // row 1: 7-9 and division
        buttons.add(b8);
        buttons.add(b9);
        buttons.add(div);

        buttons.add(b4);      // row 2: 4-6 and multiplication
        buttons.add(b5);
        buttons.add(b6);
        buttons.add(mult);

        buttons.add(b1);      // row 3: 1-3 and addition
        buttons.add(b2);
        buttons.add(b3);
        buttons.add(add);

        buttons.add(clr);      // row 4: clear, 0, subtraction, and equals sign
        buttons.add(b0);      
        buttons.add(eql);
        buttons.add(sub);

        b0.addActionListener(this);     // action listeners added for all buttons
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);   
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        mult.addActionListener(this);
        div.addActionListener(this);
        add.addActionListener(this);
        sub.addActionListener(this);
        clr.addActionListener(this);
        eql.addActionListener(this);

        JPanel calc = new JPanel();      // panel that holds the text box as well as the grid of buttons
        screen = new JTextField("",20);     // creates the text field for the screen, which is initially blank
        screen.setFont(font2);      // set the font for the calculator screen
        screen.setPreferredSize(new Dimension(600, 150));   // setting size of screen
        screen.setEditable(false);      // set screen to not be editable (user can only edit by pressing buttons to prevent characters that aren't allowed)
        screen.setHorizontalAlignment(JTextField.RIGHT);    // set screen to have right alignment

        calc.add(screen, BorderLayout.NORTH);   // add the calculator screen at the top of the panel
        calc.add(buttons, BorderLayout.CENTER);     // add the buttons under the screen

        // add contents to the frame
        add(calc);
        setSize(400,600);
        setVisible(true);
        setLocationRelativeTo(null);    // opens the frame in the center of the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /* ActionListener method for all buttons */
    public void actionPerformed(ActionEvent event){

        // "if" statement to handle numbered button presses; appends new numbers to the end of the string on the screen
        if (event.getActionCommand() == "0" || event.getActionCommand() == "1" || event.getActionCommand() == "2" || event.getActionCommand() == "3" ||
            event.getActionCommand() == "4" || event.getActionCommand() == "5" || event.getActionCommand() == "6" || event.getActionCommand() == "7" ||
            event.getActionCommand() == "8" || event.getActionCommand() == "9"){

            String n = event.getActionCommand();
            screen.setText(screen.getText() + n);
        }
        else if (event.getActionCommand() == "+"){      // handles addition; appends addition sign to end of the string on the screen
            screen.setText(screen.getText() + "+");
        }
        else if (event.getActionCommand() == "-"){      // handles subtraction; appends addition sign to end of the string on the screen
            screen.setText(screen.getText() + "-");
        }
        else if (event.getActionCommand() == "X"){      // handles multiplication; appends addition sign to end of the string on the screen
            screen.setText(screen.getText() + "*");
        }
        else if (event.getActionCommand() == "/"){      // handles division; appends addition sign to end of the string on the screen
            screen.setText(screen.getText() + "/");
        }
        else if (event.getActionCommand() == "C"){      // handles clear screen; replaces screen contents with empty string
            screen.setText("");
        }
        else if (event.getActionCommand() == "="){      // handles solving the equation; replaces screen contents with answer to equation

            Expression equ = new Expression(screen.getText());      // create a new expression "equ" which is equal to the current string on the calculator's screen
            String answer = String.valueOf((int)equ.calculate());   // answer to expression is found by using the "calculate" function from mXparser.
                                                                    // Answer is a double, so convert to integer for consistency and set the answer string to this value.
            screen.setText(answer);     // display the answer on the screen
        }
    }
}

public class Kaehlert_Problem3{
	public static void main(String[] args){
		Calculator calc = new Calculator("Simple Calculator");  // call the constructor for the calculator
		calc.setVisible(true);
	}
}