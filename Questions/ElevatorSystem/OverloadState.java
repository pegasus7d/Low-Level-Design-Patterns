package Questions.ElevatorSystem;

public class OverloadState implements ElevatorStateBehavior {
    @Override
    public void step(Elevator elevator) {
        // No-op: elevator does not move when overloaded
    }

    @Override
    public ElevatorState getStateType() {
        return ElevatorState.OVERLOAD;
    }
}
