package SolidPrinciples.InterfaceSegregation.WorkerExample;

/**
 * Human needs both work and eat — implements Workable and Eatable.
 */
public class Human implements Workable, Eatable {
    @Override
    public String work() {
        return "Human working";
    }

    @Override
    public String eat() {
        return "Human eating";
    }
}
