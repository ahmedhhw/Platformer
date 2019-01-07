package backgroundUtils;

import processing.core.PApplet;

public class Player {
	PApplet parent;
	public Vector position;
	public Vector size;
	Rectangle body;
	int speed;
	public Player(PApplet parent, Vector position, Vector size) {
		this.parent = parent;
		this.position = position;
		this.size = size;
		this.size.z = size.y;
		this.position.z = this.position.y;
		body = new Rectangle(parent,position,size);
		speed = 5;
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
				this.position.x -= speed;
			}else if (parent.key == 'd') {
				this.position.x += speed;
			}
		}
	}
	private void handleJumping() {
		
	}
	public void draw(){
		body.draw();
	}
	
}
