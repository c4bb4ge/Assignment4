/* Assignment 4, Problem 5
 * Jordan Kaehlert
 * 
 * GUI lockscreen program with 10 buttons labeled 0 through 9. To exit the program, you must click on the correct combination 
 * of 3 buttons in order, which is 6-3-1. If the wrong combination is used, the frame turns red (until the next correct number is entered) */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* Frame 3: new frame created when "3" is selected in frame 2 */
class Frame3 extends JFrame implements ActionListener{

	public Frame3(String title){
		
		super(title);
		
		JButton b0 = new JButton("0");  // creating JButtons 0-9
		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton b4 = new JButton("4");
		JButton b5 = new JButton("5");
		JButton b6 = new JButton("6");
		JButton b7 = new JButton("7");
		JButton b8 = new JButton("8");
		JButton b9 = new JButton("9");
		add(b0);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);
		add(b8);
		add(b9);

        b0.addActionListener(this); // action listeners added for all buttons
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);   
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
		
		setLayout(new GridLayout(2,5));
		setSize(500,200);
        setVisible(true);
        setLocationRelativeTo(null);    // opens the frame in the center of the screen
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);   // prevent user from closing without entering the correct combination
		
	}

    /* Action Listener for when button 6 is pressed */
    public void actionPerformed(ActionEvent event){
        if (event.getActionCommand() != "1") {
            getContentPane().setBackground(Color.red);
            repaint();
        }
        else if (event.getActionCommand() == "1") {     // if button pressed is 1...
            System.exit(0);     // exit the program
        }
        
    
    }
}

/* Frame 2: new frame created when "6" is selected in frame 1 */
class Frame2 extends JFrame implements ActionListener{

	public Frame2(String title){
		
		super(title);
		
		JButton b0 = new JButton("0");  // creating JButtons 0-9
		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton b4 = new JButton("4");
		JButton b5 = new JButton("5");
		JButton b6 = new JButton("6");
		JButton b7 = new JButton("7");
		JButton b8 = new JButton("8");
		JButton b9 = new JButton("9");
		add(b0);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);
		add(b8);
		add(b9);

        b0.addActionListener(this); // action listeners added for all buttons
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);   
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
		
		setLayout(new GridLayout(2,5));
		setSize(500,200);
        setVisible(true);
        setLocationRelativeTo(null);    // opens the frame in the center of the screen
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);   // prevent user from closing without entering the correct combination
		
	}

    /* Action Listener for when button 6 is pressed */
    public void actionPerformed(ActionEvent event){
        if (event.getActionCommand() != "3") {
            getContentPane().setBackground(Color.red);
            repaint();
        }
        else if (event.getActionCommand() == "3") {     // if the button 3 is pressed...
            Frame3 f3 = new Frame3("3-Button Lockscreen");      // create frame 3
            dispose();      // close frame 2
        }
        
    
    }
}

/* Frame 1: First frame created in the main method, which contains a 2x5 Grid Layout with buttons 0-9 */
class Frame1 extends JFrame implements ActionListener{

	public Frame1(String title){
		
		super(title);
		
		JButton b0 = new JButton("0");  // creating JButtons 0-9
		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton b4 = new JButton("4");
		JButton b5 = new JButton("5");
		JButton b6 = new JButton("6");
		JButton b7 = new JButton("7");
		JButton b8 = new JButton("8");
		JButton b9 = new JButton("9");
		add(b0);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);
		add(b8);
		add(b9);

        b0.addActionListener(this); // action listeners added for every button
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);   
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
		
		setLayout(new GridLayout(2,5));
		setSize(500,200);
        setLocationRelativeTo(null);    // opens the frame in the center of the screen
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);   // prevent user from closing without entering the correct combination
		
	}

    /* Action Listener for when button 6 is pressed */
    public void actionPerformed(ActionEvent event){
        if (event.getActionCommand() != "6") {          // if button pressed is not 6...
            getContentPane().setBackground(Color.red);      // set the frame's color to red
            repaint();      // repaint the frame
        }
        else if (event.getActionCommand() == "6") {     // if the button pressed is 6...
            Frame2 f2 = new Frame2("3-Button Lockscreen");      // create frame 2
            dispose();      // close frame 1
        }
        
    
    }
}

public class Kaehlert_Problem5{
	public static void main(String[] args){
		Frame1 f1 = new Frame1("3-Button Lockscreen");
		f1.setVisible(true);
	}
}