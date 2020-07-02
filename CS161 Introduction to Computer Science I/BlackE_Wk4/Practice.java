// *********************************************
//  Name: Ethan Black         Folder Name:  BlackE_Wk4
//  CS161  Winter 2016         Practice
//  Mon/Wed/Fri 8:00 am
//  Date:  Jan 29, 2016
//
//   Program Name: Practice.java
//   Program Description:
//                  Practice
//
//**********************************************

public class Practice
	{private int Number;
	 private char Thing;

		public String toString()
	 		{String Result;
	 		 Result = "Number is: "+Number+" Thing is: "+Thing;
	 		 return Result;
			}

	 public void Story()
	 	{System.out.println(" This is a cute little method that only prints things");
	 	 System.out.println(" First we will print the value of the integer: "+Number);
	 	 System.out.println(" Now we print the character: "+Thing);
	 	 System.out.println(" Number and Thing are called instance variables");
	 	 System.out.println(" This is a method called \"Story\" " );
	 	 System.out.println(" ... And now we are done :)");
		}

	public long SixTimes()
		{long BigNum;
		 BigNum=Number*Number*Number*Number*Number*Number;
		 return BigNum;
		}

	 public Practice(int Num, char Ans)	//constructor
	 	{Number = Num;
	 	 Thing = Ans;
	 	}
	public int setNumber(int real)
		{
			Number = real;
			return Number;
		}

	 }	//end class