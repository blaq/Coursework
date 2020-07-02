import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Pizza extends JPanel
{

	public Pizza()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.white);

		JLabel greeting = new JLabel("Thanks for seeings us for your pizza needs. Lets get right into it!");
		add(greeting);
		add(Box.createRigidArea(new Dimension(25,10)));



	//pizza size
		JLabel size = new JLabel("How big do you want your pizza?");
		JRadioButton small = new JRadioButton("Small....5.00", false);
		JRadioButton medium = new JRadioButton("Medium...6.50", false);
		JRadioButton large = new JRadioButton("Large....8.00", false);

		ButtonGroup group1 = new ButtonGroup();
		group1.add(small);
		group1.add(medium);
		group1.add(large);
	//pizza size

	//dough type
		JLabel dough = new JLabel("What Kind of dough do you want?");
		JRadioButton tossed = new JRadioButton("Tossed", false);
		JRadioButton pan = new JRadioButton("Pan", false);
		JRadioButton crunchy = new JRadioButton("Crunchy", false);
		JRadioButton gf = new JRadioButton("Gluten Free", false);

		ButtonGroup group2 = new ButtonGroup();
		group2.add(tossed);
		group2.add(pan);
		group2.add(crunchy);
		group2.add(gf);
	//dough type

	//meats
		JLabel meats = new JLabel("Any meats? (1.00 extra for each)");
		JCheckBox pep = new JCheckBox("Pepperoni", false);
		JCheckBox sau = new JCheckBox("Sausage", false);
		JCheckBox bee = new JCheckBox("Beef", false);
		JCheckBox ham = new JCheckBox("Ham", false);
		JCheckBox bac = new JCheckBox("Bacon", false);
		JCheckBox sal = new JCheckBox("Salami", false);
		JCheckBox chi = new JCheckBox("Chicken", false);

		//ButtonGroup group3 = new ButtonGroup();
		//group3.add(pep);
		//group3.add(sau);
		//group3.add(bee);
		//group3.add(ham);
		//group3.add(bac);
		//group3.add(sal);
		//group3.add(chi);
	//meats

	//other
		JLabel other = new JLabel("Or anything else? (1.00 extra for each)");
		JCheckBox oli = new JCheckBox("Olives", false);
		JCheckBox gar = new JCheckBox("Garlic", false);
		JCheckBox jal = new JCheckBox("Jalapeno", false);
		JCheckBox pin = new JCheckBox("Pineapple", false);
		JCheckBox oni = new JCheckBox("Onions", false);
		JCheckBox spi = new JCheckBox("Spinach", false);
		JCheckBox tom = new JCheckBox("Tomatoes", false);
	//other

		add(greeting);
		add(Box.createRigidArea(new Dimension(20,10)));

		add(size);
		add(small);
		add(medium);
		add(large);
		add(Box.createRigidArea(new Dimension(20,10)));

		add(dough);
		add(tossed);
		add(pan);
		add(crunchy);
		add(gf);
		add(Box.createRigidArea(new Dimension(20,10)));

		add(meats);
		add(pep);
		add(sau);
		add(bee);
		add(ham);
		add(bac);
		add(sal);
		add(chi);
		add(Box.createRigidArea(new Dimension(20,10)));

		add(other);
		add(oli);
		add(gar);
		add(jal);
		add(pin);
		add(oni);
		add(spi);
		add(tom);
		add(Box.createRigidArea(new Dimension(20,10)));
	}

	//private class StyleListener implements ItemListener
	//{
	//	public void itemStateChanged(ItemEvent event)
	//	{
	//		if(



/*
	private class QuoteListener implements ActionListener
	{
		public void actionperformed(ActionEvent event)
		{
			Object source = event.getSource();
			if(source
		}
	}
*/

}