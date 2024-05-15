package Systems;

import personClasses.Customer;

public class Table implements Comparable <Table>{
	private int NumberOfSeats;
	private String TableOwner;
	private int TableNumber ;
	private boolean reserved;
	
	protected Table()
	{
		System.out.println("Error,Can't create a table with no seats"); //to be replaced with exception block later
	}
	
	protected Table(int NumberOfSeats, int TableNumber)  //Param constructor for table
	{
		this.NumberOfSeats = NumberOfSeats;
		this.TableNumber = TableNumber;  
	}
	
	public void setStatus(boolean status)
	{
		this.reserved = status;
	}
	
	public boolean getStatus()
	{
		return reserved;
	}

	protected int getTableNumber() {
		return TableNumber;
	}

	protected int getNumberOfSeats() {
		return NumberOfSeats;
	}


	public String getTableOwner() {
		return TableOwner;
	}

	protected void setTableOwner(Customer customer) {
		this.TableOwner = customer.getName();
	}

	@Override
	public int compareTo(Table o) {
		if (this.getNumberOfSeats() > o.getNumberOfSeats()) {return 1;}
		else if (this.getNumberOfSeats() > o.getNumberOfSeats()) {return -1;}
		else {return 0;}
	}
	
}
