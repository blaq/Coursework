import  java.util.Scanner;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Towers
{
	private int disks, i=0, move=0;
	private int[][] moves = new int[50][2];

	public Towers(int n)
	{
		disks=n;
	}

	public void print()
	{
		File file = new File ("Cheats.txt");
		try
		{
			PrintWriter OF = new PrintWriter(file);
			for(i=0;i<moves.length; i++)
			{						//print array contents into file
				if(moves[i][0]!=0)
				{
					OF.println("Move peg "+moves[i][0]+" to peg "+moves[i][1]);
				}
			}
			OF.close();
		}

      	catch(FileNotFoundException e)
      	{
			System.out.println("Can't find "+file);
		}
	}

	public void solve()				//set values for recursion
	{
		Move(disks, 1, 3, 2);
	}

	private void Move(int num, int first, int last, int temp)
	{								//solve for next move
		if(num == 1)				//recursive method
			Mod(first, last);
		else
		{
			Move(num-1, first, temp, last);
			Mod(first, last);
			move++;
			Move(num-1, temp, last, first);
		}
	}

	private void Mod(int first, int last)
	{								//put moves in array
		if(moves[move][0]==0)
		{
			moves[move][0]=first;
			moves[move][1]=last;
		}
		else
		{
			move++;
			moves[move][0]=first;
			moves[move][1]=last;
		}
	}
}