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

public class driverPanel extends JPanel
{
	private Circle circle1;

	public driverPanel()
	{
		circle1 = new Circle(30, Color.red, 70, 35);

		setPreferredSize(new Dimension(300, 200));
		setBackground(Color.black);
	}

	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);

		circle1.draw(page);
	}
}