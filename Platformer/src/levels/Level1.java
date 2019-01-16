package levels;

import backgroundUtils.Platform;
import backgroundUtils.Vector;
import processing.core.PApplet;

public class Level1 extends abstractLevel {
	private PApplet parent;

	public Level1(PApplet parent) {
		super();
		this.parent = parent;
		data();
	}

	private void data() {
		int startingPosition = 50;
		int seperationDist = 600;
		addPlatform(new Platform (parent, new Vector(startingPosition,600), 400));
		addPlatform(new Platform (parent, new Vector(startingPosition+=seperationDist,400), 400));
		addPlatform(new Platform (parent, new Vector(startingPosition+=seperationDist,400), 400));
		addPlatform(new Platform (parent, new Vector(startingPosition+=seperationDist,600), 400));
		addPlatform(new Platform (parent, new Vector(startingPosition+=seperationDist,600), 400));
		addPlatform(new Platform (parent, new Vector(startingPosition+=seperationDist,600), 400));
		addPlatform(new Platform (parent, new Vector(startingPosition+=seperationDist,400), 400));
		addPlatform(new Platform (parent, new Vector(startingPosition+=seperationDist,400), 400));
		addPlatform(new Platform (parent, new Vector(startingPosition+=seperationDist,600), 400));
		addPlatform(new Platform (parent, new Vector(startingPosition+=seperationDist,600), 400));
		addPlatform(new Platform (parent, new Vector(startingPosition+=seperationDist,600), 400));
		addPlatform(new Platform (parent, new Vector(startingPosition+=seperationDist,400), 400));
		addPlatform(new Platform (parent, new Vector(startingPosition+=seperationDist,600), 400));
		addPlatform(new Platform (parent, new Vector(startingPosition+=seperationDist,600), 400));
		addPlatform(new Platform (parent, new Vector(startingPosition+=seperationDist,600), 400));
		addPlatform(new Platform (parent, new Vector(startingPosition+=seperationDist,400), 400));
		addPlatform(new Platform (parent, new Vector(startingPosition+=seperationDist,400), 400));
		addPlatform(new Platform (parent, new Vector(startingPosition+=seperationDist,600), 400));
		addPlatform(new Platform (parent, new Vector(startingPosition+=seperationDist,600), 400));
		addPlatform(new Platform (parent, new Vector(startingPosition+=seperationDist,600), 400));
	}
	public void handleEverything() {
		draw();
		drift();
	}
	private void drift() {
		for (Platform platform: platforms) {
			platform.moveLeft(5);
		}
	}

	private void addPlatform(Platform platform) {
		platforms.add(platform);
	}

	@Override
	public void draw() {
		for (Platform platform: platforms) {
			platform.draw();
		}
	}
}
