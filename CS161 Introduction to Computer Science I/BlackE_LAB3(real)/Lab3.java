// *********************************************
//  Name: Ethan Black         Folder Name:  BlackE_Lb3
//  CS161  Winter 2016         Lab #3
//  Mon/Wed/Fri 8:00 am
//  Date:  Jan 26, 2016
//
//   Program Name: Lab3.java
//   Program Description:
//                  Lab #3
//
//**********************************************
//**********************************************
//Test Oracle
//First    Last    Username
//Ethan    Black   EBlackXX
//George   Foreman GForeXX
//Eliz     Manelly EManeXX
//**********************************************
import java.util.Scanner;
import java.util.Random;

public class Lab3
{ public static void main(String[] args)
   {
	Scanner word = new Scanner(System.in);

	String first, last;
	System.out.println("What's your first name, pal?");
	first = word.nextLine();
	System.out.println("\n" );

	System.out.println("Cool. And your last name?");
	last = word.nextLine();
	System.out.println("\n");

	char num1 = first.charAt(0);
	String num2 = last.substring(0,5);

	Random r = new Random();
	int r1 = r.nextInt(90)+10;

	System.out.println("Here's your new username - "+num1+num2+r1+"\n\n\n");




  }
}