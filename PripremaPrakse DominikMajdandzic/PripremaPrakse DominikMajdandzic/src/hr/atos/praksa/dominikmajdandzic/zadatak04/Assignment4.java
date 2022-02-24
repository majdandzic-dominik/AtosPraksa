//04)	Kreiraj program koji ima definirano polje pet razlièitih cjelobrojnih vrijednosti. 
//Program treba provjeriti je li svaka od pet vrijednosti paran ili neparan broj i da li je 
//višekratnik od jednog od iduèih brojeva: 3, 5 ili 11, te ispisati poruku na konzolu u obliku 
//„XY je paran broj“ ili „XY je neparan broj“ te „XY je višekratnik od 3 “ (ili 5 ili 11, zamijeniti broj u tekstu).

package hr.atos.praksa.dominikmajdandzic.zadatak04;

import java.util.Scanner;

public class Assignment4
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int arraySize = 5;
		int[] array = new int[arraySize];

		for (int i = 0; i < arraySize; i++)
		{
			System.out.print("Unesite " + (i + 1) + ". broj: ");
			array[i] = sc.nextInt();
		}
		
		sc.close();

		for (int i = 0; i < arraySize; i++)
		{
			printParity(array[i]);
			printIfMultipleOfThree(array[i]);
		}
	}

	private static void printParity(int number)
	{
		if (number % 2 == 0)
			System.out.println(number + " je paran broj");
		else
			System.out.println(number + " je neparan broj");
	}

	private static void printIfMultipleOfThree(int number)
	{
		if (number % 3 == 0)
			System.out.println(number + " je višekratnik od 3");
	}
}
