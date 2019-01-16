package backgroundUtils;
import processing.core.*;;
public class Circle {
	PApplet parent;
	public Vector position;
	public Vector size;
	public float velocity;
	public Circle(PApplet parent, Vector position, Vector size) {
		this.parent = parent;
		this.position = position;
		this.size = size;
		velocity = 0;
	}
	public void draw() {
		parent.fill(0,255,0);
		parent.ellipse(position.x,position.y,size.x,size.y);
	}
	public void update() {
		this.position.y += this.velocity;
	}
}
