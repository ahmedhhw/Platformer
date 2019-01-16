package levels;
import java.util.ArrayList;

import backgroundUtils.Hitbox;
import backgroundUtils.Platform;
import backgroundUtils.Player;

public abstract class abstractLevel {
	ArrayList<Platform> platforms;
	public abstractLevel() {
		platforms = new ArrayList<Platform>();
	}
	public abstract void draw();
	public boolean isOnTopOfPlatform(Player player) {
		for (Platform platform: platforms) {
			if (player.getHitbox().isOnTopOf(platform.getHitbox())) {
				return true;
			}
		}
		return false;
	}
	public float getHeightOfPlatformBelow(Player player) {
		for (Platform platform: platforms) {
			if (player.getHitbox().isOnTopOf(platform.getHitbox())) {
				Hitbox currentHitbox = platform.getHitbox();
				return currentHitbox.position.y;
			}
		}
		return -1;
	}
	public abstract void handleEverything();
}
