/*
 * All material belongs to Berker Sönmez,
 * do not copy or distribute without permission.
 */

package voidgame.entity;

import voidgame.Option;
import voidgame.resource.image.SpriteManager;

/**
 *
 * @author Berker Sönmez <brkrsnmz@gmail.com>
 */
public class Arrow extends EntityAnimated {
    public Arrow(SpriteManager sm, double newX, double newY, int direction) {
        sprite = sm.getAnimationAt(0, 76, Option.ENTITY_ARROW_WIDTH, Option.ENTITY_ARROW_HEIGHT, 1, 1000, direction);
        setPhysics(Option.ENTITY_ARROW_WIDTH, Option.ENTITY_ARROW_HEIGHT, Option.ENTITY_ARROW_ACC, Option.ENTITY_ARROW_MAX_SPEED, newX, newY);
        physics.calculateWidthAndHeightByDirection(direction);
        setRestrictedMovement(false);
        addMovement(direction);
    }
}
