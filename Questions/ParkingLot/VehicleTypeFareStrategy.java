package Questions.ParkingLot;

import java.util.Map;

public class VehicleTypeFareStrategy implements FareStrategy{
    private final Map<VehicleType, Double> ratePerHourByType;

    public VehicleTypeFareStrategy(Map<VehicleType, Double> ratePerHourByType) {
        this.ratePerHourByType = ratePerHourByType;
    }

    @Override
    public double calculateFee(VehicleType vehicleType, long durationMinutes) {
        double rate = ratePerHourByType.getOrDefault(vehicleType, 10.0);
        double hours = durationMinutes / 60.0;
        return Math.ceil(hours) * rate;
    }
}
