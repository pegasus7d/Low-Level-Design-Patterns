# Parking Lot — Requirements

## System overview

- The system manages different types of vehicles.
- A parking slot is assigned when a vehicle enters and freed when it exits.
- Payment is completed at exit; the vehicle can leave only after payment is done.
- The system handles different vehicle sizes and slot allocations efficiently.

## Flow

- **Entry:** Vehicle arrives → system assigns a suitable slot → vehicle parks.
- **Exit:** Vehicle is about to leave → system calculates parking fee (e.g. by duration) → customer pays → slot is released.

## Features

- Supports different vehicle types: **Bike**, **Car**, **Truck**.
- Different slot sizes based on vehicle type (e.g. bike slot < car < truck).
- Multiple payment methods (e.g. cash, card).
- Smooth entry and exit with **parking fee calculation** (e.g. rate × duration).

## Summary

1. Manages different vehicle types.
2. Slot assigned on entry, freed on exit.
3. Payment must be completed before leaving (payment at exit).
4. Handles different vehicle sizes and slot allocation efficiently.
5. Vehicle types: Bike, Car, Truck.
6. Different slot sizes per vehicle type.
7. Multiple payment methods.
8. Fee calculation for smooth entry and exit.

