import backgroundUtils.Circle;
import backgroundUtils.Vector;
import processing.core.*;
public class Platformer extends PApplet{
	private Circle ball;
	private double gravity;
	public static void main(String[] args) {
		PApplet.main("Platformer");
	}
	@Override
	public void setup() {
		background(0);
		noStroke();
		ball = new Circle(this, new Vector(width / 2, 50), new Vector(100,100));
		gravity = 0.1f;
	}
	@Override
	public void settings() {
		  size(1920, 900);
	}
	@Override
	public void draw() {
		background(0);
		ball.draw();
		ball.velocity+= gravity;
		ball.update();
		if (ball.position.y + 50 > height)
			ball.velocity*= -1;
	}
}
