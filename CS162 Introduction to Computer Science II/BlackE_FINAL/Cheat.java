import  java.util.Scanner;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.*;
import java.io.*;

public class Cheat extends JPanel
{
	int i=0, e=0;
	String line;
	JLabel text;
	String[] phrase = new String[31];

	public Cheat()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.black);

		JButton cheat = new JButton("Cheat");
		cheat.addActionListener(new ButtonListener());
		cheat.setAlignmentX(Component.CENTER_ALIGNMENT);

		text = new JLabel("");
		text.setFont(new Font("Arial",60,60));
		text.setAlignmentX(Component.CENTER_ALIGNMENT);
		text.setForeground(Color.white);

		try							//check to see if file is present
		{
			File file = new File("Cheats.txt");
			Scanner scan = new Scanner(file);
			line=scan.nextLine();
			Scanner lineScan = new Scanner(line);
			String word = lineScan.next();
			while(scan.hasNext())	//fill array with each line
			{
				phrase[i]=line;
				i++;
				line=scan.nextLine();
			}
		}
		catch(FileNotFoundException exception)//activate recursion method
		{
			System.out.println("let me make the cheats real quick");
			Towers pegs = new Towers(5);
			pegs.solve();
			pegs.print();
		}

		add(Box.createRigidArea(new Dimension(0,150)));
		add(text);
		add(Box.createRigidArea(new Dimension(0,30)));
		add(cheat);

	}

	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{							//print one line from file
			if(e<phrase.length)
			{
				text.setText(phrase[e]);
				e++;
			}
			else
				e=0;
		}
	}
}