// *********************************************
//  Name: Ethan Black         Folder Name:  BlackE_LB5
//  CS162  Spring 2016         Lab #5
//  Tue/Thu 10:00
//  Date:  Apr 24, 2016
//
//   Program Name: Drive.java
//   Program Description:
//                  Lab #5
//
//**********************************************
//set timer
//paint background, then road, ground and cloud.
//paing car body and windows
//paint tree
//add 5 to the x coordinate of all car components
//repaint

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Drive extends JPanel
{
    public static void main(String[] args)
	{
		JFrame frame = new JFrame("Car");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(new Car());
	    frame.pack();
	    frame.setVisible(true);
	}
}