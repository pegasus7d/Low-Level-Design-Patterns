# Parking Lot — Design Diagram

## Class diagram (Mermaid)

```mermaid
classDiagram
    direction TB

    %% Enums
    class VehicleType {
        <<enum>>
        BIKE
        CAR
        -id: int
        -displayName: String
        +getId()
        +getDisplayName()
    }
    class SlotStatus {
        <<enum>>
        AVAILABLE
        OCCUPIED
    }

    %% Vehicle hierarchy (Factory)
    class Vehicle {
        <<abstract>>
        -id: String
        -brand: String
        +Vehicle(String, String)
        +getId()
        +getBrand()
        +getVehicleType()* VehicleType
    }
    class Car { }
    class Bike { }
    class VehicleFactory {
        +createVehicle(VehicleType, String, String) Vehicle
    }
    Vehicle <|-- Car
    Vehicle <|-- Bike
    Vehicle ..> VehicleType : getVehicleType

    %% Core entities
    class ParkingSlot {
        -id: String
        -slotType: VehicleType
        -status: SlotStatus
        +markOccupied()
        +markAvailable()
        +isAvailable()
        +getId()
        +getSlotType()
    }
    class Ticket {
        -id: String
        -vehicle: Vehicle
        -slot: ParkingSlot
        -entryTime: LocalDateTime
        +getId()
        +getVehicle()
        +getSlot()
        +getEntryTime()
    }
    class ParkingLot {
        -slots: List~ParkingSlot~
        -ticketCounter: int
        -exitObservers: List~ExitObserver~
        +getInstance() ParkingLot
        +findAvailableSlot(VehicleType) Optional~ParkingSlot~
        +assignSlot(Vehicle) Ticket
        +releaseSlot(Ticket)
        +processExit(Ticket, FareStrategy, PaymentStrategy) boolean
        +addExitObserver(ExitObserver)
        +getSlots()
    }

    %% Fare strategy
    class FareStrategy {
        <<interface>>
        +calculateFee(VehicleType, long) double
    }
    class PerHourFareStrategy {
        -ratePerHour: double
        +calculateFee(VehicleType, long) double
    }
    class VehicleTypeFareStrategy {
        -ratePerHourByType: Map~VehicleType, Double~
        +calculateFee(VehicleType, long) double
    }
    FareStrategy <|.. PerHourFareStrategy
    FareStrategy <|.. VehicleTypeFareStrategy

    %% Payment strategy
    class PaymentStrategy {
        <<interface>>
        +pay(double) boolean
    }
    class CashPayment { }
    class CardPayment { }
    PaymentStrategy <|.. CashPayment
    PaymentStrategy <|.. CardPayment

    %% Observer pattern
    class ExitObserver {
        <<interface>>
        +onVehicleExited(Ticket)
    }
    class DisplayBoardObserver { }
    class ExitLoggerObserver { }
    ExitObserver <|.. DisplayBoardObserver
    ExitObserver <|.. ExitLoggerObserver

    class ParkingLotMain {
        +main(String[])
    }

    %% Relationships
    ParkingSlot ..> VehicleType : slotType
    ParkingSlot ..> SlotStatus : status
    Ticket "1" *-- "1" Vehicle : vehicle
    Ticket "1" *-- "1" ParkingSlot : slot
    ParkingLot "1" *-- "*" ParkingSlot : slots
    ParkingLot "1" *-- "*" ExitObserver : notifies
    ParkingLot ..> FareStrategy : processExit
    ParkingLot ..> PaymentStrategy : processExit
    ParkingLot ..> Ticket : assignSlot / processExit
    ParkingLotMain ..> ParkingLot : uses
    ParkingLotMain ..> VehicleFactory : uses
    ParkingLotMain ..> FareStrategy : uses
    ParkingLotMain ..> PaymentStrategy : uses
```

## Pattern summary

| Pattern   | Role |
|----------|------|
| **Singleton** | `ParkingLot` — `getInstance()` (holder idiom); single lot instance per process. |
| **Factory** | `VehicleFactory.createVehicle(VehicleType, id, brand)` — creates `Car` or `Bike`; easy to add new vehicle types. |
| **Strategy (Fare)** | `FareStrategy` — `calculateFee(vehicleType, durationMinutes)`. Implementations: `PerHourFareStrategy`, `VehicleTypeFareStrategy`. |
| **Strategy (Payment)** | `PaymentStrategy` — `pay(amount)`. Implementations: `CashPayment`, `CardPayment`. |
| **Observer** | `ExitObserver` — `ParkingLot` notifies observers when a vehicle exits (after payment). Implementations: `DisplayBoardObserver`, `ExitLoggerObserver`. |

## Entry flow

```mermaid
sequenceDiagram
    participant User
    participant ParkingLotMain
    participant VehicleFactory
    participant ParkingLot
    participant ParkingSlot
    participant Ticket

    User->>ParkingLotMain: run
    ParkingLotMain->>ParkingLot: getInstance()
    ParkingLotMain->>VehicleFactory: createVehicle(CAR, id, brand)
    VehicleFactory-->>ParkingLotMain: Vehicle (Car)
    ParkingLotMain->>ParkingLot: assignSlot(vehicle)
    ParkingLot->>ParkingLot: findAvailableSlot(vehicleType)
    ParkingLot->>ParkingSlot: markOccupied()
    ParkingLot->>ParkingLot: new Ticket(...)
    ParkingLot-->>ParkingLotMain: Ticket
```

## Exit flow

```mermaid
sequenceDiagram
    participant User
    participant ParkingLotMain
    participant ParkingLot
    participant FareStrategy
    participant PaymentStrategy
    participant ParkingSlot
    participant ExitObserver

    User->>ParkingLotMain: processExit(ticket, fareStrategy, paymentStrategy)
    ParkingLotMain->>ParkingLot: processExit(ticket, fareStrategy, paymentStrategy)
    ParkingLot->>FareStrategy: calculateFee(vehicleType, durationMinutes)
    FareStrategy-->>ParkingLot: fee
    ParkingLot->>PaymentStrategy: pay(fee)
    PaymentStrategy-->>ParkingLot: paid
    alt paid
        ParkingLot->>ParkingSlot: markAvailable()
        ParkingLot->>ExitObserver: onVehicleExited(ticket)
        ParkingLot-->>ParkingLotMain: true
    else not paid
        ParkingLot-->>ParkingLotMain: false
    end
```

## File layout

```
Questions/ParkingLot/
├── design.md              (this file)
├── README.md
├── requirement.md
├── entities.md
├── approach.md
├── followup.md
├── VehicleType.java
├── SlotStatus.java
├── Vehicle.java
├── Car.java
├── Bike.java
├── VehicleFactory.java
├── ParkingSlot.java
├── Ticket.java
├── ParkingLot.java
├── FareStrategy.java
├── PerHourFareStrategy.java
├── VehicleTypeFareStrategy.java
├── PaymentStrategy.java
├── CashPayment.java
├── CardPayment.java
├── ExitObserver.java
├── DisplayBoardObserver.java
├── ExitLoggerObserver.java
└── ParkingLotMain.java
```
