//14)	Kreiraj program kojim �e korisnik izra�unati povr�inu ispod neke
//krivulje opisane funkcijom y=f(x)=A*funk(x)+B od neke
//po�etne do krajnje to�ke (T1,T2). Izra�un izvesti numeri�kom 
//metodom. Ulazni parametri su A, B, T1i T2 te funkcija koja mo�e
//biti sinus, kosinus, tangens ili kotangens. Pri rje�avanju zadatka 
//obavezno koristiti vi�e klasa i(li) su�elja te naslje�ivanje.

//sin = -cos
//cos = sin
//tg = -ln(|cos(x)|)
//ctg = ln(|sin(x)|)

package hr.atos.praksa.dominikmajdandzic.zadatak14;

import java.util.Scanner;

public class Assignment14
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		TrigonometricFunction function;

		double A, B, T1, T2;
		String functionType;

		do
		{
			System.out.print("Unestie tip funkcijve (sin, cos, tg, ctg): ");
			functionType = sc.next();
		} while (!functionType.equals("sin") && !functionType.equals("cos") && !functionType.equals("tg")
				&& !functionType.equals("ctg"));

		System.out.print("Unesite vrijednost A [A * " + functionType + "(x) + B]: ");
		A = sc.nextDouble();

		System.out.print("Unesite vrijednost B [A * " + functionType + "(x) + B]: ");
		B = sc.nextDouble();

		System.out.print("Unesite po�etak intervala: ");
		T1 = sc.nextDouble();

		do
		{
			System.out.print("Unesite kraj intervala (mora biti ve�i od po�etka intervala): ");
			T2 = sc.nextDouble();
		} while (T2 <= T1);

		switch (functionType)
		{
		case "sin":
			function = new SinusFunction(A, B);
			break;
		case "cos":
			function = new CosinusFunction(A, B);
			break;
		case "tg":
			function = new TangentFunction(A, B);
			break;
		case "ctg":
			function = new CotangentFunction(A, B);
			break;
		default:
			function = new TrigonometricFunction(A, B);
		}

		System.out.println("Povr�ina ispod zadane funkcije u zadanom intervalu: "
				+ String.format("%.2f", function.calculateIntegralInRange(T1, T2)));

		sc.close();

	}

}
