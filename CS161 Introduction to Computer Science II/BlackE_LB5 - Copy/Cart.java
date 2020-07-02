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

		//Total total = new Total();

		JButton cc = new JButton("Clear Cart");
		JLabel pay = new JLabel("Total:\n");
		//JLabel items = new JLabel("Items");

		//int cost = drive.total;
		total.setText(drive.total);

		add(cc);//, BorderLayout.SOUTH);
		add(pay);//, BorderLayout.CENTER);
		//add(items, BorderLayout.CENTER);
		//add(total);
	}

	//public double Total(double num1, double num2)
	//{
	//    double total = 0;
	    //for(double n : num1)
	    //{
	    //    total += n;
	    //}
	//	return total;
	//}

}