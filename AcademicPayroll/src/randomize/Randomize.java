package randomize;
import java.util.Random;

import enumerations.Bathmida;
import enumerations.StaffType;
import enumerations.WorkingExperience;
/**

The Randomize class provides methods to generate random values used in the program.
*/
public class Randomize {

	/**
    The random number generator used by the class.
    */
    static Random random = new Random();

    /**
    Returns a randomly generated StaffType value.
    @return a randomly generated StaffType value.
    */
    public static StaffType Staff() {
	    int res = random.nextInt(2);
	    if(res==0) {
	    	return StaffType.Permanent;
	    } else {
	    	return StaffType.HourlyBased;
	    }
    }

/**
    Returns a randomly generated Bathmida value.
    @return a randomly generated Bathmida value.
    */
    public static Bathmida Bathmida() {
	    int res = random.nextInt(4);
	    if(res==0) {
	    	return Bathmida.Lecturer;
	    } else if(res==1) {
	    	return Bathmida.Assistant;
	    } else if(res==2) {
	    	return Bathmida.Associate;
	    } else {
	    	return Bathmida.Professor;
	    }
    }

/**
    Returns a randomly generated WorkingExperience value.
    @return a randomly generated WorkingExperience value.
    */
    public static WorkingExperience WorkingExperience() {
	    int res = random.nextInt(3);
	    if(res==0) {
	    	return WorkingExperience.uptoFiveYears;
	    } else if(res==1) {
	    	return WorkingExperience.FiveToTenYears;
	    } else {
	    	return WorkingExperience.morethanTenYears;
	    }
    }

    /**
    Returns a randomly generated number of monthly working hours.
    @return a randomly generated number of monthly working hours.
    */
    public static int MonthlyWorkingHours() {
	    int res = random.nextInt(41);
	    return res;
    }

}
