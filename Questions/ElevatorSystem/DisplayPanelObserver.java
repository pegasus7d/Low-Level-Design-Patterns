package Questions.ElevatorSystem;

import java.util.List;

public class DisplayPanelObserver implements ElevatorObserver {
    private final Building building;

    public DisplayPanelObserver(Building building) {
        this.building = building;
    }

    @Override
    public void onFloorChanged(Elevator elevator, int newFloor) {
        String floorLabel = getFloorLabel(newFloor);
        System.out.println("[Display] Elevator " + elevator.getId() + " at " + floorLabel
                + " | Direction: " + elevator.getDirection().getDisplayName());
    }

    private String getFloorLabel(int floorNumber) {
        if (floorNumber >= 0 && floorNumber < building.getNumFloors()) {
            return "Floor " + building.getFloors().get(floorNumber).getId();
        }
        return "Floor " + floorNumber;
    }
    @Override
    public void onStateChanged(Elevator elevator, ElevatorState newState) {
        System.out.println("[Display] Elevator " + elevator.getId() + " state: " + newState.getDisplayName());
    }

}
