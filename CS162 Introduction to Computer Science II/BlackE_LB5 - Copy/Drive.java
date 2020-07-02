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
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Drive extends JPanel
{
    public static double total = 0.0;

    public Drive()
    {

	}

    public static void main(String[] args)
	{
		JFrame frame = new JFrame("Pizza Bizarro");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Page product = new Page();

		frame.getContentPane().add(product);
	    frame.pack();
	    frame.setVisible(true);
	}
}