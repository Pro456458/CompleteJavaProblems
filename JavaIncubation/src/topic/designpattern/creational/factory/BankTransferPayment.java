package topic.designpattern.creational.factory;

public class BankTransferPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Bank Transfer.");
    }
}