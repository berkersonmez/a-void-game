/*
 * All material belongs to Berker Sönmez,
 * do not copy or distribute without permission.
 */

package voidgame.resource.image;
import org.newdawn.slick.Image;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
/**
 *
 * @author Berker Sönmez <brkrsnmz@gmail.com>
 */
public class SpriteManager {
    private Image bigSpriteSource;
    
    private SpriteManager() {
        try {
        bigSpriteSource = new Image("voidgame/resource/image/sprites.gif");
        } catch (SlickException e) {
            // Do something!
        }
    }
    
    public static SpriteManager getInstance(){
        SpriteManager instance = new SpriteManager();
        return instance;
    }
    
    public Image getImageAt(int x, int y, int width, int height) {
        return bigSpriteSource.getSubImage(x, y, width, height);
    }
    
    public Animation getAnimationAt(int x, int y, int width, int height, int numberOfTiles, int duration) {
        Image[] imageArray = new Image[numberOfTiles];
        for (int i=0 ; i<numberOfTiles ; i++) {
            imageArray[i] = bigSpriteSource.getSubImage(x+i*width, y, width, height);
        }
        return new Animation(imageArray, duration, true);
    }
}
