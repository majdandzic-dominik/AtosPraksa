//12)	Napraviti program koji æe omoguæiti korisniku ispis statistike broja pojedinih rijeèi unutar datoteke koju odabere. Rijeèi trebaju biti poredane po abecedi i treba ignorirati velika/mala slova. Ispod se nalazi primjer ispisa:
//U datoteci XX nalaze se sljedece rijeci:
//------------------------
//Rijec (broj ponavljanja)
//------------------------
//auto (17)
//auta (2)
//boje (19)
//cipele (3)
//je (39)
//su (110)
//trava (1)
//zeleno (2)
//------------------------



package hr.atos.praksa.dominikmajdandzic.zadatak12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Assignment12
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		String filePath;

		HashMap<String, Integer> uniqueWordCountMap = new HashMap<String, Integer>();

		System.out.print("Unesite putanju datoteke: ");
		filePath = sc.nextLine();


		File file = new File(filePath);
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
			String line;
			while ((line = reader.readLine()) != null)
			{
				String[] words = line.toLowerCase().split("\\W+");
				
				for (String word : words)
				{
					if (uniqueWordCountMap.containsKey(word))
					{
						uniqueWordCountMap.put(word, uniqueWordCountMap.get(word) + 1);
					} else
					{
						uniqueWordCountMap.put(word, 1);
					}
				}
			}
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			if(uniqueWordCountMap != null)
			{
				Map<String, Integer> sortedMap = new TreeMap<String, Integer>(uniqueWordCountMap);
				System.out.print("U datoteci "+ file.getName() +" nalaze se sljedece rijeci:\r\n"
						+ "------------------------\r\n"
						+ "Rijec (broj ponavljanja)\r\n"
						+ "------------------------\r\n");
				for(String key : sortedMap.keySet())
				{
					System.out.println(key + " (" + sortedMap.get(key) + ")");
				}
				System.out.print("------------------------\r\n");
			}
		}

		sc.close();
	}
}
