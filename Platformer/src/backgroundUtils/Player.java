package backgroundUtils;

import java.util.PrimitiveIterator.OfDouble;

import javax.sound.midi.Soundbank;
import javax.xml.bind.util.ValidationEventCollector;

import levels.abstractLevel;
import processing.core.PApplet;

/**
 * Allows creation of a player
 * @author Ahmed Ali
 *
 */
public class Player {
	
	private PApplet parent;
	private Hitbox hitbox; 
	private Vector velocity;
	private int controlSpeed;
	private float gravity;
	private abstractLevel currentLevel;
	
	/**
	 * Constructor
	 * @param parent
	 * @param position
	 * @param size
	 * @param gravity
	 * @param currentLevel 
	 */
	public Player(PApplet parent, Vector position, Vector size, float gravity, abstractLevel currentLevel) {
		this.parent = parent;
		this.gravity = gravity;
		this.currentLevel = currentLevel;
		hitbox = new Hitbox(parent,position,size);
		this.hitbox.size.z = this.hitbox.size.y;
		this.hitbox.position.z = this.hitbox.position.y;
		velocity = new Vector(0, 0);
		controlSpeed = 5;
	}
	
	public void moveRight() {
		this.velocity.x = controlSpeed;
	}
	public void moveLeft() {
		this.velocity.x = -1 * controlSpeed;
	}
	public void resetMovement() {
		this.velocity.x = 0;
	}
	public Hitbox getHitbox() {
		return hitbox;
	}
	/**
	 * Handles everything player related
	 */
	public void handleEverything() {
		
		//Set up controls
		handleTheControls();
		
		//Handles physics
		handlePhysics();
	}
	
	/**
	 * Handles physics
	 */
	private void handlePhysics() {
		if (currentLevel.isOnTopOfPlatform(this) && parent.key != 'w') {
			resetAndBringUp();
		}else {
			handleGravity();
		}
		handlePositionUpdate();
	}

	/**
	 * Once player falls on a hard surface it stops falling
	 */
	private void resetAndBringUp() {
		this.velocity.y = 0;
		
		//Adjust player to correct location
		this.hitbox.position.y = currentLevel.getHeightOfPlatformBelow(this) - this.hitbox.size.y; 
	}
	
	/**
	 * Checks if player is on ground
	 * @return
	 */
	private boolean playerIsOnGround() {
		return this.hitbox.position.y + this.hitbox.size.y >= parent.height;
	}
	/**
	 * Updates players new location
	 */
	private void handlePositionUpdate() {
		//System.out.println("Position of player:" + this.position.y);
		//System.out.println("Velocity of player:" + this.velocity.y);
		this.hitbox.position.y += this.velocity.y;
		this.hitbox.position.z += this.velocity.y;
		this.hitbox.position.x += this.velocity.x;
	}
	
	/**
	 * Adds gravity to velocity
	 */
	private void handleGravity() {
		this.velocity.y += this.gravity;
	}
	
	/**
	 * Handles controls
	 */
	public void handleTheControls() {
		handleDucking();
	}
	
	/**
	 * Keeps player height at half while s is held and player is not moving
	 */
	private void handleDucking() {
		if (parent.key == 's' && parent.keyPressed) {
			this.hitbox.size.y = this.hitbox.size.z / 2;
			this.hitbox.position.y = this.hitbox.position.z + (this.hitbox.size.z - this.hitbox.size.y);
		}else if (!parent.keyPressed || parent.key == 'w'){
			this.hitbox.size.y = this.hitbox.size.z;
			this.hitbox.position.y = this.hitbox.position.z;
		}
	}
	
	/**
	 * Gives player initial speed if he is on ground and w is pressed
	 */
	public void handleJumping() {
		//System.out.println("On top of platform = " + currentLevel.isOnTopOfPlatform(this));
		if (currentLevel.isOnTopOfPlatform(this)) {
			//System.out.println("Should be jumping");
			this.velocity.y = -10;
		}
	}
	/**
	 * 
	 */
	public void draw(){
		hitbox.draw();
	}
	
}
