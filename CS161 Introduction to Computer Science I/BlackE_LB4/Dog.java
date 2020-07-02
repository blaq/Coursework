// *********************************************
//  Name: Ethan Black         Folder Name:  BlackE_Lb4
//  CS161  Winter 2016         Lab #4
//  Mon/Wed/Fri 8:00 am
//  Date:  Feb 3, 2016
//
//   Program Name: Lab3.java
//   Program Description:
//                  Lab #4
//
//**********************************************

public class Dog
{	private String Name;
	private int Age;

	public Dog(String Nm, int Old)
	{	Name=Nm;
		Age=Old;
	}

	public String toString()
	{	String Result;
		Result="Name: "+Name+" Age: "+Age;
		Result+=" In dog years, it is "+PersonYears()+".";
		return Result;
	}

	public void SetName(String Nm)
	{	Name=Nm;
	}

	public void SetAge(int Old)
	{	Age=Old;
	}

	public String GetName()
	{	return Name;
	}


	public int GetAge()
	{	return Age;
	}

	public int PersonYears()
	{	int Old;
		Old=Age*7;
		return Old;
	}





}	// end class