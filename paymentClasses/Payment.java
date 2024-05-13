package paymentClasses;
import java.time.LocalDateTime;
import java.util.*;

import OrderClasses.Order;

/*
 * author: Ahmed Tarek
 */

public class Payment {
	/*
	 * Payment Class will be for processing payments and order bills for customers
	 */
	private String paymentId;
    private double amount;
    private String method;
    private Date timestamp;
    private boolean status;
    private String cardNumber; 
    private String expiryDate;
    private String CVV;
	static private int nextId = 1;

    public Payment(Order order, String method) {
        this.paymentId = generatePaymentId();
        this.amount = order.getCost(); // Taken from order class
        // Validate payment method
        if (!method.equalsIgnoreCase("cash") && !method.equalsIgnoreCase("credit")) {
            throw new IllegalArgumentException("Invalid payment method. Only cash and credit card are accepted.");
        }
        this.method = method;
        this.timestamp = new Date();
        this.status = false;
        if(method.equalsIgnoreCase("credit")) {
        	System.out.println("Please enter the following info about your card \n1)Card No.\n2)Expiry Date\n3)CVV");
        	Scanner scan = new Scanner(System.in);
        	cardNumber = scan.next();
        	expiryDate = scan.next();
        	CVV = scan.next();
        	scan.close();
        }
    }
    
    private String generatePaymentId() {
    	LocalDateTime currentTime = LocalDateTime.now();
        String id = currentTime.toString() + "-" + nextId;
        nextId++; // Increment the counter for the next ID
        return id;
	}

	private boolean processPayment() {
        // Simulating payment processing
    	PaymentProcessor P;
        if(method.equalsIgnoreCase("cash")) {
        	P = new CashPaymentProcessor();
        	P.processCashPayment(amount);
        	return P.isPaymentSuccessful();
        }else {
            P = new CreditCardProcessor();
            return P.processCreditCardPayment(cardNumber, expiryDate, CVV, amount);
        }
    }

	public void paymentMessage() {
		if(this.processPayment()) {
			System.out.println("Amount: $" + amount + " for payment ID: " + paymentId + " via " + method);
	        System.out.println("Payment processed successfully at " + timestamp);
	        status = true;
		}else {
			System.out.println("Payment Failed");
			status = false;
		}
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public double getAmount() {
		return amount;
	}

	public String getMethod() {
		return method;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public boolean getStatus() {
		return status;
	}
    
	
}
