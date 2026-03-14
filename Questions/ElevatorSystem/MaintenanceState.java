package Questions.ElevatorSystem;

public class MaintenanceState implements ElevatorStateBehavior {
    @Override
    public void step(Elevator elevator) {
        // No-op: elevator out of service
    }

    @Override
    public ElevatorState getStateType() {
        return ElevatorState.MAINTENANCE;
    }
}
