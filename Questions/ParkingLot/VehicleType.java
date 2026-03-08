package Questions.ParkingLot;

public enum VehicleType {


    BIKE(1,"Bike"),
    CAR(2,"Car");


    private final String displayName;
    private final int id;

    VehicleType(int id,String displayName){
        this.id=id;
        this.displayName=displayName;
    }

    public String getDisplayName(){
        return displayName;
    }
    public int getId() {
        return id;
    }

}
