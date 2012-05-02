/*
 * All material belongs to Berker Sönmez,
 * do not copy or distribute without permission.
 */

package voidgame.entity;

import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.util.FastTrig;
/**
 *
 * @author Berker Sönmez <brkrsnmz@gmail.com>
 */
public abstract class Entity {
    public static final int UP = 0;
    public static final int RIGHT = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;
    protected int width;
    protected int height;
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
        position.set(newX, newY);
    }
    
    public void setVelocity(Vector2f newVelocity) {
        velocity = newVelocity;
    }
    
    public void setSpeed(float newSpeed) {
        float newX = newSpeed * (float) FastTrig.cos(StrictMath.toRadians(velocity.getTheta()));
        float newY = newSpeed * (float) FastTrig.sin(StrictMath.toRadians(velocity.getTheta()));
        velocity.set(newX, newY);
    }
    
    public void setSpeed(int speedCoefficient) {
        setSpeed(0.1f * speedCoefficient);
    }
    
    public void move(int delta) {
        if (isMoving) {
            Vector2f realVelocity = new Vector2f(velocity);
            realVelocity.set(delta*realVelocity.getX(), delta*realVelocity.getY());
            position.add(realVelocity);
        }
    }
    
    public void moveTo(float newX, float newY) {
        position.set(newX, newY);
    }
    
    public void setDirection(double newAngle) {
        velocity.setTheta(newAngle);
    }
    
    public void startMoving() {
        isMoving = true;
    }
    
    public void stopMoving() {
        isMoving = false;
    }
    
    public boolean isMoving() {
        return isMoving;
    }
    
    public void update(int delta) {
        move(delta);
    }
    
    public void addVelocity(double direction) {
        Vector2f newVelocity = new Vector2f(velocity);
        newVelocity.setTheta(direction);
        float tempSpeed = newVelocity.length();
        if (isMoving) {
            velocity.add(newVelocity);
            setSpeed(tempSpeed);
        } else {
            velocity.set(newVelocity);
            startMoving();
        }
    }
    
    public void substractVelocity(double direction) {
        if (isMoving) {
            Vector2f newVelocity = new Vector2f(velocity);
            newVelocity.setTheta(direction);
            float tempSpeed = newVelocity.length();
            velocity.sub(newVelocity);
            if (getSpeed() < 1) {
                stopMoving();
            }
            setSpeed(tempSpeed);
        }
    }
    
    public abstract void render();
}