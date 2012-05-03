/*
 * All material belongs to Berker Sönmez,
 * do not copy or distribute without permission.
 */

package voidgame.gameplay;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import voidgame.entity.EntityManager;
import voidgame.entity.Winky;
import voidgame.entity.EntityPlayable;
import voidgame.resource.image.SpriteManager;
/**
 *
 * @author Berker Sönmez <brkrsnmz@gmail.com>
 */
public class PlayState extends BasicGameState {
    private int gameBorderWidth = 620;
    private int gameBorderHeight = 460;
    private int gameBorderX = 10;
    private int gameBorderY = 10;
    private SpriteManager spriteManager = SpriteManager.getInstance();
    private EntityManager entityManager;
    private EntityPlayable player;
    
    public PlayState(int screenWidth, int screenHeight) {
        
    }
    
    public SpriteManager getSpriteManager() {
        return spriteManager;
    }
    
    @Override
    public int getID() {
        return 1;
    }
    
    @Override
    public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
        entityManager = new EntityManager();
        int[] movableArea = {gameBorderX, gameBorderY, gameBorderWidth, gameBorderHeight};
        player = new Winky(spriteManager, movableArea, 60, 65, 0.1, 1, 100, 100);
        entityManager.addEntity(player);
    }
    
    @Override
    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException {
        gc.getInput().addKeyListener(player);
    }
    
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        entityManager.updateAll(delta);
    }
    
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics gr) throws SlickException {
        entityManager.renderAll();
    }
    
}
