//15)	Za jednu tvrtku potrebno je napraviti demo aplikaciju u kojoj �e mo�i raditi 
//administraciju zaposlenika te njihbovih radnih zadataka. Ovo su im najbitniji podatci:
//Zaposlenici
//  ime
//  prezime
//  radno mjesto
//  oib
//
//Zadaci
//  naziv
//  opis
//  tip (bug, task)
//  trenutni status (otvoren, zatvoren, u tijeku)
//  kompleksnost (broj)
//  potro�eno vrijeme (sati)
//  po�etni datum i vrijeme
//  zavr�ni datum i vrijeme
//  (napomena, po�etak i zavr�etak ne zna�e nu�no da je potro�eno vrijeme njihova razlika)
//Potrebno je omogu�iti administraciju na nekoliko razina tj. potrebno je definirati korisni�ka 
//prava korisnika aplikacije po grupama: "admin", "superuser" i "user" tako da se omogu�e sljede�e akcije:
//o	kreiranje zadataka i zaposlenika (admin, superuser)
//o	izlistanje zadataka i zaposlenika (admin, superuser, user)
//o	izmjena zadataka i zaposlenika (admin)
//o	brisanje zadataka i zaposlenika (admin)
//Naposljetku aplikacija mora omogu�iti kreiranje izvje�taja:
//o	po radnom mjestu tj. koliko radnika radi na pojedinom radnom mjestu
//o	utro�eno vrijeme po osobi
//o	najdu�e otvoren zadatak
//Izvje�taje mogu kreirati samo korisnici s admin ili superuser pravima.
//Su�elje za komunikaciju s korisnicima neka bude konzola, a podaci se trebaju spremati u tekstualne datoteke ili bazu podataka po izboru.

package hr.atos.praksa.dominikmajdandzic.zadatak15;

import java.util.Scanner;

public class Assignment15
{
	private static Scanner sc = new Scanner(System.in);
	private static int selector;
	private static TaskController tc = new TaskController();
	private static WorkerController wc = new WorkerController();
	private static ReportGenerator rg = new ReportGenerator();

	public static void main(String[] args)
	{
		SelectUserLevel();
	}

	private static void SelectUserLevel()
	{
		String workerLevel;
		
		System.out.print("Unesite razinu korisnika [NORMAL | SUPERUSER | ADMIN]: ");
		workerLevel = sc.nextLine();
		while (!"NORMAL".equals(workerLevel.toUpperCase()) && !"SUPERUSER".equals(workerLevel.toUpperCase())
				&& !"ADMIN".equals(workerLevel.toUpperCase()))
		{
			System.out.print("Une�ena razina korisnika ne postoji, poku�aj ponovno [NORMAL | SUPERUSER | ADMIN]: ");
			workerLevel = sc.nextLine();
		}
		
		switch (workerLevel.toUpperCase())
		{
		case "NORMAL":
			SelectGeneralAction(new Worker(null, null, null, null));
			break;
		case "SUPERUSER":
			SelectGeneralAction(new Superuser(null, null, null, null));
			break;
		case "ADMIN":
			SelectGeneralAction(new Administrator(null, null, null, null));
			break;
		default:
			System.out.println("GRE�KA!");
			break;
		}		
	}
	
	private static void SelectGeneralAction(Worker user)
	{
		do
		{
			System.out
					.print("[1 = kontrola korisnika | 2 = kontrola zadataka | 3 = kreiranje izvje�taja | 4 = izlaz]: ");
			selector = sc.nextInt();
			sc.nextLine();
			switch (selector)
			{
			case 1:
				SelectWorkerAction(user);
				break;
			case 2:
				SelectTaskAction(user);
				break;
			case 3:
				SelectReportAction(user);
				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("Neispravni unos");
				break;
			}
		} while (selector < 1 || selector > 4);
	}

	private static void SelectWorkerAction(Worker user)
	{
		do
		{
			System.out.println("Odaberite radnju");
			System.out.println("1 = natrag");
			System.out.println("2 = prika�i korisnike");
			if (user instanceof Administrator || user instanceof Superuser)
				System.out.println("3 = napravi novog korisnika");
			if (user instanceof Administrator)
			{
				System.out.println("4 = izmjeni korisnika");
				System.out.println("5 = obri�i korisnika");
			}

			selector = sc.nextInt();
			sc.nextLine();
			switch (selector)
			{
			case 1:
				SelectGeneralAction(user);
				break;
			case 2:
				wc.listAllWorkers();
				SelectGeneralAction(user);
				break;
			case 3:
				wc.addNewWorker(user);
				SelectGeneralAction(user);
				break;
			case 4:
				System.out.print("Unesite OIB korisnika: ");
				wc.updateWorker(sc.nextLine(), user);
				SelectGeneralAction(user);
				break;
			case 5:
				System.out.print("Unesite OIB korisnika: ");
				wc.deleteWorker(sc.nextLine(), user);
				SelectGeneralAction(user);
				break;
			default:
				System.out.println("Neispravni unos");
				break;
			}
		} while (selector < 1 || selector > 5);

	}

	private static void SelectTaskAction(Worker user)
	{
		do
		{
			System.out.println("Odaberite radnju");
			System.out.println("1 = natrag");
			System.out.println("2 = prika�i zadatke");
			if (user instanceof Administrator || user instanceof Superuser)
				System.out.println("3 = napravi novi zadatak");
			if (user instanceof Administrator)
			{
				System.out.println("4 = izmjeni zadatak");
				System.out.println("5 = obri�i zadatak");
			}

			selector = sc.nextInt();
			sc.nextLine();
			switch (selector)
			{
			case 1:
				SelectGeneralAction(user);
				break;
			case 2:
				tc.listAllTasks();
				SelectGeneralAction(user);
				break;
			case 3:
				tc.addNewTask(user);
				SelectGeneralAction(user);
				break;
			case 4:
				System.out.print("Unesite naziv zadatka: ");
				tc.updateTask(sc.nextLine(), user);
				SelectGeneralAction(user);
				break;
			case 5:
				System.out.print("Unesite naziv zadatka: ");
				tc.deleteTask(sc.nextLine(), user);
				SelectGeneralAction(user);
				break;
			default:
				System.out.println("Neispravni unos");
				break;
			}
		} while (selector < 1 || selector > 5);
	}

	private static void SelectReportAction(Worker user)
	{
		do
		{
			System.out.println("Odaberite radnju");
			System.out.println("1 = natrag");
			System.out.println("2 = broj radnika po radnom mjestu");
			System.out.println("3 = najstariji otvoreni zadatak");
			System.out.println("4 = broj sati po radniku");

			selector = sc.nextInt();
			sc.nextLine();
			switch (selector)
			{
			case 1:
				SelectGeneralAction(user);
				break;
			case 2:
				rg.printWorkplaceNumberOfWorkers();
				SelectGeneralAction(user);
				break;
			case 3:
				rg.printLongestOpenTask();
				SelectGeneralAction(user);
				break;
			case 4:
				rg.printWorkHoursByWorker();
				SelectGeneralAction(user);
				break;
			default:
				System.out.println("Neispravni unos");
				break;
			}
		} while (selector < 1 || selector > 3);
	}
}