package Questions.ElevatorSystem;

public class IdleState implements ElevatorStateBehavior {
    @Override
    public void step(Elevator elevator) {
        if (elevator.getStopList().isEmpty()) return;
        int currentFloor = elevator.getCurrentFloor();
        int target = elevator.getStopList().stream()
                .min((a, b) -> Integer.compare(
                        Math.abs(a - currentFloor),
                        Math.abs(b - currentFloor)))
                .orElse(currentFloor);
        if (target == currentFloor) {
            elevator.setPreviousDirection(Direction.IDLE);
            elevator.removeStop(currentFloor);
            elevator.setStateBehavior(new DoorOpenState());
            return;
        }
        if (target > currentFloor) elevator.setStateBehavior(new MovingUpState());
        else elevator.setStateBehavior(new MovingDownState());
    }

    @Override
    public ElevatorState getStateType() {
        return ElevatorState.IDLE;
    }
}
