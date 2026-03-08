package Questions.ParkingLot;

public class CardPayment implements PaymentStrategy{
    @Override
    public boolean pay(double amount) {
        System.out.println("Payment using Card");
        return true;
    }
}
