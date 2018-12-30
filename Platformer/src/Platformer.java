import backgroundUtils.Circle;
import backgroundUtils.Vector;
import processing.core.*;
public class Platformer extends PApplet{
	public static void main(String[] args) {
		PApplet.main("Platformer");
	}
	private Circle circle;
	public void setup() {
		circle = new Circle(this, new Vector(200, 200), new Vector(100,100));
	}
	public void settings() {
		  size(1920, 1080);
	}
	@Override
	public void draw() {
		circle.draw();
	}
}
