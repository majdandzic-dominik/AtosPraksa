//06)	Kreiraj program koji æe koristeæi for petlje automatizirati ispis tablice množenja u ovom obliku:
//-------------------------------
//: : :  TABLICA  MNOZENJA  : : :
//-------------------------------
// * |  1  2  3  4  5  6  7  8  9
//-------------------------------
// 1 |  1  2  3  4  5  6  7  8  9
// 2 |  2  4  6  8 10 12 14 16 18
// 3 |  3  6  9 12 15 18 21 24 27
// 4 |  4  8 12 16 20 24 28 32 36
// 5 |  5 10 15 20 25 30 35 40 45
// 6 |  6 12 18 24 30 36 42 48 54
// 7 |  7 14 21 28 35 42 49 56 63
// 8 |  8 16 24 32 40 48 56 64 72
// 9 |  9 18 27 36 45 54 63 72 81
//-------------------------------
//:  :  :  :  :  :  :  :  :by Ime
//-------------------------------
//Umjesto "Ime" treba ispisati ime uneseno s konzole i pri tome pripaziti da zadnje slovo imena bude poravnato s desnim rubom tablice.

package hr.atos.praksa.dominikmajdandzic.zadatak06;

import java.util.Scanner;

public class Assignment6
{
	private static int tableWidth = 31, footerFreeSpace = tableWidth - 3; // 3 je broj znakova "by "

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String name = "";
		do
		{
			System.out.print("Unesite vaše ime (minimalno 1 znak, maksimalno " + footerFreeSpace + " znakova): ");
			name = sc.nextLine();
		} while (name.length() == 0 || name.length() > footerFreeSpace);

		printTable(name);

		sc.close();
	}

	private static void printTable(String name)
	{
		printTableHeader();
		printTableRows();
		printTableFooter(name);
	}

	private static void printTableHeader()
	{
		printSeparatorLine();
		System.out.println(": : :  TABLICA  MNOZENJA  : : :");
		printSeparatorLine();
		System.out.println(" * |  1  2  3  4  5  6  7  8  9");
		printSeparatorLine();
	}

	private static void printSeparatorLine()
	{
		for (int i = 0; i < tableWidth; i++)
		{
			System.out.print("-");
		}
		System.out.println();
	}

	private static void printTableRows()
	{
		for (int i = 1; i <= 9; i++)
		{
			System.out.print(" " + i + " |");
			for (int j = 1; j <= 9; j++)
			{
				System.out.print("  " + j);
			}
			System.out.println();
		}
	}

	private static void printTableFooter(String name)
	{
		printSeparatorLine();
		int newFreeSpace = footerFreeSpace - name.length();

		for (int i = 0; i < newFreeSpace - 3; i += 3)
		{
			System.out.print(":  ");
		}
		if (name.length() % 3 == 1)
			System.out.print(":  ");
		else if (name.length() % 3 == 2)
			System.out.print(": ");
		else if (name.length() % 3 == 0)
			System.out.print(":");

		System.out.print("by " + name + "\r\n");
		printSeparatorLine();
	}

}
