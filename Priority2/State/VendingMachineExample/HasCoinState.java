package Priority2.State.VendingMachineExample;

// State when coin inserted
public class HasCoinState implements VendingState {
    private final VendingMachine machine;
    public HasCoinState(VendingMachine m) { this.machine = m; }
    public void insertCoin() { System.out.println("Coin already inserted"); }
    public void ejectCoin() { System.out.println("Coin ejected"); machine.setState(machine.getNoCoinState()); }
    public void selectProduct() { System.out.println("Product selected"); machine.setState(machine.getDispensingState()); }
    public void dispense() { System.out.println("Select product first"); }
}
