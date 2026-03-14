package Questions.ElevatorSystem;

import java.util.List;

public class ElevatorMain {
    public static void main(String[] args) throws InterruptedException {
        ElevatorController controller = ElevatorController.getInstance();
        Building building = controller.getBuilding();
        List<Elevator> elevators = building.getElevators();

        for (Elevator e : elevators) {
            e.addObserver(new DisplayPanelObserver(building));
        }

        controller.submitCallRequest(2, Direction.UP);
        controller.submitDestinationRequest(new DestinationRequest(0, 5));
        controller.submitCallRequest(7, Direction.DOWN);
        controller.submitDestinationRequest(new DestinationRequest(1, 3));

        while (elevators.stream().anyMatch(Elevator::hasWork)) {
            for (Elevator e : elevators) {
                e.step();
            }
            Thread.sleep(200);
        }

        System.out.println("Simulation done.");
    }
}
