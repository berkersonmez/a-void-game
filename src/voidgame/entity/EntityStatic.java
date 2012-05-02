/*
 * All material belongs to Berker Sönmez,
 * do not copy or distribute without permission.
 */

package voidgame.entity;

import org.newdawn.slick.Image;

/**
 *
 * @author Berker Sönmez <brkrsnmz@gmail.com>
 */
public abstract class EntityStatic extends Entity {
    protected Image sprite;
    
    public void render() {
        sprite.draw(getX(), getY());
    }
}