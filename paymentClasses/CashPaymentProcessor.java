package paymentClasses;
import java.util.*;
import java.lang.Throwable;
/*
 * author: Ahmed Tarek
 */

public class CashPaymentProcessor implements PaymentProcessor {
	  @Override
	  public boolean processCreditCardPayment(String cardNumber, String expiryDate, String CVV, double amount) {
	    throw new UnsupportedOperationException("Credit card payments not supported by Cash Processor");
	  }

	  @Override
	  public boolean processCashPayment(double amount) {
	    System.out.println("Processing cash payment of $" + amount);
	    return true; // Payment successful for cash
	  }

	  @Override
	  public boolean isPaymentSuccessful() {
	    return true; // Cash payment is assumed successful here (can be modified)
	  }
}
