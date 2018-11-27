package bomberman.Sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundPlay {
    public static final String LEVEL_1_SOUND="C:\\Github\\asg1-mi-ng-th-t-to\\bombermanv2\\res\\BombermanSound\\04 Level 1.wav";
    public static final String MENU_SOUND=null;
    public static final String BOMB_FIRE="C:\\Github\\assignment-2-bomberman-japanteam\\src\\sound\\bomb_bang.wav";
    public static final String BOMBER_RUN_SOUND="C:\\Github\\asg1-mi-ng-th-t-to\\bombermanv2\\res\\BombermanSound\\foot.wav";
    public static final String START_SOUND="C:\\Github\\asg1-mi-ng-th-t-to\\bombermanv2\\res\\BombermanSound\\03 Start.wav" ;
    public static void playSound(String soundPath)  {
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File(soundPath));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
            //Thread.sleep(clip.getMicrosecondLength()/1000);
            //clip.close();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        playSound(START_SOUND);
    }
}


