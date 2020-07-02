// *********************************************
//  Name: Ethan Black         Folder Name:  BlackE_LAB2
//  CS161  Winter 2016         Lab #2
//  Mon/Wed/Fri 8:00 am
//  Date:  Jan 19, 2016
//
//   Program Name: lab_2.java
//   Program Description:
//                  lab #2 exercises
//
//**********************************************

import javax.swing.JApplet;
import java.awt.*;

public class lab_2 extends JApplet
{ public void paint(Graphics page)
   {

	final int MID = 150;
	final int TOP = 50;

	//setBackground(Color.cyan);
	page.setColor(Color.cyan);
	page.fillRect(0, 0, 300, 175);

	page.setColor(Color.green);
	page.fillRect(0, 175, 300, 50);

	page.setColor(Color.yellow);
	page.fillOval(260, -40, 80,80);

	page.setColor(Color.white);
	page.fillOval(MID+0, TOP, 40,40);
	page.fillOval(MID-15, TOP+35, 70, 50);
	page.fillOval(MID-30, TOP+80, 100, 60);

	page.setColor(Color.black);
	page.fillOval(MID+10, TOP+10, 5, 5);
	page.fillOval(MID+25, TOP+10, 5, 5);

	page.drawArc(MID+10, TOP+25, 20, 10, 20, 140);

	page.drawLine(MID-5, TOP+60, MID-30, TOP+40);
	page.drawLine(MID+45, TOP+60, MID+75, TOP+60);

	page.drawLine(MID+0, TOP+5, MID+40, TOP+5);
	page.fillRect(MID+5, TOP-20, 30, 25);

	page.setColor(Color.red);
	page.fillOval(MID+15, TOP+45, 10, 10);
	page.fillOval(MID+15, TOP+60, 10, 10);

	page.setColor(Color.black);
	page.drawLine(MID-140, TOP-40, MID-120, TOP-40);
	page.drawLine(MID-140, TOP-25, MID-130, TOP-25);
	page.drawLine(MID-140, TOP-10, MID-120, TOP-10);
	page.drawLine(MID-140, TOP-40, MID-140, TOP-10);

	page.drawLine(MID-115, TOP-40, MID-95, TOP-40);
	page.drawLine(MID-105, TOP-40, MID-105, TOP-10);

	page.drawLine(MID-90, TOP-40, MID-90, TOP-10);
	page.drawLine(MID-90, TOP-25, MID-70, TOP-25);
	page.drawLine(MID-70, TOP-40, MID-70, TOP-10);

	page.drawLine(MID-65, TOP-10, MID-55, TOP-40);
	page.drawLine(MID-55, TOP-40, MID-45, TOP-10);
	page.drawLine(MID-60, TOP-25, MID-50, TOP-25);

	page.drawLine(MID-40, TOP-40, MID-40, TOP-10);
	page.drawLine(MID-40, TOP-40, MID-20, TOP-10);
	page.drawLine(MID-20, TOP-40, MID-20, TOP-10);

	/*Makes a snowman with red buttons, stick arms,
	frowny face, top hat, my name, and a sun.
*/
  }
}