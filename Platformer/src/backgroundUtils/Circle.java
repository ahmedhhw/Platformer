package backgroundUtils;
import processing.core.*;;
public class Circle {
	PApplet parent;
	Vector position;
	Vector size;
	public Circle(PApplet parent, Vector position, Vector size) {
		this.parent = parent;
		this.position = position;
		this.size = size;
	}
	public void draw() {
		parent.ellipse(position.x,position.y,size.x,size.y);
	}
}
