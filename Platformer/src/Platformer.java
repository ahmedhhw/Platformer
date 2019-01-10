import java.nio.channels.ShutdownChannelGroupException;

import javax.xml.bind.ParseConversionEvent;

import backgroundUtils.Circle;
import backgroundUtils.Player;
import backgroundUtils.Vector;
import processing.core.*;
public class Platformer extends PApplet{
	Player player1;
	float gravity;
	public static void main(String[] args) {
		PApplet.main("Platformer");
	}

	@Override
	public void setup() {
		background(0);
		noStroke();
		gravity = 0.2f;
		player1 = new Player(this, new Vector(width / 2, height - 100), new Vector(100,100),gravity);
		//this.frameRate(1);
	}
	@Override
	public void settings() {
		  size(1920, 900);
	}
	
	@Override
	public void draw() {
		background(0);
		player1.draw();
		player1.handleEverything();
	}
}