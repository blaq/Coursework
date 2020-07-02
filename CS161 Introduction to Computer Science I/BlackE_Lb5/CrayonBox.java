// *********************************************
//  Name: Ethan Black         Folder Name:  BlackE_Lb5
//  CS161  Winter 2016         Lab #5
//  Mon/Wed/Fri 8:00 am
//  Date:  Feb 9, 2016
//
//   Program Name: CrayonBox.java
//   Program Description:
//                  Lab #5
//
//**********************************************
import java.awt.*;
import javax.swing.*;

public class CrayonBox
{	public static void main(String[] args)
	{	JFrame frame = new JFrame("CrayonBox");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(new CrayonPanel());

		frame.pack();
		frame.setVisible(true);
	}
}
