import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Special extends JPanel
{

	public Special()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.white);

		JLabel greeting = new JLabel("Still Hungry?");

	//sides
		JLabel sides = new JLabel("Sides:");
		JRadioButton chicken = new JRadioButton("Fried Chicken...3.50");
		JRadioButton wings = new JRadioButton("Wings...3.50");
		JRadioButton breadsticks = new JRadioButton("Breadsticks...3.50");
		JRadioButton cheesebread = new JRadioButton("Cheesy Bread...3.50");

		ButtonGroup group2 = new ButtonGroup();
		group2.add(chicken);
		group2.add(wings);
		group2.add(breadsticks);
		group2.add(cheesebread);
	//sides

	//desserts
		JLabel desserts = new JLabel("Desserts");
		JRadioButton sticks = new JRadioButton("Cinnamon Sticks...3.50");
		JRadioButton brownie = new JRadioButton("Family-sized Brownie...3.50");
		JRadioButton pizza = new JRadioButton("Dessert Pizza...4.00");

		ButtonGroup group1 = new ButtonGroup();
		group1.add(sticks);
		group1.add(brownie);
		group1.add(pizza);
	//desserts

		add(Box.createRigidArea(new Dimension(20,10)));

		add(sides);
		add(chicken);
		add(wings);
		add(breadsticks);
		add(cheesebread);
		add(Box.createRigidArea(new Dimension(20,10)));

		add(desserts);
		add(sticks);
		add(brownie);
		add(pizza);
	}
}