package Questions.ElevatorSystem;

public enum ElevatorState {

    IDLE("Idle"),
    MOVING_UP("Moving Up"),
    MOVING_DOWN("Moving Down"),
    DOOR_OPEN("Door Open"),
    EMERGENCY_STOP("Emergency Stop"),
    OVERLOAD("Overload"),
    MAINTENANCE("Maintenance");


    private final String displayName;
    ElevatorState(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName() {
        return displayName;
    }
}
