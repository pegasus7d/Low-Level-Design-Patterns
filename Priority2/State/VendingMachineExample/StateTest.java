package Priority2.State.VendingMachineExample;

// Test for State (Vending Machine)
// TODO: Implement testInsertCoin() - create VendingMachine, call insertCoin(), assert state changed (e.g. selectProduct works)

public class StateTest {

    public static void main(String[] args) {
        System.out.println("=== State (Vending Machine) Tests ===\n");
        testInsertCoin();
        testFullCycle();
        System.out.println("\n=== All tests passed ===");
    }

    // TODO: VendingMachine vm = new VendingMachine(); vm.insertCoin(); vm.selectProduct(); vm.dispense();
    private static void testInsertCoin() {
        System.out.println("Test 1: Insert Coin");
        VendingMachine vm = null; // TODO: new VendingMachine(), insertCoin(), selectProduct(), dispense()
        assert vm != null : "Machine should not be null";
        vm.insertCoin();
        vm.selectProduct();
        vm.dispense();
        System.out.println("  ✓ Passed\n");
    }

    private static void testFullCycle() {
        System.out.println("Test 2: Full cycle");
        VendingMachine vm = new VendingMachine();
        vm.insertCoin();
        vm.selectProduct();
        vm.dispense();
        System.out.println("  ✓ Passed\n");
    }
}
