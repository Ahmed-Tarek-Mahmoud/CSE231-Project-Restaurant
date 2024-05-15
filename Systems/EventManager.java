package Systems;
import java.time.LocalDateTime;
import java.util.ArrayList;

import personClasses.Customer;

public interface EventManager{
	
	ArrayList <Event> events = new ArrayList <Event>();
	
	default void CreateEvent(String Name ,String Date_Time)
	{
		events.add(new Event(Name,Date_Time));
	}
	
	void ReserveEventTables(int NumberOfTables, ArrayList <Integer> NumberOfSeats,Customer customer);

	
	void ChangeEventTables(int NumberOfTables, ArrayList <Integer> NumberOfSeats,Customer customer, ArrayList<Integer> DeletedReservations);

	
	
	default void DeleteEvent(String name)
	{
		for (int i=0; i<events.size();i++)
		{
			if(events.get(i).getName() == name) {events.set(i, null);}
		}
	}
	
	default void ChangeEventName(String old,String change)
	{
		for (int i=0; i<events.size();i++)
		{
			if(events.get(i).getName() == old) {events.get(i).setName(change);}
		}
	}
	
	default void ChangeEventDate(LocalDateTime old,LocalDateTime change)
	{
		for (int i=0; i<events.size();i++)
		{
			if(events.get(i).getDate() == old) {events.get(i).setDate(change);}
		}
	}
	
	
	
}
