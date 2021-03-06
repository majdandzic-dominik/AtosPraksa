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

public class TaskController
{

	public static Scanner sc = new Scanner(System.in);

	public void addNewTask(Worker user)
	{
		if (user instanceof Administrator || user instanceof Superuser)
		{
			Task task = inputNewTaskParameters();

			try
			{
				FileOutputStream f = new FileOutputStream(
						System.getProperty("user.dir") + "\\tasks\\" + task.getName() + ".txt");
				ObjectOutputStream o = new ObjectOutputStream(f);

				o.writeObject(task);

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

	private Task inputNewTaskParameters()
	{

		System.out.print("Unesite naziv zadatka: ");
		String name = sc.nextLine();
		System.out.print("Unesite opis zadatka: ");
		String description = sc.nextLine();
		System.out.print("Unesite tip zadatka [TASK|BUG]: ");
		TaskType type = TaskType.valueOf(sc.next().toUpperCase());
		System.out.print("Unesite kompleksnost zadatka: ");
		int complexity = sc.nextInt();

		Task task = new Task(name, description, type, complexity);

		return task;
	}

	public Task getTaskByName(String name)
	{
		try
		{
			FileInputStream f = new FileInputStream(System.getProperty("user.dir") + "\\tasks\\" + name + ".txt");
			ObjectInputStream o = new ObjectInputStream(f);

			Task task = (Task) o.readObject();

			o.close();
			f.close();

			return task;
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

	public void deleteTask(String name, Worker user)
	{
		if (user instanceof Administrator)
		{
			File f = new File(System.getProperty("user.dir") + "\\tasks\\" + name + ".txt");

			if (f.delete())
				System.out.println("Zadatak se uspje?no obrisao.");
			else
				System.out.println("Zadatak se nije uspio obrisati.");
		}
	}

	public void updateTask(String name, Worker user)
	{
		Task task = getTaskByName(name);
		if (user instanceof Administrator)
		{
			inputTaskUpdateParameters(task, user);
			try
			{
				FileOutputStream f = new FileOutputStream(
						System.getProperty("user.dir") + "\\tasks\\" + task.getName() + ".txt");
				ObjectOutputStream o = new ObjectOutputStream(f);

				o.writeObject(task);

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

	private void inputTaskUpdateParameters(Task task, Worker user)
	{
		String choice;

		System.out.print("?elite li izmjeniti naziv? [DA|NE]: ");
		choice = sc.nextLine();
		if (choice.toUpperCase().equals("DA"))
		{
			deleteTask(task.getName(), user);
			updateTaskName(task, user);
		}

		System.out.print("?elite li izmjeniti opis? [DA|NE]: ");
		choice = sc.nextLine();
		if (choice.toUpperCase().equals("DA"))
			updateTaskDescription(task, user);

		System.out.print("?elite li izmjeniti tip? [DA|NE]: ");
		choice = sc.nextLine();
		if (choice.toUpperCase().equals("DA"))
			updateTaskType(task, user);

		System.out.print("?elite li izmjeniti status? [DA|NE]: ");
		choice = sc.nextLine();
		if (choice.toUpperCase().equals("DA"))
			updateTaskStatus(task, user);

		System.out.print("?elite li izmjeniti kompleksnost? [DA|NE]: ");
		choice = sc.nextLine();
		if (choice.toUpperCase().equals("DA"))
			updateTaskComplexity(task, user);

		System.out.print("?elite li izmjeniti utro?eno vrijeme? [DA|NE]: ");
		choice = sc.nextLine();
		if (choice.toUpperCase().equals("DA"))
			increaseTaskTimeSpent(task, user);
	}

	private void updateTaskName(Task task, Worker user)
	{
		System.out.print("Unesite novi naziv: ");

		task.updateName(sc.nextLine(), user);
	}

	private void updateTaskDescription(Task task, Worker user)
	{
		System.out.print("Unesite novi opis: ");

		task.updateDescription(sc.nextLine(), user);
	}

	private void updateTaskType(Task task, Worker user)
	{
		System.out.print("Unesite novi tip [TASK|BUG]: ");

		task.updateType(TaskType.valueOf(sc.next().toUpperCase()), user);
		sc.nextLine();
	}

	private void updateTaskStatus(Task task, Worker user)
	{
		System.out.print("Unesite novi status [OPEN|CLOSED|IN_PROGRESS]: ");

		task.updateStatus(TaskStatus.valueOf(sc.next().toUpperCase()), user);
		sc.nextLine();
	}

	private void updateTaskComplexity(Task task, Worker user)
	{
		System.out.print("Unesite novu kompleksonst: ");

		task.updateComplexity(sc.nextInt(), user);
		sc.nextLine();
	}

	private void increaseTaskTimeSpent(Task task, Worker user)
	{
		System.out.print("Unesite novi utro?eno vrijeme: ");

		task.increaseTimeSpent(sc.nextDouble(), user);
		sc.nextLine();
	}

	public void listAllTasks()
	{
		File directory = new File(System.getProperty("user.dir") + "\\tasks");

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
