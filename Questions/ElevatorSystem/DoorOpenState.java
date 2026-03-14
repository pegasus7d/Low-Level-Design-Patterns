package Questions.ElevatorSystem;

public class DoorOpenState implements ElevatorStateBehavior {
    @Override
    public void step(Elevator elevator) {
        if (elevator.isDoorObstructed()) return;
        if (elevator.getStopList().isEmpty()) {
            elevator.setPreviousDirection(Direction.IDLE);
            elevator.setStateBehavior(new IdleState());
            return;
        }
        int currentFloor = elevator.getCurrentFloor();
        boolean hasAbove = elevator.getStopList().stream().anyMatch(f -> f > currentFloor);
        boolean hasBelow = elevator.getStopList().stream().anyMatch(f -> f < currentFloor);
        Direction prev = elevator.getPreviousDirection();
        if (hasAbove && hasBelow) {
            elevator.setStateBehavior(prev == Direction.UP ? new MovingUpState() : new MovingDownState());
        } else if (hasAbove) {
            elevator.setStateBehavior(new MovingUpState());
        } else {
            elevator.setStateBehavior(new MovingDownState());
        }
    }

    @Override
    public ElevatorState getStateType() {
        return ElevatorState.DOOR_OPEN;
    }
}
