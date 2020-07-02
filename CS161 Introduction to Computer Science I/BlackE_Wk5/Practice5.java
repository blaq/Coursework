// *********************************************
//  Name: Ethan Black         Folder Name:  BlackE_Wk5
//  CS161  Winter 2016         Worksheet #5
//  Mon/Wed/Fri 8:00 am
//  Date:  Feb 5, 2016
//
//   Program Name: Worksheet5.java
//   Program Description:
//                  Worksheet #5
//
//**********************************************
import java.util.Scanner;
import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class Practice5
{		public static void Lyrics()
	{	System.out.println("Row, row, row your boat");
		System.out.println("Gently down the stream");
		System.out.println("Merrily, merrily, merrily merrily");
		System.out.println("Life is but a dream. \n\n");
	}	//end method Lyrics

	public static int FourPower(int Number)
	{	int Ans = Number*Number*Number*Number;
		return Ans;
	}

	public static void Random100()
	{	Random Gen = new Random();
		int Rand = Gen.nextInt(100)+1;
		System.out.println(Rand);
	}

	public static int RandomInRange(int min, int max)
	{	Random Gen = new Random();
		int Rand = Gen.nextInt(max-min+1)+min;
		System.out.println(Rand);
		return Rand;
	}

	public static void RandomColor()
	{	Random Genx = new Random();
		Random Geny = new Random();
		Random Genz = new Random();


		int x = Genx.nextInt(256);
		int y = Geny.nextInt(256);
		int z = Genz.nextInt(256);
		Color MyColor = new Color(x, y, z);

	}









}	// end class