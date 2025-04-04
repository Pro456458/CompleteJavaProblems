package topic.designpattern.creational.factory;

public class TestFactoryDesignPattern {

    public static void main(String[] args) {

        PaymentFactory factory = new PaymentFactory();



        PaymentMethod creditCard = factory.createPaymentFactory(PaymentType.CREDIT_CARD);
        creditCard.pay(100.0);  // Output: Paid 100.0 using Credit Card.

        PaymentMethod payPal = factory.createPaymentFactory(PaymentType.PAYPAL);
        payPal.pay(200.0);  // Output: Paid 200.0 using PayPal.

        PaymentMethod bankTransfer = factory.createPaymentFactory(PaymentType.BANK_TRANSFER);
        bankTransfer.pay(300.0);  // Output: Paid 300.0 using Bank Transfer.

    }
}
