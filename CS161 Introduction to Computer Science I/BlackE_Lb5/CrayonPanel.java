// *********************************************
//  Name: Ethan Black         Folder Name:  BlackE_Lb5
//  CS161  Winter 2016         Lab #5
//  Mon/Wed/Fri 8:00 am
//  Date:  Feb 9, 2016
//
//   Program Name: CrayonPanel.java
//   Program Description:
//                  Lab #5
//
//**********************************************
import javax.swing.*;
import java.awt.*;

public class CrayonPanel extends JPanel
{	private Crayon Crayon1, Crayon2, Crayon3, Crayon4, Crayon5, Crayon6, Crayon7;

	public CrayonPanel()
	{	Crayon1=new Crayon(25,135,Color.red,170,185);
		Crayon2=new Crayon(25,130,Color.orange,197,190);
		Crayon3=new Crayon(25,125,Color.yellow,224,195);
		Crayon4=new Crayon(25,120,Color.green,251,200);
		Crayon5=new Crayon(25,115,Color.blue,278,205);
		Crayon6=new Crayon(25,110,Color.magenta,305,210);

		Crayon7=new Crayon(164,125,Color.gray,167,275);

		setPreferredSize(new Dimension(500,500));
		setBackground(Color.white);
	}

	public void paintComponent(Graphics page)
	{	super.paintComponent(page);

		Crayon1.draw(page);
		Crayon2.draw(page);
		Crayon3.draw(page);
		Crayon4.draw(page);
		Crayon5.draw(page);
		Crayon6.draw(page);
		Crayon7.draw(page);
	}
}