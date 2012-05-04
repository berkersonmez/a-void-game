/*
 * All material belongs to Berker Sönmez,
 * do not copy or distribute without permission.
 */

package voidgame.gameplay;

import java.util.Map;

/**
 *
 * @author Berker Sönmez <brkrsnmz@gmail.com>
 */
public class Stage {
    private Effect arrowCount;
    private Effect arrowChance;
    private Effect arrowsOnScreen;
    
    public Stage() {
        arrowCount = Effect.ARROW_COUNT;
        arrowChance = Effect.ARROW_CHANCE;
        arrowsOnScreen = Effect.ARROWS_ON_SCREEN;
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
        arrowCount = oldStage.arrowCount;
        arrowCount.val += effects.get(arrowCount.id).val;
        arrowChance = oldStage.arrowChance;
        arrowChance.val += effects.get(arrowChance.id).val;
        arrowsOnScreen = oldStage.arrowsOnScreen;
        arrowsOnScreen.val += effects.get(arrowsOnScreen.id).val;
    }
    
}
