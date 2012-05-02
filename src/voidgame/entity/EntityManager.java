/*
 * All material belongs to Berker Sönmez,
 * do not copy or distribute without permission.
 */

package voidgame.entity;
import java.util.ArrayList;
/**
 *
 * @author Berker Sönmez <brkrsnmz@gmail.com>
 */
public class EntityManager {
    private ArrayList<Entity> entities = new ArrayList<Entity>();
    
    public void addEntity(Entity newEntity) {
        entities.add(newEntity);
    }
    
    public void removeEntity(Entity oldEntity) {
        entities.remove(oldEntity);
    }
    
    public void renderAll() {
        for (Entity entity : entities) {
            entity.render();
        }
    }
    
    public void updateAll(int delta) {
        for (Entity entity : entities) {
            entity.update(delta);
        }
    }
}
