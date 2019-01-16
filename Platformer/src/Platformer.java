import java.nio.channels.ShutdownChannelGroupException;

import javax.xml.bind.ParseConversionEvent;

import backgroundUtils.*;
import levels.*;
import processing.core.*;
/**
 * Main canvas to draw on
 * @author doublea
 *
 */
public class Platformer extends PApplet{
	
	Player player1; //Main player
	float gravity; //Gravity Value
	abstractLevel currentLevel;
	public static void main(String[] args) {
		PApplet.main("Platformer");
	}

	/**
	 * Set up game and instantiate variables
	 */
	@Override
	public void setup() {
		ellipseMode(CORNER);
		background(0);
		noStroke();
		gravity = 0.2f;
		currentLevel = new Level1(this);
		player1 = new Player(this, new Vector(50, 500), new Vector(100,100),gravity, currentLevel);
		//this.frameRate(1);
		
	}
	
	/**
	 * Sets up background settings
	 */
	@Override
	public void settings() {
		  size(1920, 900);
	}
	
	/**
	 * Draw function, executes 60 times per second
	 */
	@Override
	public void draw() {
		background(0);
		player1.draw();
		player1.handleEverything();
		currentLevel.handleEverything();
	}
	@Override
	public void keyTyped() {
		if (key == 'w') {
			player1.handleJumping();
		}else if (key == 'a') {
			player1.moveLeft();
		}else if (key == 'd') {
			player1.moveRight();
		}
	}
	@Override
	public void keyReleased() {
		if (key == 'a' || key == 'd') {
			player1.resetMovement();
		}
	}
}