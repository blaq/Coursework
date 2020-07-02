import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Title extends JPanel
{
	public Title()
	{
		ImageIcon icon = new ImageIcon("coolpizza.png");

		//setLayout(new GridLayout(1,1));
		setBackground(Color.red);

		JLabel a = new JLabel("Pizza Bizzaro");
		a.setForeground(Color.orange);
		a.setFont(new Font("Serif Italic",75,75));

		JLabel b = new JLabel(icon);

		add(a);
		add(b);
	}
}