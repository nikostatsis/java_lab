
// Import necessary packages
import java.io.IOException;
import java.util.Scanner;

// Import classes from other files
import enumerations.StaffType;
import randomize.Randomize;
import Employee.HourlyBasedStaff;
import Employee.PermanentStaff;
import Employee.employee;

// Define the MainClass
public class MainClass {
	// Main method that is executed when the program is run
	public static void main(String[] args) {
		
		// Print a greeting message to the console
		System.out.println("HELLO PROJECT WEEK4");
		
		// Create 1000 randomized employees
		int nOf=1000;
		creatRandomizedEmployees(nOf);	
		
		// Ask the user to enter an employee ID to search for
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter employee ID to search: ");
		int searchemployeeID = scanner.nextInt();
		scanner.close();
		// Search for the employee with the specified ID using a linked list
		System.out.println("\n\nSearch with Linked List for Employee with id:"+searchemployeeID);
		employee x=employee.search_with_linkedList(searchemployeeID);
		x.printInfo();
		
		// Search for the employee with the specified ID using a hash map
		System.out.println("\nSearch with Hash Mapfor Employee with id:"+searchemployeeID);
		x=employee.search_with_HashMap(searchemployeeID);
		x.printInfo();
	}

	// Method to create a specified number of randomized employees
	public static void creatRandomizedEmployees(int k) {
		System.out.println("Creating "+k+" randomized employees");
		
		// Loop k times to create k randomized employees
		for(int i=0;i<k;i++) {
			
			// Randomly determine whether the employee should be permanent or hourly-based
			StaffType staff=Randomize.Staff();
			
			// If the employee is permanent, create a PermanentStaff object
			if(staff==StaffType.Permanent) {
				PermanentStaff pstaff=new PermanentStaff(i);
				
				// Add the employee to the employee linked list
				employee.addEmployeeNode(pstaff);
				
				// Calculate the employee's monthly salary and print their information to the console
				pstaff.CalculateMonthlySalary();
				pstaff.printInfo();
				
				// Export the employee's information to a file named "permanent staff"
		          try {
		                pstaff.exportInfoToFile("permanent staff");
		            } catch (IOException e) {
		                System.err.println("Error exporting permanent staff information to file: " + e.getMessage());
		            }
			}
			
			// If the employee is hourly-based, create a HourlyBasedStaff object
			else if(staff==StaffType.HourlyBased) {
				int hours= Randomize.MonthlyWorkingHours();
				HourlyBasedStaff hstaff=new HourlyBasedStaff(i,hours);
				
				// Add the employee to the employee linked list
				employee.addEmployeeNode(hstaff);
				
				// Calculate the employee's monthly salary and print their information to the console
				hstaff.CalculateMonthlySalary();
				hstaff.printInfo();
				
				// Export the employee's information to a file named "hourly staff"
	            try {
	                hstaff.exportInfoToFile("hourly staff");
	            } catch (IOException e) {
	                System.err.println("Error exporting hourly staff information to file: " + e.getMessage());
	            }
			}
		}
	}

}