package Questions.ElevatorSystem;

/**
 * State pattern: encapsulates elevator behavior per state.
 * Each concrete state handles step() and reports its ElevatorState enum value.
 */
public interface ElevatorStateBehavior {
    void step(Elevator elevator);
    ElevatorState getStateType();
}
