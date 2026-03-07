package Priority1.Facade.HomeTheaterExample;

// Subsystem - sound
public class SoundSystem {
    public void on() { System.out.println("Sound on"); }
    public void setVolume(int level) { System.out.println("Volume: " + level); }
    public void off() { System.out.println("Sound off"); }
}
