/* Assignment 4, Problem 4
 * Jordan Kaehlert
 *
 * Simple application with a text area, a text field, and a button. In the text field, you can enter a name. When the button is pressed,
 * a new window is opened that is titled with the name the user entered */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* Frame 2: New frame with the entered name as the frame's title; called from the ActionListener in the Frame1 class */
class Frame2 extends JFrame{

    /* Constructor for Frame 2 */
    public Frame2(String title){
		
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // closes upon clicking the 'X' button
		setSize(500,100);               // size of frame is 500x100
        setLocationRelativeTo(null);    // opens the frame in the center of the screen
	}
}

/* Frame 1: First frame, which contains a label requesting the user's name, a text box where they can enter their name,
 * and a button for them to enter it. There is also an Action Listener for the button being clicked, which calls the Frame2 constructor.
 */
class Frame1 extends JFrame implements ActionListener{

	JLabel jlblName;        // declaring the objects for the label, text field, and button
	JTextField jtfName;
	JButton jbtEnter;

    /* Constructor for Frame 1 */
	public Frame1(){

		jtfName = new JTextField(10);   // text field with length 10
		jlblName = new JLabel("Enter your name:");      // label which asks user to enter their name
		jbtEnter = new JButton("Enter");        // button with the text "Enter"
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));   // layout is Flow Layout, with the "center" option picked and spacing of 10 between components
		
		jbtEnter.addActionListener(this);   // action listener added for the button
		
		add(jlblName);
		add(jtfName);
		add(jbtEnter);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,100);
        setLocationRelativeTo(null);
		
	}
    
    /* Button's ActionListener */
	public void actionPerformed(ActionEvent event){
	
		String name = jtfName.getText();    // set the string 'Name' to the text entered in the text field
		Frame2 f2 = new Frame2(name);       // Call the Frame2 constructor to create the second frame; set its title to the name the user entered
		f2.setVisible(true);
		
	}
}
	
public class Kaehlert_Problem4{
	public static void main(String[] args){
	
		Frame1 f1 = new Frame1();   // call the Frame1 constructor to create the first frame
		f1.setVisible(true);
		
	}
}