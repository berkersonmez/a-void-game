/*
 * All material belongs to Berker Sönmez,
 * do not copy or distribute without permission.
 */

package voidgame;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import voidgame.gameplay.PlayState;
/**
 *
 * @author Berker Sönmez <brkrsnmz@gmail.com>
 * @version 0.0.1
 */
public class Game extends StateBasedGame {

     static final int height = 480;
     static final int width = 640;
 
     static final boolean fullscreen = false;
 
     static final boolean showFPS = true;
 
     static final String title = "A Void Game";
 
     static final int fpslimit = 60;
     static final double version = 0.1;
     
     
     public Game(String title)
     {
          super(title + " v" + version);
     }
     
     @Override
     public void initStatesList(GameContainer gc) throws SlickException {
         addState(new PlayState(width, height));
     }
 
     public static void main(String[] args) throws SlickException
     {
          AppGameContainer app = new AppGameContainer(new Game(title));
          app.setDisplayMode(width, height, fullscreen);
          app.setSmoothDeltas(true);
          app.setTargetFrameRate(fpslimit);
          app.setShowFPS(showFPS);
          app.start();
     }
}
