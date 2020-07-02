/********************************************************************
* Ethan Patterson	Folder Name pattersonE_lb5
* CS162 Spring 2016	Lab#: 2
* Class time: (Tues/Thurs 10:00am)
* April 26th 2016
* Programe will creat an application for a ordering pizza
*-----------------Test Oracle----------------------------------------
* No critical information to display here, Exicute the code
* to see the application compiled on java version (1.7.0_95)
*********************************************************************/
import java.awt.*;
import javax.swing.*;

public class lab5
{
	public static int total = 0;

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("HutPizza");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(800, 650));

		JTabbedPane tp = new JTabbedPane();//creat a tab object

		//tp.setBorder(BorderFactory.createLoweredBevelBorder());
		tp.addTab("Home", new homePane());// Adding homePane to a tabe
		tp.addTab("Food", new foodPanel2());// Adding foodPanel to a tabe
		tp.addTab("Drinks", new drinksPanel());// Adding drinksPanel to a tabe
		tp.addTab("Special Order", new specialPanel());// Adding specialPanel to a tabe

		frame.getContentPane().add(tp);
		frame.pack();
		frame.setVisible(true);
		System.out.println(total);
	}// main end

	public static int setToZero(int total)
	{

		return total;
	}

	public static int setToPrice(int total, char sym)
	{

		if (sym == '+')
			total += 1;

		else if(sym == '-')
			total -=1;

		return total;
	}
}// class end
