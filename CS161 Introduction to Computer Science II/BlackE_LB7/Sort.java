import java.util.Random;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Sort extends JPanel
{
    private final int DELAY = 1000;
	private int x=50, y, z;
	private Timer timer;
	private int[] array = new int[25];
	//private static Bar[] bars = new Bar[25];

    public void Sort()
	{
		timer = new Timer(DELAY, new SelectionSort());
		setBackground(Color.black);

		Random gen = new Random();
		for(int i=0; i<array.length; i++)
		{
			y=gen.nextInt(91)+10;
			array[i]=y;
//System.out.println(y+"\t"+array[i]);
		}
		timer.start();
	}

	public Dimension getPreferredSize()
	{
		return new Dimension(1000, 500);
	}

	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		if(z == 0)
		{
			Sort();
		}
		paintBars(page);
		z++;
	}

	private void paintBars(Graphics page)
	{
		//Sort();

		JPanel primary = new JPanel();

		page.setColor(Color.white);
		for(int i=0; i<array.length; i++)
		{
			page.fillRect(x, (150-array[i]), 15, array[i]);
			x+=17;
		}
		x=50;
	}

	private class SelectionSort implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			int i, j, first, temp;
			for (i=0; i<array.length; i++)
			{
				first = 0;
			    for(j=1; j<=i; j++)
			    {
			    	if(array[j]<array[first])
			        	first = j;
			    }
			    	temp = array[first];
			        array[first] = array[i];
			        array[i] = temp;
				System.out.println(temp);
				repaint();
			}
		}
	}
}