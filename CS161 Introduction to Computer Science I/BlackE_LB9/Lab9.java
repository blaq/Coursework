// *********************************************
//  Name: Ethan Black         Folder Name:  BlackE_LB9
//  CS161  Winter 2016         Lab #9
//  Mon/Wed/Fri 8:00 am
//  Date:  Mar 9, 2016
//
//   Program Name: Lab9.java
//   Program Description:
//                  Lab #9 exercises
//
//**********************************************
//******************Test Oracle*****************
//1       showed up 0 times.
//2       showed up 3 times.
//3       showed up 2 times.
//4       showed up 4 times.
//5       showed up 3 times.
//6       showed up 3 times.
//7       showed up 1 times.
//8       showed up 2 times.
//9       showed up 5 times.
//10      showed up 0 times.
//**********************************************
import java.util.Random;

public class Lab9
{	public static void main(String[] args)
	{	Random gen = new Random();
		int[] Rand = new int [51];
		for(int i=0;i<=1000;i++)
		{	int ran = gen.nextInt(51);
			Rand[ran]++;
		}

		for(int e=0; e<50; e++)
		{	System.out.println((e+1)+"\tshowed up "+arrayCount(Rand,e)+" times.");
		}
	}
	public static int arrayCount(int[] array, int item)
	{	return array[item];
	}
}
