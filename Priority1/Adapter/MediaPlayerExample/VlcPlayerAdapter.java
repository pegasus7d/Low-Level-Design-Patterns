package Priority1.Adapter.MediaPlayerExample;

// Adapter: makes LegacyVlcPlayer work as a MediaPlayer
public class VlcPlayerAdapter implements MediaPlayer {
    private final LegacyVlcPlayer adaptee = new LegacyVlcPlayer();
    public void play(String fileName) { adaptee.playVlc(fileName); }
}
