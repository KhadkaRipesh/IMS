import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class EMS{
    // Creating ArrayList to store data of employee

    private static List<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EMS obj= new EMS();
        displayTitile();

        while(true){
            displayMenu();
            try{
               int choice=scanner.nextInt();
    
                switch(choice){
                    case 1: 
                        obj.addEmployee(scanner);
                        break;
    
                    case 2:
                        obj.updateEmployee(scanner);
                        break;
    
                    case 3: 
                        obj.viewEmployee();;
                        break;
    
                    case 4: 
                        obj.deleteEmployee(scanner);
                        break;
                    
                    case 5:
                        obj.viewEmployeeDuties();
                        break;

                    case 6:
                        System.out.println("");
                        System.out.println("-----------------------");
                        System.out.println("Exiting the System....");
                        System.out.println("-----------------------");
                        return;
                    
                    default:
                    System.out.println("Invalid Choice. Please choose from the menu.");
                }

            }catch(InputMismatchException e){
                System.out.println("Please enter valid option");
                scanner.nextLine();

            }
        }
    }
    // -----------------Method for displaying title of System-------------------
    public static void displayTitile(){
        System.out.println("");
        System.out.println("==========================================");
        System.out.println("= Welcome to Employee Management System  =");
        System.out.println("==========================================");
    }

    // -----------------Method for displaying the menu options-------------------
    public static void displayMenu(){
        System.out.println("");
        System.out.println("1. Add Employee");
        System.out.println("2. Update Employee");
        System.out.println("3. View Employee");
        System.out.println("4. Delete Employee");        
        System.out.println("5. View Employee Duties");
        System.out.println("6. Exit");        
        System.out.println("");

        System.out.print("Please select an option: ");
    }
    // -----------------Method for adding employee information-------------------

    public  void addEmployee(Scanner scanner){
        System.out.print("Employee ID: ");
        Integer id= scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name= scanner.nextLine();

        System.out.print("Date of Birth: ");
        String DOB= scanner.nextLine();

        System.out.print("Gender: ");
        String gender= scanner.nextLine();

        System.out.print("Position: ");
        String position= scanner.nextLine();

        System.out.print("Department: ");
        String department= scanner.nextLine();

        
        // If staff type is manager add manager to Manager list too.
        if("Manager".equals(position)){
            // Creating object to send data in arraylist
            Manager manager= new Manager(id, name, DOB, gender, position, department);
            employeeList.add( manager);
        }else{
            // Creating object to send data in arraylist
            RegularEmployee employee= new RegularEmployee(id, name, DOB, gender, position, department);
            employeeList.add(employee);
        }

        System.out.println("");
        System.out.println("++++++++++++++++++++++++++++++++");
        System.out.println("+ Employee added successfully. +");
        System.out.println("++++++++++++++++++++++++++++++++");
    }

    // -----------------Method for viewing employee details-------------------

    public void viewEmployee(){
        System.out.println("Employee List");
        System.out.println("___________________________________________");
        for (Employee employee : employeeList) {
            System.out.println("****************************************");
            System.out.println("Employee ID: " + employee.getId());
            System.out.println("Name: " + employee.getName());
            System.out.println("Date of Birth: " + employee.getDob());
            System.out.println("Gender: " + employee.getGender());
            System.out.println("Position: " + employee.getPosition());
            System.out.println("Department: " + employee.getDepartment());
            System.out.println();
            
        }
        System.out.println("___________________________________________");
    }


    // -----------------Method for deleting an employee -------------------

    public void deleteEmployee(Scanner scanner){
        System.out.println("Enter the employee id to delete: ");
        int id=scanner.nextInt();
        scanner.nextLine();

        Iterator<Employee> iterator= employeeList.iterator();

        while(iterator.hasNext()){
            Employee employee = iterator.next();
            if(employee.getId() == id){
                iterator.remove();
                System.out.println("");
                System.out.println("--------------------------------------------");
                System.out.println("Employee id :"+ id+" deleted successfully.");
                System.out.println("--------------------------------------------");
                System.out.println("");
                return;
            }
        }
        System.out.println("");
        System.out.println("-----------------------------");
        System.out.println("Employee with id: "+id+ " not found.");
        System.out.println("-----------------------------");

    }

     // -----------------Method for updateing an employee details -------------------

    public void updateEmployee(Scanner scanner){
        System.out.print("Enter the employee id to edit: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Iterator<Employee> iterator = employeeList.iterator();

        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getId() == id) {
                System.out.println("Editing Employee with ID " + id);
                System.out.print("New Name: ");
                employee.setName(scanner.nextLine());

                System.out.print("New Date of Birth: ");
                employee.setDob(scanner.nextLine());

                System.out.print("New Gender: ");
                employee.setGender(scanner.nextLine());

                System.out.print("New Position: ");
                employee.setPosition(scanner.nextLine());

                System.out.print("New Department: ");
                employee.setDepartment(scanner.nextLine());

                System.out.println("");
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("+ Employee with ID " + id + " has been updated. +");
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");

                return;
            }
        }
        System.out.println("");
        System.out.println("-----------------------------");
        System.out.println("Employee with id: "+id+ " not found.");
        System.out.println("-----------------------------");
    }

     // -----------------Method for viewing an employee -------------------
     public void viewEmployeeDuties() {
        System.out.println("Viewing Employee Duties");
        for (Employee employee : employeeList) {
            System.out.println("_____________________________");
            System.out.println("Employee ID: " + employee.getId());
            System.out.println("Name: " + employee.getName());
            employee.viewDuties();
            System.out.println("_____________________________");
        }
    }
}