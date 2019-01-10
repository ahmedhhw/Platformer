package backgroundUtils;

public class Vector {
	public float x,y,z;
	public Vector(float x, float y) {
		this.x = x;
		this.y = y;
	}
	public Vector(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Vector(double x, double y) {
		this.x = (float)x;
		this.y = (float)y;
	}
	public Vector(double x, double y, double z) {
		this.x = (float)x;
		this.y = (float)y;
		this.z = (float)z;
	}
}
