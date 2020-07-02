import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class specialPanel extends JPanel
{
	private static JCheckBox checkBox[] = new JCheckBox[4];//
	
	public specialPanel()
	{
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		JLabel pickDrink = new JLabel("Pick your dessert!");
		add(pickDrink);	// Add pickDrinks to the panel
	
		String specialTypes[] = {"Chocolate Cake","Ice Cream Volcano", "My soul"};//special food types 
		for (int i = 0; i < specialTypes.length;i++)
		{
			checkBox[i] = new JCheckBox(specialTypes[i]);
			add(checkBox[i]);// Add checkBox to the panel	
		}
	}
}// class end  
