import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Drinks extends JPanel
{

	public Drinks()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.white);

	//flavors
		JLabel drink = new JLabel("Would you like something to drink?");
		JCheckBox coke = new JCheckBox("Coke");
		JCheckBox diet = new JCheckBox("Diet Coke");
		JCheckBox sprite = new JCheckBox("Sprite");
		JCheckBox pepper = new JCheckBox("Dr. Pepper");
		JCheckBox fanta = new JCheckBox("Orange Fanta");
	//flavors

	//size
		JLabel size = new JLabel("What size do you want?");
		JRadioButton small = new JRadioButton("16 oz......2.00");
		JRadioButton medium = new JRadioButton("20 oz......2.50");
		JRadioButton large = new JRadioButton("32 oz......3.00");
		JRadioButton largest = new JRadioButton("2 liters...4.00");

		ButtonGroup group1 = new ButtonGroup();
		group1.add(small);
		group1.add(medium);
		group1.add(large);
		group1.add(largest);
	//size

		add(Box.createRigidArea(new Dimension(20,10)));

		add(drink);
		add(coke);
		add(diet);
		add(sprite);
		add(pepper);
		add(fanta);
		add(Box.createRigidArea(new Dimension(20,10)));

		add(size);
		add(small);
		add(medium);
		add(large);
		add(largest);

	}
}