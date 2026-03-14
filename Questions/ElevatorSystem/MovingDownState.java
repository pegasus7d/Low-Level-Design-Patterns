package Questions.ElevatorSystem;

public class MovingDownState implements ElevatorStateBehavior {
    @Override
    public void step(Elevator elevator) {
        int currentFloor = elevator.getCurrentFloor();
        if (elevator.getStopList().contains(currentFloor)) {
            elevator.setPreviousDirection(Direction.DOWN);
            elevator.removeStop(currentFloor);
            elevator.setStateBehavior(new DoorOpenState());
            return;
        }
        if (currentFloor > 0) {
            elevator.setCurrentFloor(currentFloor - 1);
        }
    }

    @Override
    public ElevatorState getStateType() {
        return ElevatorState.MOVING_DOWN;
    }
}
