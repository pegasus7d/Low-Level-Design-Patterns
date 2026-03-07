package Priority2.State.VendingMachineExample;

public class DispensingState implements VendingState {
    private final VendingMachine machine;
    public DispensingState(VendingMachine m) { this.machine = m; }
    public void insertCoin() { System.out.println("Wait for product"); }
    public void ejectCoin() { System.out.println("Too late"); }
    public void selectProduct() { System.out.println("Dispensing..."); }
    public void dispense() { System.out.println("Product dispensed"); machine.setState(machine.getNoCoinState()); }
}
