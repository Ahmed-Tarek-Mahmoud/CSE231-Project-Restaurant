package personClasses;

public class Person {

	private String Name;
	private String Age;
	private String Gender;
	private String ID;
	private String PhoneNumber;
	private String EMail;
	private String Address; 

	public String getName() {
		return Name;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public String getEMail() {
		return EMail;
	}

	public String getAddress() {
		return Address;
	}

	public Person(String name, String age, String gender, String iD, String phoneNumber, String eMail, String address) {
		Name = name;
		Age = age;
		Gender = gender;
		ID = iD;
		PhoneNumber = phoneNumber;
		EMail = eMail;
		Address = address;
	}

	public String PersonInfo() {
		return "[Name:" + Name + ", Age:" + Age + ", Gender:" + Gender + ", ID:" + ID + ", PhoneNumber:"
				+ PhoneNumber + ", EMail:" + EMail + ", Address:" + Address + "]";
	}
	
}