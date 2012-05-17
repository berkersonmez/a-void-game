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
    public Arrow(SpriteManager sm, int newX, int newY, int direction) {
        if (direction == 0)
            sprite = sm.getAnimationAt(50, 76, Option.ENTITY_ARROW_HEIGHT, Option.ENTITY_ARROW_WIDTH, 1, 1000, false, true);
        else if (direction == 2)
            sprite = sm.getAnimationAt(50, 76, Option.ENTITY_ARROW_HEIGHT, Option.ENTITY_ARROW_WIDTH, 1, 1000, false, false);
        else if (direction == 1)
            sprite = sm.getAnimationAt(0, 76, Option.ENTITY_ARROW_WIDTH, Option.ENTITY_ARROW_HEIGHT, 1, 1000, false, false);
        else
            sprite = sm.getAnimationAt(0, 76, Option.ENTITY_ARROW_WIDTH, Option.ENTITY_ARROW_HEIGHT, 1, 1000, true, false);
        setPhysics(Option.ENTITY_ARROW_WIDTH, Option.ENTITY_ARROW_HEIGHT, Option.ENTITY_ARROW_ACC, Option.ENTITY_ARROW_MAX_SPEED, newX, newY);
        physics.calculateWidthAndHeightByDirection(direction);
        setRestrictedMovement(false);
        addMovement(direction);
    }
}
