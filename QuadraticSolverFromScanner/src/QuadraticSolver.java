import java.util.Scanner;

public class QuadraticSolver extends Exception {
	
	public static double a;
	public static double b;
	public static double c;
	public static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		
		System.out.print("Enter value for a: ");
		a = userInput.nextDouble();

		System.out.print("Enter value for b: ");
		b = userInput.nextDouble();

		System.out.print("Enter value for c: ");
		c = userInput.nextDouble();

		
		double disc = b*b-4.0*a*c;
		try {
			if (disc < 0) throw new Exception();
			else {
				double sqrtDisc = Math.sqrt(disc);
				double x1 = -b + sqrtDisc;
				double x2 = -b - sqrtDisc;
		
				System.out.println(x1 + " " + x2);
			}
		}
		catch (Exception e) {
			System.out.println("Possible negative radicand");
			}
	}

}
