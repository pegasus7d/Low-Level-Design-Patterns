# Entities

- Building
- Floor
- Elevator
- Direction (enum)
- ElevatorState (enum)
- Request (or CallRequest + DestinationRequest)
- ElevatorController

---

## Entity properties

### Building
| Property   | Type              | Notes                    |
|------------|-------------------|--------------------------|
| numFloors  | int               | Number of floors         |
| floors     | List\<Floor\>     | Floors in the building   |
| elevators  | List\<Elevator\>  | Elevators in the building |

### Floor
| Property | Type   | Notes        |
|----------|--------|--------------|
| id       | (e.g. int) | Primary key; floor number (0 to N-1) |

### Elevator
| Property       | Type              | Notes                              |
|----------------|-------------------|------------------------------------|
| id             | (e.g. int)        | Primary key                        |
| currentFloor   | int               | Current floor position             |
| direction      | Direction         | UP, DOWN, IDLE                     |
| state          | ElevatorState     | IDLE, MOVING_UP, MOVING_DOWN, DOOR_OPEN, EMERGENCY_STOP, (OVERLOAD, MAINTENANCE) |
| stopList       | List\<Integer\> or Queue | Floors to stop at (ordered) |
| doorObstructed | boolean           | Door sensor; if true, don’t close   |

### Direction (enum)
| Value  | Notes                    |
|--------|--------------------------|
| UP     | Moving up                |
| DOWN   | Moving down              |
| IDLE   | Not moving               |

### ElevatorState (enum)
| Value         | Notes                              |
|---------------|------------------------------------|
| IDLE          | No movement, no door open          |
| MOVING_UP     | Moving upward                      |
| MOVING_DOWN   | Moving downward                    |
| DOOR_OPEN     | Stopped, door open                 |
| EMERGENCY_STOP| Emergency stop active               |
| OVERLOAD      | Optional; out of service (no load tracking in this impl) |
| MAINTENANCE   | Optional; out of service           |

### Request (or separate CallRequest / DestinationRequest)
| Property    | Type     | Notes                              |
|-------------|----------|------------------------------------|
| id          | (e.g. int) | Primary key                      |
| type        | enum     | CALL / DESTINATION                 |
| fromFloor   | int      | For CALL: floor where button pressed |
| direction   | Direction| For CALL: UP or DOWN               |
| elevatorId  | int      | For DESTINATION: which elevator    |
| toFloor     | int      | For DESTINATION: target floor       |

*(Alternatively: **CallRequest**(fromFloor, direction) and **DestinationRequest**(elevatorId, toFloor) as separate classes.)*

### ElevatorController
| Property     | Type                    | Notes                              |
|--------------|-------------------------|------------------------------------|
| building     | Building                | The building (floors + elevators)   |
| schedulingStrategy | SchedulingStrategy | Strategy for selecting elevator; no request queue in this impl |

*(Singleton: one controller per building.)*

---

## Implementation (Java classes)

| Concept | Classes |
|--------|---------|
| Requests | `CallRequest` (fromFloor, direction), `DestinationRequest` (elevatorId, toFloor) |
| State pattern | `ElevatorStateBehavior` interface; `IdleState`, `MovingUpState`, `MovingDownState`, `DoorOpenState`, `EmergencyStopState`, `MaintenanceState`, `OverloadState` |
| Scheduling | `SchedulingStrategy` interface; `FirstIdleStrategy`, `NearestIdleOrSameDirectionStrategy` (and others) |
| Observer | `ElevatorObserver` interface; `DisplayPanelObserver` |
| Driver | `ElevatorMain` — gets controller, registers observers, submits requests, runs step loop |
