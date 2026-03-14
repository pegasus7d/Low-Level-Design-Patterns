package Questions.ElevatorSystem;

public class DestinationRequest {

    private final int elevatorId;
    private final int toFloor;
    public DestinationRequest(int elevatorId, int toFloor) {
        this.elevatorId = elevatorId;
        this.toFloor = toFloor;
    }
    public int getElevatorId() {
        return elevatorId;
    }
    public int getToFloor() {
        return toFloor;
    }

}
