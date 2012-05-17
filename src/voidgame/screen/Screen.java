/*
 * All material belongs to Berker Sönmez,
 * do not copy or distribute without permission.
 */

package voidgame.screen;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import voidgame.gameplay.PlayState;
import voidgame.resource.image.SpriteManager;

/**
 *
 * @author Berker Sönmez <brkrsnmz@gmail.com>
 */
public class Screen {
    public static void drawBorders(Graphics gc) {
        SpriteManager sm = SpriteManager.getInstance();
        Image borterTile = sm.getImageAt(0, 102, 20, 20);
        gc.fillRect(0, 0, PlayState.width, PlayState.gameBorderY, borterTile, 0, 0);
        gc.fillRect(0, PlayState.gameBorderHeight+PlayState.gameBorderY, PlayState.width, PlayState.gameBorderY, borterTile, 0, 0);
        gc.fillRect(0, PlayState.gameBorderY, PlayState.gameBorderX, PlayState.gameBorderHeight, borterTile, 0, 0);
        gc.fillRect(PlayState.gameBorderWidth+PlayState.gameBorderX, PlayState.gameBorderY, PlayState.gameBorderX, PlayState.gameBorderHeight, borterTile, 0, 0);
    }
    
    public static void drawBackground(Graphics gc) {
        SpriteManager sm = SpriteManager.getInstance();
        Image bgTile = sm.getImageAt(0, 128, 20, 20);
        gc.fillRect(0, 0, PlayState.width, PlayState.width, bgTile, 0, 0);
    }
}
