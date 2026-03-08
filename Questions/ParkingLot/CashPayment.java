package Questions.ParkingLot;

public class CashPayment implements PaymentStrategy{
    @Override
    public boolean pay(double amount) {
        System.out.println("Payment using Cash");
        return true;
    }
}
