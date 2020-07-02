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
import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class pizzaPanel extends JPanel
{
	private static circle[] dots = new circle[20];
	private int X, Y;

	public pizzaPanel()
	{
		this.X = X;
		this.Y = Y;
		int r=45;

		Random ranX = new Random();
		Random ranY = new Random();

		setPreferredSize(new Dimension(1500, 1500));
		setBackground(Color.black);

		for(int e=0; e<dots.length; e++)
		{
			X = ranX.nextInt(500);
			Y = ranY.nextInt(500);
			dots[e] = new circle(r, Color.green, X, Y);
		}

		for(int a=0; a<dots.length; a++)
		{
			radar(r);
		}
	}
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);

		for(int i=0; i<dots.length; i++)
		{
			dots[i].draw(page);
		}
	}

	public void radar(int r)
	{
		int firstX=0, firstY=0, secondX=0, secondY=0;
		double radius1=0.0, radius2=0.0, ans=0.0;

		for(int u=0; u<dots.length; u++)
		{
			firstX = dots[u].getX();
			firstY = dots[u].getY();

			for(int o=0; o<dots.length; o++)
			{
				secondX = dots[o].getX();
				secondY = dots[o].getY();

				radius1 = Math.pow(secondX-firstX, 2);
				radius2 = Math.pow(secondY-firstY, 2);
				ans = Math.sqrt(radius1+radius2);
				if(ans < r && ans != 0)
				{
					dots[u].setColor(Color.cyan);
					dots[o].setColor(Color.cyan);
				}
			}
		}
	}
}