package Systems;
import java.util.ArrayList;

import java.util.Collections;

import personClasses.Customer;

public interface TableManager {

	ArrayList<Table> tables = new ArrayList <Table>();
		
	default boolean checkTableAvailability(int id)
	{
		for (int i=0; i<21; i++)
		{
			if (tables.get(i).getTableNumber()==id) {return tables.get(i).getStatus();}
		}
		return false;
	}
	default void UpdateTableStatus (int id , boolean status)
	{
		for (int i=0; i<21; i++)
		{
			if (tables.get(i).getTableNumber()==id) {tables.get(i).setStatus(status);}
		}
	}
	
	
	default void setTables () //sets 20 tables for the restaurant 
	{
		int tablenumber =0;
		
			for (int i=1; i<=5; i++) //Setting tables with even number of chairs 
			{
				tables.add(new Table(i*2 ,tablenumber++)); 
				tables.add(new Table(i*2,tablenumber++));
			}
			for (int i=1; i<=5; i++) //Setting tables with odd number of chairs 
			{
				tables.add(new Table((i*2)+1,tablenumber++));
				tables.add(new Table((i*2)+1,tablenumber++));
			}

			Collections.sort(tables);
	}
	
	
	default int ReserveTable(int guests, Customer customer)
	{
		for(Table t : tables) {
			if(t.getStatus() == false && t.getNumberOfSeats() >= guests) {
				t.setStatus(true);
				t.setTableOwner(customer);
				return t.getTableNumber();
			}
		}
				return 0;
	}	
	
	
	default void ReserveTable(int NumberOfTables , ArrayList <Integer> NumberOfSeats, Customer customer)
	{
		Collections.sort(NumberOfSeats);
		
		if (NumberOfTables > 20) //implement exception handling
		{
			System.out.println("Max number of tables is 20");
		}
		else
		{
			for (int i=0; i<NumberOfTables; i++)
			{
				for (Table t : tables)
				{
					if (t.getNumberOfSeats() >= NumberOfSeats.get(0) && t.getStatus() == false)
					{
						t.setStatus(true);
						t.setTableOwner(customer);
						System.out.println("Table " + t.getTableNumber() + " has been reserved, customer of reservation:" + customer.getName());
						NumberOfSeats.remove(0);
					}
					else
					{
						System.out.println("No tables are empty with required number of seats");
					}
				}
			}
		}
	}
	
	
	
	default void DeleteTableReservation(int tablenumber)
	{
		for (Table t : tables)
		{
			if (t.getTableNumber() == tablenumber)
			{
				t.setStatus(false);
				System.out.println("Table " + t.getTableNumber() + "which belongs to customer:"+ t.getTableOwner()+" reservation has been deleted");
			}
		}
	}
	
	
	default void DeleteTableReservation(ArrayList <Integer> TableNumbers)
	{
		for (int i=0; i <TableNumbers.size(); i++)
		{
			for (Table t : tables) 
			{
				if (t.getTableNumber()== TableNumbers.get(0) && t.getStatus() == true)
				{
					t.setStatus(false);
					System.out.println("Table " + t.getTableNumber() + "which belongs to customer:"+ t.getTableOwner()+" reservation has been deleted");
					TableNumbers.remove(0);
				}
				else
				{
					System.out.println("Invalid table ID or No table with such ID is reserved");
				}
			}
		}
	}
	
	
	
	
	
	
}
