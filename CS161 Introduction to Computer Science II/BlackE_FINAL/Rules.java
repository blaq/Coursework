import java.awt.event.*;
import java.awt.Font;
import javax.swing.*;
import java.awt.*;

public class Rules extends JPanel
{
	public Rules()
	{
		setLayout(new GridLayout(4,1));
		setBackground(Color.white);
		setPreferredSize(new Dimension(1000, 450));

		ImageIcon icon1 = new ImageIcon("Capture5.png");
		ImageIcon icon2 = new ImageIcon("Capture2.png");
		ImageIcon icon3 = new ImageIcon("Capture4.png");
		ImageIcon icon4 = new ImageIcon("Capture.png");

		JLabel a = new JLabel("__Rules & Instructions__");
		a.setForeground(Color.blue);
		a.setFont(new Font("Georgia",40,40));

		JLabel b = new JLabel(icon1);
		JLabel c = new JLabel(icon2);

		JLabel d = new JLabel("1. Move only ONE disk at a time");
		d.setForeground(Color.blue);
		d.setFont(new Font("Verdana",20,20));

		JLabel e = new JLabel(icon3);

		JLabel f = new JLabel("2. Bigger disks CANNOT be put on smaller disks");
		f.setForeground(Color.blue);
		f.setFont(new Font("Verdana",20,20));

		JLabel g = new JLabel(icon4);

		JLabel h = new JLabel("3. Moves all the disks to the center peg to WIN");
		h.setForeground(Color.blue);
		h.setFont(new Font("Verdana",20,20));

		add(b);
		add(a);
		add(c);
		add(d);
		add(e);
		add(f);
		add(g);
		add(h);
	}
}