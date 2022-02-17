//07)	Kreiraj program koji æe ispisati koliko ima brojeva djeljivih sa 6 
//u intervalu izmeðu neka dva prirodna broja unesena s konzole.

package hr.atos.praksa.dominikmajdandzic.zadatak07;

import java.util.Scanner;

public class Assignment7
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		int intervalStart, intervalEnd, temp, counter = 0;

		System.out.print("Unesite prvi broj: ");
		intervalStart = sc.nextInt();

		System.out.print("Unesite drugi broj: ");
		temp = sc.nextInt();

		if (temp < intervalStart)
		{
			intervalEnd = intervalStart;
			intervalStart = temp;
		} else
		{
			intervalEnd = temp;
		}

		for (int i = intervalStart; i <= intervalEnd; i++)
		{
			if (i % 6 == 0 && i != 0)
				counter++;
		}

		System.out.println("Ima " + counter + " brojeva dijelivih s 6");

		sc.close();
	}
}
