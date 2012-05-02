/*
 * All material belongs to Berker Sönmez,
 * do not copy or distribute without permission.
 */

package voidgame.entity;

import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author Berker Sönmez <brkrsnmz@gmail.com>
 */
public abstract class Entity {
    private String name;
    private Vector2f position = new Vector2f(0, 0);
    private Vector2f velocity = new Vector2f(0, 0);
    private boolean isMoving = false;
    
    public String getName() {
        return name;
    }
    
    public void setName(String newName) {
        name = newName;
    }
    
    public Vector2f getPosition() {
        return position;
    }
    
    public Vector2f getVelocity() {
        return velocity;
    }
    
    public float getSpeed() {
        return velocity.length();
    }
    
    public float getSpeedX() {
        return velocity.getX();
    }
    
    public float getSpeedY() {
        return velocity.getY();
    }
    
    public float getX() {
        return position.getX();
    }
    
    public float getY() {
        return position.getY();
    }
    
    public void setPosition(Vector2f newPosition) {
        position = newPosition;
    }
    
    public void setPosition(float newX, float newY) {
        position.set(newY, newY);
    }
    
    public void setVelocity(Vector2f newVelocity) {
        velocity = newVelocity;
    }
    
    public void setSpeed(float newSpeed) {
        double newSpeedDouble = newSpeed;
        float newX = newSpeed * (float) Math.cos(newSpeedDouble);
        float newY = newSpeed * (float) Math.sin(newSpeedDouble);
        velocity.set(newY, newY);
    }
    
    public void move(int delta) {
        Vector2f realVelocity = new Vector2f(velocity);
        realVelocity.set(delta*realVelocity.getX(), delta*realVelocity.getY());
        if (isMoving) {
            position.add(realVelocity);
        }
    }
    
    public void move(float newX, float newY) {
        position.set(newX, newY);
    }
    
    public void setDirection(double newAngle) {
        velocity.setTheta(newAngle);
    }
    
    
}