package stefy;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

import javax.swing.Timer;
import java.awt.event.*;

import javax.swing.JPanel;

class BallPanel extends JPanel {
	private int delay = 10;
	private PriorityQueue<Ball> queue = new PriorityQueue<>(Collections.reverseOrder());
// Create a timer with the initial delay
	protected Timer timer = new Timer(delay, new TimerListener());

	private class TimerListener implements ActionListener {
		@Override /** Handle the action event */
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}

	public BallPanel() {
		timer.start();
		this.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				for(Ball nextBall: queue) {
					double distance = distance(x, y, nextBall.x, nextBall.y);
					if(nextBall.radius >= distance) {
						queue.remove(nextBall);
						break;
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	public void add() {
		queue.offer(new Ball());
		System.out.println("Queue");
		for(Ball ball : queue) {
			System.out.println(ball.radius);
		}
	}

	public void subtract() {
		if (queue.size() > 0)
			queue.poll(); // Remove the last ball
		System.out.println("Queue");
		for(Ball ball : queue) {
		System.out.println(ball.radius);
	}
}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Ball ball: queue) { // Get a ball
			g.setColor(ball.color); // Set ball color
			// Check boundaries
			if (ball.x < 0 || ball.x > getWidth())
				ball.dx = -ball.dx;
			if (ball.y < 0 || ball.y > getHeight())
				ball.dy = -ball.dy;
			// Adjust ball position
			ball.x += ball.dx;
			ball.y += ball.dy;
			g.fillOval(ball.x - ball.radius, ball.y - ball.radius, ball.radius * 2, ball.radius * 2);
		}
		
		ArrayList<Ball> ballsToRemove = new ArrayList<>();
		for(Ball ball: queue) {
			if(!ballsToRemove.contains(ball)) {
				for(Ball nextBall: queue) {
					if(nextBall != ball) {
						int radiusSum = ball.radius + nextBall.radius;
						double distance = BallPanel.distance(ball.x, ball.y, nextBall.x, nextBall.y);
						if(radiusSum >= distance) {
							ballsToRemove.add(nextBall);
							ball.radius += nextBall.radius;
						}
					}
				}
			}
		}
		queue.removeAll(ballsToRemove);
		
	}

	
	public double distance(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
	}
	
	public void suspend() {
		timer.stop();
	}

	public void resume() {
		timer.start();
	}

	public void setDelay(int delay) {
		this.delay = delay;
		timer.setDelay(delay);
	}
}
