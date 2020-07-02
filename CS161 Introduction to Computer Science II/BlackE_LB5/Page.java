import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Page extends JPanel
{
    public Page()
    {
		setLayout(new BorderLayout());

		JPanel primary = new JPanel();
		primary.setBackground(Color.red);

		JTabbedPane tp = new JTabbedPane();
		//tp.addTab("Game", new Picture());
		tp.addTab("Cheat", new Title());

		String a = "Towers of Hanoi";
		Cart b = new Cart();
		//add(a, BorderLayout.NORTH);
		add(b, BorderLayout.EAST);
		add(tp);

	}
}