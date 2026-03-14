# Elevator System — Design Diagram

## Class diagram (Mermaid)

```mermaid
classDiagram
    direction TB

    %% Enums
    class Direction {
        <<enum>>
        UP
        DOWN
        IDLE
        getDisplayName()
    }
    class ElevatorState {
        <<enum>>
        IDLE
        MOVING_UP
        MOVING_DOWN
        DOOR_OPEN
        EMERGENCY_STOP
        OVERLOAD
        MAINTENANCE
        getDisplayName()
    }

    %% Requests
    class CallRequest {
        -fromFloor: int
        -direction: Direction
        +getFromFloor()
        +getDirection()
    }
    class DestinationRequest {
        -elevatorId: int
        -toFloor: int
        +getElevatorId()
        +getToFloor()
    }

    %% State pattern
    class ElevatorStateBehavior {
        <<interface>>
        +step(Elevator)
        +getStateType() ElevatorState
    }
    class IdleState { }
    class MovingUpState { }
    class MovingDownState { }
    class DoorOpenState { }
    class EmergencyStopState { }
    class MaintenanceState { }
    class OverloadState { }
    ElevatorStateBehavior <|.. IdleState
    ElevatorStateBehavior <|.. MovingUpState
    ElevatorStateBehavior <|.. MovingDownState
    ElevatorStateBehavior <|.. DoorOpenState
    ElevatorStateBehavior <|.. EmergencyStopState
    ElevatorStateBehavior <|.. MaintenanceState
    ElevatorStateBehavior <|.. OverloadState

    %% Strategy pattern
    class SchedulingStrategy {
        <<interface>>
        +selectElevator(CallRequest, List~Elevator~) Elevator
    }
    class FirstIdleStrategy { }
    class NearestIdleOrSameDirectionStrategy { }
    SchedulingStrategy <|.. FirstIdleStrategy
    SchedulingStrategy <|.. NearestIdleOrSameDirectionStrategy

    %% Observer pattern
    class ElevatorObserver {
        <<interface>>
        +onFloorChanged(Elevator, int)
        +onStateChanged(Elevator, ElevatorState)
    }
    class DisplayPanelObserver {
        -building: Building
        +DisplayPanelObserver(Building)
        +onFloorChanged(Elevator, int)
        +onStateChanged(Elevator, ElevatorState)
    }
    ElevatorObserver <|.. DisplayPanelObserver

    %% Core entities
    class Floor {
        -id: int
        +Floor(int)
        +getId()
    }
    class Building {
        -numFloors: int
        -floors: List~Floor~
        -elevators: List~Elevator~
        +getNumFloors()
        +getFloors()
        +getElevators()
    }
    class Elevator {
        -id: int
        -currentFloor: int
        -stopList: List~Integer~
        -doorObstructed: boolean
        -maxFloor: int
        -previousDirection: Direction
        -stateBehavior: ElevatorStateBehavior
        -observers: List~ElevatorObserver~
        +step()
        +addStop(int)
        +addObserver(ElevatorObserver)
        +getState()
        +getDirection()
        +setStateBehavior(ElevatorStateBehavior)
    }
    class ElevatorController {
        -building: Building
        -schedulingStrategy: SchedulingStrategy
        -getInstance() ElevatorController
        +submitCallRequest(int, Direction)
        +submitDestinationRequest(DestinationRequest)
        +getBuilding()
        +setSchedulingStrategy(SchedulingStrategy)
    }
    class ElevatorMain {
        +main(String[])
    }

    %% Relationships
    Building "1" *-- "*" Floor : has
    Building "1" *-- "*" Elevator : has
    Elevator "1" o-- "1" ElevatorStateBehavior : stateBehavior
    Elevator "1" *-- "*" ElevatorObserver : notifies
    Elevator ..> Direction : getDirection
    Elevator ..> ElevatorState : getState
    ElevatorController "1" o-- "1" Building : building
    ElevatorController "1" o-- "1" SchedulingStrategy : strategy
    ElevatorController ..> CallRequest : uses
    ElevatorController ..> DestinationRequest : uses
    ElevatorController ..> Elevator : assigns to
    DisplayPanelObserver ..> Building : uses
    ElevatorMain ..> ElevatorController : uses
    ElevatorMain ..> Building : uses
    ElevatorMain ..> DisplayPanelObserver : creates
```

## Pattern summary

| Pattern   | Role |
|----------|------|
| **State** | `ElevatorStateBehavior` — one implementation per elevator state (Idle, MovingUp, MovingDown, DoorOpen, etc.). `Elevator.step()` delegates to `stateBehavior.step(this)`. |
| **Strategy** | `SchedulingStrategy` — selects which elevator handles a call. Controller uses `FirstIdleStrategy` (default) or `NearestIdleOrSameDirectionStrategy`. |
| **Observer** | `ElevatorObserver` — `Elevator` notifies observers on floor/state change. `DisplayPanelObserver` shows floor label, direction, state. |
| **Singleton** | `ElevatorController` — `getInstance()` (holder idiom); one controller per process. |

## Request flow

```mermaid
sequenceDiagram
    participant User
    participant ElevatorMain
    participant ElevatorController
    participant SchedulingStrategy
    participant Elevator
    participant State

    User->>ElevatorMain: run
    ElevatorMain->>ElevatorController: getInstance()
    ElevatorMain->>Elevator: addObserver(DisplayPanelObserver)
    ElevatorMain->>ElevatorController: submitCallRequest(floor, direction)
    ElevatorController->>ElevatorController: new CallRequest(...)
    ElevatorController->>SchedulingStrategy: selectElevator(request, elevators)
    SchedulingStrategy-->>ElevatorController: elevator
    ElevatorController->>Elevator: addStop(floor)
    ElevatorMain->>ElevatorController: submitDestinationRequest(DestinationRequest)
    ElevatorController->>Elevator: addStop(toFloor)
    loop each tick
        ElevatorMain->>Elevator: step()
        Elevator->>State: stateBehavior.step(this)
        State->>Elevator: setStateBehavior(next) / setCurrentFloor(...)
        Elevator->>Elevator: notify observers
    end
```

## File layout

```
Questions/ElevatorSystem/
├── design.md          (this file)
├── README.md
├── requirement.md
├── entities.md
├── approach.md
├── followup.md
├── Direction.java
├── ElevatorState.java
├── CallRequest.java
├── DestinationRequest.java
├── Floor.java
├── Building.java
├── Elevator.java
├── ElevatorStateBehavior.java
├── IdleState.java
├── MovingUpState.java
├── MovingDownState.java
├── DoorOpenState.java
├── EmergencyStopState.java
├── MaintenanceState.java
├── OverloadState.java
├── SchedulingStrategy.java
├── FirstIdleStrategy.java
├── NearestIdleOrSameDirectionStrategy.java
├── ElevatorObserver.java
├── DisplayPanelObserver.java
├── ElevatorController.java
└── ElevatorMain.java
```
