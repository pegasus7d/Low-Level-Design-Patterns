package Questions.ParkingLot;

public class Car extends Vehicle{

    public Car(String id, String brand) {
        super(id, brand);
    }
    @Override
    public VehicleType getVehicleType() {
        return VehicleType.CAR;
    }
}
