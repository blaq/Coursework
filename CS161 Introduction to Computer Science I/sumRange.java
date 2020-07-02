import java.util.Scanner;

public class sumRange
{	private int n1, n2;
	public sumRange()
	{	n1=0;
		n2=0;
	}
	public void getN1(int N1)
	{	n1=N1;
	}
	public void getN2(int N2)
	{	n2=N2;
	}
	public int setN1()
	{	return n1;
	}
	public int setN2()
	{	return n2;
	}
	public void print()
	{	double i, x=0;
		if(n1<n2)
		{	for(i=0; n1<=n2; i++, n1++)
			x+=n1;
			x=x/i;
			System.out.println("Set your range "+x);
		}
		else
			System.out.println("An error message");
	}




}