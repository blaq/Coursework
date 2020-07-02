// *********************************************
//  Name: Ethan Black         Folder Name:  BlackE_LB8
//  CS161  Winter 2016         Lab #8
//  Mon/Wed/Fri 8:00 am
//  Date:  Mar 1, 2016
//
//   Program Name: Lab8.java
//   Program Description:
//                  Lab #8 exercises
//
//**********************************************
import javax.swing.JFrame;

public class Quilt
{ public static void main(String[] args)
   {	JFrame frame = new JFrame("Quilt");
   		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		QuiltPanel panel = new QuiltPanel();

		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);

  }
}