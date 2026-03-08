package Priority1.Facade.HomeTheaterExample;

// Test for Facade (Home Theater)
// TODO: Implement testWatchMovie() - create facade and call watchMovie("Inception")

public class FacadeTest {

    public static void main(String[] args) {
        System.out.println("=== Facade (Home Theater) Tests ===\n");
        testWatchMovie();
        testFacadeExists();
        System.out.println("\n=== All tests passed ===");
    }

    // TODO: HomeTheaterFacade facade = new HomeTheaterFacade(); facade.watchMovie("Inception");
    private static void testWatchMovie() {
        System.out.println("Test 1: Watch Movie");
        // TODO: new HomeTheaterFacade(), then facade.watchMovie("Inception")
        HomeTheaterFacade facade= new HomeTheaterFacade();
        assert facade != null : "Facade should not be null";
        facade.watchMovie("Inception");
        System.out.println("  ✓ Passed\n");
    }

    private static void testFacadeExists() {
        System.out.println("Test 2: Facade creates subsystems");
        HomeTheaterFacade facade = new HomeTheaterFacade();
        facade.watchMovie("Test Movie");
        System.out.println("  ✓ Passed\n");
    }
}
