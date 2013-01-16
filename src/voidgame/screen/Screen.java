/*
 * All material belongs to Berker Sönmez,
 * do not copy or distribute without permission.
 */

package voidgame.screen;

import java.awt.Font;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.TrueTypeFont;
import voidgame.Option;
import voidgame.gameplay.Attribute;
import voidgame.gameplay.PlayState;
import voidgame.gameplay.Score;
import voidgame.library.Counter;
import voidgame.resource.image.SpriteManager;

/**
 *
 * @author Berker Sönmez <brkrsnmz@gmail.com>
 */
public class Screen {
    static final Font messageFont = new Font("Verdana", Font.PLAIN, 26);
    static TrueTypeFont messageTTFont = new TrueTypeFont(messageFont, true);
    
    static final Font messageLittleFont = new Font("Verdana", Font.PLAIN, 18);
    static TrueTypeFont messageLittleTTFont = new TrueTypeFont(messageLittleFont, true);
    
    static final Font messageSoLittleFont = new Font("Verdana", Font.PLAIN, 12);
    static TrueTypeFont messageSoLittleTTFont = new TrueTypeFont(messageSoLittleFont, true);
    
    static Counter counter = new Counter(90, 120);
    
    static Image borterTile = SpriteManager.getInstance().getImageAt(0, 102, 20, 20);
    static Image bgTile = SpriteManager.getInstance().getImageAt(0, 128, 20, 20);
    
    static Image logo = SpriteManager.getInstance().getImageAt(212, 6, 248, 146);
    
    public static void drawBorders(Graphics gc) {        
        gc.fillRect(0, 0, PlayState.width, PlayState.gameBorderY, borterTile, 0, 0);
        gc.fillRect(0, PlayState.gameBorderHeight+PlayState.gameBorderY, PlayState.width, PlayState.gameBorderY, borterTile, 0, 0);
        gc.fillRect(0, PlayState.gameBorderY, PlayState.gameBorderX, PlayState.gameBorderHeight, borterTile, 0, 0);
        gc.fillRect(PlayState.gameBorderWidth+PlayState.gameBorderX, PlayState.gameBorderY, PlayState.gameBorderX, PlayState.gameBorderHeight, borterTile, 0, 0);
    }
    
    public static void drawBackground(Graphics gc) {        
        gc.fillRect(0, 0, PlayState.width, PlayState.width, bgTile, 0, 0);
    }
    
    public static void drawMenuMessages(Graphics gc) {
        if (counter.tock()) {
            messageTTFont.drawString(Option.WINDOW_WIDTH / 11, (Option.WINDOW_HEIGHT/4)*3, "POSITION WINKY AND PRESS 'ENTER' TO START!", Color.white);
            messageLittleTTFont.drawString((Option.WINDOW_WIDTH / 4), (Option.WINDOW_HEIGHT/4)*3 + 30, "MOVE WITH ARROW OR 'WASD' KEYS...", Color.white);
            messageSoLittleTTFont.drawString(30, 30, "PRO TIP: Near miss arrows for more score!", Color.white);
        }
    }
    
    public static void drawRetryMessage(Graphics gc) {
        if (counter.tock()) {
            messageLittleTTFont.drawString((Option.WINDOW_WIDTH / 3), (Option.WINDOW_HEIGHT/4)*3 + 30, "PRESS 'ENTER' TO TRY AGAIN!", Color.white);
        }
    }
    
    public static void drawAttributes(Graphics gc) {
        int i = 3;
        for(Attribute attr : Attribute.values()) {
            messageSoLittleTTFont.drawString(Option.WINDOW_WIDTH - (i*140), Option.WINDOW_HEIGHT-18, attr.name + ": " + attr.getVal(), Color.orange);
            i--;
        }
    }
    
    public static void drawScore(Graphics gc) {
        messageSoLittleTTFont.drawString(5, Option.WINDOW_HEIGHT-18, "SCORE: " + Score.getScore(), Color.white);
    }
    
    public static void drawLogo() {
        if (counter.tockCtrl()) {
            logo.draw((Option.WINDOW_WIDTH - 248)/2, (Option.WINDOW_HEIGHT - 146)/2);
        }
    }
}
