package topic.designpattern.creational.factory;

public class PaymentFactory {

    public PaymentMethod createPaymentFactory(PaymentType type){

        if(type == null )
            return null;

        switch (type) {
            case CREDIT_CARD:
                return new CreditCardPayment();
            case PAYPAL:
                return new PayPalPayment();
            case BANK_TRANSFER:
                return new BankTransferPayment();
            default:
                return null;

        }


    }
}
