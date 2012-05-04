/*
 * All material belongs to Berker Sönmez,
 * do not copy or distribute without permission.
 */

package voidgame.gameplay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import voidgame.Option;

/**
 *
 * @author Berker Sönmez <brkrsnmz@gmail.com>
 */
public class StageFactory {
    public static int stageCount = 0;
    public static Stage stg;
    
    public static ArrayList<Integer> effectChances;
    public static Map<Integer, Effect> effect;
    
    public static void init() {
        effectChances = new ArrayList<Integer>();
        effect = new HashMap<Integer, Effect>();
        effectChances.add(Option.STAGE_DEFAULT_EFFECT_CHANCE_1);
        effectChances.add(Option.STAGE_DEFAULT_EFFECT_CHANCE_2);
        effectChances.add(Option.STAGE_DEFAULT_EFFECT_CHANCE_3);
        effectChances.add(Option.STAGE_DEFAULT_EFFECT_CHANCE_4);
        effectChances.add(Option.STAGE_DEFAULT_EFFECT_CHANCE_5);
    }
    
    public static void createStage() {
        if (stageCount == 0) {
            stg = new Stage();
        } else {
            Random rand = new Random();
            for (int i=0 ; i < 5 ; i++) {
                int effectPoints = rand.nextInt(100)+1;
                if (effectChances.get(i) > effectPoints) {
                    Effect e = Effect.randomEffect(rand);
                    e.val = rand.nextInt(e.max-e.min+1)+e.min;
                    if (effect.containsKey(e.id)) {
                        e.val += effect.get(e.id).val;
                    }
                    effect.put(e.id, e);
                }
            }
            effect.clear();
            stg = new Stage(stg, effect);
        }
        stageCount++;
    }
    
    public static void handleEffectChances() {
        // increase all effect chances by 2*(levels of group of 5)
        for (int i=0 ; i<5 ; i++) {
            effectChances.set(i, effectChances.get(i)+((int) Math.ceil(((double)stageCount)/5))*2);
        }
    }
}
