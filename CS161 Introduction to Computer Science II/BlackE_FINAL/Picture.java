import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Picture extends JPanel
{
	private Point point1 = null, point2 = null;
	private Disks[] peg1 = new Disks[5];
	private Disks[] peg2 = new Disks[5];
	private Disks[] peg3 = new Disks[5];
	private int[] x = {93, 118, 142, 166, 190};
	private int[] y = {93, 118, 142, 166, 190};
	private int times=0;
	private Disks fake;
	private String time;

    public Picture()
	{
		peg1[0] = new Disks(250, Color.red, x[0], y[0], false, true);
		peg1[1] = new Disks(200, Color.yellow, x[1], y[1], false, true);
		peg1[2] = new Disks(150, Color.green, x[2], y[2], false, true);
		peg1[3] = new Disks(100, Color.blue, x[3], y[3], false, true);
		peg1[4] = new Disks(50, Color.magenta, x[4], y[4], true, true);

		peg2[0] = new Disks(250, Color.red, x[0]+280, y[0], false, false);
		peg2[1] = new Disks(200, Color.yellow, x[1]+280, y[1], false, false);
		peg2[2] = new Disks(150, Color.green, x[2]+280, y[2], false, false);
		peg2[3] = new Disks(100, Color.blue, x[3]+280, y[3], false, false);
		peg2[4] = new Disks(50, Color.magenta, x[4]+280, y[4], false, false);

		peg3[0] = new Disks(250, Color.red, x[0]+560, y[0], false, false);
		peg3[1] = new Disks(200, Color.yellow, x[1]+560, y[1], false, false);
		peg3[2] = new Disks(150, Color.green, x[2]+560, y[2], false, false);
		peg3[3] = new Disks(100, Color.blue, x[3]+560, y[3], false, false);
		peg3[4] = new Disks(50, Color.magenta, x[4]+560, y[4], false, false);

		fake = new Disks(0, Color.blue, 0, 0, false, false);

		Game input = new Game();
		addMouseListener(input);
		addMouseMotionListener(input);

		JButton restart = new JButton("Restart");
		restart.addActionListener(new ButtonListener());
		add(restart);

		setPreferredSize(new Dimension(1000, 450));
		setBackground(Color.blue);
		setFont(new Font("Arial", Font.BOLD, 50));
	}

	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);

		page.setColor(Color.black);		//backboard
		page.fillRect(75, 75, 850, 295);
		page.fillOval(433, 377, 120, 65);

		if(times<10)					//counter
			time = "0"+times;
		if(times>=10)
			time = ""+times;
		page.setColor(Color.orange);
		page.drawString(time, 467, 425);

		for(int i=0;i<peg1.length;i++)	//print only one of each
		{								//disk of all pegs
			boolean x = peg1[i].getPeg();
			boolean y = peg2[i].getPeg();
			boolean z = peg3[i].getPeg();
			boolean f = fake.getPeg();

			if(x==true)
				peg1[i].draw(page);
			if(y==true)
				peg2[i].draw(page);
			if(z==true)
				peg3[i].draw(page);
			if(f==true)
				fake.draw(page);
		}

		page.setColor(Color.black);	//pegs
		page.fillOval(202, 202, 25, 25);
		page.fillOval(484, 202, 25, 25);
		page.fillOval(764, 202, 25, 25);

		page.setColor(Color.white);	//peg lining
		page.drawOval(202, 202, 25, 25);
		page.drawOval(484, 202, 25, 25);
		page.drawOval(764, 202, 25, 25);

		boolean w1 = peg2[0].getPeg();
		boolean w2 = peg2[1].getPeg();
		boolean w3 = peg2[2].getPeg();
		boolean w4 = peg2[3].getPeg();
		boolean w5 = peg2[4].getPeg();
		if(w1==true&&w2==true&&w3==true&&w4==true&&w5==true)
		{							//Check to see if player won
			setFont(new Font("Arial", Font.BOLD, 200));
			page.setColor(Color.white);
			page.drawString("WINNER", 111, 301);
			page.setColor(Color.magenta);
			page.drawString("WINNER", 85, 275);
			page.setColor(Color.blue);
			page.drawString("WINNER", 90, 280);
			page.setColor(Color.green);
			page.drawString("WINNER", 95, 285);
			page.setColor(Color.yellow);
			page.drawString("WINNER", 100, 290);
			page.setColor(Color.red);
			page.drawString("WINNER", 105, 295);
			page.setColor(Color.black);
			page.drawString("WINNER", 110, 300);
			//setFont(new Font("Arial", Font.BOLD, 50));
		}
	}

	private class Game implements MouseListener, MouseMotionListener
	{
		public void Move(Disks[] from, Disks[] to)
		{								//move disk from peg to peg
			int e=0;
			while(e<peg1.length)
			{
				boolean x = from[e].getPeg();
				boolean a = from[e].getTop();
				if(x==true&&a==true)	//first is visible and top
				{
					boolean p1 = to[0].getPeg();
					boolean p2 = to[1].getPeg();
					boolean p3 = to[2].getPeg();
					boolean p4 = to[3].getPeg();
					boolean p5 = to[4].getPeg();
					if(a==true&&p1==false&&p2==false&&p3==false&&p4==false&&p5==false)
					{					//check to see if peg has no disks
						from[e].setPeg(false);
						from[e].setTop(false);
						to[e].setPeg(true);
						to[e].setTop(true);
						if(e>0)
							from[e-1].setTop(true);
						times+=1;
					}
					else
					{
						int u=0;
						while(u<peg1.length)
						{
							boolean y = to[u].getPeg();
							boolean b = to[u].getTop();
							if(y==true&&b==true&&e>u)	//check if peg + top
							{							//are true + if disk
								from[e].setPeg(false);	//is smallest
								from[e].setTop(false);
								if(from[e-1].getPeg()==true);
								{
									if(e>0)
										from[e-1].setTop(true);
								}
								to[e].setPeg(true);
								to[e].setTop(true);
								to[u].setTop(true);
								Look(peg1);			//check for top disk
								Look(peg2);
								Look(peg3);
								times+=1;
							}
							u++;
							Look(peg1);			//check again
							Look(peg2);
							Look(peg3);
						}
						Look(peg1);			//check again
						Look(peg2);
						Look(peg3);
					}
					for(int i=0; i<peg1.length; i++)
					{							//if peg is false, top is fakse
						boolean q = to[e].getPeg();
						boolean w = from[e].getPeg();
						if(q==false)
							to[e].setTop(false);
						if(w==false)
							from[e].setTop(false);
					}
				}
				e++;
				Look(peg1);		//check again
				Look(peg2);
				Look(peg3);
			}
		}

		public void Look(Disks[] from)	//check for top disk
		{
			int e=0;
			while(e<=4)
			{
				boolean x = from[e].getPeg();
				boolean a = from[e].getTop();
				int t = from[e].getDiameter();
				if(x==true)
				{
					if(e>0)
						from[e-1].setTop(false);
						if(e>1)
							from[e-2].setTop(false);
							if(e>2)
								from[e-3].setTop(false);
								if(e>3)
									from[e-4].setTop(false);
					from[e].setTop(true);
				}
				e++;
			}
		}

		public void mousePressed(MouseEvent event)
		{
			point1 = event.getPoint();
		}

		public void mouseReleased(MouseEvent event)
		{								//check where button was
			fake.setPeg(false);			//pressed + released
			point2 = event.getPoint();

			if(point1.x>95&&point1.x<340&&point1.y>95&&point1.y<350)//first peg
			{
				if(point2.x>378&&point2.x<620&&point2.y>95&&point2.y<350)//second peg
					Move(peg1, peg2);//one to two
				else if(point2.x>658&&point2.x<900&&point2.y>95&&point2.y<350)//third peg
					Move(peg1, peg3);//one to three
			}
			else if(point1.x>378&&point1.x<620&&point1.y>95&&point1.y<350)//second peg
			{
				if(point2.x>95&&point2.x<340&&point2.y>95&&point2.y<350)//first peg
					Move(peg2, peg1);//two to one
				else if(point2.x>658&&point2.x<900&&point2.y>95&&point2.y<350)//third peg
					Move(peg2, peg3);//two to three
			}
			else if(point1.x>658&&point1.x<900&&point1.y>95&&point1.y<350)//third peg
			{
				if(point2.x>95&&point2.x<340&&point2.y>95&&point2.y<350)//first peg
					Move(peg3, peg1);//three to one
				else if(point2.x>378&&point2.x<620&&point2.y>95&&point2.y<350)//second peg
					Move(peg3, peg2);//three to two
			}
			repaint();
		}

		public void mouseDragged(MouseEvent event)
		{
			if(point1.x>95&&point1.x<340&&point1.y>95&&point1.y<350)
				Animate(peg1, event);
			if(point1.x>378&&point1.x<620&&point1.y>95&&point1.y<350)
				Animate(peg2, event);
			if(point1.x>658&&point1.x<900&&point1.y>95&&point1.y<350)
				Animate(peg3, event);
			repaint();
		}

		public void Animate(Disks[]from, MouseEvent event)
		{									//disk follows mouse while pressed
			int e=0, i=0;
			while(e<=4)
			{
				boolean a = from[e].getPeg();
				boolean b = from[e].getTop();

				int c = event.getX();
				int d = event.getY();
				if(a==true&&b==true)	//check if peg and top are true
				{
					int size = from[e].getDiameter();
					Color color = from[e].getColor();
					fake.setDiameter(size);
					fake.setColor(color);
					fake.setX(c-(size/2));
					fake.setY(d-(size/2));
					fake.setPeg(true);
				}
				e++;
			}
		}

		public void mouseClicked(MouseEvent event) {}
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited(MouseEvent event) {}
		public void mouseMoved(MouseEvent event) {}
	}

	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{									//resest the desks
			for(int i=0; i<peg1.length; i++)
			{
				peg1[i].setPeg(true);
				peg2[i].setPeg(false);
				peg3[i].setPeg(false);
				times=0;
			}
			Game reset = new Game();
			reset.Look(peg1);
			reset.Look(peg2);
			reset.Look(peg3);
			repaint();
		}
	}
}