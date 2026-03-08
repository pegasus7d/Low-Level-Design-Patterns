# Approach — Design patterns for challenges

1. **Factory for vehicle creation**
  - Allows easy extension for new vehicle types.
  - Ensures consistent object creation.
2. **Strategy pattern for payments and parking fares**
  - Enables flexible payment methods and parking fares based on vehicle type and duration.
  - Easily extendable for future payment integrations and new fare strategies.
3. **Singleton pattern for parking lot management**
  - Ensures only one instance of the parking lot exists.
  - (If multiple locations are needed later, switch to a registry or dependency injection.)
4. **Observer pattern for exit notifications**
  - Notifies the system when a vehicle exits.
  - Can be extended for alerts or logging.

