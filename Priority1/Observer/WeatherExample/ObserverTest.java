package Priority1.Observer.WeatherExample;

// Test for Observer (Weather)
// TODO: Implement testNotifyObservers() - create subject, attach observer, setWeather("Sunny"), assert observer got it

public class ObserverTest {

    public static void main(String[] args) {
        System.out.println("=== Observer (Weather) Tests ===\n");
        testNotifyObservers();
        testMultipleObservers();
        System.out.println("\n=== All tests passed ===");
    }

    // TODO: Create subject, create DisplayObserver, subject.attach(obs), subject.setWeather("Sunny")
    private static void testNotifyObservers() {
        System.out.println("Test 1: Notify Observers");
        WeatherSubject subject = new WeatherSubject();
        DisplayObserver obs = new DisplayObserver();
        // TODO: subject.attach(obs); subject.setWeather("Sunny");
        subject.attach(obs);
        subject.setWeather("Sunny");
        assert "Sunny".equals(obs.getLastWeather()) : "Observer should receive Sunny";
        System.out.println("  ✓ Passed\n");
    }

    private static void testMultipleObservers() {
        System.out.println("Test 2: Multiple Observers");
        WeatherSubject subject = new WeatherSubject();
        DisplayObserver o1 = new DisplayObserver();
        DisplayObserver o2 = new DisplayObserver();
        subject.attach(o1);
        subject.attach(o2);
        subject.setWeather("Rainy");
        assert "Rainy".equals(o1.getLastWeather()) && "Rainy".equals(o2.getLastWeather());
        System.out.println("  ✓ Passed\n");
    }
}
