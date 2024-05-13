package paymentClasses;

/*
 * author: Ahmed Tarek
 */

public class CreditCardProcessor implements PaymentProcessor {



		  // Replace with actual Credit Card Processing Gateway Integration
		  private static final String GATEWAY_URL = "https://your-payment-gateway.com/process";

		  @Override
		  public boolean processCreditCardPayment(String cardNumber, String expiryDate, String CVV, double amount) {
		    // Simulate sending payment details to the gateway (replace with actual API call)
		    System.out.println("Simulating credit card payment processing...");
		    boolean success = Math.random() > 0.1; // Simulate random failure (10% chance)
		    return success;
		  }

		  @Override
		  public boolean processCashPayment(double amount) {
		    throw new UnsupportedOperationException("Cash payments not supported by Credit Card Processor");
		  }

		  @Override
		  public boolean isPaymentSuccessful() {
		    // In a real implementation, this would check the gateway response for success.
		    return true; // Placeholder for actual success check
		  }
		

}
