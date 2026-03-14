package Questions.ElevatorSystem;

public interface ElevatorObserver {

    /** Called when the elevator's current floor changes. */
    void onFloorChanged(Elevator elevator, int newFloor);
    /** Called when the elevator's state (e.g. IDLE, MOVING_UP, DOOR_OPEN) changes. */
    void onStateChanged(Elevator elevator, ElevatorState newState);
}
