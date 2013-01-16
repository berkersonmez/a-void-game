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
     
     
     public Game(String title)
     {
          super(title + " v" + Option.WINDOW_GAME_VERSION);
     }
     
     @Override
     public void initStatesList(GameContainer gc) throws SlickException {
         addState(new PlayState());
     }
 
     public static void main(String[] args) throws SlickException
     {
          AppGameContainer app = new AppGameContainer(new Game(Option.WINDOW_TITLE));
          app.setDisplayMode(Option.WINDOW_WIDTH, Option.WINDOW_HEIGHT, Option.WINDOW_FULLSCREEN);
          app.setSmoothDeltas(true);
          app.setTargetFrameRate(Option.WINDOW_FPS_LIMIT);
          app.setShowFPS(Option.WINDOW_SHOWFPS);
          app.setIcon("voidgame/resource/image/icon.png");
          app.start();
     }
}
