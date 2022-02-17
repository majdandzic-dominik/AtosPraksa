//08)	Kreiraj program koji æe s konzole uèitati redni broj mjeseca u 
//nekoj prijestupnoj godini. Napraviti provjeru je li uneseni redni broj
//mjeseca ispravan (ne postoji npr. 15. mjesec), a zatim ispisati kalendar tog mjeseca u obliku:
// P  U  S  È  P  S  N
// 1  2  3  4  5  6  7
// 8  9 10 11 12 13 14
//15 16 17 18 19 20 21
//22 23 24 25 26 27 28
//29 30 31
//Pretpostavlja se kako prvi u mjesecu pada na ponedjeljak. Takoðer, 
//treba ispisati onoliko dana koliko ih taj mjesec po klasiènom kalendaru doista ima.

package hr.atos.praksa.dominikmajdandzic.zadatak08;

import java.util.Scanner;

public class Assignment8
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int month;
		int[] daysInMonth =
		{ 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		System.out.print("Unesite redni broj mjeseca: ");
		month = sc.nextInt();

		while (month < 1 || month > 12)
		{
			System.out.print(
					"Redni broj mjeseca nije ispravan, mora biti broj od 1 do 12\r\n" + "Unesite redni broj mjeseca: ");
			month = sc.nextInt();
		}

		printCalendar(daysInMonth[month - 1]);

		sc.close();
	}

	private static void printCalendar(int numOfDays)
	{
		printCalendarHeader();
		printCalendarDays(numOfDays);
	}

	private static void printCalendarHeader()
	{
		System.out.println(" P  U  S  È  P  S  N");
	}

	private static void printCalendarDays(int numOfDays)
	{
		int day = 1;
		for (int i = 0; i <= numOfDays / 7; i++)
		{
			for (int j = 0; (j < 7) && (day <= numOfDays); j++)
			{
				if (day / 10 == 0)
					System.out.print(" " + day);
				else
					System.out.print(day);
				System.out.print(" ");
				day++;
			}
			System.out.println();
		}
	}

}
