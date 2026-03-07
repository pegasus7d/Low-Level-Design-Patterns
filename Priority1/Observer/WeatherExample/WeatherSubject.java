package Priority1.Observer.WeatherExample;

// Subject - holds state, notifies observers
import java.util.ArrayList;
import java.util.List;
// TODO: private String weather; setWeather(String w) must notify all observers via o.update(weather)
public class WeatherSubject {
    private List<WeatherObserver> observers = new ArrayList<>();
    private String weather;
    public void attach(WeatherObserver o) { observers.add(o); }
    public void setWeather(String weather) {
        this.weather = weather;
        // TODO: for each observer, call observer.update(weather)
        for (WeatherObserver o : observers) o.update(weather);
    }
    public String getWeather() { return weather; }
}
