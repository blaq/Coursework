// *********************************************
//  Name: Ethan Black         Folder Name:  BlackE_Wk7
//  CS161  Winter 2016         Worksheet #7
//  Mon/Wed/Fri 8:00 am
//  Date:  Feb 19, 2016
//
//   Program Name: Worksheet_7.java
//   Program Description:
//                  Worksheet #7
//
//**********************************************
import java.util.Scanner;

public class Worksheet_7
{	public static void main(String[] args)
	{	Scanner Fred=new Scanner(System.in);

		System.out.println("Today we practice using switch statements \n\n");
		char Ans;
		char DoMore='Y';
		String Word;
		boolean flag=false;
		while(DoMore=='Y'||DoMore=='y')
		{	while(flag==false)
			{	System.out.println("What kind of car do you drive?");
				System.out.println("(F)ord, (C)hevy, (B)uick, (M)azda, (H)onda, (S)uburu, (T)esla");
				Word=Fred.next();
				Word=Word.toUpperCase();
				Ans=Word.charAt(0);

				switch (Ans)
				{	case 'C': System.out.println("Chevy-the heartbeat of America");
							  System.out.println("Chevy Chase");
							  flag=false;
							  break;
					case 'F': System.out.println("Ford tough");
							  System.out.println("Henry Ford");
							  flag=false;
							  break;
					case 'B': System.out.println("Buick-Luxury you can afford");
							  System.out.println("Make you Buick");
							  flag=false;
							  break;
					case 'M': System.out.println("Mazda-Zoom, Zoom");
							  System.out.println("Amazda");
							  flag=false;
							  break;
					case 'H': System.out.println("Honda-Always dependable");
							  System.out.println("Hondastly");
							  flag=false;
							  break;
					case 'S': System.out.println("Suburu, Super You");
							  System.out.println("eh");
							  flag=false;
							  break;
					case 'T': System.out.println("Telsa Powered");
							  System.out.println("A man's car.");
							  flag=true;
							  break;
					default:  System.out.println("Get a better car....");
							  System.out.println("Loser");
							  flag=false;
							  break;
				}

				System.out.println("That wasn't the car I was looking for.");
			}




			System.out.println("Try Again? (Y/N)");
			Word=Fred.next();
			Word=Word.toUpperCase();
			DoMore=Word.charAt(0);
		}

		System.out.println("\n\n done for now..");
	}
}