package hr.atos.praksa.dominikmajdandzic.zadatak15;

import java.io.File;
import java.util.Scanner;

public class WorkerController
{
	public static Scanner sc = new Scanner(System.in);
	public static FileReaderWriter frw = new FileReaderWriter();
	
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

			frw.writeWorkerToFile(newWorker);
		}
	}

	public void deleteWorker(String oib, Worker user)
	{
		if (user instanceof Administrator)
		{
			frw.deleteFile(oib, "workers");
		}
	}

	public Worker getWorkerByOIB(String oib)
	{
		return frw.readWorkerFromFile(oib);
	}

	public void updateWorker(String oib, Worker user)
	{
		Worker worker = getWorkerByOIB(oib);
		if (user instanceof Administrator)
		{
			String choice;

			System.out.print("�elite li izmjeniti ime? [DA|NE]: ");
			choice = sc.nextLine();
			if (choice.toUpperCase().equals("DA"))
			{
				System.out.print("Unesite novo ime: ");
				worker.setName(sc.nextLine(), user);
			}

			System.out.print("�elite li izmjeniti prezime? [DA|NE]: ");
			choice = sc.nextLine();
			if (choice.toUpperCase().equals("DA"))
			{
				System.out.print("Unesite novo prezime: ");
				worker.setSurname(sc.nextLine(), user);
			}

			System.out.print("�elite li izmjeniti radno mjesto? [DA|NE]: ");
			choice = sc.nextLine();
			if (choice.toUpperCase().equals("DA"))
			{
				System.out.print("Unesite novo radno mjesto: ");
				worker.setWorkplace(sc.nextLine(), user);
			}

			System.out.print("�elite li izmjeniti OIB? [DA|NE]: ");
			choice = sc.nextLine();
			if (choice.toUpperCase().equals("DA"))
			{
				deleteWorker(worker.getOib(), user);
				System.out.print("Unesite novi OIB: ");
				worker.setOib(sc.nextLine(), user);
			}
			System.out.print("�elite li izmjeniti broj odra�enih sati? [DA|NE]: ");
			choice = sc.nextLine();
			if (choice.toUpperCase().equals("DA"))
			{
				System.out.print("Unesite novi broj odra�enih sati: ");
				worker.setOib(sc.nextLine(), user);
			}

			frw.writeWorkerToFile(worker);

		}
	}

	public void listAllWorkers()
	{
		File[] directoryContents = frw.getAllTxtFilesInFolder("workers");

		for (File f : directoryContents)
		{
			System.out.println(f.getName().replaceFirst("[.][^.]+$", ""));
		}		
	}

}
