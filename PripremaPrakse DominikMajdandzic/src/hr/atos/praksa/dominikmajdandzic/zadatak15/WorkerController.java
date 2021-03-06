package hr.atos.praksa.dominikmajdandzic.zadatak15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class WorkerController
{
	public static Scanner sc = new Scanner(System.in);

	public void addNewWorker(Worker user)
	{
		if (user instanceof Administrator || user instanceof Superuser)
		{
			Worker newWorker;

			System.out.print("Unesite ime: ");
			String name = sc.nextLine();
			System.out.print("Unesite prezime: ");
			String surname = sc.nextLine();
			System.out.print("Unesite radno mjesto: ");
			String workplace = sc.nextLine();
			System.out.print("Unesite OIB: ");
			String oib = sc.nextLine();

			newWorker = new Worker(name, surname, workplace, oib);

			try
			{
				FileOutputStream f = new FileOutputStream(
						System.getProperty("user.dir") + "\\workers\\" + newWorker.getOib() + ".txt");
				ObjectOutputStream o = new ObjectOutputStream(f);

				o.writeObject(newWorker);

				o.close();
				f.close();

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
	}

	public void deleteWorker(String oib, Worker user)
	{
		if (user instanceof Administrator)
		{
			File f = new File(System.getProperty("user.dir") + "\\workers\\" + oib + ".txt");
			if (f.delete())
				System.out.println("Radnik se uspje?no obrisao.");
			else
				System.out.println("Radnik se nije uspio obrisati.");
		}
	}

	public Worker getWorkerByOIB(String oib)
	{
		try
		{
			FileInputStream f = new FileInputStream(System.getProperty("user.dir") + "\\workers\\" + oib + ".txt");
			ObjectInputStream o = new ObjectInputStream(f);

			Worker worker = (Worker) o.readObject();

			o.close();
			f.close();

			return worker;
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public void updateWorker(String oib, Worker user)
	{
		Worker worker = getWorkerByOIB(oib);
		if (user instanceof Administrator)
		{
			String choice;

			System.out.print("?elite li izmjeniti ime? [DA|NE]: ");
			choice = sc.nextLine();
			if (choice.toUpperCase().equals("DA"))
			{
				System.out.print("Unesite novo ime: ");
				worker.setName(sc.nextLine(), user);
			}

			System.out.print("?elite li izmjeniti prezime? [DA|NE]: ");
			choice = sc.nextLine();
			if (choice.toUpperCase().equals("DA"))
			{
				System.out.print("Unesite novo prezime: ");
				worker.setSurname(sc.nextLine(), user);
			}

			System.out.print("?elite li izmjeniti radno mjesto? [DA|NE]: ");
			choice = sc.nextLine();
			if (choice.toUpperCase().equals("DA"))
			{
				System.out.print("Unesite novo radno mjesto: ");
				worker.setWorkplace(sc.nextLine(), user);
			}

			System.out.print("?elite li izmjeniti OIB? [DA|NE]: ");
			choice = sc.nextLine();
			if (choice.toUpperCase().equals("DA"))
			{
				deleteWorker(worker.getOib(), user);
				System.out.print("Unesite novi OIB: ");
				worker.setOib(sc.nextLine(), user);
			}

			try
			{
				FileOutputStream f = new FileOutputStream(
						System.getProperty("user.dir") + "\\workers\\" + worker.getOib() + ".txt");
				ObjectOutputStream o = new ObjectOutputStream(f);

				o.writeObject(worker);

				o.close();
				f.close();

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
	}

	public void listAllWorkers()
	{
		File directory = new File(System.getProperty("user.dir") + "\\workers");

		FilenameFilter textFilefilter = new FilenameFilter()
		{
			public boolean accept(File dir, String name)
			{
				String lowercaseName = name.toLowerCase();
				if (lowercaseName.endsWith(".txt"))
				{
					return true;
				} else
				{
					return false;
				}
			}
		};

		File[] directoryContents = directory.listFiles(textFilefilter);

		for (File f : directoryContents)
		{
			System.out.println(f.getName().replaceFirst("[.][^.]+$", ""));
		}
	}

}
