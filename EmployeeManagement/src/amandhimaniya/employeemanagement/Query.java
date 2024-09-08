package amandhimaniya.employeemanagement;

public class Query {
	
	public static final String INSERT_EMPLOYEE = 
			"INSERT INTO EmployeeData (employeeId, employeeFirstName, employeeLastName, employeeEmail, employeeMobileNumber) VALUES (?, ?, ?, ?, ?)";
	
	public static final String SELECT_ALL_EMPLOYEE = 
			"SELECT * FROM EmployeeData";
	
	public static final String SELECT_EMPLOYEE_BY_ID = 
			"SELECT * FROM EmployeeData WHERE employeeId = ?";
	
	public static final String UPDATE_EMPLOYEE = 
			"UPDATE EmployeeData SET employeeFirstName = ?, employeeLastName = ?, employeeEmail = ?, employeeMobileNumber = ? WHERE employeeId = ?";
	
	public static final String DELETE_EMPLOYEE =
			 "DELETE FROM EmployeeData WHERE employeeId = ?";

}
