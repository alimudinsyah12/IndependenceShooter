package Sound;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class Sound{
    
    private Clip clip;
    private Long currentFrame;
    private String sound;
    AudioInputStream ais;
    public Sound(String sound){
        this.sound=sound;
        try{
            ais = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(sound));
            AudioFormat baseFormat = ais.getFormat();
            AudioFormat decodeFormat= new AudioFormat(
                AudioFormat.Encoding.PCM_SIGNED,
                baseFormat.getSampleRate(),
                16,
                baseFormat.getChannels(),
                baseFormat.getChannels()*2,
                baseFormat.getSampleRate(),
                false);
            AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat,ais);
            clip = AudioSystem.getClip();
            clip.open(dais);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void play(){
        if(clip == null) return;
        stop();
        clip.setFramePosition(0);
        clip.start();
    }
    
    public void playLoop(){
        clip.setFramePosition(0);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void pause() 
    {
        currentFrame = 
        clip.getMicrosecondPosition();
        clip.stop();
    }
    public void resume()
    {
        clip.close();
        clip.setMicrosecondPosition(currentFrame);
    }
    public void stop(){
        if(clip.isRunning()){
            clip.stop();
        }
    }
    
    public void close(){
        stop();
        clip.close();
    }
    public void resetAudioStream() throws UnsupportedAudioFileException, IOException,
                                            LineUnavailableException 
    {
        ais = AudioSystem.getAudioInputStream(
        new File(sound).getAbsoluteFile());
        clip.open(ais);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}