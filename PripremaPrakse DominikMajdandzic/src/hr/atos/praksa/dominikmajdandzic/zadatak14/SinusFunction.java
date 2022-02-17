package hr.atos.praksa.dominikmajdandzic.zadatak14;

public class SinusFunction extends TrigonometricFunction
{

	public SinusFunction(double a, double b)
	{
		super(a, b);
	}

	@Override
	public double calculateIntegralInRange(double T1, double T2)
	{
		return (a * (-Math.cos(T2)) + b * T2) - (a * (-Math.cos(T1)) + b * T1);
	}

}
