package Questions.ParkingLot;

public class ExitLoggerObserver implements ExitObserver {
    @Override
    public void onVehicleExited(Ticket ticket) {
        System.out.println("[Exit] Vehicle " + ticket.getVehicle().getId() + " left slot "
                + ticket.getSlot().getId() + " (ticket " + ticket.getId() + ")");
    }
}
