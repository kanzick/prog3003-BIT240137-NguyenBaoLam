package com.ex02;

interface Payment {

    void pay(double amount);
}

class CreditCardPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card.");
    }
}

class PayPalPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal.");
    }
}

class CashPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Cash.");
    }
}

abstract class PaymentFactory {

    public abstract Payment createPayment();
}

class CreditCardFactory extends PaymentFactory {

    @Override
    public Payment createPayment() {
        return new CreditCardPayment();
    }
}

class PayPalFactory extends PaymentFactory {

    @Override
    public Payment createPayment() {
        return new PayPalPayment();
    }
}

class CashFactory extends PaymentFactory {

    @Override
    public Payment createPayment() {
        return new CashPayment();
    }
}

public class Ex02 {

    public static void main(String[] args) {
        PaymentFactory creditCardFactory = new CreditCardFactory();
        Payment creditCardPayment = creditCardFactory.createPayment();
        creditCardPayment.pay(150.75);

        PaymentFactory payPalFactory = new PayPalFactory();
        Payment payPalPayment = payPalFactory.createPayment();
        payPalPayment.pay(89.50);

        PaymentFactory cashFactory = new CashFactory();
        Payment cashPayment = cashFactory.createPayment();
        cashPayment.pay(40.00);
    }
}
