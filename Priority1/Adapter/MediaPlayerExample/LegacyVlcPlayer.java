package Priority1.Adapter.MediaPlayerExample;

// Adaptee - legacy class with different interface (we cannot change it)
public class LegacyVlcPlayer {
    public void playVlc(String fileName) {
        System.out.println("Playing VLC: " + fileName);
    }
}
