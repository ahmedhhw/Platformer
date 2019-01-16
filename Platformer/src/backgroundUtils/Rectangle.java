package backgroundUtils;

import processing.core.PApplet;

public class Rectangle {
	PApplet parent;
	public Vector position;
	public Vector size;
	public float velocity;
	public Rectangle(PApplet parent, Vector position, Vector size) {
		this.parent = parent;
		this.position = position;
		this.size = size;
		velocity = 0;
	}
	public void draw() {
		parent.fill(255);
		parent.rect(position.x,position.y,size.x,size.y);
	}
	public void update() {
		this.position.y += this.velocity;
	}
}
