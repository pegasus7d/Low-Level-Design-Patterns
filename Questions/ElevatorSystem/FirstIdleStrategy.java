package Questions.ElevatorSystem;

import java.util.List;

public class FirstIdleStrategy implements SchedulingStrategy {


    @Override
    public Elevator selectElevator(CallRequest request, List<Elevator> elevators) {
        int fromFloor = request.getFromFloor();
        Elevator nearestIdle = null;
        int minDistance = Integer.MAX_VALUE;


        for (Elevator e : elevators) {
            if (e.getState() == ElevatorState.IDLE) {
                int distance = Math.abs(e.getCurrentFloor() - fromFloor);
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestIdle = e;
                }
            }
        }
        if (nearestIdle != null) return nearestIdle;

        return elevators.isEmpty() ? null : elevators.getFirst();

    }
}
