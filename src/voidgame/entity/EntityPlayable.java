/*
 * All material belongs to Berker Sönmez,
 * do not copy or distribute without permission.
 */

package voidgame.entity;

import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.geom.Vector2f;
/**
 *
 * @author Berker Sönmez <brkrsnmz@gmail.com>
 */
public class EntityPlayable extends EntityAnimated implements KeyListener{
    public static final int STARTING_SPEED_COEFFICIENT = 5;
    private int speedCoefficient;
    private int[] movableArea = {0, 0, 0, 0};
    
    public EntityPlayable(int[] newMovableArea) {
        speedCoefficient = STARTING_SPEED_COEFFICIENT;
        movableArea = newMovableArea;
        setSpeed(speedCoefficient);
    }
    
    public boolean isInMovableArea() {
        if (!(getX() >= movableArea[0])) {
            setPosition(movableArea[0], getY());
            return false;
        }
        if (!(getY() >= movableArea[1])) {
            setPosition(getX(), movableArea[1]);
            return false;
        }
        if (!(getX()+width <= movableArea[2]-movableArea[0])) {
            setPosition(movableArea[2]-movableArea[0]-width, getY());
            return false;
        }
        if (!(getY()+height <= movableArea[3]-movableArea[1])) {
            setPosition(getX(), movableArea[3]-movableArea[1]-height);
            return false;
        }
        
        return true;
    }
    
    @Override
    public void move(int delta) {
        if (isMoving() && isInMovableArea()) {
            Vector2f realVelocity = new Vector2f(getVelocity());
            realVelocity.set(delta*realVelocity.getX(), delta*realVelocity.getY());
            getPosition().add(realVelocity);
        }
        if (!isInMovableArea()) {
            stopMoving();
        }
    }
    
    @Override
    public void keyPressed(int i, char c) {
        switch (i) {
            case Input.KEY_UP: case Input.KEY_W:
                addVelocity(270);
                break;
            case Input.KEY_DOWN: case Input.KEY_S:
                addVelocity(90);
                break;
            case Input.KEY_RIGHT: case Input.KEY_D:
                addVelocity(0);
                break;
            case Input.KEY_LEFT: case Input.KEY_A:
                addVelocity(180);
                break;
        }
    }

    @Override
    public void keyReleased(int i, char c) {
        switch (i) {
            case Input.KEY_UP: case Input.KEY_W:
                substractVelocity(270);
                break;
            case Input.KEY_DOWN: case Input.KEY_S:
                substractVelocity(90);
                break;
            case Input.KEY_RIGHT: case Input.KEY_D:
                substractVelocity(0);
                break;
            case Input.KEY_LEFT: case Input.KEY_A:
                substractVelocity(180);
                break;
        }
    }

    @Override
    public void setInput(Input ınput) {
        
    }

    @Override
    public boolean isAcceptingInput() {
        return true;
    }

    @Override
    public void inputEnded() {
        
    }

    @Override
    public void inputStarted() {
        
    }
    
}
