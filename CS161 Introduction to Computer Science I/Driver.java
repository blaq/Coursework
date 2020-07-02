// *********************************************
//  Name: Ethan Black         Folder Name:  BlackE
//  CS161  Winter 2016         Assignment #6
//  Mon/Wed/Fri 8:00 am
//  Date:  Feb 11, 2016
//
//   Program Description:
//                  Assignment #6
//
//**********************************************
import java.util.Scanner;

public class Driver
{	public static void main(String [] args)
	{	Scanner scan=new Scanner(System.in);

		System.out.println("Give me an integer. ");

		int First=scan.nextInt();

		System.out.print(First+" is "+Cube.ThirdPower(First)+" to the third power.");
		System.out.print("\n\n\n");
	}

}