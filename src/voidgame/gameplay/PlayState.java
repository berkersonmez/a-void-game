/*
 * All material belongs to Berker Sönmez,
 * do not copy or distribute without permission.
 */

package voidgame.gameplay;
import java.util.Random;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import voidgame.Option;
import voidgame.entity.EntityManager;
import voidgame.entity.EntityPlayable;
import voidgame.entity.Winky;
import voidgame.resource.image.SpriteManager;
import voidgame.screen.Screen;
/**
 *
 * @author Berker Sönmez <brkrsnmz@gmail.com>
 */
public class PlayState extends BasicGameState {
    public static final int STATE_START = 0;
    public static final int STATE_NORMAL = 1;
    public static final int STATE_NEXT_STAGE = 2;
    public static final int STATE_ARROW_TOUCH = 3;
    public static final int STATE_GAME_OVER = 4;
    public static int gameBorderWidth = 760;
    public static int gameBorderHeight = 440;
    public static int gameBorderX = 20;
    public static int gameBorderY = 20;
    public static int width;
    public static int height;
    public static int state = 0;
    private Random rnd = new Random();
    private SpriteManager spriteManager = SpriteManager.getInstance();
    private EntityManager entityManager;
    private EntityPlayable player;
    
    public PlayState() {
        width = Option.WINDOW_WIDTH;
        height = Option.WINDOW_HEIGHT;
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
        player = new Winky(spriteManager, movableArea, Option.ENTITY_WINKY_WIDTH, Option.ENTITY_WINKY_HEIGHT, Option.ENTITY_WINKY_ACC, Option.ENTITY_WINKY_MAX_SPEED, Option.ENTITY_WINKY_START_POS_X, Option.ENTITY_WINKY_START_POS_Y);
        entityManager.addEntity(player);
        StageFactory.init();
    }
    
    @Override
    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException {
        gc.getInput().addKeyListener(player);
    }
    
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        switch(state) {
            case STATE_START:
                StageFactory.createStage();
                System.out.println("==GAME START==");
                state = STATE_NORMAL;
                break;
            case STATE_NORMAL:
                if (entityManager.getNumberOfArrows() < StageFactory.stg.getArrowsOnScreen().val) {
                    if (rnd.nextInt(100)+1 < StageFactory.stg.getArrowChance().val) {
                        if (StageFactory.stg.isArrowLeft()) {
                            entityManager.addArrowRandomly(rnd, spriteManager);
                        } else {
                            state = STATE_NEXT_STAGE;
                        }
                    }
                }
                break;
            case STATE_NEXT_STAGE:
                StageFactory.createStage();
                state = STATE_NORMAL;
                break;
            case STATE_ARROW_TOUCH:
                break;
            case STATE_GAME_OVER:
                break;
        }
        entityManager.updateAll(delta);
    }
    
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics gr) throws SlickException {
        Screen.drawBorders(gr);
        entityManager.renderAll();
    }
    
}
