//10)	Kreiraj java program koji æe pretražiti sve datoteke s ekstenzijama "csv" i "txt" 
//unutar jednog direktorija (foldera) kako bi provjerio nalazi li se u njima definirana 
//tekstualna fraza. Nazive datoteka u kojima se fraza nalazi, ispisat æe na konzolu. 
//Putanju direktorija za pretraživanje kao i tekstualnu frazu treba unijeti s konzole.
//Popis klasa koje bi mogle biti korisne:
//java.io.File (za manipuliranje datotekama / direktorijima)
//java.io.BufferedReader (za èitanje sadržaja datoteke)
//java.lang.String (za manipulaciju sa tekstom)
//
//Fraza usput može biti regular expression.



package hr.atos.praksa.dominikmajdandzic.zadatak10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;

public class Assignment10
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		String folderPath, searchTerm;

		System.out.print("Unesite izraz za pretraživanje: ");
		searchTerm = sc.nextLine();

		System.out.print("Unesite putanju direktorija: ");
		folderPath = sc.nextLine();

		File directory = new File(folderPath);

		FilenameFilter textCsvFilefilter = new FilenameFilter()
		{
			public boolean accept(File dir, String name)
			{
				String lowercaseName = name.toLowerCase();
				if (lowercaseName.endsWith(".txt") || lowercaseName.endsWith(".csv"))
				{
					return true;
				} else
				{
					return false;
				}
			}
		};
		
		File[] directoryContents = directory.listFiles(textCsvFilefilter);

		for (File file : directoryContents)
		{
			try
			{
				BufferedReader reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
				String line;
				Pattern regex = Pattern.compile(searchTerm);
				while ((line = reader.readLine()) != null)
				{
					Matcher matcher = regex.matcher(line);
					if (matcher.find())
					{
						System.out.println(file.getName());
						break;
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
			}
		}

		sc.close();
	}
}
