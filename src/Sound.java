import java.io.File;
import javax.sound.sampled.*;

public class Sound {
    private Clip clip;
    private boolean loopState = false;

    public void playMusic(String musicLocation) {
        stop(); // stop any previous clip on this Sound object

        try {
            File filePath = new File(musicLocation);
            if (!filePath.exists()) {
                System.out.println("Sound file not found: " + filePath.getAbsolutePath());
                return;
            }

            AudioInputStream audioInput = AudioSystem.getAudioInputStream(filePath);
            clip = AudioSystem.getClip();
            clip.open(audioInput);

            if (loopState) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                clip.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setLoop(boolean loopState) {
        this.loopState = loopState;
        if (clip != null && clip.isOpen()) {
            if (loopState) clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public void stop() {
        if (clip != null) {
            clip.stop();
            clip.close();
            clip = null;
        }
    }
}
