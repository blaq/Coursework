// *********************************************
//  Name: Ethan Black         Folder Name:  BlackE_LB7
//  CS161  Winter 2016         Lab #7
//  Mon/Wed/Fri 8:00 am
//  Date:  Feb 24, 2016
//
//   Program Name: Lab_7.java
//   Program Description:
//                  Lab #7
//
//**********************************************
//TEST ORACLE
//Golfers:        James  Pete  Harry  Tyrone
//Hole 1 - par 1     0     1     2     3
//Hole 2 - par 2     0     1     2     -1
//Hole 3 - par 3     0     1     -2     -1
//Hole 4 - par 4     0     -3     -2     -1
//
//Jame's score was 43.0 and his average was 2.388888888888889
//Pete's score was 44.0 and his average was 2.4444444444444446
//
//James is the winner!
//*************************************************************
import java.util.Scanner;
import java.io.*;

public class Lab_7
{	public static void main (String[] args) throws IOException
   {	String Name;
    	int James, Pete, Harry, Tyrone, Hole, Par;
      	int Jpar, Ppar, Hpar, Tpar;
      	double Jscore=0, Pscore=0, Hscore=0, Tscore=0;
      	double Javg, Pavg, Havg, Tavg;
      	Scanner filescan, linescan;
      	File myfile = new File("Scores.txt.txt");
      	filescan = new Scanner(myfile);

        System.out.println("Golfers:        James  Pete  Harry  Tyrone");
		while(filescan.hasNext())
		{	String line = filescan.nextLine();
			linescan = new Scanner(line);

			Hole = linescan.nextInt();
        	Par = linescan.nextInt();
        	James = linescan.nextInt();
        	Pete = linescan.nextInt();
       		Harry = linescan.nextInt();
       	 	Tyrone = linescan.nextInt();

			Jpar=James-Par;
			Ppar=Pete-Par;
			Hpar=Harry-Par;
			Tpar=Tyrone-Par;

       	 	System.out.println("Hole "+Hole+" - par "+Par+"     "+Jpar+"     "+Ppar+"     "+Hpar+"     "+Tpar);
			Jscore=Jscore + James;
			Pscore=Pscore + Pete;
			Hscore=Hscore + Harry;
			Tscore=Tscore + Tyrone;


		}
			System.out.println("\n\n");

			Javg=Jscore/18;
			System.out.println("Jame's score was "+Jscore+" and his average was "+Javg);

			Pavg=Pscore/18;
			System.out.println("Pete's score was "+Pscore+" and his average was "+Pavg);

			Havg=Hscore/18;
			System.out.println("Harry's score was "+Hscore+" and his average was "+Havg);

			Tavg=Tscore/18;
			System.out.println("Tyrone's score was "+Tscore+" and his average was "+Tavg);

			System.out.println("\n");

			if(Jscore<Pscore)
			{	if(Jscore<Hscore)
				{	if(Jscore<Tscore)
						System.out.println("James is the winner!");
				}
			}

			if(Pscore<Jscore)
			{	if(Pscore<Hscore)
				{	if(Pscore<Tscore)
						System.out.println("Pete is the winner!");
				}
			}

			if(Hscore<Jscore)
			{	if(Hscore<Pscore)
				{	if(Hscore<Tscore)
						System.out.println("Harry is the winner!");
				}
			}

			if(Tscore<Jscore)
			{	if(Tscore<Pscore)
				{	if(Tscore<Hscore)
						System.out.println("James is the winner!");
				}
			}

         System.out.println("\n");
	}
}