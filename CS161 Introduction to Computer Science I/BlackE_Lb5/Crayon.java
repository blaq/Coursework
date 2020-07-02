// *********************************************
//  Name: Ethan Black         Folder Name:  BlackE_Lb5
//  CS161  Winter 2016         Lab #5
//  Mon/Wed/Fri 8:00 am
//  Date:  Feb 9, 2016
//
//   Program Name: Crayon.java
//   Program Description:
//                  Lab #5
//
//**********************************************
import java.awt.*;
import javax.swing.*;

public class Crayon
{	private int width, height, x, y;
	private Color color;

	public Crayon(int Width, int Height, Color shade, int upperX, int upperY)
	{	width=Width;
		height=Height;
		color=shade;
		x=upperX;
		y=upperY;
	}

	public void draw(Graphics page)
	{	page.setColor(color);
		page.fillRect(x, y, width, height);
	}

	public void setWidth(int Width)
	{	width=Width;
	}

	public void setHeight(int Height)
	{	height=Height;
	}

	public void setColor(Color shade)
	{	color=shade;
	}

	public void setX(int upperX)
	{	x=upperX;
	}

	public void setY(int upperY)
	{	y=upperY;
	}

	public int getWidth()
	{	return width;
	}

	public int getHeight()
	{	return height;
	}

	public Color getColor()
	{	return color;
	}

	public int getX()
	{	return x;
	}

	public int getY()
	{	return y;
	}
}