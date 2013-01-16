/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package voidgame.entity;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Map;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import voidgame.Option;
import voidgame.gameplay.Effect;
import voidgame.gameplay.StageFactory;
import voidgame.resource.image.SpriteManager;

/**
 *
 * @author Berker
 */
public class StageTable extends EntityStatic {
    TrueTypeFont headerTTFont;
    TrueTypeFont bodyTTFont;
    ArrayList<String> effectTexts;
    
    public StageTable() {
    }

    public StageTable(SpriteManager sm) {
        setPhysics(186, 198, 0, 0, (Option.WINDOW_WIDTH-186)/2, (Option.WINDOW_HEIGHT-198)/2);
        sprite = sm.getImageAt(0, 156, getWidth(), getHeight());
        sprite.setAlpha(0.9f);
        ArrayList<Effect> stgEffects = StageFactory.stg.getStgEffects();
        effectTexts = new ArrayList<String>();
        
        Font headerFont = new Font("Verdana", Font.BOLD, 18);
        headerTTFont = new TrueTypeFont(headerFont, true);
        Font bodyFont = new Font("Verdana", Font.PLAIN, 16);
        bodyTTFont = new TrueTypeFont(bodyFont, true);
        
        for (Effect effect : stgEffects) {
            if (effect.getVal() != 0) {
                effectTexts.add(effect.getValueText());
            }
        }
    }
    
    @Override
    public void render() {
        super.render();
        headerTTFont.drawString(getX()+50, getY()+5, "Stage "+String.valueOf(StageFactory.stageCount), Color.white);
        if (effectTexts.isEmpty()) {
            bodyTTFont.drawString(getX()+5, getY()+30, "No new effects...", Color.yellow);
        }
        for (String effectStr : effectTexts) {
            bodyTTFont.drawString(getX()+5, getY()+30+(effectTexts.indexOf(effectStr)*18), effectStr, Color.yellow);
        }
    }
}
