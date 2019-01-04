import backgroundUtils.Circle;
import backgroundUtils.Vector;
import processing.core.*;
public class Platformer extends PApplet{
	
	public static void main(String[] args) {
		PApplet.main("Platformer");
	}
	@Override
	public void setup() {
		background(0);
		noStroke();
	}
	@Override
	public void settings() {
		  size(1920, 900);
	}
	@Override
	public void draw() {
		background(0);
	}
}
