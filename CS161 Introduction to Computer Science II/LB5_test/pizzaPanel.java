// *********************************************
//  Name: Ethan Black         Folder Name:  BlackE_LB5
//  CS162  Spring 2016         Lab #5
//  Tue/Thu 10:00
//  Date:  Apr 24, 2016
//
//   Program Name: pizzaPanel.java
//   Program Description:
//                  Lab #5
//
//**********************************************

import javax.swing.*;
import java.awt.*;

public class pizzaPanel extends JPanel
{
	public pizzaPanel()
	{
		setPreferredSize(new Dimension(1700, 900));
		setBackground(Color.black);

        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon icon = createImageIcon("images/middle.gif");


        JComponent panel1 = makeTextPanel("Panel #1");
        tabbedPane.addTab("Tab 1", icon, panel1,
                "Does nothing");

	}

	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);

		//for(int i=0; i<dots.length; i++)
		//{
		//	//dots[i].draw(page);
		//}

	}
    protected JComponent makeTextPanel(String text)
    {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }

    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = TabbedPaneDemo.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
