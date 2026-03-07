package Priority1.Adapter.MediaPlayerExample;

// Concrete target - plays MP4 natively
public class Mp4Player implements MediaPlayer {
    public void play(String fileName) { System.out.println("Playing MP4: " + fileName); }
}
