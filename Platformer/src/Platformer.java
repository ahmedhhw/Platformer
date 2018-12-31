import backgroundUtils.Circle;
import backgroundUtils.Vector;
import processing.core.*;
public class Platformer extends PApplet{
	public static void main(String[] args) {
		PApplet.main("Platformer");
	}
	private Circle circle;
	public Vector degree;
	private Vector radius;
	Vector center;
	Color color;
	public void setup() {
		background(0);
		noStroke();
		circle = new Circle(this, new Vector(200, 200), new Vector(5,5));
		center = new Vector(width/2, height / 2);
		degree = new Vector(50,0, -0.01); // initial value, speed, acceleration
		radius = new Vector(0,1, 0); // initial value, speed, acceleration;
		color = new Color(new Vector(255,0,-0.01),new Vector(34,0,0.01),new Vector(77,0,-0.01));	
	}
	public void settings() {
		  size(1920, 1080);
	}
	@Override
	public void draw() {
		fill(color.red.x,color.green.x,color.blue.x);
		circle.position.x = (int)(cos(degree.x) * radius.x + center.x);
		circle.position.y = (int)(sin(degree.x) * radius.x + center.y);
		radius.changeVector();
		degree.changeVector();
		color.changeColor();
		color.bounceBack();
		circle.draw();
	}
	class Color {
		Vector red; // Saves red
		Vector green; // Saves green
		Vector blue; // Saves blue
		public Color (Vector red, Vector green, Vector blue) {
			this.red = red;
			this.green = green;
			this.blue = blue;
		}
		void changeColor() {
			red.changeVector();
			green.changeVector();
			blue.changeVector();
		}
		void bounceBack() {
			bounceBack(red);
			bounceBack(green);
			bounceBack(blue);
		}
		private void bounceBack(Vector value) {
			if (value.z != 0 && (value.x > 255 && value.z > 0 || value.x < 0 && value.z < 0)) {
				value.z *= -1;
			}else if (value.x > 255 && value.y > 0 || value.x < 0 && value.y < 0) {
				value.y *= -1;
			}
		}
	}
}
