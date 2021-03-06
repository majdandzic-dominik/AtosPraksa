package hr.atos.praksa.dominikmajdandzic.zadatak15;

import java.io.Serializable;
import java.time.LocalDate;

enum TaskType
{
	BUG, TASK
}

enum TaskStatus
{
	OPEN, CLOSED, IN_PROGRESS
}

public class Task implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String name, description;
	private TaskType type;
	private TaskStatus status;
	private int complexity;
	private LocalDate dateStart;
	private LocalDate dateEnd;
	private double timeSpent;

	public TaskStatus getStatus()
	{
		return status;
	}

	public LocalDate getDateStart()
	{
		return dateStart;
	}

	public String getName()
	{
		return name;
	}

	public Task(String name, String description, TaskType type, int complexity)
	{
		super();
		this.name = name;
		this.description = description;
		this.type = type;
		this.status = TaskStatus.OPEN;
		this.complexity = complexity;
		this.dateStart = LocalDate.now();
		this.timeSpent = 0;
	}

	@Override
	public String toString()
	{
		return "Name: " + name + "\r\nDescription: " + description + "\r\nType: " + type + "\r\nStatus: " + status
				+ "\r\nComplexity: " + complexity + "\r\nTime spent: " + timeSpent + " h\r\nStart date: " + dateStart
				+ "\r\nEnd date: " + dateEnd + "\r\n";
	}

	public void updateName(String name, Worker worker)
	{
		if (worker instanceof Administrator)
		{
			this.name = name;
		}
	}

	public void updateDescription(String description, Worker worker)
	{
		if (worker instanceof Administrator)
		{
			this.description = description;
		}
	}

	public void updateType(TaskType type, Worker worker)
	{
		if (worker instanceof Administrator)
		{
			this.type = type;
		}
	}

	public void updateStatus(TaskStatus status, Worker worker)
	{
		if (worker instanceof Administrator)
		{
			this.status = status;
			if (this.status == TaskStatus.CLOSED)
				dateEnd = LocalDate.now();
		}
	}

	public void updateComplexity(int complexity, Worker worker)
	{
		if (worker instanceof Administrator)
		{
			this.complexity = complexity;
		}
	}

	public void increaseTimeSpent(double timeSpent, Worker worker)
	{
		if (worker instanceof Administrator)
		{
			this.timeSpent += timeSpent;
		}
	}

}
