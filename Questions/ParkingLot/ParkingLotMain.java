package Questions.ParkingLot;

public class ParkingLotMain {
    public static void main(String[] args) {
        ParkingLot lot = ParkingLot.getInstance();


        lot.addExitObserver(new ExitLoggerObserver());
        lot.addExitObserver(new DisplayBoardObserver());

        Vehicle car = VehicleFactory.createVehicle(VehicleType.CAR, "C-001", "Toyota");
        Ticket ticket = lot.assignSlot(car);

        System.out.println("Entry: Ticket " + ticket.getId() + ", Slot " + ticket.getSlot().getId());

        FareStrategy fareStrategy = new PerHourFareStrategy(10.0);
        PaymentStrategy paymentStrategy = new CashPayment();
        boolean ok = lot.processExit(ticket, fareStrategy, paymentStrategy);
        System.out.println("Exit: " + (ok ? "Success" : "Failed"));
    }
}
