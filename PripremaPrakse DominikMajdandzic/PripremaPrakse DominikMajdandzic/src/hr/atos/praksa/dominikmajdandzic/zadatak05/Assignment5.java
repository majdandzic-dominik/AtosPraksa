//05)	Kreiraj program koji ima definiran poèetak i kraj intervala te jedan brojaè. 
//Neka poèetak intervala bude manji od 10, a kraj intervala veæi od 100. Program treba provjeriti 
//jesu li poèetak i kraj intervala ispravno definirani te ispisati poruku o pogrešci ukoliko nisu. 
//Ukoliko jesu program treba za svaki broj u zadanom intervalu napraviti sljedeæe:
//o	ukoliko je broj manji ili jednak 18, brojaè treba poveæati za 4
//o	ukoliko je broj veæi od 18, brojaè treba umanjiti za 1
//o	ukoliko je broj djeljiv s 20, treba prekinuti procesuiranje tog broja i prijeæi na sljedeæi
//o	ukoliko je broj jednak ili veæi od 75, treba prekinuti procesuiranje intervala te ispisati vrijednost brojaèa

package hr.atos.praksa.dominikmajdandzic.zadatak05;

import java.util.Scanner;

public class Assignment5
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int intervalStart, intervalEnd, counter = 0;

		System.out.print("Unesite poèetak intervala (mora biti manji od 10): ");
		intervalStart = sc.nextInt();

		System.out.print("Unesite kraj intervala (mora biti veæi od 100): ");
		intervalEnd = sc.nextInt();

		if (isIntervalValid(intervalStart, intervalEnd))
		{
			for (int i = intervalStart; i <= intervalEnd; i++)
			{
				if (i >= 75)
				{
					System.out.println("Vrijednost brojaèa: " + counter);
					break;
				} 
				else if (i % 20 == 0)
					continue;
				else if (i <= 18)
					counter += 4;
				else
					counter -= 1;
			}
		}

		sc.close();
	}

	private static boolean isIntervalValid(int intervalStart, int intervalEnd)
	{
		if (intervalStart >= 10)
		{
			System.out.println("Greška: poèetak intervala mora biti manji od 10.");
		}
		if (intervalEnd <= 100)
		{
			System.out.println("Greška: kraj intervala mora biti veæi od 100.");
		}

		return (intervalStart < 10 && intervalEnd > 100);
	}
}
