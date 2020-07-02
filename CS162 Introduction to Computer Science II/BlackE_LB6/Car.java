import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Car extends JPanel
{
    private final int DELAY = 20;
	private Timer timer;
	private int body1 = -400, body2= -344;
	private int window = -339, wheel1 = -340, wheel2 = -140;
	private int[] xfront = {-101, -101, -1};
	private int[] yfront = {75, 150, 150};
	private int[] xback = {-344, -344, -399};
	private int[] yback = {75, 150, 150};

    public Car()
	{
		timer = new Timer(DELAY, new move());
		setPreferredSize(new Dimension(700, 450));
		setBackground(Color.cyan);
		timer.start();
	}

	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);

		page.setColor(Color.gray);
		page.fillRect(0, 250, 700, 50);

		page.setColor(Color.green);
		page.fillRect(0, 300, 700, 150);

		page.setColor(Color.white);
		page.fillOval(180, 20, 60, 60);
		page.fillOval(200, 4, 60, 60);
		page.fillOval(220, 22, 60, 60);
		page.fillOval(240, 0, 60, 60);
		page.fillOval(260, 18, 60, 60);

		page.setColor(Color.red);
		//page.fillRect(body, 75, 400, 150);
		page.fillRect(body1, 150, 400, 75);
		page.fillRect(body2, 75, 245, 75);

		page.setColor(Color.black);
		page.fillRect(window, 78, 233, 72);
		page.fillPolygon(xfront, yfront, xfront.length);
		page.fillPolygon(xback, yback, xback.length);

		page.fillOval(wheel1, 185, 80, 80);
		page.fillOval(wheel2, 185, 80, 80);

		page.setColor(new Color(156, 93, 82));
		page.fillRect(500, 50, 50, 400);

		page.setColor(Color.green);
		page.fillOval(250, -300, 600, 400);
	}

	private class move implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			body1 += 5;
			body2 += 5;
			window += 5;
			wheel1 += 5;
			wheel2 += 5;
			for(int i=0; i<xfront.length; i++)
			{
				xfront[i] += 5;
				xback[i] += 5;
			}

			repaint();
		}
	}
}