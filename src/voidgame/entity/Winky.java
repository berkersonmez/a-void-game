

package voidgame.entity;

import org.newdawn.slick.Image;
import voidgame.resource.image.SpriteManager;
import voidgame.gameplay.PlayState;
/**
 *
 * @author Berker
 */
public class Winky extends EntityPlayable {
    public Winky(SpriteManager sm, int[] newMovableArea) {
        super(newMovableArea);
        width = 60;
        height = 65;
        setPosition(100f, 100f);
        sprite = sm.getAnimationAt(0, 0, width, height, 3, 250);
    }
}
