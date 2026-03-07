package Priority2.State.VendingMachineExample;

// State when no coin inserted
// TODO: Implement VendingState. insertCoin() -> machine.setState(hasCoinState). others print "Insert coin first"
public class NoCoinState implements VendingState {
    private final VendingMachine machine;
    public NoCoinState(VendingMachine m) { this.machine = m; }
    public void insertCoin() { machine.setState(machine.getHasCoinState()); }
    public void ejectCoin() { System.out.println("No coin to eject"); }
    public void selectProduct() { System.out.println("Insert coin first"); }
    public void dispense() { System.out.println("Insert coin first"); }
}
