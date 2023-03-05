package Employee;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import enumerations.Bathmida;
import randomize.Randomize;

/**

This class represents a Permanent Staff employee who is an Academic staff member.

It extends the Academic class.
*/
final public class PermanentStaff extends Academic{
	// Fields
	private Bathmida rank; // The academic rank of the permanent staff member
	private int monthlysalary; // The monthly salary of the permanent staff member
	private static int totalpay=0; // The total pay of all permanent staff members
	private static int totalmembers=0; // The total number of permanent staff members

	/**
    Constructor for PermanentStaff class.
    @param id The ID of the employee.
    */
    public PermanentStaff(int id) {
	    super(id); // Calls the constructor of the superclass (Academic)
	    rank = Randomize.Bathmida(); // Assigns a random academic rank to the staff member
	    if(id!=-1) { // If the ID is valid
	    totalmembers++; // Increase the total number of permanent staff members
	    totalpay+=CalculateMonthlySalary(); // Add the monthly salary of the staff member to the total pay of all permanent staff members
	    }
    }

    /**
    Calculates the monthly salary of the permanent staff member based on their academic rank.
    @return The monthly salary of the staff member.
    */
    public int CalculateMonthlySalary() {
	    int onTopSalary=0;
	    // Calculates the additional salary based on the academic rank of the staff member
	    if(rank==Bathmida.Lecturer)onTopSalary=1000;
	    if(rank==Bathmida.Assistant)onTopSalary=1200;
	    if(rank==Bathmida.Associate)onTopSalary=1400;
	    if(rank==Bathmida.Professor)onTopSalary=1500;
	    monthlysalary=basemonthlySalary+onTopSalary; // Adds the additional salary to the base monthly salary of the staff member
	   
	    return monthlysalary;
    }

    /**
    Returns the academic rank of the permanent staff member.
    @return The academic rank of the staff member.
    */
    public Bathmida getBathmida() {return rank;}

    /**
    Prints the information of the permanent staff member.
    */
    public void printInfo() {
	    System.out.println("");
	    System.out.println("EmployeeID "+super.getEmployeeID()+" is permanent");
	    System.out.println("academic rank "+rank);
	    System.out.println("Hourly based employee salary:"+monthlysalary);
    }

/**
    Prints the total pay and total number of permanent staff members.
    */
    public void getstats(){
	    System.out.println("");
	    System.out.println("permanent staff total pay="+totalpay);
	    System.out.println("permanent staff total members="+totalmembers);
    }

/**

    Exports the information of the permanent staff member to a file.

    @param filename The name of the file to export the information to.

    @throws IOException if there is an error writing to the file.
    */
    public void exportInfoToFile(String filename) throws IOException {
	    File file = new File(filename + ".txt"); // Creates a new file object with the given filename
	    FileWriter fw = new FileWriter(file, true); // Creates a new FileWriter object to write to the file, in append mode
	    PrintWriter pw = new PrintWriter(fw); // Creates a new PrintWriter object to write to the file
	
	    // Prints the information of the permanent staff member to the file
	    pw.println("");
	    pw.println("EmployeeID "+super.getEmployeeID()+" is permanent");
	    pw.println("academic rank "+rank);
	    pw.println("Hourly based employee salary:"+monthlysalary);
	    
	    pw.close();
	    fw.close();
	}
}

