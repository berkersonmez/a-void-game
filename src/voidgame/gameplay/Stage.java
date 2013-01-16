/*
 * All material belongs to Berker Sönmez,
 * do not copy or distribute without permission.
 */

package voidgame.gameplay;

import java.util.ArrayList;
import java.util.Map;
import voidgame.Option;

/**
 *
 * @author Berker Sönmez <brkrsnmz@gmail.com>
 */
public class Stage {
    private int arrowsLeft;
    private ArrayList<Effect> stgEffects;
    
    public Stage() {
        arrowsLeft = Attribute.ARROW_COUNT.getVal();
        System.out.println("====INITIAL STAGE CREATED====");
        Attribute.print();
        System.out.println("=====================");
    }
    
    
    public Stage(Stage oldStage, Map<Integer, Effect> effects) {
        stgEffects = new ArrayList<Effect>();
        for (Attribute attr : Attribute.values()) {
            attr.addVal(attr.baseInc);
            if (effects.containsKey(attr.id)) {
                Effect effect = effects.get(attr.id);
                attr.addVal(effect.getVal());
                effect.addVal(attr.baseInc);
                stgEffects.add(effect);
            } else if (attr.baseInc != 0) {
                Effect effect = new Effect();
                effect.setAttrID(attr.id);
                effect.setVal(attr.baseInc);
                stgEffects.add(effect);
            }
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

    public ArrayList<Effect> getStgEffects() {
        return stgEffects;
    }
    
}
