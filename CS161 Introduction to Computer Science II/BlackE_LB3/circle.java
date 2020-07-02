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

public class circle
{
	private int diameter, x, y;
	private Color color;

	public circle(int size, Color shade, int upperX, int upperY)
	{
		diameter = size;
		color = shade;
		x = upperX-(diameter/2);
		y = upperY-(diameter/2);
	}

	public void draw(Graphics page)
	{
		page.setColor(color);
		page.fillOval(x, y, diameter, diameter);
	}

	public void setDiameter(int size)
	{
		diameter = size;
	}

	public void setColor(Color shade)
	{
		color = shade;
	}

	public void setX(int upperX)
	{
		x = upperX;
	}

	public void setY(int upperY)
	{
		y = upperY;
	}

	public int getDiameter()
	{
		return diameter;
	}

	public Color getColor()
	{
		return color;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}
}