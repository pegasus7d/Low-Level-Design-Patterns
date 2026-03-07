package Priority1.Adapter.MediaPlayerExample;

// Test for Adapter (MediaPlayer)
// TODO: Implement testPlayVlcViaAdapter() - create VlcPlayerAdapter and call play()

public class AdapterTest {

    public static void main(String[] args) {
        System.out.println("=== Adapter (MediaPlayer) Tests ===\n");
        testPlayVlcViaAdapter();
        testPlayMp4();
        testAdapterIsMediaPlayer();
        System.out.println("\n=== All tests passed ===");
    }

    // TODO: MediaPlayer player = new VlcPlayerAdapter(); player.play("movie.vlc");
    private static void testPlayVlcViaAdapter() {
        System.out.println("Test 1: Play VLC via Adapter");
        MediaPlayer player = null; // TODO: new VlcPlayerAdapter()
        assert player != null : "Player should not be null";
        player.play("movie.vlc");
        System.out.println("  ✓ Passed\n");
    }

    private static void testPlayMp4() {
        System.out.println("Test 2: Play MP4 directly");
        MediaPlayer player = new Mp4Player();
        player.play("movie.mp4");
        System.out.println("  ✓ Passed\n");
    }

    private static void testAdapterIsMediaPlayer() {
        System.out.println("Test 3: Adapter is MediaPlayer");
        MediaPlayer player = new VlcPlayerAdapter();
        assert player instanceof MediaPlayer : "Adapter should be MediaPlayer";
        System.out.println("  ✓ Passed\n");
    }
}
