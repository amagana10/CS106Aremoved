import java.awt.Graphics;
import acm.graphics.*;
import acm.program.*;

public abstract class RandomCircle extends Graphics {
	private static final int NCIRCLE = 10;
	private static final double MIN_RADIUS = 5;
	private static final double MAX_RADIUS = 50;

	public void run() {
		for (int i = 0; i < NCIRCLE; i++) {

			double r = rgen.nextDouble((int) MIN_RADIUS, MAX_RADIUS);
			double x = rgen.nextDouble(0, getWidth() - 2 * r);
			double y = rgen.nextDouble(0, getHeight() - 2 * r);
			GOval circle = new GOval(x, y, 2 * r, 2 * r);
			
			circle.setFilled(true);
			circle.setColor(rgen.nextColor());
			add(circle);

		}

	}

	
	private void add(GOval circle) {
		
		
	}


	private double getHeight() {
		
		return 0;
	}

	private double getWidth() {
		
		return 0;
	}




	private RandomGenerator rgen = RandomGenerator.getInstance();

}
