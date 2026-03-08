package Questions.ParkingLot;

public interface FareStrategy {
    double calculateFee(VehicleType vehicleType, long durationMinutes);
}
