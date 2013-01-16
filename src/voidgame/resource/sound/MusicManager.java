/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package voidgame.resource.sound;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Berker
 */
public class MusicManager {
    private Music menuMusic;
    private Music playMusic;
    private Music deathMusic;
    
    public MusicManager() {
        try {
            menuMusic = new Music("voidgame/resource/sound/VoidGameCalm.ogg");
            playMusic = new Music("voidgame/resource/sound/VoidGamePlay.ogg");
            deathMusic = new Music("voidgame/resource/sound/VoidGameOver.ogg");
        } catch (SlickException ex) {
            Logger.getLogger(MusicManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void playMenuMusic() {
        if (!menuMusic.playing()) {
            menuMusic.loop();
        }
    }
    
    public void playGameplayMusic() {
        if (!playMusic.playing()) {
            playMusic.loop();
        }
    }
    
    public void playGameOverMusic() {
        if (!deathMusic.playing()) {
            deathMusic.play();
        }
    }
}
