/*
 * All material belongs to Berker Sönmez,
 * do not copy or distribute without permission.
 */

package voidgame.entity;
import java.util.ArrayList;
import java.util.Random;
import org.newdawn.slick.Graphics;
import voidgame.Option;
import voidgame.gameplay.PlayState;
import voidgame.library.Physics;
import voidgame.resource.image.SpriteManager;
/**
 *
 * @author Berker Sönmez <brkrsnmz@gmail.com>
 */
public class EntityManager {
    private ArrayList<Entity> entities = new ArrayList<Entity>();
    private int numberOfArrows = 0;
    
    public void addEntity(Entity newEntity) {
        entities.add(newEntity);
        if (newEntity instanceof Arrow) numberOfArrows++;
    }
    
    public void removeEntity(Entity oldEntity) {
        entities.remove(oldEntity);
    }
    
    public void renderAll(Graphics gr) {
        for (Entity entity : entities) {
            entity.render();
            if (Option.DEBUG_DRAW_COLLISION_SHAPES){
                entity.physics.drawMask(gr);
            }
        }
    }
    
    public void updateAll(int delta) {
        ArrayList<Integer> entitiesToDelete = new ArrayList<Integer>();
        for (Entity entity : entities) {
            if (entity.physics.isOutOfScreen()) {
                entitiesToDelete.add(entities.indexOf(entity));
                if (entity instanceof Arrow) numberOfArrows--;
            } else
                entity.update(delta);
        }
        checkArrowTouch();
        deleteEntities(entitiesToDelete);
    }
    
    private void checkArrowTouch() {
        for (Entity entity1 : entities) {
            if (entity1 instanceof Winky) {
                for (Entity entity2 : entities) {
                    if (entity2 instanceof Arrow) {
                        if (entity1.physics.collidesWith(entity2.physics)) PlayState.state = PlayState.STATE_ARROW_TOUCH;
                    }
                }
                break;
            }
        }
    }
    
    public void deleteEntities(ArrayList<Integer> entityList) {
        for (int entity : entityList) {
            entities.remove(entity);
        }
    }
    
    public int getNumberOfArrows() {
        return numberOfArrows;
    }
    
    public void addArrowRandomly(Random rnd, SpriteManager sm) {
        int xOfArrow = 0;
        int yOfArrow = 0;
        int direction = 0;
        switch (rnd.nextInt(4)) {
            case 0:
                yOfArrow = -Option.ENTITY_ARROW_SPAWN_COORD;
                xOfArrow = rnd.nextInt(Option.ENTITY_ARROW_MAX_POS_X - Option.ENTITY_ARROW_MIN_POS_X+1)+Option.ENTITY_ARROW_MIN_POS_X;
                direction = Physics.DOWN;
                break;
            case 1:
                xOfArrow = Option.ENTITY_ARROW_SPAWN_COORD + Option.WINDOW_WIDTH;
                yOfArrow = rnd.nextInt(Option.ENTITY_ARROW_MAX_POS_Y - Option.ENTITY_ARROW_MIN_POS_Y+1)+Option.ENTITY_ARROW_MIN_POS_Y;
                direction = Physics.LEFT;
                break;
            case 2:
                yOfArrow = Option.ENTITY_ARROW_SPAWN_COORD + Option.WINDOW_HEIGHT;
                xOfArrow = rnd.nextInt(Option.ENTITY_ARROW_MAX_POS_X - Option.ENTITY_ARROW_MIN_POS_X+1)+Option.ENTITY_ARROW_MIN_POS_X;
                direction = Physics.UP;
                break;
            case 3:
                xOfArrow = -Option.ENTITY_ARROW_SPAWN_COORD;
                yOfArrow = rnd.nextInt(Option.ENTITY_ARROW_MAX_POS_Y - Option.ENTITY_ARROW_MIN_POS_Y+1)+Option.ENTITY_ARROW_MIN_POS_Y;
                direction = Physics.RIGHT;
                break;
        }
        addEntity(new Arrow(sm, xOfArrow, yOfArrow, direction));
    }
    
}
