package Priority1.Observer.WeatherExample;

// Concrete observer - displays weather when updated
public class DisplayObserver implements WeatherObserver {
    private String lastWeather;
    public void update(String weather) { this.lastWeather = weather; }
    public String getLastWeather() { return lastWeather; }
}
