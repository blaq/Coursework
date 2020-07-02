// *********************************************
//  Name: Ethan Black         Folder Name:  BlackE_Wk6
//  CS161  Winter 2016         Worksheet #6
//  Mon/Wed/Fri 8:00 am
//  Date:  Feb 12, 2016
//
//   Program Name: Worksheet_6.java
//   Program Description:
//                  Worksheet #6
//
//**********************************************
import java.util.Scanner;

public class Worksheet_6
{	public static void main(String[] args)
	{	Scanner Fred=new Scanner(System.in);
	/*
		System.out.println("Today we practice writing loops ");
		System.out.println("Here is the first loop: \n");
		int count=1;
		while (count<10)
		{	System.out.println("Hello - my name is Jack.... ");
				count=count+1;
		}


		System.out.println("How many times do you want me to go? ");

		// using decrement to control a loop
		int Stuff=Fred.nextInt();
		while(Stuff>0)
		{	System.out.println("Here comes Peter Cottontail, hopping down the bunny trail");
			Stuff=Stuff+1;
		}

		//summation loop
		int Number;
		int Total=0;
		while (Total>0)
		{	System.out.print("Enter number of tickets sold: ");
			Number=Fred.nextInt();
			Total=Total+Number;
		}
		System.out.println("Total is: "+Total);



		int Ast=0;
		while(Ast<10)
		{	System.out.println("****************************************");
			Ast=Ast+1;
		}

		int DL=0;
		while(DL<50)
		{	System.out.print("@");
			DL=DL+1;
		}
	*/

		char Again='Y';
		while(Again!='N')
		{
		long product=1;
		int count=0;
		System.out.println("This program will generate a table of powers of a number.");
		System.out.println("You just have to tell me what number: \n\n");
		System.out.print("Enter an integer please: ");
		int MyNum=Fred.nextInt();
		while(count<15)
		{	product=product*MyNum;

			System.out.print(product+", ");
			count++;
			if(count%5==0)
				System.out.println();
		}
		System.out.println("Bye for now.....");
		System.out.println("\n\n\nTry another number (y/n)? ");
		String Word=Fred.next();
		Word=Word.toUpperCase();
		Again=Word.charAt(0);
		}


	System.out.println("\n\n\n\n\n");

	}
}