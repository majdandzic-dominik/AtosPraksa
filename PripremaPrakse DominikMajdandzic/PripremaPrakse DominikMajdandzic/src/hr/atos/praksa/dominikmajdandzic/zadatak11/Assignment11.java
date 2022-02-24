//11)	Kreiraj program koji æe omoguæiti interakciju s korisnikom na 
//jednom od tri ponuðena jezika. Interakcija se treba sastojati od nekoliko 
//meðusobno izmijenjenih poruka. Prijevodi na pojedini jezik trebaju 
//biti dostupni unutar java properties datoteka za svaki jezik odvojeno.

package hr.atos.praksa.dominikmajdandzic.zadatak11;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Assignment11
{

	public static void main(String[] args)
	{
		Properties config = new Properties();
		FileInputStream fis;
		Scanner sc = new Scanner(System.in);
		int selector, healthCounter = 0, numOfQuestions = 0, questionStartNum = 1;
		String selectedLanguage = "", healthResult = "";

		try
		{
			fis = new FileInputStream(System.getProperty("user.dir") + "\\resources\\config.properties");
			config.load(fis);
			numOfQuestions = Integer.parseInt(config.getProperty("numOfQuestions"));
			questionStartNum = Integer.parseInt(config.getProperty("questionStartNum"));
		} catch (IOException io)
		{
			io.printStackTrace();
		}

		System.out.print("Select language | Odaberite jezik | Sprache auswählen\r\n"
				+ "[1 FOR ENGLISH  | 2 ZA HRVATSKI   | 3 FÜR DEUTSCH]: ");

		do
		{
			selector = sc.nextInt();
			if (selector == 1)
				selectedLanguage = "ENG";
			else if (selector == 2)
				selectedLanguage = "CRO";
			else if (selector == 3)
				selectedLanguage = "GER";
			else
				System.out.print(
						"Invalid input, input number 1-3 | Neispravan unos, unesite broj 1-3 | Ungültige Eingabe, Eingabenummer 1-3: ");
		} while (selector < 1 || selector > 3);

		for (int i = questionStartNum; i < (numOfQuestions + 1); i++)
		{
			System.out.print(config.getProperty("Question" + i + selectedLanguage));
			do
			{
				selector = sc.nextInt();
				if (selector != 0 && selector != 1)
					System.out.print(
							"Invalid input, input number 0-1 | Neispravan unos, unesite broj 0-1 | Ungültige Eingabe, Eingabenummer 0-1: ");
			} while (selector != 0 && selector != 1);
			healthCounter += selector;
		}

		if (healthCounter <= numOfQuestions / 2)
			healthResult = "Bad";
		else if (healthCounter > numOfQuestions / 2)
			healthResult = "Good";

		System.out.println(config.getProperty("Result" + healthResult + selectedLanguage));

		sc.close();
	}

}
