import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Object;

public class homePane extends JComponent
{
	private JButton b1, b2;

	public homePane()
	{
		setLayout(new FlowLayout());
		
		b1 = new JButton("Food");// Creats a button with the text Food 
		b2 = new JButton("Drinks");// Creats a button with the text Drinks
		
		b1.addActionListener(new foodListener());
		//b2.addActionListener(new drinkListener());

		b1.setBounds(50, 50, 400, 400);	
		add(b1);
		add(b2);
		//paint();
	}// homePane end 	
	class foodListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			//b1.setSelectedIndex(1);
		}//actionPerformed end 
	}//foodListener end 
}//class end 

/*
* setSelectedIndex is not recognized for some reason, but 
* we need it to change to the food tabe
* 
* Try and make a setter and getter method for displaing the users total
*/
