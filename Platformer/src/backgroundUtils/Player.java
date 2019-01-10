package backgroundUtils;

import java.util.PrimitiveIterator.OfDouble;

import javax.sound.midi.Soundbank;
import javax.xml.bind.util.ValidationEventCollector;

import processing.core.PApplet;

public class Player {
	PApplet parent;
	public Vector position;
	public Vector size;
	Rectangle body;
	Vector velocity;
	float gravity;
	public Player(PApplet parent, Vector position, Vector size, float gravity) {
		this.parent = parent;
		this.position = position;
		this.size = size;
		this.gravity = gravity;
		this.size.z = size.y;
		this.position.z = this.position.y;
		body = new Rectangle(parent,position,size);
		velocity = new Vector(5, 0);
	}
	public void handleEverything() {
		handleTheControls();
		if (playerIsOnGround()) {
			System.out.println("NONONONO");
			resetAndBringUp();
		}else {
			System.out.println("YESYESYES");
			handleGravity();
		}
		handlePositionUpdate();
		//System.out.println("Position of player:" + this.position.y);
	}
	private void resetAndBringUp() {
	
		this.velocity.y = 0;
		this.position.y = parent.height - this.size.y; 
	}
	private boolean playerIsOnGround() {
		// TODO Auto-generated method stub
		return this.position.y + this.size.y >= parent.height;
	}
	private void handlePositionUpdate() {
		//System.out.println("Position of player:" + this.position.y);
		//System.out.println("Velocity of player:" + this.velocity.y);
		this.position.y += this.velocity.y;
		this.position.z += this.velocity.y;
	}
	private void handleGravity() {
		this.velocity.y += this.gravity;
	}
	public void handleTheControls() {
		handleJumping();
		handleMoving();
		handleDucking();
	}
	private void handleDucking() {
		if (parent.key == 's' && parent.keyPressed) {
			this.size.y = this.size.z / 2;
			this.position.y = this.position.z + (this.size.z - this.size.y);
		}else if (!parent.keyPressed || parent.key == 'w'){
			this.size.y = this.size.z;
			this.position.y = this.position.z;
		}
	}
	private void handleMoving() {
		if (parent.keyPressed) {
			if (parent.key == 'a') {
				this.position.x -= velocity.x;
			}else if (parent.key == 'd') {
				this.position.x += velocity.x;
			}
		}
	}
	private void handleJumping() {
		if (parent.keyPressed && parent.key == 'w' && playerIsOnGround()) {
			this.position.y -= 1;
			this.position.z -= 1;
			this.velocity.y = -10;
		}
	}
	public void draw(){
		body.draw();
	}
	
}
