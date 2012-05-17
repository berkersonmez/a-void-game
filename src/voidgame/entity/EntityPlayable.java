/*
 * All material belongs to Berker Sönmez,
 * do not copy or distribute without permission.
 */

package voidgame.entity;

import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import voidgame.library.Physics;
/**
 *
 * @author Berker Sönmez <brkrsnmz@gmail.com>
 */
public class EntityPlayable extends EntityAnimated implements KeyListener{
    public static final int STARTING_SPEED_COEFFICIENT = 5;
    
    
    public EntityPlayable(int[] newMovableArea, int initWidth, int initHeight, double initAcc, double initMaxSpeed, int newX, int newY) {
        setPhysics(initWidth, initHeight, initAcc, initMaxSpeed, newX, newY);
    }
        
    @Override
    public void keyPressed(int i, char c) {
        switch (i) {
            case Input.KEY_UP: case Input.KEY_W:
                addMovement(Physics.UP);
                break;
            case Input.KEY_DOWN: case Input.KEY_S:
                addMovement(Physics.DOWN);
                break;
            case Input.KEY_RIGHT: case Input.KEY_D:
                addMovement(Physics.RIGHT);
                break;
            case Input.KEY_LEFT: case Input.KEY_A:
                addMovement(Physics.LEFT);
                break;
        }
    }

    @Override
    public void keyReleased(int i, char c) {
        switch (i) {
            case Input.KEY_UP: case Input.KEY_W:
                removeMovement(Physics.UP);
                break;
            case Input.KEY_DOWN: case Input.KEY_S:
                removeMovement(Physics.DOWN);
                break;
            case Input.KEY_RIGHT: case Input.KEY_D:
                removeMovement(Physics.RIGHT);
                break;
            case Input.KEY_LEFT: case Input.KEY_A:
                removeMovement(Physics.LEFT);
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
