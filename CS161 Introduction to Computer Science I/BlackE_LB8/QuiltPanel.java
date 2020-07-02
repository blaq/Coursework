import javax.swing.JPanel;
import java.awt.*;

public class QuiltPanel extends JPanel
{	private final int width = 50, height = 50;
	public QuiltPanel()
	{	setBackground(Color.black);
		setPreferredSize(new Dimension(1500, 1500));
	}
	public void paintComponent(Graphics page)
	{	super.paintComponent(page);
		int x = 50, y = 50, u = width, v = height;
		for(int e = 0; e < 10; e++)
		{	for(int i = 0; i < 10; i++)
			{	if(page.getColor() == Color.red)
					page.setColor(Color.green);
				else
					page.setColor(Color.red);
				page.fillRect(x, y, u, v);
				x += u;
			}
		if(page.getColor() == Color.red)
			page.setColor(Color.green);
		else
			page.setColor(Color.red);
			y += v;
			x -= 500;
		}
	}
}