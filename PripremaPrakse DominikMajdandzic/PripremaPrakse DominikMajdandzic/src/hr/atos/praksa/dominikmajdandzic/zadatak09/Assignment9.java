//09)	Luka je vaš dobar prijatelj. Nedavno vam je spomenuo kako bi volio imati 
//grafièko rješenje prikaza njegovog troška struje njegove „krušne“ peæi kroz
//godinu (on je naime pizza majstor i ima svoj restoran). Raèun mu stalno varira,
//ali nikada ne prelazi 4500kn. Prvo ste mu rekli da još ne znate raditi grafièki
//prikaz u Javi, ali vam je bilo žao ne ponuditi mu nikakvo rješenje pa ste na papiru
//nacrtali ovakav graf i rekli da znanje za napraviti ovakav prikaz imate:
//
//5000kn - |
//         |                              x
//4000kn - |       x
//         |
//3000kn - |                      x  x
//         |
//2000kn - |          x
//         |
//1000kn - |    x        x                    x
//         |
//   0kn - | x                 x
//          -- -- -- -- -- -- -- -- -- -- -- --
//           1  2  3  4  5  6  7  8  9 10 11 12
//Takoðer ste mu pojasnili kako æe morati unijeti plaæu za svaki pojedini mjesec, 
//a onda æe program iscrtati graf. Upozorili ste ga kako æe vrijednosti plaæe biti 
//aproksimirane. Primjerice mjeseèna plaæa koja iznosi od 1501kn pa sve do 2500kn,
//na grafu æe biti obilježena iksiæem uz vrijednost 2000kn. On se naposljetku složio
//s vašim prijedlogom i od srca zahvalio. Stoga kreirajte program kojim æete pomoæi Luki.


package hr.atos.praksa.dominikmajdandzic.zadatak09;

import java.util.Scanner;

public class Assignment9
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		
		int[] monthRevenue = new int[12];
		

		for (int i = 0; i < 12; i++)
		{
			System.out.print("Unesite plaæu za " + (i + 1) + ". mjesec: ");
			monthRevenue[i] = sc.nextInt();
		}

		printGraph(monthRevenue);

		sc.close();
	}

	private static void printGraph(int[] monthRevenue)
	{
		int minRevenue = 0, maxRevenue = 5000;

		for (int i = maxRevenue; i >= minRevenue; i -= 1000)
		{
			if (i <= minRevenue)
			{
				System.out.print("   " + i + "kn - |");
				printGraphRow(monthRevenue, i);
			}
			else
			{
				System.out.print(i + "kn - |");
				printGraphRow(monthRevenue, i);
			}

			if (i > minRevenue)
				System.out.println("\r\n         |");
			else
				System.out.println();
		}
		
		printGraphFooter();
	}

	private static void printGraphRow(int[] monthRevenue, int rowValue)
	{
		for (int revenue : monthRevenue)
		{
			if((revenue >= (rowValue - 499)) && (revenue <= (rowValue + 500)))
			{
				System.out.print(" x ");
			}
			else
				System.out.print("   ");
		}
	}
	
	private static void printGraphFooter()
	{
		System.out.print("          -- -- -- -- -- -- -- -- -- -- -- --\r\n"
				+ "           1  2  3  4  5  6  7  8  9 10 11 12\r\n");
		
	}
}
