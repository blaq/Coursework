import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class drinksPanel extends JPanel
{
	private JCheckBox checkBox[];
	private JLabel total;
	private JButton clear;
	public lab5 driver;
	
	public drinksPanel()
	{
		final int drinkListSize = 4;// used to hold the dirnkType string array size; 

		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));// Using the Box layout top down 
		setBackground(Color.cyan);
	
		toolBox drinks = new toolBox();// uses the Food class for radio buttons and checkBoxes 
		JLabel logo = new JLabel();
		Clear listener = new Clear();
		add(logo = drinks.logoPrint());	
		total = new JLabel("Total ____");
		clear = new JButton("Clear");
	
		checkBox = new JCheckBox[drinkListSize];
		JLabel pickDrink = new JLabel("Pick your drinks (Coke only!)");
		add(pickDrink); // Adds pickDrink to the panel
		
		String drinkTypes[] = {"Coke","Sprite", "Dr.Pepper"};
		checkBox = drinks.setCheckBox(drinkTypes, drinkListSize); // creates an array of check Boxes
		for (int i = 0; i < checkBox.length-1;i++)
			add(checkBox[i]);// adds check boxes to the panel
		
		clear.addActionListener(listener);
		add(clear);
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(total);	
		total.setText("Total " + driver.total);
	}
	
	private class Clear implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			Object source = event.getSource();
			
			if (source == clear)
				for (int i = 0; i < checkBox.length-1;i++)
					checkBox[i].setSelected(false);
			
			for (int i = 0; i < checkBox.length-1;i++)
				if (checkBox[i].isSelected() == true)
					driver.total += 1;
			/*for (int i = 0; i < checkBox.length-1;i++)
			{
				if (checkBox[i].isSelected() == true)
					driver.total +=1;
				else if (
			}*/	
			total.setText("Total " + driver.total);
		}// actionPerformed end
	}// class clear end 
}	
