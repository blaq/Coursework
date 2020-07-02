import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Cart extends JPanel
{
	public double total;
	public static driver drive;

	public Cart()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.yellow);


		JButton cheat = new JButton("Cheat");
		JLabel text = new JLabel("");

		//total.setText(drive.total);


		add(cheat);
	}
}