package hr.atos.praksa.dominikmajdandzic.zadatak15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileReaderWriter
{

	public void writeWorkerToFile(Worker worker)
	{
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
	
	public Worker readWorkerFromFile(String oib)
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
	
	
	public void writeTaskToFile(Task task)
	{
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
	
	public Task readTaskFromFile(String name)
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
	
	
	public void deleteFile(String name, String folder)
	{
		File f = new File(System.getProperty("user.dir") + "\\" + folder + "\\" + name + ".txt");
		if (f.delete())
			System.out.println("Brisanje uspje�no.");
		else
			System.out.println("Brisanje nije uspje�no.");
	}
	
	public File[] getAllTxtFilesInFolder(String folder)
	{
		File directory = new File(System.getProperty("user.dir") + "\\" + folder);

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
		
		return directory.listFiles(textFilefilter);
	}

}
