package paymentClasses;

/*
 * author: Ahmed Tarek
 */

interface PaymentProcessor {
	/*
	 * interface with some abstract methods to support both payment methods
	 * note: CVV stands for Card Verification Value
	 */
	  boolean processCreditCardPayment(String cardNumber, String expiryDate, String CVV, double amount);

	  boolean processCashPayment(double amount);

	  boolean isPaymentSuccessful();
}
