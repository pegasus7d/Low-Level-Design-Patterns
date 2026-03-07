package Priority2.State.VendingMachineExample;

// Context - holds current state, delegates to it
// TODO: Hold NoCoinState, HasCoinState, DispensingState and currentState. setState(), getNoCoinState(), getHasCoinState(), getDispensingState()
public class VendingMachine {
    private final NoCoinState noCoinState;
    private final HasCoinState hasCoinState;
    private final DispensingState dispensingState;
    private VendingState currentState;
    public VendingMachine() {
        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        dispensingState = new DispensingState(this);
        currentState = noCoinState;
    }
    public void setState(VendingState s) { currentState = s; }
    public VendingState getNoCoinState() { return noCoinState; }
    public VendingState getHasCoinState() { return hasCoinState; }
    public VendingState getDispensingState() { return dispensingState; }
    public void insertCoin() { currentState.insertCoin(); }
    public void ejectCoin() { currentState.ejectCoin(); }
    public void selectProduct() { currentState.selectProduct(); }
    public void dispense() { currentState.dispense(); }
}
