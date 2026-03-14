package Questions.ElevatorSystem;

public class MovingUpState implements ElevatorStateBehavior {
    @Override
    public void step(Elevator elevator) {
        int currentFloor = elevator.getCurrentFloor();
        if (elevator.getStopList().contains(currentFloor)) {
            elevator.setPreviousDirection(Direction.UP);
            elevator.removeStop(currentFloor);
            elevator.setStateBehavior(new DoorOpenState());
            return;
        }
        if (currentFloor < elevator.getMaxFloor()) {
            elevator.setCurrentFloor(currentFloor + 1);
        }
    }

    @Override
    public ElevatorState getStateType() {
        return ElevatorState.MOVING_UP;
    }
}
