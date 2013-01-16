/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package voidgame.library;

/**
 *
 * @author Berker
 */
public class Counter {
    int value;
    int target;
    int target2;
    
    public Counter(int target) {
        this.target = target;
        value = 0;
    }
    
    public Counter(int target, int target2) {
        this.target = target;
        this.target2 = target2;
        value = 0;
    }
    
    public void reset() {
        value = 0;
    }
    
    public boolean tick() {
        value++;
        if (value == target) {
            return true;
        }
        return false;
    }
    
    public boolean tock() {
        value++;
        if (value < target) {
            return true;
        }
        if (value == target2) {
            value = 0;
            return false;
        }
        return false;
    }
    
    public boolean tockCtrl() {
        if (value < target) {
            return true;
        }
        if (value == target2) {
            value = 0;
            return false;
        }
        return false;
    }
}
