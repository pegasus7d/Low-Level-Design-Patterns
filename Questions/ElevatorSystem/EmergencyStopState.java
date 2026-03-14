package Questions.ElevatorSystem;

public class EmergencyStopState implements ElevatorStateBehavior {
    @Override
    public void step(Elevator elevator) {
        // No-op: elevator does not move in emergency stop
    }

    @Override
    public ElevatorState getStateType() {
        return ElevatorState.EMERGENCY_STOP;
    }
}
