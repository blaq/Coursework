// *********************************************
//  Name: Ethan Black         Folder Name:  BlackE_LB72
//  CS162  Spring 2016         Lab #7
//  Tue/Thu 10:00
//  Date:  May 17, 2016
//
//   Program Name: Drive.java
//   Program Description:
//                  Lab #7
//
//**********************************************
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Drive extends JPanel
{
    public static void main(String[] args)
	{
		JFrame frame = new JFrame("Sort");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(new Sort());
	    frame.pack();
	    frame.setVisible(true);
	}
}