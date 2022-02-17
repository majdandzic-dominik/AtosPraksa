//05)	Kreiraj program koji ima definiran po�etak i kraj intervala te jedan broja�. 
//Neka po�etak intervala bude manji od 10, a kraj intervala ve�i od 100. Program treba provjeriti 
//jesu li po�etak i kraj intervala ispravno definirani te ispisati poruku o pogre�ci ukoliko nisu. 
//Ukoliko jesu program treba za svaki broj u zadanom intervalu napraviti sljede�e:
//o	ukoliko je broj manji ili jednak 18, broja� treba pove�ati za 4
//o	ukoliko je broj ve�i od 18, broja� treba umanjiti za 1
//o	ukoliko je broj djeljiv s 20, treba prekinuti procesuiranje tog broja i prije�i na sljede�i
//o	ukoliko je broj jednak ili ve�i od 75, treba prekinuti procesuiranje intervala te ispisati vrijednost broja�a

package hr.atos.praksa.dominikmajdandzic.zadatak05;

import java.util.Scanner;

public class Assignment5
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int intervalStart, intervalEnd, counter = 0;

		System.out.print("Unesite po�etak intervala (mora biti manji od 10): ");
		intervalStart = sc.nextInt();

		System.out.print("Unesite kraj intervala (mora biti ve�i od 100): ");
		intervalEnd = sc.nextInt();

		if (isIntervalValid(intervalStart, intervalEnd))
		{
			for (int i = intervalStart; i <= intervalEnd; i++)
			{
				if (i >= 75)
				{
					System.out.println("Vrijednost broja�a: " + counter);
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
			System.out.println("Gre�ka: po�etak intervala mora biti manji od 10.");
		}
		if (intervalEnd <= 100)
		{
			System.out.println("Gre�ka: kraj intervala mora biti ve�i od 100.");
		}

		return (intervalStart < 10 && intervalEnd > 100);
	}
}
