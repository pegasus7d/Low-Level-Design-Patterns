package Questions.ParkingLot;

public class Bike extends Vehicle{

    public Bike(String id, String brand) {
        super(id, brand);
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.BIKE;
    }
}
