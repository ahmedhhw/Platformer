package backgroundUtils;

import org.w3c.dom.css.Rect;

import processing.core.PApplet;

public class Hitbox extends Rectangle {
	PApplet parent;
	public Hitbox(PApplet parent, Vector position, Vector size) {
		super(parent, position, size);
		this.parent = parent;
	}
	/**
	 * Draws hitbox over object lightly
	 */
	public void show() {
		parent.fill(255,0,0,100);
		this.draw();
	}
	/**
	 * For A to be on top of B:
	 * 		-Top of A has to be above the top of B
	 * 		-Bottom part of A has to be below or equal to top part of B
	 * 		-Bottom part of A has to be above bottom part of B
	 * 		-Negate case for not horizontal intersection
	 * @param other
	 * @return
	 */
	public boolean isOnTopOf(Hitbox other) {
		float ATopPart = this.position.y;
		float ABottomPart = this.position.y + this.size.y;
		float BTopPart = other.position.y;
		float BBottomPart = other.position.y + other.size.y;
		float ALeft = this.position.x;
		float ARight = this.position.x + this.size.x;
		float BLeft = other.position.x;
		float BRight = other.position.x + other.size.x;
		return (ATopPart < BTopPart) && (ABottomPart > BTopPart) && (ABottomPart < BBottomPart) && !((ALeft > BRight) || (ARight < BLeft));
	}
	/**
	 * For A to be touching left of B:
	 * 		-Left of A has to be to the left of left of B
	 * 		-Right of A has to be to right of left of B
	 * 		-Right part of A has to be to the left of right of B
	 * 		-Negate case of vertical intersection
	 * @param other
	 * @return
	 */
	public boolean isTouchingLeftOf(Hitbox other) {
		float ALeft = this.position.x;
		float ARight = this.position.x + this.size.x;
		float BLeft = other.position.x;
		float BRight = other.position.x + other.size.x;
		float ATopPart = this.position.y;
		float ABottomPart = this.position.y + this.size.y;
		float BTopPart = other.position.y;
		float BBottomPart = other.position.y + other.size.y;
		return (ALeft < BLeft) && (ARight > BLeft) && (ARight < BRight) && !((ATopPart > BBottomPart) || (ABottomPart < BTopPart ));
	}
	/**
	 * For A to be touching right part of B:
	 * 		-ALeft has to be left of BRight
	 * 		-ALeft has to be right of BLeft
	 * 		-ARight has to be right of BRight
	 * 		-Negate case for vertical intersection
	 * @param other
	 * @return
	 */
	public boolean isTouchingRightOf(Hitbox other) {
		float ALeft = this.position.x;
		float Aright = this.position.x + this.size.x;
		float BLeft = other.position.x;
		float Bright = other.position.x + other.size.x;
		float ATopPart = this.position.y;
		float ABottomPart = this.position.y + this.size.y;
		float BTopPart = other.position.y;
		float BBottomPart = other.position.y + other.size.y;
		return (ALeft < Bright) && (ALeft > BLeft) && (Aright > Bright) && !((ATopPart > BBottomPart) || (ABottomPart < BTopPart ));
	}
	/**
	 * For A to be touching bottom of B:
	 * 		-ATop be above BBottom
	 * 		-ATop be below BTop
	 * 		-ABottom be below BBottom
	 * 		-Negate case for not horizontal intersection
	 * @param other
	 * @return
	 */
	public boolean isTouchingBottomOf(Hitbox other) {
		float ATopPart = this.position.y;
		float ABottomPart = this.position.y + this.size.y;
		float BTopPart = other.position.y;
		float BBottomPart = other.position.y + other.size.y;
		float ALeft = this.position.x;
		float ARight = this.position.x + this.size.x;
		float BLeft = other.position.x;
		float BRight = other.position.x + other.size.x;
		return (ATopPart < BBottomPart) && (ATopPart > BTopPart) && (ABottomPart > BBottomPart) && !((ALeft > BRight) || (ARight < BLeft));
	}
}