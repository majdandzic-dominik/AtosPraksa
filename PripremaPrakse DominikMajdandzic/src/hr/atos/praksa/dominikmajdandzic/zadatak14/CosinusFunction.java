package hr.atos.praksa.dominikmajdandzic.zadatak14;

public class CosinusFunction extends TrigonometricFunction
{

	public CosinusFunction(double a, double b)
	{
		super(a, b);
	}

	@Override
	public double calculateIntegralInRange(double T1, double T2)
	{
		return (a * (Math.sin(T2)) + b * T2) - (a * (Math.sin(T1)) + b * T1);
	}

}
