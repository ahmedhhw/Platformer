import backgroundUtils.Circle;
import backgroundUtils.Player;
import backgroundUtils.Vector;
import processing.core.*;
public class Platformer extends PApplet{
	Player player1;
	public static void main(String[] args) {
		PApplet.main("Platformer");
	}
	@Override
	public void setup() {
		background(0);
		noStroke();
		player1 = new Player(this, new Vector(width / 2, height - 100), new Vector(100,100));
		//this.frameRate(1);
	}
	@Override
	public void settings() {
		  size(1920, 900);
	}
	@Override
	public void draw() {
		background(0);
		//System.out.println("Player size: " + player1.size.y);
		//System.out.println("Player max size: " + player1.size.z);
		player1.draw();
		player1.handleTheControls();
	}
}
