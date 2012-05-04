/*
 * All material belongs to Berker Sönmez,
 * do not copy or distribute without permission.
 */

package voidgame.gameplay;

import java.util.Map;
import voidgame.Option;

/**
 *
 * @author Berker Sönmez <brkrsnmz@gmail.com>
 */
public class Stage {
    private Effect arrowCount;
    private Effect arrowChance;
    private Effect arrowsOnScreen;
    private int arrowsLeft;
    
    public Stage() {
        arrowCount = Effect.ARROW_COUNT;
        arrowChance = Effect.ARROW_CHANCE;
        arrowsOnScreen = Effect.ARROWS_ON_SCREEN;
        arrowsLeft = arrowCount.val;
        System.out.println("====STAGE CREATED====");
        System.out.println("Arrow Count: " + arrowCount.val);
        System.out.println("Arrow Chance: %" + arrowChance.val);
        System.out.println("Arrows On Screen: " + arrowsOnScreen.val);
        System.out.println("=====================");
    }
    
    public Effect getArrowCount() {
        return arrowCount;
    }
    
    public Effect getArrowChance() {
        return arrowChance;
    }
    
    public Effect getArrowsOnScreen() {
        return arrowsOnScreen;
    }
    
    public Stage(Stage oldStage, Map<Integer, Effect> effects) {
        for (int i = 0 ; i < 3 ; i++) {
            if (effects.containsKey(i))System.out.println(effects.get(i).id + " : mi:" + effects.get(i).min + " - mx:" + effects.get(i).max + " - v:" + effects.get(i).val);
        }
        arrowCount = oldStage.arrowCount;
        arrowCount.val += Option.STAGE_ARROW_COUNT_INCREASE_PER_LEVEL;
        if (effects.containsKey(arrowCount.id))
            arrowCount.val += effects.get(arrowCount.id).val;
        arrowChance = oldStage.arrowChance;
        if (effects.containsKey(arrowChance.id))
            arrowChance.val += effects.get(arrowChance.id).val;
        arrowsOnScreen = oldStage.arrowsOnScreen;
        if (effects.containsKey(arrowsOnScreen.id))
            arrowsOnScreen.val += effects.get(arrowsOnScreen.id).val;
        arrowsLeft = arrowCount.val;
        
        System.out.println("====STAGE CREATED FROM OLD====");
        System.out.println("Arrow Count: " + arrowCount.val);
        System.out.println("Arrow Chance: %" + arrowChance.val);
        System.out.println("Arrows On Screen: " + arrowsOnScreen.val);
        System.out.println("==============================");
    }
    
    public boolean isArrowLeft() {
        if (arrowsLeft == 0) return false;
        arrowsLeft--;
        return true;
    }
    
}
