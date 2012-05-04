/*
 * All material belongs to Berker Sönmez,
 * do not copy or distribute without permission.
 */
package voidgame.gameplay;

import java.util.Random;

/**
 *
 * @author Berker Sönmez <brkrsnmz@gmail.com>
 */
public enum Effect {
    ARROW_COUNT(0, 5, 2, 10),
    ARROW_CHANCE(1, 3, 1, 2),
    ARROWS_ON_SCREEN(2, 1, 1, 2);
    
    public final int id;
    public final int start;
    public final int min;
    public final int max;
    private static final Effect[] VALUES = values();
    public int val;
    Effect(int nID, int nStart, int nMin, int nMax) {
        id = nID;
        start = nStart;
        min = nMin;
        max = nMax;
        val = nStart;
    }
    
    public static Effect randomEffect(Random randomSeed) {
        return VALUES[randomSeed.nextInt(VALUES.length)];
    }
}