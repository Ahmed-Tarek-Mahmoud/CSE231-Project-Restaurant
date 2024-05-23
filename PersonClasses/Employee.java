package PersonClasses;

public class Employee extends Person{

	private String Role;  
	private String EmpSysID; 
	private int Salary; 

	
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		this.Role = role;
	}
	
	public String getEmpSysID() {
		return EmpSysID;
	}
	
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		this.Salary = salary;
	}
	
	public void addSalary(int bonus) {
		this.Salary += bonus;
	}
	
	public Employee(String name, String age, String gender, String iD, String phoneNumber, String eMail,
			String address , String role , String empSysID , int salary) {
		super(name, age, gender, iD, phoneNumber, eMail, address);
		this.Role = role;
		this.EmpSysID = empSysID;
		this.Salary = salary;
		// TODO Auto-generated constructor stub
	}
	
	public String EmployeeInfo() {
		return "[Role=" + Role + ", EmpSysID=" + EmpSysID + ", Salary=" + Salary + "]\n" + super.PersonInfo() ;
	}
	
	
	
}