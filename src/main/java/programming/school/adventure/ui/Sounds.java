package programming.school.adventure.ui;

import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class Sounds {

  // Clears out resources for any clips that are done playing.
  public static void clear() {
    
  }
  
  public static void play(URL resource) {
    try {
      AudioInputStream as = AudioSystem.getAudioInputStream(resource);
      AudioFormat af = as.getFormat();
      DataLine.Info info = new DataLine.Info(Clip.class, af);
      Clip audioClip = (Clip) AudioSystem.getLine(info);
      audioClip.open(as);
      audioClip.start();
    } catch (Exception e) {
      System.err.println("COULD NOT PLAY SOUND: " + e.getMessage());
      e.printStackTrace();
    } 

  }
}
