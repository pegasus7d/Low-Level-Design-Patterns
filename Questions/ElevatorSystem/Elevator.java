package Questions.ElevatorSystem;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private final int id;
    private int currentFloor;
    private final List<Integer> stopList;
    private boolean doorObstructed;
    private final int maxFloor;
    private Direction previousDirection = Direction.IDLE;
    private ElevatorStateBehavior stateBehavior;

    public Elevator(int id, int currentFloor, int maxFloor) {
        this.id = id;
        this.currentFloor = currentFloor;
        this.stopList = new ArrayList<>();
        this.doorObstructed = false;
        this.maxFloor = maxFloor;
        this.stateBehavior = new IdleState();
    }

    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        if (this.currentFloor != currentFloor) {
            this.currentFloor = currentFloor;
            notifyFloorChanged(this.currentFloor);
        }
    }

    public ElevatorState getState() {
        return stateBehavior.getStateType();
    }

    public void setState(ElevatorState state) {
        if (getState() != state) {
            stateBehavior = toStateBehavior(state);
            notifyStateChanged(state);
        }
    }

    /** State pattern: transition to a behavior object. Used by state classes and externally (e.g. EMERGENCY_STOP). */
    public void setStateBehavior(ElevatorStateBehavior behavior) {
        if (getState() != behavior.getStateType()) {
            stateBehavior = behavior;
            notifyStateChanged(behavior.getStateType());
        } else {
            stateBehavior = behavior;
        }
    }

    private static ElevatorStateBehavior toStateBehavior(ElevatorState state) {
        return switch (state) {
            case IDLE -> new IdleState();
            case MOVING_UP -> new MovingUpState();
            case MOVING_DOWN -> new MovingDownState();
            case DOOR_OPEN -> new DoorOpenState();
            case EMERGENCY_STOP -> new EmergencyStopState();
            case MAINTENANCE -> new MaintenanceState();
            case OVERLOAD -> new OverloadState();
        };
    }

    public List<Integer> getStopList() {
        return stopList;
    }

    public boolean isDoorObstructed() {
        return doorObstructed;
    }

    public void setDoorObstructed(boolean doorObstructed) {
        this.doorObstructed = doorObstructed;
    }



    public void addStop(int floor) {
        if (!stopList.contains(floor)) stopList.add(floor);
    }
    public void removeStop(int floor) {
        stopList.remove(Integer.valueOf(floor));
    }

    public Direction getDirection() {
        return switch (getState()) {
            case MOVING_UP -> Direction.UP;
            case MOVING_DOWN -> Direction.DOWN;
            default -> Direction.IDLE;
        };
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public Direction getPreviousDirection() {
        return previousDirection;
    }

    public void setPreviousDirection(Direction previousDirection) {
        this.previousDirection = previousDirection;
    }

    public void addObserver(ElevatorObserver observer) {
        observers.add(observer);
    }

    public boolean hasWork() {
        return !stopList.isEmpty() || getState() != ElevatorState.IDLE;
    }

    /** One tick: delegate to current state (State pattern). */
    public void step() {
        ElevatorState s = getState();
        if (s == ElevatorState.EMERGENCY_STOP || s == ElevatorState.MAINTENANCE || s == ElevatorState.OVERLOAD) {
            return;
        }
        stateBehavior.step(this);
    }

    private final List<ElevatorObserver> observers = new ArrayList<>();

    private void notifyFloorChanged(int newFloor) {
        for (ElevatorObserver o : observers) {
            o.onFloorChanged(this, newFloor);
        }
    }

    private void notifyStateChanged(ElevatorState newState) {
        for (ElevatorObserver o : observers) {
            o.onStateChanged(this, newState);
        }
    }



}
