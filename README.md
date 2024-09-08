
# Employee Management System

## Project Overview
The Employee Management System is a Java-based console application that allows users to manage employee data using basic CRUD (Create, Read, Update, Delete) operations. The project uses JDBC for database connectivity with MySQL to perform database operations.

## Project Structure
App.java: The main class where the program execution starts. It allows users to choose between various operations like Create, Read, Update, and Delete.

DataBaseConnection.java: This class is responsible for establishing a connection to the MySQL database.

DataBaseOperations.java: This class handles the CRUD operations such as adding a new employee, updating employee details, deleting an employee, and retrieving employee details.

Employee.java: This class defines the employee structure, including fields like employeeId, first name, last name, email, salary, and mobile number.

Query.java: Contains all the SQL query strings used for the operations.

## Requirements
Java: Ensure Java is installed and configured on your machine.

MySQL: MySQL should be installed and running on your machine.

JDBC Driver: The MySQL JDBC driver should be included in your project.

## How to Run
1. Clone the repository:
    git clone https://github.com/your-username/employee-management-system.git

2. Open the project in your preferred IDE (like IntelliJ IDEA or Eclipse).

3. Set up the database:

Create a MySQL database named Employee.
Create a table EmployeeData using the following SQL script:


    CREATE TABLE EmployeeData (
    employeeId INT PRIMARY KEY,
    employeeFirstName VARCHAR(20),
    employeeLastName VARCHAR(20),
    employeeEmail VARCHAR(100),
    employeeSalary BIGINT,
    employeeMobileNumber BIGINT);

4. Update database connection credentials in the DataBaseConnection.java file:


    
    String url = "jdbc:mysql://localhost:3306/Employee";
    String dbName = "root"; // replace with your database username
    String dbPassword = "yourpassword"; // replace with your database password





5. Run the App.java file. You will be prompted to select an option (Create, Read, Update, Delete).

## Features
Add Employee: Enter employee details (ID, first name, last name, email, salary, mobile number) to add a new employee to the database.

View Employees: Fetch and display all employees stored in the database.

Update Employee: Update an employee's details by entering their ID.

Delete Employee: Delete an employee from the database using their ID.

## Classes and Functions
1. App.java
The main class which accepts user input and calls the relevant methods from DataBaseOperations to perform CRUD operations.

2. DataBaseConnection.java
Handles the MySQL database connection.

    connect(): Connects to the MySQL database.
    getConnection(): Returns the current database connection.

3. DataBaseOperations.java
Handles all the database operations.

    addEmployee(Employee emp): Adds a new employee to the database.
    getAllEmployee(): Retrieves all employees from the database.
    getEmployeeById(int employeeId): Fetches an employee by their ID.
    updateEmployee(Employee emp): Updates employee details in the database.
    deleteEmployee(int employeeId): Deletes an employee from the database.
4. Employee.java
The model class representing an employee.

Constructor: Initializes an employee object with ID, first name, last name, email, salary, and mobile number.

Getters and Setters: Provides access to employee fields.

5. Query.java
Contains SQL queries as constants.

    INSERT_EMPLOYEE: SQL query to insert a new employee.
    SELECT_ALL_EMPLOYEE: SQL query to fetch all employees.
    SELECT_EMPLOYEE_BY_ID: SQL query to fetch an employee by ID.
    UPDATE_EMPLOYEE: SQL query to update an employee’s details.
    DELETE_EMPLOYEE: SQL query to delete an employee by ID.

## Sample Code
### Inserting a New Employee
    Employee employee = new Employee(1, "John", "Doe", "john.doe@example.com", 50000L, 9876543210L);
    dbo.addEmployee(employee);
### Fetching All Employees
    for (Employee emp : dbo.getAllEmployee()) {
    System.out.println(emp);
    }
### Deleting an Employee by ID
    dbo.deleteEmployee(1);


## Dependencies
1. Java
2. MySQL
3. MySQL JDBC Driver

## Future Enhancements
1. Implement more robust error handling and input validation.
2. Create a graphical user interface (GUI) for better user experience.
3. Add search filters and sorting options for employee data.## Color Reference

