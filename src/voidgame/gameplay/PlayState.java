/*
 * All material belongs to Berker Sönmez,
 * do not copy or distribute without permission.
 */

package voidgame.gameplay;
import java.util.Random;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import voidgame.Option;
import voidgame.entity.EntityManager;
import voidgame.entity.EntityPlayable;
import voidgame.entity.EntityStatic;
import voidgame.entity.GameOverTable;
import voidgame.entity.PlayStartTable;
import voidgame.entity.StageTable;
import voidgame.entity.Winky;
import voidgame.library.Counter;
import voidgame.library.Physics;
import voidgame.resource.image.SpriteManager;
import voidgame.resource.sound.MusicManager;
import voidgame.screen.Screen;
/**
 *
 * @author Berker Sönmez <brkrsnmz@gmail.com>
 */
public class PlayState extends BasicGameState implements KeyListener{
    public static final int STATE_MENU = 5;
    public static final int STATE_START = 0;
    public static final int STATE_NORMAL = 1;
    public static final int STATE_NEXT_STAGE = 2;
    public static final int STATE_ARROW_TOUCH = 3;
    public static final int STATE_GAME_OVER = 4;
    public static final int STATE_RESTART = 6;
    
    public static int gameBorderWidth = 760;
    public static int gameBorderHeight = 440;
    public static int gameBorderX = 20;
    public static int gameBorderY = 20;
    public static int width;
    public static int height;
    public static int state = 5;
    private Random rnd = new Random();
    private SpriteManager spriteManager = SpriteManager.getInstance();
    private EntityManager entityManager;
    private MusicManager musicManager;
    private EntityPlayable player;
    private EntityStatic stageInfo;
    private Counter counter;
    
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
        musicManager = new MusicManager();
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
            case STATE_MENU:
                entityManager.updateAll(delta);
                musicManager.playMenuMusic();
                break;
            case STATE_START:
                musicManager.playGameplayMusic();
                StageFactory.createStage();
                System.out.println("==GAME START==");
                stageInfo = new PlayStartTable(spriteManager);
                counter = new Counter(180);
                state = STATE_NEXT_STAGE;
                entityManager.updateAll(delta);
                break;
            case STATE_NORMAL:
                Score.step();
                if (entityManager.getNumberOfArrows() < Attribute.ARROWS_ON_SCREEN.getVal()) {
                    if (rnd.nextInt(100)+1 < Attribute.ARROW_CHANCE.getVal()) {
                        if (StageFactory.stg.isArrowLeft()) {
                            entityManager.addArrowRandomly(rnd, spriteManager);
                        } else {
                            StageFactory.createStage();
                            stageInfo = new StageTable(spriteManager);
                            counter = new Counter(180);
                            state = STATE_NEXT_STAGE;
                        }
                    }
                }
                entityManager.updateAll(delta);
                break;
            case STATE_NEXT_STAGE:
                if (counter.tick()) {
                    state = STATE_NORMAL;
                }
                entityManager.updateAll(delta);
                break;
            case STATE_ARROW_TOUCH:
                stageInfo = new GameOverTable(spriteManager);
                musicManager.playGameOverMusic();
                state = STATE_GAME_OVER;
                break;
            case STATE_GAME_OVER:
                break;
            case STATE_RESTART:
                clean();
                state = STATE_MENU;
                break;
        }
        
    }
    
    private void clean() {
        entityManager.flush();
        entityManager.addEntity(player);
        Score.reset();
        StageFactory.init();
        Attribute.reset();
    }
    
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics gr) throws SlickException {
        Screen.drawBackground(gr);
        Screen.drawBorders(gr);
        entityManager.renderAll(gr);
        if (state == STATE_NEXT_STAGE) {
            stageInfo.render();
        }
        if (state == STATE_MENU) {
            Screen.drawMenuMessages(gr);
            Screen.drawLogo();
        }
        if (state == STATE_GAME_OVER) {
            stageInfo.render();
            Screen.drawRetryMessage(gr);
        }
        if (state != STATE_MENU) {
            Screen.drawAttributes(gr);
            Screen.drawScore(gr);
        }
    }
    
    
    @Override
    public void keyPressed(int i, char c) {
        if (state == STATE_MENU && i == Input.KEY_ENTER) {
            state = STATE_START;
        } else if (state == STATE_GAME_OVER && i == Input.KEY_ENTER) {
            state = STATE_RESTART;
        }
    }
    
    @Override
    public boolean isAcceptingInput() {
        return true;
    }
}
