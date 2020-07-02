// *********************************************
//  Name: Ethan Black         Folder Name:  BlackE_LB8
//  CS162  Spring 2016         Lab #8
//  Tue/Thu 10:00
//  Date:  May 23, 2016
//
//   Program Name: Drive.java
//   Program Description:
//                  Lab #8
//
//**********************************************
import  java.util.Scanner;
import java.io.*;

public class lab8
{
	public static void  main (String[] args) throws IOException
	{
		int Items, count = 0;
		double Sale;
		String Name;
		char work = 'y';
		String Code, Input;
		Scanner scan = new Scanner (System.in);
		Doc[] ument = new Doc[50];
		PrintWriter OF = new PrintWriter(new File("OutFile.txt"));
		System.out.println("Enter receipts here");
		System.out.println("------------------------------------------");

      	while(work != 'n')
      	{

      		System.out.print("Enter the customer name:\t\t\t\t");
		    Name = scan.next();
		    System.out.print("Enter the amount of items:\t\t\t\t");
		    Items = scan.nextInt();
		    System.out.print("Enter the total amount of sale:\t\t\t\t");
      		Sale = scan.nextDouble();
			System.out.println("Enter the 2 digit document code with a U, C, or P");
			System.out.print("(U = Unclassified, C = Confidential, P = Proprietary):\t");
			try
			{
				Code = scan.next();
				Code = Code.toUpperCase();
				if(!Code.startsWith("U")&&!Code.startsWith("C")&&!Code.startsWith("P"))
					throw new Exception();
			}

      		catch(Exception e)
      		{
      			System.out.print("Oops! Try that one again:\t\t\t\t");
        		Input = scan.next();
        		Code = Input;
      		}
			ument[count] = new Doc(Name, Items, Sale, Code);
			System.out.println();
			System.out.print("Would you like to do another? (Y/N):\t\t\t");
			work = scan.next().charAt(0);
			System.out.println();
		}

		OF.println();
		OF.println("\t\t\tReciepts");
		OF.println("-----------------------------------------------------");

		for(int i=0; i<ument.length; i++)
		{
			if(ument[i] != null)
			{	System.out.println(ument[i]);
				OF.println(ument[i]);
			}
		}
		OF.close();
	}
}

class Doc
{
	private String code, name;
	private int items;
	private double sale;

	public Doc(String Name, int Items, double Sale, String Code)
	{
		code = Code;
		items = Items;
		sale = Sale;
		name = Name;
	}

	public String getName()
	{	return name;
	}

	public int getItems()
	{	return items;
	}

	public double getSale()
	{	return sale;
	}

	public String getCode()
	{	return code;
	}

	public String toString()
	{	String result = name+"\t"+items+"\t"+sale+"\t"+code;
		return result;
	}
}
