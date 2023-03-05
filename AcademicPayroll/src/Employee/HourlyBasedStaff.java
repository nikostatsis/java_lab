package Employee;

import enumerations.WorkingExperience;
import randomize.Randomize;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//Create a public final class named HourlyBasedStaff which extends Academic class
final public class HourlyBasedStaff extends Academic{
	// Declare instance variables
	private WorkingExperience exp;
	private int monthlysalary;
	private int hoursworked;
	private static int totalpay=0;
	private static int totalmembers=0;
	private static int totalhoursworked=0;

	// Constructor to initialize instance variables with given parameters
	public HourlyBasedStaff(int id,int hours) {
		
		// Call the constructor of the super class
		super(id);
		
		// Initialize instance variables
		exp = Randomize.WorkingExperience();
		hoursworked = hours;
		
		// Check if the parameters are valid and update the static variables accordingly
		if(id!=-1 && hours!=-1) {
			totalmembers++;
			totalhoursworked += hoursworked;
			totalpay += CalculateMonthlySalary();
		}
	}

	// Method to calculate monthly salary based on working experience and hours worked
	public int CalculateMonthlySalary() {
		
		// Declare and initialize a variable to store additional salary based on working experience
		int onTopSalary=0;
		
		// Determine the additional salary based on working experience
		if(exp==WorkingExperience.uptoFiveYears) {
			onTopSalary = hoursworked * 10;
		} else if(exp==WorkingExperience.FiveToTenYears) {
			onTopSalary = hoursworked * 20;
		} else if(exp==WorkingExperience.morethanTenYears) {
			onTopSalary = hoursworked * 30;
		}
		
		// Calculate monthly salary by adding additional salary to the base monthly salary
		monthlysalary = basemonthlySalary + onTopSalary;
		
		// Return the monthly salary
		return monthlysalary;			
	}

	// Getter method to get working experience of the hourly based staff
	public WorkingExperience getWorkingExperience() {
		return exp;
	}

	// Method to print information about the hourly based staff
	public void printInfo() {
		
		// Print information to console
		System.out.println("");
		System.out.println("EmployeeID" + super.getEmployeeID() + " hour based employee");
		System.out.println("academic experience " + exp);
		System.out.println("hours worked: " + hoursworked);
		System.out.println("Hourly based employee salary:" + monthlysalary);
	}

	// Method to get statistics about the hourly based staff
	public void getstats(){
		System.out.println("");
		System.out.println("Hourly based employee total pay=" + totalpay);	
		System.out.println("Hourly based employee total members=" + totalmembers);	
		System.out.println("Hourly based employee total hours=" + totalhoursworked);	
	}

	// Method to export information about the hourly based staff to a text file
	public void exportInfoToFile(String filename) throws IOException {
		
		// Create a file object with the given filename
	    File file = new File(filename + ".txt");
	    
	    // Create a file writer object to write to the file in append mode
	    FileWriter fw = new FileWriter(file, true);
	    
	    // Create a print writer object to write to the file
	    PrintWriter pw = new PrintWriter(fw);
	    
	    // Write information about the hourly based staff to the file
	    pw.println("");
	    pw.println("EmployeeID" + super.getEmployeeID() + " hour based employee");
	    pw.println("academic experience " + exp);
	    pw.println("hours worked: " + hoursworked);
	    
	    pw.close();
	    fw.close();
	} 

}
