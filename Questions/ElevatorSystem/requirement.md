# Elevator System — Requirements

## System overview

- The system manages multiple elevators in a building with multiple floors.
- Users request elevators from floors (up/down) and select destination floors inside the elevator.
- The system schedules elevator movement to minimize wait times and optimize assignments.
- Safety features (emergency stop, door obstruction) must be supported.

## Rules of the system

### Setup

- The building has multiple floors and can have multiple elevators.
- Elevators can be called from any floor and can travel to any floor.
- The system schedules elevator movement based on requests and optimizes for efficiency.

### Operation

- Users can request an elevator from any floor by pressing **up/down** buttons (external requests).
- Inside the elevator, users can select **destination floors** (internal requests).
- The system prioritizes and schedules these requests efficiently.
- Elevators have indicators showing **current floor** and **direction**.

### Safety features

- **Emergency stop** functionality must be available.
- **Door sensors** prevent doors from closing if obstructed.

## Flow (summary)

1. **External request:** User on floor F presses UP or DOWN → controller creates `CallRequest` → scheduling strategy selects an elevator → that elevator adds F to its `stopList` and (when stepped) moves to F.
2. **Internal request:** User inside elevator selects floor G → `submitDestinationRequest(new DestinationRequest(elevatorId, G))` → that elevator adds G to its `stopList`; elevator visits G in order with other stops.
3. **Movement:** Each tick, each elevator’s `step()` is called; state (Idle → MovingUp/Down → DoorOpen → …) determines whether to move one floor or open/close doors; when no more stops, elevator becomes IDLE.
4. **Safety:** Emergency stop / maintenance use dedicated states whose `step()` is a no-op; door obstructed blocks transition from DoorOpen to Moving.

## Implementation

- Java code in `Questions/ElevatorSystem/`: entities, State pattern (elevator behavior), Strategy (scheduling), Observer (display/panels), Singleton (controller).
- Run: `make run-elevator` from project root (see `README.md`).

## Summary

1. Multiple floors, multiple elevators.
2. External requests (from floor, up/down) and internal requests (destination from inside elevator).
3. Efficient scheduling to minimize wait times (pluggable strategy).
4. Current floor and direction indicators (observers).
5. Emergency stop, door obstruction handling.
6. (Out of scope here: destination selection from outside the elevator.)
