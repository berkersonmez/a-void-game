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
public class Effect {
    private int val;
    private int attrID;
    public static Effect getRandom(Random randomSeed) {
        Effect newEffect = new Effect();
        newEffect.attrID = Attribute.randomAttributeID(randomSeed);
        newEffect.val = Attribute.randomEffectValue(newEffect.attrID, randomSeed);
        return newEffect;
    }
    public int getAttrID() {
        return attrID;
    }
    public int getVal() {
        return val;
    }
    
    public void setAttrID(int newAttrID) {
        attrID = newAttrID;
    }
    
    public void setVal(int newVal) {
        val = newVal;
    }
    
}
