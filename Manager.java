// extending class to show inheritance relation
public class Manager extends Employee{

	public Manager(int id, String name, String dob, String gender, String position, String department) {
		super(id, name, dob, gender, position, department);
	}
    public void conductMeeting(){
        System.out.println("Manager "+ getName()+ " is conducting meeting.");
    }
    // Overriding the method of Employee class.

    public void viewDuties(){
        System.out.println("Manages the other employee");
    }
    
}
