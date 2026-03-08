package SolidPrinciples.InterfaceSegregation.WorkerExample;

/**
 * ISP: Robot only works; it does NOT eat. So it implements only Workable, not Eatable.
 *
 * TODO: Implement Workable. work() should return "Robot working" (or similar).
 */
public class Robot implements Workable {

    @Override
    public String work() {
        // TODO: return a string like "Robot working"
        return "Robot working";
    }
}
