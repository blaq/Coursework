import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;

public class Page extends JPanel
{
    public Page()
    {
		setLayout(new BorderLayout());
		setBackground(Color.orange);

		String a = "Towers of Hanoi";
		JLabel title = new JLabel(a);
		title.setForeground(Color.blue);
		title.setFont(new Font("Courier New",112,112));
		TitledBorder tb = BorderFactory.createTitledBorder("Black '16");
		tb.setTitleJustification(TitledBorder.RIGHT);
		title.setBorder(tb);

		JTabbedPane tp = new JTabbedPane();
		tp.addTab("Rules", new Rules());
		tp.addTab("Game", new Picture());
		tp.addTab("Cheat", new Cheat());

		add(title, BorderLayout.NORTH);
		add(tp);

	}
}