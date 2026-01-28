interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Thanh toán " + amount + " VND bằng thẻ credit card: " + cardNumber);
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Thanh toán " + amount + " VND qua PayPal: " + email);
    }
}

class ShoppingCart {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void checkout(int amount) {
        if (strategy == null) {
            System.out.println("Vui lòng chọn phương thức thanh toán!");
            return;
        }
        strategy.pay(amount);
    }
}

class ExFour {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        System.out.println("=== Thanh toán bằng Credit Card ===");
        PaymentStrategy creditCard = new CreditCardPayment("1234-5678-9012-3456");
        cart.setPaymentStrategy(creditCard);
        cart.checkout(500000);

        System.out.println("\n=== Thay đổi sang PayPal ===");
        PaymentStrategy paypal = new PayPalPayment("user@example.com");
        cart.setPaymentStrategy(paypal);
        cart.checkout(300000);

        System.out.println("\n=== Quay lại Credit Card ===");
        cart.setPaymentStrategy(creditCard);
        cart.checkout(150000);
    }
}
