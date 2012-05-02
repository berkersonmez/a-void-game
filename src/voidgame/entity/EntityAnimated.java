/*
 * All material belongs to Berker Sönmez,
 * do not copy or distribute without permission.
 */

package voidgame.entity;
import org.newdawn.slick.Animation;

/**
 *
 * @author Berker Sönmez <brkrsnmz@gmail.com>
 */
public abstract class EntityAnimated extends Entity {
    protected Animation sprite;
    public void render() {
        sprite.draw(getX(), getY());
    }
}
