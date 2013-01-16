/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package voidgame.entity;

import java.awt.Font;
import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import voidgame.Option;
import voidgame.gameplay.Effect;
import voidgame.gameplay.Score;
import voidgame.gameplay.StageFactory;
import voidgame.resource.image.SpriteManager;

/**
 *
 * @author Berker
 */
public class GameOverTable extends EntityStatic {
    
    TrueTypeFont headerTTFont;
    TrueTypeFont bodyTTFont;
    TrueTypeFont bodySmallTTFont;
    ArrayList<String> smallTexts;
    String stageText;
    String scoreText;

    public GameOverTable(SpriteManager sm) {
        setPhysics(186, 198, 0, 0, (Option.WINDOW_WIDTH-186)/2, (Option.WINDOW_HEIGHT-198)/2);
        sprite = sm.getImageAt(196, 156, getWidth(), getHeight());
        sprite.setAlpha(0.9f);
        smallTexts = new ArrayList<String>();
        Font headerFont = new Font("Verdana", Font.BOLD, 18);
        headerTTFont = new TrueTypeFont(headerFont, true);
        Font bodyFont = new Font("Verdana", Font.PLAIN, 18);
        bodyTTFont = new TrueTypeFont(bodyFont, true);
        Font bodySmallFont = new Font("Verdana", Font.PLAIN, 8);
        bodySmallTTFont = new TrueTypeFont(bodySmallFont, true);
        
        smallTexts.add("You are so rude!");
        smallTexts.add("How can you hit an arrow like that!");
        stageText = "Stage: "+StageFactory.stageCount;
        scoreText = "Score: "+Score.getScore();
    }
    
    @Override
    public void render() {
        super.render();
        headerTTFont.drawString(getX()+30, getY()+5, "Game Over!", Color.white);

        for (String str : smallTexts) {
            bodySmallTTFont.drawString(getX()+5, getY()+getHeight()-30+(smallTexts.indexOf(str)*15), str, Color.yellow);
        }
        
        bodyTTFont.drawString(getX()+5, getY()+40, stageText, Color.white);
        bodyTTFont.drawString(getX()+5, getY()+60, scoreText, Color.white);
    }
    
}
