package Questions.ElevatorSystem;

import java.util.List;

public class ElevatorController {

    private final Building building;
    private SchedulingStrategy schedulingStrategy;

    private ElevatorController(Building building) {
        this.building = building;
        this.schedulingStrategy = new FirstIdleStrategy();
    }

    private static Building createDefaultBuilding() {
        return new Building(10, 2);  // 10 floors, 2 elevators
    }


    private static class Holder {
        private static final ElevatorController INSTANCE =
                new ElevatorController(createDefaultBuilding());
    }

    public static ElevatorController getInstance() {
        return Holder.INSTANCE;
    }
    public Building getBuilding() {
        return building;
    }

    public void setSchedulingStrategy(SchedulingStrategy strategy) {
        this.schedulingStrategy = strategy;
    }

    private Elevator selectElevator(CallRequest request) {
        List<Elevator> elevators = building.getElevators();
        return schedulingStrategy.selectElevator(request, elevators);
    }

    /** External request: someone on a floor presses up/down. Controller assigns an elevator and adds the floor to its stop list. */
    public void submitCallRequest(int floor, Direction direction) {
        CallRequest request = new CallRequest(floor, direction);
        Elevator elevator = selectElevator(request);
        if (elevator != null) {
            elevator.addStop(floor);
        }
    }

    /** Internal request: someone inside an elevator selects a destination floor. */
    public void submitDestinationRequest(DestinationRequest request) {
        Elevator elevator = building.getElevators().stream()
                .filter(e -> e.getId() == request.getElevatorId())
                .findFirst()
                .orElse(null);
        if (elevator != null) {
            elevator.addStop(request.getToFloor());
        }
    }






}
