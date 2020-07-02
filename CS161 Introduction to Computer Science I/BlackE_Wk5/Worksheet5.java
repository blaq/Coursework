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

public class Worksheet5
{	public static void main(String [] args)
	{	Scanner scan = new Scanner(System.in);
		System.out.println("Today we practice writing methods again ");
		System.out.println("Here is the first method: \n");
		Practice5.Lyrics();

		System.out.println("Here it is again:\n");
		Practice5.Lyrics();

		System.out.println(" 2 to the fourth power is: "+Practice5.FourPower(2));
		System.out.println(" 6 to the fourth power is: "+Practice5.FourPower(6));

		Practice5.Random100();

		Practice5.RandomInRange(2, 19);
		Practice5.RandomInRange(50, 95);

		int First, Second;
		System.out.print("First: ");
		First = scan.nextInt();
		System.out.print("Second: ");
		Second = scan.nextInt();

		Practice5.RandomInRange(First, Second);

		Practice5.RandomColor();

		System.out.println("\n\n\n");
	}	//end method main()



}	//end class