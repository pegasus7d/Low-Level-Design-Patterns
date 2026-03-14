# Approach — Design patterns for challenges

1. **State pattern for elevator behavior**
   - Encodes elevator state (IDLE, MOVING_UP, MOVING_DOWN, DOOR_OPEN, EMERGENCY_STOP, optionally OVERLOAD, MAINTENANCE).
   - **Implemented:** `ElevatorStateBehavior` interface with `step(Elevator)` and `getStateType()`; concrete classes `IdleState`, `MovingUpState`, `MovingDownState`, `DoorOpenState`, `EmergencyStopState`, `MaintenanceState`, `OverloadState`. `Elevator` holds `stateBehavior` and delegates `step()` to it; state objects transition by calling `elevator.setStateBehavior(nextState)`.
   - Behavior (move one floor, open/close door, pick next stop) lives in state classes; transitions are explicit.

2. **Strategy pattern for scheduling**
   - Lets you plug in different algorithms for “which elevator handles a call” (e.g. nearest idle, same-direction-first).
   - **Implemented:** `SchedulingStrategy` with `selectElevator(CallRequest request, List<Elevator> elevators)`. `ElevatorController` has `schedulingStrategy` (default `FirstIdleStrategy`) and `setSchedulingStrategy()`. Implementations: `FirstIdleStrategy`, `NearestIdleOrSameDirectionStrategy`.

3. **Command pattern for requests**
   - Call and destination requests can be modeled as commands (optional).
   - Not implemented in this codebase; we use `CallRequest` and `DestinationRequest` as data and controller methods `submitCallRequest` / `submitDestinationRequest` directly. Can be added later with an `ElevatorCommand` interface and queue.

4. **Singleton pattern for elevator controller**
   - One central controller per building.
   - **Implemented:** `ElevatorController.getInstance()` (holder idiom); single instance created with default building (e.g. 10 floors, 2 elevators).

5. **Observer pattern for indicators and panels**
   - Elevators notify listeners when floor or state changes.
   - **Implemented:** `ElevatorObserver` with `onFloorChanged(Elevator, int)` and `onStateChanged(Elevator, ElevatorState)`. `Elevator` has `addObserver()` and notifies in `setCurrentFloor` / `setStateBehavior` (only when value changes). Example: `DisplayPanelObserver` prints floor and state to console.
