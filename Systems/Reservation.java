package Systems;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kiere
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Random;

import PersonClasses.Customer;


public class Reservation {
    private int ID;
    private Customer customer;
    private int guests;
    private int tableNumber;
    private LocalDateTime dateTime;
    
    
    //constructor
    public Reservation(Customer customer, int guests, String datetime) {
        this.customer = customer;
        this.guests = guests;
        this.generateID();
        this.parseDateTime(datetime);
    }
    
    //getters
    public int getID() {
        return ID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getGuests() {
        return guests;
    }

    public int getTableNumber() {
        return tableNumber;
    }


    //setters
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    public void setTableNum(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public void generateID(){
        Random random = new Random();
        this.ID = random.nextInt();   
    }
    
    public void parseDateTime(String datetime){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd/HH:mm");
            this.dateTime= LocalDateTime.parse(datetime, formatter);
        } 
        catch (DateTimeParseException e) {
            // Handle the case where the string is not in the expected format
            System.out.println("Error parsing the date-time string: " + e.getMessage());
        }
    }

	@Override
	public String toString() {
		return "Reservation [ID=" + ID + ", customer=" + customer.getName() + ", guests=" + guests + ", tableNumber="
				+ tableNumber + ", dateTime=" + dateTime + "]";
	}
    
    
    
    
}
