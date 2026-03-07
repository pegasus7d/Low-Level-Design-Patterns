package SolidPrinciples.InterfaceSegregation.WorkerExample;

/**
 * ISP: Clients should not depend on interfaces they don't use.
 * Workable = only work(). Robot implements this only.
 */
public interface Workable {
    String work();
}
