

package voidgame.entity;

import voidgame.resource.image.SpriteManager;
/**
 *
 * @author Berker
 */
public class Winky extends EntityPlayable {
    public Winky(SpriteManager sm, int[] newMovableArea, int initWidth, int initHeight, double initAcc, double initMaxSpeed, double newX, double newY) {
        super(newMovableArea, initWidth, initHeight, initAcc, initMaxSpeed, newX, newY);
        sprite = sm.getAnimationAt(0, 0, initWidth, initHeight, 3, 250);
    }
}
