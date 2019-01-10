package backgroundUtils;

import java.util.PrimitiveIterator.OfDouble;

import javax.sound.midi.Soundbank;
import javax.xml.bind.util.ValidationEventCollector;

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
	private float gravity;
	
	/**
	 * Constructor
	 * @param parent
	 * @param position
	 * @param size
	 * @param gravity
	 */
	public Player(PApplet parent, Vector position, Vector size, float gravity) {
		this.parent = parent;
		this.gravity = gravity;
		hitbox = new Hitbox(parent,position,size);
		this.hitbox.size.z = this.hitbox.size.y;
		this.hitbox.position.z = this.hitbox.position.y;
		velocity = new Vector(5, 0);
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
		if (playerIsOnGround()) {
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
		this.hitbox.position.y = parent.height - this.hitbox.size.y; 
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
		handleJumping();
		handleMoving();
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
	 *  Handles moving
	 */
	private void handleMoving() {
		if (parent.keyPressed) {
			if (parent.key == 'a') {
				this.hitbox.position.x -= velocity.x;
			}else if (parent.key == 'd') {
				this.hitbox.position.x += velocity.x;
			}
		}
	}
	/**
	 * Gives player initial speed if he is on ground and w is pressed
	 */
	private void handleJumping() {
		if (parent.keyPressed && parent.key == 'w' && playerIsOnGround()) {
			this.hitbox.position.y -= 1;
			this.hitbox.position.z -= 1;
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
