package Employee;

abstract public class Academic extends employee {
	static final int basemonthlySalary=500;
	private int id;
	
	Academic(int Aid){
		this.id=Aid;
	}

	public int CalculateMonthlySalary() {
		return basemonthlySalary;
	}
	abstract public void printInfo();
	public int getEmployeeID() {return id;}
	
}
