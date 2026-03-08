# Entities

- Vehicle
- VehicleType
- ParkingSlot
- ParkingLot
- Ticket
- Payment
- FeeCalculator

---

## Entity properties

### Vehicle
| Property    | Type     | Notes        |
|------------|----------|--------------|
| id         | (e.g. int / UUID) | Primary key |
| brand      | String   |              |
| vehicleTypeId | (e.g. int) | Foreign key → VehicleType |

### VehicleType
| Property | Type   | Notes        |
|----------|--------|--------------|
| id       | (e.g. int) | Primary key |
| name     | String | e.g. BIKE, CAR, TRUCK |

### ParkingSlot
| Property   | Type     | Notes        |
|------------|----------|--------------|
| id        | (e.g. int) | Primary key |
| slotTypeId| (e.g. int) | Foreign key → VehicleType |
| status    | String/enum | e.g. AVAILABLE, OCCUPIED |

### ParkingLot
| Property | Type     | Notes        |
|----------|----------|--------------|
| id       | (e.g. int) | Primary key |
| slots    | List\<ParkingSlot\> (or slotIds) | Slots in this lot |

### Ticket
| Property  | Type     | Notes        |
|-----------|----------|--------------|
| id        | (e.g. int) | Primary key |
| vehicleId | (e.g. int) | Foreign key → Vehicle |
| slotId    | (e.g. int) | Foreign key → ParkingSlot |
| entryTime | (e.g. LocalDateTime) | When vehicle entered |

### Payment
| Property | Type     | Notes        |
|----------|----------|--------------|
| id       | (e.g. int) | Primary key |
| amount   | (e.g. double) | Fee paid |
| method   | String   | e.g. CASH, CARD |
| ticketId | (e.g. int) | Foreign key → Ticket |
| paidAt   | (e.g. LocalDateTime) | When payment was made |

### FeeCalculator
| Property | Type   | Notes        |
|----------|--------|--------------|
| (no persistent fields) | — | Usually a service: computes fee from duration / vehicle type (e.g. ratePerHour). |
