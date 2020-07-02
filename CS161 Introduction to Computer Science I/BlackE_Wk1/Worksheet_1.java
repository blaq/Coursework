// *********************************************
//  Name: Ethan Black         Folder Name:  BlackE_Wk1
//  CS161  Winter 2016         Worksheet #1
//  Mon/Wed/Fri 8:00 am
//  Date:  Jan 8, 2016
//
//   Program Name: Worksheet1.java
//   Program Description:
//                  Worksheet #1 exercises
//
//**********************************************
import java.util.Scanner;

public class Worksheet_1
{ public static void main(String[] args)
   {
   		Scanner scan=new Scanner(System.in);

   		char omega=scan.findInLine(".").charAt(0);

		if(Character.isUpperCase(omega))
   			System.out.println("true");
		else
			System.out.println("false");


  }
}