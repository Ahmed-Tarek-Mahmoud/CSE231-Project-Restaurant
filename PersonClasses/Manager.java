package personClasses;

import java.time.LocalDateTime;
import java.util.ArrayList;

import OrderClasses.Ingredients;
import OrderClasses.Item;
import Systems.*;

public class Manager extends Employee implements ReservationManager, TableManager, EventManager, MenuManager{


	public Manager(String name, String age, String gender, String iD, String phoneNumber, String eMail,
			String address, String role, String empSysID, int salary) {
		super(name, age, gender, iD, phoneNumber, eMail, address, role, empSysID, salary);
		
	}
	
	public void Reserve(Customer customer, int guests, String datetime) {
		this.CreateReservation(customer, guests, datetime);
		Rlist.get(Rlist.size()-1).setTableNum(this.ReserveTable(guests, customer));
	}
	
	

	@Override
	public void removeReservation(Reservation reservation) {
		Rlist.remove(reservation);
        this.DeleteTableReservation(reservation.getTableNumber());
	}

	@Override
	public void ReserveEventTables(int NumberOfTables, ArrayList<Integer> NumberOfSeats, Customer customer) {
		this.ReserveTable(NumberOfTables,NumberOfSeats,customer);
		
	}

	@Override
	public void ChangeEventTables(int NumberOfTables, ArrayList<Integer> NumberOfSeats, Customer customer,
			ArrayList<Integer> DeletedReservations) {
		this.DeleteTableReservation(DeletedReservations);
		this.ReserveTable(NumberOfTables,NumberOfSeats,customer);
		
		
	}


    
}
