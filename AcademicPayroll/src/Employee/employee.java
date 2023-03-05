package Employee;
import java.util.HashMap;
import java.util.LinkedList;


abstract public class employee {
	// The linked list and hash map data structures to store employee nodes
	static private LinkedList<employee> linkedlist=new LinkedList<employee>();
	static private HashMap<Integer,employee> hashmap=new HashMap<Integer,employee>();
	/**
	 * An abstract method that must be implemented by subclasses to print staff information.
	 */
	abstract public void printInfo();

	/**
	 * An abstract method that must be implemented by subclasses to get the employee ID.
	 * @return the employee ID
	 */
	abstract public int getEmployeeID();

	/**
	 * Adds an employee node to the linked list and hash map data structures.
	 * @param x the employee node to add
	 */
	public static void addEmployeeNode(employee x) {
		linkedlist.add(x);
		hashmap.put(x.getEmployeeID(), x);
	}

	/**
	 * Searches for an employee in the hash map data structure by employee ID.
	 * @param id the employee ID to search for
	 * @return the employee node if found, or null if not found
	 */
	public static employee search_with_HashMap(int id) {
		long startTime,estimatedTime;
		startTime=System.currentTimeMillis();
		
		employee tmp=hashmap.get(id);
		estimatedTime=System.currentTimeMillis();
		
		System.out.println("elapsed time:"+(estimatedTime-startTime)+"ms");
		return tmp;
	}

	/**
	 * Searches for an employee in the linked list data structure by index (employee ID).
	 * @param id the employee ID to search for
	 * @return the employee node if found, or null if not found
	 */
	public static employee search_with_linkedList(int id) {
		long startTime,estimatedTime;
		startTime=System.currentTimeMillis();
		
		employee tmp=linkedlist.get(id);
		estimatedTime=System.currentTimeMillis();
		
		System.out.println("elapsed time:"+(estimatedTime-startTime)+"ms");
		return tmp;
	}

}