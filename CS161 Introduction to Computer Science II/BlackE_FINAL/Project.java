// ***************************************************
//  Name: Ethan Black         Folder Name:  final
//  CS162  Spring 2016         Final Project
//  Tue/Thu 10:00
//  Date:  June 1, 2016
//
//   Program Name: project.java
//   Program Description:
//                  Final Project
//
//****************************************************
import java.util.Scanner;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Project extends JPanel
{
	public static void  main (String[] args)
	{
		JFrame frame = new JFrame("Towers Of Hanoi");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new Page());
		frame.pack();
		frame.setVisible(true);
	}
}

