/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package voidgame.entity;

import java.awt.Font;
import java.util.ArrayList;
import org.newdawn.slick.TrueTypeFont;
import voidgame.Option;
import voidgame.gameplay.Attribute;
import voidgame.gameplay.Effect;
import voidgame.gameplay.StageFactory;
import voidgame.resource.image.SpriteManager;

/**
 *
 * @author Berker
 */
public class PlayStartTable extends StageTable {
    
    public PlayStartTable(SpriteManager sm) {
        super();
        setPhysics(186, 198, 0, 0, (Option.WINDOW_WIDTH-186)/2, (Option.WINDOW_HEIGHT-198)/2);
        sprite = sm.getImageAt(0, 156, getWidth(), getHeight());
        sprite.setAlpha(0.9f);
        effectTexts = new ArrayList<String>();
        
        Font headerFont = new Font("Verdana", Font.BOLD, 18);
        headerTTFont = new TrueTypeFont(headerFont, true);
        Font bodyFont = new Font("Verdana", Font.PLAIN, 16);
        bodyTTFont = new TrueTypeFont(bodyFont, true);
        effectTexts.add("INITIAL VALUES:");
        for (Attribute attr : Attribute.values()) {
            effectTexts.add(attr.name+": "+attr.start);
        }
    }
    
}
