/*
 * All material belongs to Berker Sönmez,
 * do not copy or distribute without permission.
 */

package voidgame;

/**
 *
 * @author Berker Sönmez <brkrsnmz@gmail.com>
 */
public class Option {
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 480;
    public static final boolean WINDOW_FULLSCREEN = false;
    public static final boolean WINDOW_SHOWFPS = true;
    public static final String WINDOW_TITLE = "A Void Game";
    public static final int WINDOW_FPS_LIMIT = 60;
    public static final double WINDOW_GAME_VERSION = 0.01;
    
    public static final boolean DEBUG_DRAW_COLLISION_SHAPES = false;
    
    public static final int STAGE_DEFAULT_EFFECT_CHANCE_1 = 50;
    public static final int STAGE_DEFAULT_EFFECT_CHANCE_2 = 30;
    public static final int STAGE_DEFAULT_EFFECT_CHANCE_3 = 10;
    public static final int STAGE_DEFAULT_EFFECT_CHANCE_4 = 0;
    public static final int STAGE_DEFAULT_EFFECT_CHANCE_5 = 0;
    
    
    public static final int ENTITY_WINKY_WIDTH = 60;
    public static final int ENTITY_WINKY_HEIGHT = 65;
    public static final double ENTITY_WINKY_ACC = 0.05;
    public static final double ENTITY_WINKY_MAX_SPEED = 0.5;
    public static final int ENTITY_WINKY_START_POS_X = 100;
    public static final int ENTITY_WINKY_START_POS_Y = 100;
    
    public static final int ENTITY_ARROW_WIDTH = 44;
    public static final int ENTITY_ARROW_HEIGHT = 20;
    public static final double ENTITY_ARROW_ACC = 0.5;
    public static final double ENTITY_ARROW_MAX_SPEED = 0.5;
    public static final int ENTITY_ARROW_MIN_POS_X = 64;
    public static final int ENTITY_ARROW_MIN_POS_Y = 64;
    public static final int ENTITY_ARROW_MAX_POS_X = 736;
    public static final int ENTITY_ARROW_MAX_POS_Y = 416;
    public static final int ENTITY_ARROW_SPAWN_COORD = 64;
    public static final int ENTITY_OUT_OF_SCREEN_BORDER = 64;
    
    public static final int ENTITY_COLLISION_TOLERANCE = 5;
}
