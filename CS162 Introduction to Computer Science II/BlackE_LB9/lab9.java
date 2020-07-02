// ***************************************************
//  Name: Ethan Black         Folder Name:  BlackE_LB9
//  CS162  Spring 2016         Lab #9
//  Tue/Thu 10:00
//  Date:  May 30, 2016
//
//   Program Name: lab9.java
//   Program Description:
//                  Lab #9
//
//****************************************************
import  java.util.Scanner;

public class lab9
{
	public static void  main (String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Type a number between 1 and 15\t");
		int num = scan.nextInt();
		while(num > 15 || num<1)
		{
			System.out.println("please give valid number\t");
			num = scan.nextInt();
		}
		print(num);
	}

	public static void print(int n)
	{
		int tabs = 0;
		for(int e=0; e<n; e++)
		{
			for(int u=0; u<=e; u++)
			{
				System.out.print(triangle(e, u)+"\t");
			}
			System.out.println();
		}
	}

	public static int triangle(int e, int u)
	{
		if(u==0)
			return 1;
		else if(u==e)
			return 1;
		else
			return triangle(e-1, u-1)+triangle(e-1, u);
	}
}