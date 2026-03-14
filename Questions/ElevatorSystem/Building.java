package Questions.ElevatorSystem;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private final int numFloors;
    private final List<Floor> floors;
    private final List<Elevator> elevators;


    public Building(int numFloors, int numElevators) {
        this.numFloors = numFloors;
        this.floors = new ArrayList<>();
        for (int i = 0; i < numFloors; i++) {
            floors.add(new Floor(i));
        }

        this.elevators = new ArrayList<>();
        for (int i = 0; i < numElevators; i++) {
            elevators.add(new Elevator(i, 0, numFloors - 1));
        }
    }

    public int getNumFloors() { return numFloors; }
    public List<Floor> getFloors() { return new ArrayList<>(floors); }
    public List<Elevator> getElevators() { return new ArrayList<>(elevators); }
}
