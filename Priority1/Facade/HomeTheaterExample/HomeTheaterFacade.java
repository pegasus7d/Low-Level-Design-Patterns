package Priority1.Facade.HomeTheaterExample;

// Facade: one simple method that uses all subsystems
// TODO: In watchMovie(), call lights.dim(10), sound.on(), sound.setVolume(5), dvd.on(), dvd.play(movie)
public class HomeTheaterFacade {
    private final DvdPlayer dvd = new DvdPlayer();
    private final Lights lights = new Lights();
    private final SoundSystem sound = new SoundSystem();
    public void watchMovie(String movie) {
        lights.dim(10);
        sound.on();
        sound.setVolume(5);
        dvd.on();
        dvd.play(movie);
    }
}
