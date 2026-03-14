# Elevator System — LLD

Low-level design for an elevator system: multiple elevators, external call requests (floor + up/down), internal destination requests, scheduling, and movement with State, Strategy, Observer, and Singleton patterns.

## What’s implemented

- **Entities:** Building, Floor, Elevator, Direction, ElevatorState, CallRequest, DestinationRequest, ElevatorController.
- **State pattern:** Elevator behavior per state (`ElevatorStateBehavior` → IdleState, MovingUpState, MovingDownState, DoorOpenState, EmergencyStopState, etc.); `Elevator.step()` delegates to the current state.
- **Strategy pattern:** `SchedulingStrategy` (e.g. `FirstIdleStrategy`, `NearestIdleOrSameDirectionStrategy`) selects which elevator handles a call; controller uses `setSchedulingStrategy()` to plug different algorithms.
- **Observer pattern:** `ElevatorObserver` (e.g. `DisplayPanelObserver` with `Building` for floor labels); elevators notify on `setCurrentFloor` / state transitions; direction and state use `getDisplayName()`.
- **Singleton:** `ElevatorController.getInstance()` for one controller per building.
- **Movement:** External loop (e.g. in `ElevatorMain`) calls `elevator.step()` each tick; each elevator moves one floor per tick or opens/closes doors.

## How to run

From project root:

```bash
make run-elevator
```

Runs `ElevatorMain`: registers observers, submits call + destination requests for multiple elevators, then runs the simulation until all elevators are idle.

## Main classes

| Class | Role |
|-------|------|
| `ElevatorController` | Singleton; `submitCallRequest(floor, direction)`, `submitDestinationRequest(DestinationRequest)`; uses `SchedulingStrategy` to assign calls. |
| `Elevator` | Holds `stopList`, `ElevatorStateBehavior`; `step()`, `addStop()`, `addObserver()`, `hasWork()`. |
| `ElevatorStateBehavior` | State pattern interface; implementations: IdleState, MovingUpState, MovingDownState, DoorOpenState, etc. |
| `Building` | Holds floors and elevators; created with `numFloors`, `numElevators`. |
| `ElevatorMain` | Driver: get controller, add observers, submit requests, run `while (any hasWork) { for each elevator step(); sleep(200); }`. |

## Docs

- `requirement.md` — System overview, rules, flow.
- `entities.md` — Entities and properties.
- `approach.md` — Design patterns used.
- `followup.md` — Interview follow-ups (concurrency, scheduling, fault tolerance, thread-safety).
