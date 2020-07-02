import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class toolBox extends JPanel
{
	private static ButtonGroup group;
	
	public JRadioButton[] setPizzaStyle(String[] list, int size)// creates an array of radio buttons 
	{
		JRadioButton pizzaType[] = new JRadioButton[size];
		for (int i = 0; i < list.length;i++)
			pizzaType[i] = new JRadioButton(list[i]);

		return pizzaType;
	}
	public JCheckBox[] setCheckBox(String[] list, int size)// creats an array of check boxes 
	{
		JCheckBox checkBox[] = new JCheckBox[size];
		for (int i = 0; i < list.length;i++)
			checkBox[i] = new JCheckBox(list[i]);
		
		return checkBox;
	}

	public JLabel logoPrint()// used to hold company logo
	{
		ImageIcon icon = new ImageIcon("logo.jpg");
		JLabel logo = new JLabel("HutPzza", icon, SwingConstants.RIGHT);
	
		return logo;		
	}
	
	public double readFile(String fileName) throws IOException
	{
		double total = 0;
		Scanner fileScan, lineScan;
		File myFile = new File(fileName);
		fileScan = new Scanner(myFile);
		String line = null;
		
		while (fileScan.hasNext())
		{
			line = fileScan.nextLine(); 
			total = Double.parseDouble(line);	
		}

		return total;
	}// readFile end
	public void writeFile(String fileName, double value) throws IOException
	{
		PrintWriter writer = new PrintWriter(fileName, "UTF-8");
		writer.println(value);

		writer.close();
	}// writeFile end 
}// class end
