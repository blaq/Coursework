// *********************************************
//  Name: Ethan Black         Folder Name:  BlackE_LB3
//  CS162  Spring 2016         Lab #3
//  Tue/Thu 10:00
//  Date:  Apr 20, 2016
//
//   Program Name: lab3.java
//   Program Description:
//                  Lab #3
//
//**********************************************
import javax.swing.*;
import java.awt.*;

public class driver
{
	public static void main(String[] args)
    {
	   	JFrame frame = new JFrame("driver");
   		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(new driverPanel());

		frame.pack();
		frame.setVisible(true);

  	}
}





