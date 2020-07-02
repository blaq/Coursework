import javax.swing.*;
import java.awt.*;

public class Disks
{
	private int diameter, x, y;
	private Color color;
	private boolean top, peg;

	public Disks(int size, Color shade, int upperX, int upperY, boolean topDisk, boolean pegNumber)
	{
		diameter = size;
		color = shade;
		x = upperX;
		y = upperY;
		top = topDisk;
		peg = pegNumber;
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

	public void setTop(boolean topDisk)
	{
		top = topDisk;
	}

	public void setPeg(boolean pegNumber)
	{
		peg = pegNumber;
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

	public boolean getTop()
	{
		return top;
	}

	public boolean getPeg()
	{
		return peg;
	}
}