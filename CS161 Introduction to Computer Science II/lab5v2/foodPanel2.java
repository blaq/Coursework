import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class foodPanel2 extends JPanel
{
	private static JRadioButton pizzaType[];
//	private static List <JCheckBox> displayToppings[];
	private static JCheckBox displayToppings[];
	private static ButtonGroup group;
	private static JButton clear;
	private static JLabel total;
	public static lab5 driver;


	public foodPanel2()
	{
		final int styleSize = 4; // Used to hold the size of typeOfPizza
		final int toppingSize = 4;// used to hold the size of toppings

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.cyan);// sets the background to the color cyan

		group = new ButtonGroup();// used to group the radio buttons together
		toolBox food = new toolBox();// uses some useful methods from the Food class
		JLabel logo = new JLabel();// used to hold the company logo
		Clear listener = new Clear();
		total = new JLabel();
		clear = new JButton("Clear");

		logo = food.logoPrint();
		add(logo);// adds the logo to the panel here
		String typeOfPizza[] = {"Hand Tossed - 5$", "Deep Dsih - 8$", "Flat Bread - 5$"};
		pizzaType = food.setPizzaStyle(typeOfPizza, styleSize);

		for (int i = 0; i < styleSize-1; i++)//fills the radio buttons
		{
			add(pizzaType[i]);
			group.add(pizzaType[i]);
		}

		add(Box.createRigidArea(new Dimension(0, 10)));
		String toppings[] = {"Pepperoni - .30$","Spinach - .30$","Anchovies - 30$"};
		displayToppings = food.setCheckBox(toppings, toppingSize);
		for (int i = 0; i < toppingSize-1; i++)
		{
			add(displayToppings[i]);
			displayToppings[i].addActionListener(listener);
			displayToppings[i].putClientProperty("price", 1);
		}

		add(Box.createRigidArea(new Dimension(0, 10)));
		clear.addActionListener(listener);

		add(Box.createRigidArea(new Dimension(0, 10)));
		add(clear);// adds the clear button to the panel

		add(Box.createRigidArea(new Dimension(0, 10)));
		add(total);
		total.setText("Total " + driver.total);
		System.out.println(driver.total);
	}// foodPanel2 end

	private class Clear implements ActionListener // This class is used for the clear button
	{
		public void actionPerformed(ActionEvent event)//clears all user input
		{
			//JCheckBox checkBox = (JCheckBox)e.getSource();
			Object source = event.getSource();
			int cost = driver.total;
			if (source == clear)
			{
				for (int i = 0; i < displayToppings.length-1;i++)
					displayToppings[i].setSelected(false);

				driver.total = 0;
				cost = 0;
				group.clearSelection();
			}

			/*for (int i = 0; i < displayToppings.length-1;i++)
				cost  = displayToppings[i].isSelected() ? (cost + 1) : (cost - 1);
*/			cost = 0;
			driver.total = 0;
			for (int i = 0; i < displayToppings.length-1;i++)
			{
				if (displayToppings[i].isSelected())
					cost += 1;

				else if (displayToppings[i].isSelected() == false && driver.total != 0)
					cost -= 1;
			}
			driver.total = cost;
			total.setText("Total " + driver.total);
		}// actionPerformed end
	}//class clear end
}//class end
