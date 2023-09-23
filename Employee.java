public class Employee {
    private int id;
    private String name;
    private String dob;
    private String gender;
    private String position;
    private String department; 

    // constructor for creating employee
     public Employee(int id, String name, String dob, String gender, String position, String department) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.position = position;
        this.department = department;
    }

     // Setter methods
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

     public void viewDuties(){
     }
}
