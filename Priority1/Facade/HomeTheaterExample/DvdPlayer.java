package Priority1.Facade.HomeTheaterExample;

// Subsystem - DVD player
public class DvdPlayer {
    public void on() { System.out.println("DVD on"); }
    public void play(String movie) { System.out.println("Playing: " + movie); }
    public void off() { System.out.println("DVD off"); }
}
