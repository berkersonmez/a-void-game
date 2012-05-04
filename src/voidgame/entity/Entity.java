/*
 * All material belongs to Berker Sönmez,
 * do not copy or distribute without permission.
 */

package voidgame.entity;

import voidgame.library.Physics;
/**
 *
 * @author Berker Sönmez <brkrsnmz@gmail.com>
 */
public abstract class Entity{
    private String name;
    protected Physics physics;
    
    public void setPhysics(int initWidth, int initHeight, double initAcc, double initMaxSpeed, double newX, double newY) {
        physics = new Physics(initWidth, initHeight, initAcc, initMaxSpeed, newX, newY);
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String newName) {
        name = newName;
    }
    
    public int getX() {
        return (int) physics.getPositionVector().getX();
    }
    
    public int getY() {
        return (int) physics.getPositionVector().getY();
    }
    
    public int getWidth() {
        return (int) physics.getWidth();
    }
    
    public int getHeight() {
        return (int) physics.getHeight();
    }
    
    public void update(int delta) {
        physics.move(delta);
    }
    
    public void setPosition(int x, int y) {
        physics.setPosition(x, y);
    }
    
    public void addMovement(int direction) {
        physics.addMovement(direction);
    }
    
    public void removeMovement(int direction) {
        physics.removeMovement(direction);
    }
    
    public abstract void render();
}