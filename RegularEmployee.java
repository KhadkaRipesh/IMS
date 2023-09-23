public class RegularEmployee extends Employee {

	public RegularEmployee(int id, String name, String dob, String gender, String position, String department) {
		super(id, name, dob, gender, position, department);
		
	}
      public void viewDuties(){
        System.out.println("Performed office tasks.");
    }
    
}
