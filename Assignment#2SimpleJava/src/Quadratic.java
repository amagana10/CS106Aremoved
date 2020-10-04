/**
 * Find the quadratic answers; 6x^2 + 11x -35 = 0; Coefficient of variable; a =
 * 6; b = 11 and c = -35. +
 */

public class Quadratic {

	public static void main(String[] args) {
		double a = 6;
		double b = 11;
		double c = -35;
		double answer1, answer2;

		answer1 = Math.sqrt((b * b) - 4 * a * c);
		answer1 = -b + answer1;
		answer1 = answer1 / (2 * a);
		answer2 = Math.sqrt((b * b) - 4 * a * c);
		answer2 = -b - answer2;
		answer2 = answer2 / (2 * a);
		System.out.println("solution for x1 is = " + answer1 + " and solution for x2 is = " + answer2);

	}

}
