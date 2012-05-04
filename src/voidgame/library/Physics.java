/*
 * All material belongs to Berker Sönmez,
 * do not copy or distribute without permission.
 */

package voidgame.library;

import voidgame.Option;
import voidgame.gameplay.PlayState;

/**
 *
 * @author Berker Sönmez <brkrsnmz@gmail.com>
 */
public class Physics {
    public static final int UP = 0;
    public static final int RIGHT = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;
    private double vx = 0;
    private double vy = 0;
    private double maxSpeed;
    private double acc;
    private int width;
    private int height;
    private boolean restrictedMovement = true;
    protected boolean upFlag = false;
    protected boolean rightFlag = false;
    protected boolean leftFlag = false;
    protected boolean downFlag = false;
    protected boolean isMoving = false;
    private Vector2d position;
    
    
    public Physics(int initWidth, int initHeight, double initAcc, double initMaxSpeed, double newX, double newY) {
        width = initWidth;
        height = initHeight;
        acc = initAcc;
        maxSpeed = initMaxSpeed;
        position = new Vector2d(newX, newY);
    }
    
    public void move(int delta) {
        if (testAndKeepInMovableArea()) {
            calculateVelocity();
            if (isMoving) {
                position = position.add(getVelocityVector().multi(delta));
            }
        } else {
            isMoving = false;
            vx = 0; vy = 0;
        }
    }
    
    public void setRestrictedMovement(boolean b) {
        restrictedMovement = b;
    }
    
    public boolean testAndKeepInMovableArea() {
        if (!restrictedMovement) {
            return true;
        }
        if (!(position.getX() >= PlayState.gameBorderX)) {
            setPosition(PlayState.gameBorderX, (int) position.getY());
            return false;
        }
        if (!(position.getY() >= PlayState.gameBorderY)) {
            setPosition((int) position.getX(), PlayState.gameBorderY);
            return false;
        }
        if (!(position.getX()+width <= PlayState.gameBorderWidth+PlayState.gameBorderX)) {
            setPosition(PlayState.gameBorderWidth+PlayState.gameBorderX-width, (int) position.getY());
            return false;
        }
        if (!(position.getY()+height <= PlayState.gameBorderHeight+PlayState.gameBorderY)) {
            setPosition((int) position.getX(), PlayState.gameBorderHeight+PlayState.gameBorderY-height);
            return false;
        }
        return true;
    }
    
    public void addMovement(int direction) {
        switch (direction) {
            case UP:
                upFlag = true;
                break;
            case DOWN:
                downFlag = true;
                break;
            case RIGHT:
                rightFlag = true;
                break;
            case LEFT:
                leftFlag = true;
                break;
        }
    }
    
    public void removeMovement(int direction) {
        switch (direction) {
            case UP:
                upFlag = false;
                break;
            case DOWN:
                downFlag = false;
                break;
            case RIGHT:
                rightFlag = false;
                break;
            case LEFT:
                leftFlag = false;
                break;
        }
    }
    
    public Vector2d getVelocityVector() {
        return new Vector2d(vx, vy);
    }
    
    public Vector2d getPositionVector() {
        return position;
    }
    
    public void setPosition(int x, int y) {
        position = new Vector2d(x, y);
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void calculateWidthAndHeightByDirection(int direction) {
        if (direction == UP || direction == DOWN) {
            int temp;
            temp = width;
            width = height;
            height = temp;
        }
    }
    
    public boolean isOutOfScreen() {
        if (position.getX() < -Option.ENTITY_OUT_OF_SCREEN_BORDER) return true;
        if (position.getX() > Option.ENTITY_OUT_OF_SCREEN_BORDER + Option.WINDOW_WIDTH) return true;
        if (position.getY() < -Option.ENTITY_OUT_OF_SCREEN_BORDER) return true;
        if (position.getY() > Option.ENTITY_OUT_OF_SCREEN_BORDER + Option.WINDOW_HEIGHT) return true;
        return false;
    }
    
    public double getMaxAxisSpeed() {
        if ((upFlag || downFlag) && (rightFlag || leftFlag)) {
            return maxSpeed * (Math.sqrt(2)/2);
        }
        return maxSpeed;
    }
    
    public void calculateVelocity() {
        // y-axis
        if (upFlag) {
            vy -= acc;
            if (!isMoving) isMoving = true;
        }
        if (downFlag) {
            vy += acc;
            if (!isMoving) isMoving = true;
        }
        if (vy > getMaxAxisSpeed()) vy = getMaxAxisSpeed();
        if (vy < -getMaxAxisSpeed()) vy = -getMaxAxisSpeed();
        if (!upFlag && vy < 0) {
            vy += acc;
            if (vy > 0) { vy = 0; }
        }
        if (!downFlag && vy > 0) {
            vy -= acc;
            if (vy < 0) { vy = 0; }
        }
        
        // x-axis
        if (leftFlag) {
            vx -= acc;
            if (!isMoving) isMoving = true;
        }
        if (rightFlag) {
            vx += acc;
            if (!isMoving) isMoving = true;
        }
        if (vx > getMaxAxisSpeed()) vx = getMaxAxisSpeed();
        if (vx < -getMaxAxisSpeed()) vx = -getMaxAxisSpeed();
        if (!leftFlag && vx < 0) {
            vx += acc;
            if (vx > 0) { vx = 0; }
        }
        if (!rightFlag && vx > 0) {
            vx -= acc;
            if (vx < 0) { vx = 0; }
        }
    }
    
}
