package topic.designpattern.creational.factory;

public class CreditCardPayment implements PaymentMethod{
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}
