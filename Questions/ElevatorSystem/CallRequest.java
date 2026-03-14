package Questions.ElevatorSystem;

public class CallRequest {
    private final int fromFloor;
    private final Direction direction;

    public CallRequest(int fromFloor, Direction direction) {
        this.fromFloor = fromFloor;
        this.direction = direction;
    }
    public int getFromFloor() {
        return fromFloor;
    }
    public Direction getDirection() {
        return direction;
    }
}
