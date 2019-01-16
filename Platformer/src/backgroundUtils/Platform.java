package backgroundUtils;

import processing.core.PApplet;

public class Platform {
	private Hitbox hitbox;
	private PApplet parent;
	private Circle body;
	public Platform (PApplet parent, Vector position, int width) {
		this.parent = parent;
		body = new Circle(parent, position, new Vector (width, 50));
		hitbox = new Hitbox(parent, position, new Vector (width, 50));
	}
	public Circle getBody() {
		return body;
	}
	public Hitbox getHitbox() {
		return hitbox;
	}
	public void draw() {
		body.draw();
		//hitbox.show();
	}
	public void moveRight(int amount){
		body.position.x+= amount;
	}
	public void moveLeft(int amount) {
		body.position.x-= amount;
	}
}
