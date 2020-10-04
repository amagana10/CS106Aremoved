import acm.graphics.GRect;

public class Pyramid extends GraphicsProgram {
	private static final int  BRICK_WIDTH = 30;
	private static final int  BRICK_HEIGHT = 12;
	private static final int  BRICK_IN_BASE = 14;
	
public void run() {
	
	 for (int i = 0; i <BRICK_IN_BASE; i++ ) {
		 
		 for (int j = 0; j < i; j++) {
			 
			 int x = BRICK_IN_BASE * j;
			 int y = BRICK_IN_BASE * i;
			 
			 GRect brick = new GRect (x, y, BRICK_WIDTH, BRICK_HEIGHT);
			 add(brick);
			 
			 
		 }
		 
	 }
	
}

private void add(GRect brick) {
	
	
}

}
