package PersonClasses;

public class Waiter extends Employee{

	private int TipsEarned=0;
	private int Shift_Hours;
	private int Arrived;
	private int Left;
	private int Salary_Bonus_Cut = 100;
	
	
	public Waiter(String name, String age, String gender, String iD, String phoneNumber, String eMail, String address, String role, String empSysID, int salary, int shift_hours) {
		super(name, age, gender, iD, phoneNumber, eMail, address, role, empSysID, salary);
		this.Shift_Hours=shift_hours;
	}

	
	//calculate salary after bonus and cuts
	public void Salary_update_hours() {
		int Workedhours=Left-Arrived;
		int hours = Workedhours - Shift_Hours;
		super.addSalary(hours*Salary_Bonus_Cut);
	}
	
	//calculate salary after tips
	public void Salary_update_tips() {
		super.addSalary(TipsEarned);
		TipsEarned=0;
	}

	//If needed to change bonus and cut paying
	public void setSalary_Bonus_Cut(int salary_Bonus_Cut) {
		Salary_Bonus_Cut = salary_Bonus_Cut;
	}

	public void setArrived(int arrived) {
		this.Arrived = arrived;
	}

	public void setLeft(int left) {
		Left = left;
	}

	public void setTipsEarned(int tipsEarned) {
		TipsEarned += tipsEarned;
	}

	//If needed to change shift length
	public void setShift_Hours(int shift_Hours) {
		Shift_Hours = shift_Hours;
	}


	public String WaiterInfo() {
		return super.EmployeeInfo() + "\n" + "[TipsEarned=" + TipsEarned + ", Shift_Hours=" + Shift_Hours + "]";
	}
	
	
	
}
