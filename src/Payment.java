interface Payment {
    boolean pay(double prices);
    void changePaymentMethod(Payment payment);
    void changePaymentAccount(String account);
    // payments like credit card, paypal, afterpay will implement this interface
}
