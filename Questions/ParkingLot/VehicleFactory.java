package Questions.ParkingLot;

public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType vehicleType,String id,String brand){

        return switch (vehicleType){
            case BIKE -> new Bike(id,brand);
            case CAR -> new Car(id,brand);
            default -> throw new IllegalArgumentException("Unknown vehicle type: " + vehicleType);
        };
    }
}
