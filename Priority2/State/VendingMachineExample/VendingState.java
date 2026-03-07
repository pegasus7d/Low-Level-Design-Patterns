package Priority2.State.VendingMachineExample;

// State interface
public interface VendingState {
    void insertCoin();
    void ejectCoin();
    void selectProduct();
    void dispense();
}
