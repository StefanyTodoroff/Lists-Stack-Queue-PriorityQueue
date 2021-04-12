package stefy;
import java.awt.Color;


class Ball implements Comparable<Ball>{
	int x = 0;
	int y = 0;
	
	int dx = 2;
	int dy = 2;
	int radius = (int)(Math.random() * 19) + 2; // Ball radius
	Color color = new Color((int) (Math.random() * 256), 
			(int) (Math.random() * 256), (int) (Math.random() * 256));
	@Override
	public int compareTo(Ball arg0) {
		if(radius - arg0.radius > 0) {
			return 1;
		} else if(radius - arg0.radius < 0) {
			return -1;
		}
			return 0;
	}
}
