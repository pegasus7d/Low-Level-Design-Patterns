package Questions.ParkingLot;

public class PerHourFareStrategy implements FareStrategy{
    private final double ratePerHour;
    public PerHourFareStrategy(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }
    @Override
    public double calculateFee(VehicleType vehicleType, long durationMinutes) {
        double hours = durationMinutes / 60.0;
        return Math.ceil(hours) * ratePerHour;  // or use different rate by vehicleType
    }
}
