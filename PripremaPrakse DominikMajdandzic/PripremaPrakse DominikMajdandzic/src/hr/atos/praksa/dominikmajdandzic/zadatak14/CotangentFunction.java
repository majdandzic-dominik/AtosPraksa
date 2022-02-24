package hr.atos.praksa.dominikmajdandzic.zadatak14;

public class CotangentFunction extends TrigonometricFunction
{

	public CotangentFunction(double a, double b)
	{
		super(a, b);
	}

	@Override
	public double calculateIntegralInRange(double T1, double T2)
	{
		return (Math.log(Math.abs(Math.sin(T2))) * a + b * T2) - (Math.log(Math.abs(Math.sin(T1))) * a + b * T1);
	}

}
