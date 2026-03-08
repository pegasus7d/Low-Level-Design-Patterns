package Questions.ParkingLot;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingLot {
    private final List<ParkingSlot> slots;
    private int ticketCounter;
    private final List<ExitObserver> exitObservers = new ArrayList<>();



    public void addExitObserver(ExitObserver observer) {
        exitObservers.add(observer);
    }
    private void notifyExitObservers(Ticket ticket) {
        for (ExitObserver o : exitObservers) {
            o.onVehicleExited(ticket);
        }
    }


    private ParkingLot(List<ParkingSlot> slots) {
        this.slots = new ArrayList<>(slots);
        this.ticketCounter = 0;
    }


    private static List<ParkingSlot> createDefaultSlots() {
        return List.of(
                new ParkingSlot("S1", VehicleType.BIKE),
                new ParkingSlot("S2", VehicleType.BIKE),
                new ParkingSlot("S3", VehicleType.CAR),
                new ParkingSlot("S4", VehicleType.CAR)
        );
    }

    private static class Holder {
        private static final ParkingLot INSTANCE = new ParkingLot(createDefaultSlots());
    }

    public static ParkingLot getInstance() {
        return Holder.INSTANCE;
    }


    public Optional<ParkingSlot> findAvailableSlot(VehicleType type) {
        return slots.stream()
                .filter(s -> s.getSlotType() == type && s.isAvailable())
                .findFirst();
    }

    public Ticket assignSlot(Vehicle vehicle) {
        ParkingSlot slot = findAvailableSlot(vehicle.getVehicleType())
                .orElseThrow(() -> new IllegalStateException("No slot available for " + vehicle.getVehicleType()));
        slot.markOccupied();
        String ticketId = "T-" + (++ticketCounter);
        return new Ticket(ticketId, vehicle, slot, LocalDateTime.now());
    }


    public void releaseSlot(Ticket ticket) {
        ticket.getSlot().markAvailable();
    }


    public List<ParkingSlot> getSlots() {
        return new ArrayList<>(slots);
    }


    public boolean processExit(Ticket ticket, FareStrategy fareStrategy, PaymentStrategy paymentStrategy) {
        long durationMinutes = ChronoUnit.MINUTES.between(ticket.getEntryTime(), LocalDateTime.now());
        double fee = fareStrategy.calculateFee(ticket.getVehicle().getVehicleType(), durationMinutes);
        boolean paid = paymentStrategy.pay(fee);
        if (paid) {
            releaseSlot(ticket);
            notifyExitObservers(ticket);
            return true;
        }
        return false;
    }






}
