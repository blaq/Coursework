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
		tp.addTab("Pizza", new Pizza());
		tp.addTab("Special", new Special());
		tp.addTab("Drinks", new Drinks());

		Title a = new Title();
		Cart b = new Cart();
		add(a, BorderLayout.NORTH);
		add(b, BorderLayout.EAST);
		add(tp);

	}
}