package amandhimaniya.employeemanagement;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        DataBaseOperations dbo = new DataBaseOperations();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter Your Choice:");
            System.out.println("1 = Create || 2 = Read || 3 = Update || 4 = Delete || 5 = Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("Enter Employee ID:");
                    int employeeId = sc.nextInt();
                    sc.nextLine(); // Consume newline

                    System.out.println("Enter First Name:");
                    String employeeFirstName = sc.nextLine();

                    System.out.println("Enter Last Name:");
                    String employeeLastName = sc.nextLine();

                    System.out.println("Enter Email:");
                    String employeeEmail = sc.nextLine();

                    System.out.println("Enter Salary:");
                    Long employeeSalary = sc.nextLong();

                    System.out.println("Enter Mobile Number:");
                    Long employeeMobileNumber = sc.nextLong();

                    Employee employee = new Employee(employeeId, employeeFirstName, employeeLastName, employeeEmail,
                            employeeSalary, employeeMobileNumber);
                    dbo.addEmployee(employee);
                    System.out.println("Employee added successfully!");
                    break;
                }
                case 2: {
                    System.out.println("List of all employees:");
                    for (Employee emp : dbo.getAllEmployee()) {
                        System.out.println(emp);
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter Employee ID to update:");
                    int employeeId = sc.nextInt();
                    sc.nextLine(); // Consume newline

                    Employee emp = dbo.getEmployeeById(employeeId);
                    if (emp != null) {
                        System.out.println("Enter new First Name (current: " + emp.getEmployeeFirstName() + "):");
                        String newFirstName = sc.nextLine();

                        System.out.println("Enter new Last Name (current: " + emp.getEmployeeLastName() + "):");
                        String newLastName = sc.nextLine();

                        System.out.println("Enter new Email (current: " + emp.getEmployeeEmail() + "):");
                        String newEmail = sc.nextLine();

                        System.out.println("Enter new Salary (current: " + emp.getEmployeeSalary() + "):");
                        Long newSalary = sc.nextLong();

                        System.out.println("Enter new Mobile Number (current: " + emp.getEmployeeMobileNumber() + "):");
                        Long newMobileNumber = sc.nextLong();

                        // Update the employee details
                        emp.setEmployeeFirstName(newFirstName);
                        emp.setEmployeeLastName(newLastName);
                        emp.setEmployeeEmail(newEmail);
                        emp.setEmployeeSalary(newSalary);
                        emp.setEmployeeMobileNumber(newMobileNumber);

                        dbo.updateEmployee(emp);
                        System.out.println("Employee updated successfully!");
                    } else {
                        System.out.println("Employee not found!");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Enter Employee ID to delete:");
                    int employeeId = sc.nextInt();
                    dbo.deleteEmployee(employeeId);
                    System.out.println("Employee deleted successfully!");
                    break;
                }
                case 5: {
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                }
                default: {
                    System.out.println("Invalid choice. Please try again.");
                    break;
                }
            }
        }
    }
}
