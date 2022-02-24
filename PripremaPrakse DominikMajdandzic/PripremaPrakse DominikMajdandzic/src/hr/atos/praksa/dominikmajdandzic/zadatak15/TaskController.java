package hr.atos.praksa.dominikmajdandzic.zadatak15;

import java.io.File;
import java.util.Scanner;

public class TaskController
{

	public static Scanner sc = new Scanner(System.in);
	public static FileReaderWriter frw = new FileReaderWriter();

	public void addNewTask(Worker user)
	{
		if (user instanceof Administrator || user instanceof Superuser)
		{
			Task task = inputNewTaskParameters();

			frw.writeTaskToFile(task);
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
		return frw.readTaskFromFile(name);
	}

	public void deleteTask(String name, Worker user)
	{
		if (user instanceof Administrator)
		{
			frw.deleteFile(name, "tasks");
		}
	}

	public void updateTask(String name, Worker user)
	{
		Task task = getTaskByName(name);
		if (user instanceof Administrator)
		{
			inputTaskUpdateParameters(task, user);
			frw.writeTaskToFile(task);
		}
	}

	private void inputTaskUpdateParameters(Task task, Worker user)
	{
		String choice;

		System.out.print("�elite li izmjeniti naziv? [DA|NE]: ");
		choice = sc.nextLine();
		if (choice.toUpperCase().equals("DA"))
		{
			deleteTask(task.getName(), user);
			updateTaskName(task, user);
		}

		System.out.print("�elite li izmjeniti opis? [DA|NE]: ");
		choice = sc.nextLine();
		if (choice.toUpperCase().equals("DA"))
			updateTaskDescription(task, user);

		System.out.print("�elite li izmjeniti tip? [DA|NE]: ");
		choice = sc.nextLine();
		if (choice.toUpperCase().equals("DA"))
			updateTaskType(task, user);

		System.out.print("�elite li izmjeniti status? [DA|NE]: ");
		choice = sc.nextLine();
		if (choice.toUpperCase().equals("DA"))
			updateTaskStatus(task, user);

		System.out.print("�elite li izmjeniti kompleksnost? [DA|NE]: ");
		choice = sc.nextLine();
		if (choice.toUpperCase().equals("DA"))
			updateTaskComplexity(task, user);

		System.out.print("�elite li izmjeniti utro�eno vrijeme? [DA|NE]: ");
		choice = sc.nextLine();
		if (choice.toUpperCase().equals("DA"))
			increaseTaskTimeSpent(task, user);
	}

	private void updateTaskName(Task task, Worker user)
	{
		System.out.print("Unesite novi naziv: ");

		task.setName(sc.nextLine(), user);
	}

	private void updateTaskDescription(Task task, Worker user)
	{
		System.out.print("Unesite novi opis: ");

		task.setDescription(sc.nextLine(), user);
	}

	private void updateTaskType(Task task, Worker user)
	{
		System.out.print("Unesite novi tip [TASK|BUG]: ");

		task.setType(TaskType.valueOf(sc.next().toUpperCase()), user);
		sc.nextLine();
	}

	private void updateTaskStatus(Task task, Worker user)
	{
		System.out.print("Unesite novi status [OPEN|CLOSED|IN_PROGRESS]: ");

		task.setStatus(TaskStatus.valueOf(sc.next().toUpperCase()), user);
		sc.nextLine();
	}

	private void updateTaskComplexity(Task task, Worker user)
	{
		System.out.print("Unesite novu kompleksonst: ");

		task.setComplexity(sc.nextInt(), user);
		sc.nextLine();
	}

	private void increaseTaskTimeSpent(Task task, Worker user)
	{
		System.out.print("Unesite novi utro�eno vrijeme: ");

		task.setTimeSpent(sc.nextDouble(), user);
		sc.nextLine();
	}

	public void listAllTasks()
	{
		File[] directoryContents = frw.getAllTxtFilesInFolder("tasks");

		for (File f : directoryContents)
		{
			System.out.println(f.getName().replaceFirst("[.][^.]+$", ""));
		}		
	}

}