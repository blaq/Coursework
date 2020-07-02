import java.util.Scanner;

public class alarm
{	private int x;
		public alarm()
		{	x=0;
		}
		public void getX(int input)
		{	x=input;
		}
		public int setX()
		{	return x;
		}
		public void print()
		{	if(x > 1)
				for(int i=1; i<=x; i++)
					System.out.println("Alarm!");
			else
				System.out.println("An error message");
		}
}
