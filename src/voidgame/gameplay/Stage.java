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
    private int arrowsLeft;
    
    public Stage() {
        arrowsLeft = Attribute.ARROW_COUNT.getVal();
        System.out.println("====INITIAL STAGE CREATED====");
        Attribute.print();
        System.out.println("=====================");
    }
    
    
    public Stage(Stage oldStage, Map<Integer, Effect> effects) {
        
        for (Attribute attr : Attribute.values()) {
            attr.addVal(attr.baseInc);
            if (effects.containsKey(attr.id))
                attr.addVal(effects.get(attr.id).getVal());
        }
        arrowsLeft += Attribute.ARROW_COUNT.getVal();
        System.out.println("====STAGE CREATED FROM OLD====");
        Attribute.print();
        System.out.println("==============================");
    }
    
    public boolean isArrowLeft() {
        if (arrowsLeft == 0) return false;
        arrowsLeft--;
        return true;
    }
    
}
