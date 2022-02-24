//13)	Kreiraj program koji se sastoji od jedne klase i su�elja 
//koje klasa naslje�uje. Su�elje treba definirati dvije razli�ite metode po vlastitom izboru. 

package hr.atos.praksa.dominikmajdandzic.zadatak13;

public class Square implements Shape2D
{
	private double side;

	public Square(double value)
	{
		this.side = value;
	}

	@Override
	public double calculateArea()
	{
		return side * 4;
	}

	@Override
	public double calculateCircumference()
	{
		return side * side;
	}

}
