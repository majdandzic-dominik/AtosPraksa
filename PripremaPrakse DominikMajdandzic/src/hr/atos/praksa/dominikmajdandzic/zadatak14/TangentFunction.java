package hr.atos.praksa.dominikmajdandzic.zadatak14;

public class TangentFunction extends TrigonometricFunction
{

	public TangentFunction(double a, double b)
	{
		super(a, b);
	}

	@Override
	public double calculateIntegralInRange(double T1, double T2)
	{
		
		return (-Math.log(Math.abs(Math.cos(T2))) * a + b * T2) - (-Math.log(Math.abs(Math.cos(T1))) * a + b * T1);
	}

}
