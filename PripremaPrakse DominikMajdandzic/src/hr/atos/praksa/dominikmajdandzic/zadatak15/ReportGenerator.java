package hr.atos.praksa.dominikmajdandzic.zadatak15;

import java.io.File;
import java.io.FilenameFilter;
import java.time.LocalDate;
import java.util.HashMap;

public class ReportGenerator
{
	private static TaskController tc = new TaskController();
	private static WorkerController wc = new WorkerController();

	public void printLongestOpenTask()
	{
		File directory = new File(System.getProperty("user.dir") + "\\tasks");
		String oldestOpenTaskName = "";
		LocalDate oldestDate = LocalDate.now();

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
			Task task = tc.getTaskByName(f.getName().replaceFirst("[.][^.]+$", ""));
			if (task.getStatus() == TaskStatus.OPEN)
			{
				if (oldestDate.compareTo(task.getDateStart()) > 0)
				{
					oldestOpenTaskName = task.getName();
					oldestDate = task.getDateStart();
				}
			}
		}

		if (oldestOpenTaskName.equals(""))
			System.out.println("Ne postoji niti jedan otvoreni zadatak");
		else
			System.out.print(tc.getTaskByName(oldestOpenTaskName).toString());
	}

	public void printWorkplaceNumberOfWorkers()
	{
		HashMap<String, Integer> workplaceCounterMap = new HashMap<String, Integer>();

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
			Worker worker = wc.getWorkerByOIB(f.getName().replaceFirst("[.][^.]+$", ""));
			String workplace = worker.getWorkplace();
			if (workplaceCounterMap.containsKey(workplace))
				workplaceCounterMap.put(workplace, workplaceCounterMap.get(workplace) + 1);
			else
				workplaceCounterMap.put(workplace, 1);

			if(workplaceCounterMap != null)
			{
				for(String key : workplaceCounterMap.keySet())
				{
					System.out.println(key + ": " + workplaceCounterMap.get(key));
				}
			}
		}
	}
}
