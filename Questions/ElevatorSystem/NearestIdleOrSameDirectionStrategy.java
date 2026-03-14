package Questions.ElevatorSystem;

import java.util.List;

public class NearestIdleOrSameDirectionStrategy implements SchedulingStrategy {


    @Override
    public Elevator selectElevator(CallRequest request, List<Elevator> elevators) {
        int fromFloor = request.getFromFloor();
        Direction direction = request.getDirection();

        Elevator bestIdle = null;
        int minIdleDistance = Integer.MAX_VALUE;


        for (Elevator e : elevators) {
            if (e.getState() == ElevatorState.IDLE) {
                int distance = Math.abs(e.getCurrentFloor() - fromFloor);
                if (distance < minIdleDistance) {
                    minIdleDistance = distance;
                    bestIdle = e;
                }
            }
        }
        if (bestIdle != null) return bestIdle;

        for (Elevator e : elevators) {
            if (direction == Direction.UP && e.getState() == ElevatorState.MOVING_UP && e.getCurrentFloor() <= fromFloor)
                return e;
            if (direction == Direction.DOWN && e.getState() == ElevatorState.MOVING_DOWN && e.getCurrentFloor() >= fromFloor)
                return e;
        }
        return elevators.isEmpty() ? null : elevators.getFirst();


    }

}
