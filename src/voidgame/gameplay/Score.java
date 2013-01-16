/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package voidgame.gameplay;

import voidgame.library.Counter;

/**
 *
 * @author Berker
 */
public class Score {
    private static int score = 0;
    private static Counter counter = new Counter(10);
    
    public static void step() {
        if (counter.tick()) {
            score++;
            counter.reset();
        }
    }
    
    public static void addArrowPoints(int arrowPoints) {
        score += arrowPoints;
    }

    public static int getScore() {
        return score;
    }
    
    public static void reset() {
        score = 0;
    }
}
