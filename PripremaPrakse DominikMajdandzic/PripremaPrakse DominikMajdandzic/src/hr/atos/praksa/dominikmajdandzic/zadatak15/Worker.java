package hr.atos.praksa.dominikmajdandzic.zadatak15;

import java.io.Serializable;

public class Worker implements Serializable
{
	private static final long serialVersionUID = 1L;
	protected String name, surname, workplace, oib;
	protected double workTime;

	public Worker(String name, String surname, String workplace, String oib)
	{
		super();
		this.name = name;
		this.surname = surname;
		this.workplace = workplace;
		this.oib = oib;
		this.workTime = 0;
	}
	
	public double getWorkTime()
	{
		return workTime;
	}

	public String getWorkplace()
	{
		return workplace;
	}

	public void setName(String name, Worker user)
	{
		if (user instanceof Administrator)
			this.name = name;
	}

	public void setSurname(String surname, Worker user)
	{
		if (user instanceof Administrator)
			this.surname = surname;
	}

	public void setWorkplace(String workplace, Worker user)
	{
		if (user instanceof Administrator)
			this.workplace = workplace;
	}

	public void setOib(String oib, Worker user)
	{
		if (user instanceof Administrator)
			this.oib = oib;
	}
	
	public void setWorkTime(double workTime, Worker user)
	{
		if (user instanceof Administrator)
			this.workTime = workTime;
	}

	public String getOib()
	{
		return oib;
	}

	@Override
	public String toString()
	{
		return "Name: " + name + "\r\nSurname: " + surname + "\r\nWorkplace: " + workplace + "\r\nOIB:" + oib + "\r\nWork hours: " + workTime + "h\rqn";
	}
	
	public void printWorkHours()
	{
		System.out.println(name + " " + surname + ", work hours: " + workTime + "h");
	}
}
