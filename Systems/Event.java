package Systems;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Event {

	private String Name;
	private LocalDateTime Date;
	private int tables;
	private int seats;
	private final String Date_Time_Formatter = "yyyy-MM-dd/HH:mm";
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Date_Time_Formatter);
	
	public Event(String Name ,String Date_Time) {
		
		this.Name = Name;
		Date = LocalDateTime.parse(Date_Time,formatter); //Sets the event date with the above format
	}
	
	public LocalDateTime getDate() {
		return Date;
	}


	public void setDate(LocalDateTime date) {
		Date = date;
	}

	protected String getEventDate() {
		return "Event name: " +getName()+ "Event Date: " + Date.toString();
	}
	protected String getName() {
		return Name;
	}

	protected void setName(String name) {
		Name = name;
	}
	
}
