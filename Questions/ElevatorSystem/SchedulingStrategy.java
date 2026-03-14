package Questions.ElevatorSystem;

import java.util.List;

public interface SchedulingStrategy {

    Elevator selectElevator(CallRequest request, List<Elevator> elevators);
}
