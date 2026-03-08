package Questions.ParkingLot;

public class ParkingSlot {
    private final String id;
    private final VehicleType slotType;
    private SlotStatus status;

    public ParkingSlot(String id, VehicleType slotType) {
        this.id = id;
        this.slotType = slotType;
        this.status = SlotStatus.AVAILABLE;
    }

    public String getId() {
        return id;
    }

    public VehicleType getSlotType() {
        return slotType;
    }

    public SlotStatus getStatus() {
        return status;
    }

    public void markOccupied() {
        this.status = SlotStatus.OCCUPIED;
    }

    public void markAvailable() {
        this.status = SlotStatus.AVAILABLE;
    }

    public boolean isAvailable() {
        return status == SlotStatus.AVAILABLE;
    }

}
