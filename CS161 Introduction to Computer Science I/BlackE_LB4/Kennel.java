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
import java.util.Scanner;

public class Kennel
{
	public static void main(String[] args)
	{	String Name;
		int Age;
		Dog KennysDog=new Dog("Tesla", 7);
		Dog YourDog=new Dog("Mitsi", 3);
		Dog HisDog=new Dog("Corvey", 5);
		Dog HerDog=new Dog("Lambo", 9);

		Scanner scan1=new Scanner(System.in);

		System.out.println("What's your dog's name?");

		Name=scan1.nextLine();
		YourDog.SetName(Name);
		Age=scan1.nextInt();
		YourDog.SetAge(Age);
		System.out.println(YourDog);

		Scanner scan2=new Scanner(System.in);

		System.out.println("What's his dog's name?");

		Name=scan2.nextLine();
		HisDog.SetName(Name);
		Age=scan2.nextInt();
		HisDog.SetAge(Age);
		System.out.println(HisDog);

		Scanner scan3=new Scanner(System.in);

		System.out.println("What's her dog's name?");

		Name=scan3.nextLine();
		HerDog.SetName(Name);
		Age=scan3.nextInt();
		HerDog.SetAge(Age);
		System.out.println(HerDog);

		Scanner scan4=new Scanner(System.in);

		System.out.println("What's his Kenny's name?");

		Name=scan4.nextLine();
		KennysDog.SetName(Name);
		Age=scan4.nextInt();
		KennysDog.SetAge(Age);
		System.out.println(KennysDog);



	}

}	// end class