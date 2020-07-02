// *********************************************
//  Name: Ethan Black         Folder Name:  BlackE_Wk9
//  CS161  Winter 2016         Worksheet #9
//  Mon/Wed/Fri 8:00 am
//  Date:  Mar 4, 2016
//
//   Program Name: Worksheet_9.java
//   Program Description:
//                  Worksheet #9
//
//**********************************************
import java.util.Scanner;
import java.util.Random;

public class Worksheet_9
{	public static void main(String[] args)
	{	Scanner MyScan = new Scanner(System.in);
		int Number, count=0;
		Random gen = new Random();
		System.out.println("Today we practice using arrays \n\n");
		System.out.print("How many integers do you want in your array today? ");
		Number = MyScan.nextInt();
	/*	int[] MyArray = new int[Number];
		for(int i = 0; i<=MyArray.length-1; i++)
		{	MyArray[i] = gen.nextInt((94-7)+1)+7;
			if(i % 8 == 0)
				System.out.println();
			System.out.print(MyArray[i]+"\t");
			count=i;
		}
		System.out.println("\n\n"+count);


		double[] Stuff = new double[30];
		for(int i = 0; i<=Stuff.length-1; i++)
		{	Stuff[i] = gen.nextDouble() * gen.nextInt((100-1)+1);
			if(i % 5 == 0)
				System.out.println();
			System.out.print(Stuff[i]+"\t");
			count=i;
		}

		System.out.println(Stuff[-3]);

		char[] Vowels = {'a', 'e', 'i', 'o', 'u'};
		for(int i = 0; i<=Vowels.length-1; i++)
		{	System.out.println(Vowels.length);
		}

		String[] Friends = new String[10];
		Friends[1] = "Tiny Tim";
		Friends[2] = "Fred Flintstone";
		Friends[3] = "Hattrick Sam";
		Friends[4] = "Barney Rubble";
		Friends[5] = "Jimmeny Snickers";
		for(int i = 0; i<=Friends.length-1; i++)
		{	System.out.println(Friends[i]);
		}
	*/

		String[] DaysOfWeek = new String[7];
		DaysOfWeek[0] = "Sunday";
		DaysOfWeek[1] = "Monday";
		DaysOfWeek[2] = "Tuesday";
		DaysOfWeek[3] = "Wednesday";
		DaysOfWeek[4] = "Thursday";
		DaysOfWeek[5] = "Friday";
		DaysOfWeek[6] = "Saturday";
		for(int i = 0; i<=DaysOfWeek.length-1; i++)
		{	System.out.println(DaysOfWeek[i]);
		}

		System.out.println("\n\n"+count);

    	System.out.println("\n\n done for now..");
	}
}