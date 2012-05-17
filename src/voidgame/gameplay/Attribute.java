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
public enum Attribute {
    ARROW_COUNT(0, 5, 2, 1, 3, "Arrow Count"),
    ARROW_CHANCE(1, 3, 0, 1, 2, "Arrow Chance"),
    ARROWS_ON_SCREEN(2, 1, 0, 0, 1, "Arrows on Screen");
    
    public final int id; // Attribute id
    public final int start; // Starting value at the start of the game
    public final int baseInc; // Increment value each level (will be done every level, without waiting an effect)
    public final int min; // Minimum effect value per level
    public final int max; // Maximum effect value per level
    public final String name; // Text of the attribute
    private static final Attribute[] VALUES = values();
    private int val;
    Attribute(int nID, int nStart, int nBaseInc, int nMin, int nMax, String nName) {
        id = nID;
        start = nStart;
        baseInc = nBaseInc;
        min = nMin;
        max = nMax;
        val = nStart;
        name = nName;
    }
    
    public static int randomAttributeID(Random randomSeed) {
        return randomSeed.nextInt(VALUES.length);
    }
    public static int randomEffectValue(int attributeID, Random randomSeed) {
        Attribute effect = VALUES[attributeID];
        return randomSeed.nextInt(effect.max-effect.min+1)+effect.min;
    }
    
    public int getVal() {
        return val;
    }
    
    public void setVal(int newVal) {
        val = newVal;
    }
    
    public void addVal(int newVal) {
        val += newVal;
    }
    
    @Override
    public String toString() {
        return name + "= " + val;
    }
    
    public static void print() {
        for (Attribute attr : VALUES) {
            System.out.println(attr);
        }
    }
}