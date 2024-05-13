package paymentClasses;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import OrderClasses.*;

/*
 * author: Ahmed Tarek
 */

public class Receipt {

	  private String receiptNumber;
	  private Order order;
	  private Payment payment;
	  private LocalDateTime timestamp;

	  public Receipt(Order order, Payment payment) {
	    this.receiptNumber = generateReceiptNumber(); // Implement logic for unique receipt number generation
	    this.order = order;
	    this.payment = payment;
	    this.timestamp = LocalDateTime.now();
	    //this.printReceipt();
	  }

	  private String generateReceiptNumber() {
		  StringBuilder receiptNumber = new StringBuilder();

		  // Use current timestamp in milliseconds for a base value
		  long base = System.currentTimeMillis();

		  // Extract last 4 digits of the timestamp
		  int timestampPart = (int) (base % 10000);

		  // Generate a random 4-digit number (avoid 0000 for uniqueness)
		  int randomPart = (int) (Math.random() * 9000) + 1000;

		  // Combine timestamp and random parts with a separator
		  receiptNumber.append("RCPT-").append(timestampPart).append("-").append(randomPart);

		  return receiptNumber.toString();
		}
	  public String getReceiptNumber() {
	    return receiptNumber;
	  }

	  public double getTotalAmountPaid() {
	    return payment.getAmount();
	  }

	 
	  public String getTimestamp() {
	    return timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")); // Format timestamp for readability
	  }

	  public String printReceipt() {
		double subTotal = order.getCost();
	    StringBuilder receipt = new StringBuilder();
	    receipt.append("** Restaurant Receipt **\n\n");
	    receipt.append("Receipt Number : ").append(receiptNumber).append("\n");
	    receipt.append("Order ID       : ").append(order.getOrderNumber()).append("\n");
	    receipt.append("Items Ordered  :\n");
	    for (Item item : order.getItems()) {
	      receipt.append("     - ").append(item.getName()).append(" : ").append(item.getPrice()).append("\n");
	    }
	    receipt.append("Subtotal       : $").append(String.format("%.2f", subTotal)).append("\n");
	    receipt.append("14% VAT\n").append("12% service\n");
	    receipt.append("Tax           : $").append(String.format("%.2f", 0.26*subTotal)).append("\n");
	    receipt.append("**Total       : $").append(String.format("%.2f", 1.26*subTotal)).append("**\n");
	    receipt.append("Payment Method: ").append(payment.getMethod()).append("\n");
	    receipt.append("Timestamp: ").append(getTimestamp()).append("\n");
	    return receipt.toString();
	  }
	}

