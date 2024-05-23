package PersonClasses;

import OrderClasses.*;
import paymentClasses.*;

public class Customer extends Person {

	static float RestaurantRate;
	static int NumberOfReviews = 0;
	static int ReviewStack = 0;
	private Order currentOrder; // Added By Tarek

	public Customer(String name, String age, String gender, String iD, String phoneNumber, String eMail,
			String address) {
		super(name, age, gender, iD, phoneNumber, eMail, address);
	}

	// Request bill
	public void requestBill(String method) {
		if (!method.equalsIgnoreCase("cash") && !method.equalsIgnoreCase("credit")) {
			throw new IllegalArgumentException();
		}

		if (this.currentOrder == null)
			throw new NullPointerException();

		Payment P = new Payment(currentOrder, method);
		P.paymentMessage();
		if (P.getStatus()) {
			Receipt r = new Receipt(currentOrder, P);
			System.out.println(r.printReceipt());
			currentOrder = null;
		}
	}

	// Customer Review
	public void CustomerReview(int rate) {
		NumberOfReviews += 1;
		ReviewStack += rate;
		RestaurantRate = (float) ReviewStack / NumberOfReviews;
		if (RestaurantRate > 5)
			RestaurantRate = 5;
	}

	// This method is related to the Restaurant Class not the customer :)
	public void getRestaurantRate() {
		System.out.println("Restaurant's Rate is: " + RestaurantRate + "/5");
	}

	public Order getCurrentOrder() {
		return currentOrder;
	}


	// in GUI pressing checkbox call addItemToOrder method 
	public void requestOrder(int tableNumber) {
		currentOrder = new Order(tableNumber);
	}

	
	// this method does not change any attribute value but it is to be handeled in
	// program execution
	public void requestRecipt(String paymentMethod) {
		Payment myPayment = new Payment(currentOrder, paymentMethod);
		Receipt myReceipt = new Receipt(currentOrder, myPayment);
		// payment method to be defined during event handling
		myReceipt.printReceipt();
	}

}