//13)	Kreiraj program koji se sastoji od jedne klase i suèelja 
//koje klasa nasljeðuje. Suèelje treba definirati dvije razlièite metode po vlastitom izboru. 

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
