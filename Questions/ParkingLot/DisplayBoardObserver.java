package Questions.ParkingLot;

public class DisplayBoardObserver implements ExitObserver{
    @Override
    public void onVehicleExited(Ticket ticket) {
        System.out.println("[Display] Slot " + ticket.getSlot().getId() + " is now available.");
    }
}
