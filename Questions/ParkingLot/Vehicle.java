package Questions.ParkingLot;

public abstract class Vehicle {
    private final String id;        // or int/UUID if you prefer
    private final String brand;


    public Vehicle(String id, String brand) {
        this.id = id;
        this.brand = brand;
    }


    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public abstract VehicleType getVehicleType();


}
