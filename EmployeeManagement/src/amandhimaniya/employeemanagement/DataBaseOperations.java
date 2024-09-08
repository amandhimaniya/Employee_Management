package amandhimaniya.employeemanagement;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseOperations {
    private Connection con;

    // Constructor that initializes the database connection
    public DataBaseOperations() {
        DataBaseConnection dbc = new DataBaseConnection();
        dbc.connect();
        this.con = dbc.getConnection();
    }

    // Method to add a new employee
    public void addEmployee(Employee emp) {
        String sql = Query.INSERT_EMPLOYEE;  // Use the query constant directly
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, emp.getEmployeeId());
            pst.setString(2, emp.getEmployeeFirstName());
            pst.setString(3, emp.getEmployeeLastName());
            pst.setString(4, emp.getEmployeeEmail());
            pst.setLong(5, emp.getEmployeeMobileNumber());  // This should be the 5th parameter (no employeeSalary in the query)

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get all employees
    public ArrayList<Employee> getAllEmployee() {
        String sql = Query.SELECT_ALL_EMPLOYEE;  // Use the query constant
        ArrayList<Employee> employees = new ArrayList<>();
        try (PreparedStatement pst = con.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Employee emp = new Employee(
                    rs.getInt("employeeId"),
                    rs.getString("employeeFirstName"),
                    rs.getString("employeeLastName"),
                    rs.getString("employeeEmail"),
                    rs.getLong("employeeSalary"),  // Assuming salary is Double
                    rs.getLong("employeeMobileNumber")
                );
                employees.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    // Method to get an employee by ID
    public Employee getEmployeeById(int employeeId) {
        Employee emp = null;
        String sql = Query.SELECT_EMPLOYEE_BY_ID;
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, employeeId);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    emp = new Employee(
                        rs.getInt("employeeId"),
                        rs.getString("employeeFirstName"),
                        rs.getString("employeeLastName"),
                        rs.getString("employeeEmail"),
                        rs.getLong("employeeSalary"),
                        rs.getLong("employeeMobileNumber")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }

    // Method to update employee details
    public void updateEmployee(Employee emp) {
        String sql = Query.UPDATE_EMPLOYEE;
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, emp.getEmployeeFirstName());
            pst.setString(2, emp.getEmployeeLastName());
            pst.setString(3, emp.getEmployeeEmail());
            pst.setLong(4, emp.getEmployeeMobileNumber());
            pst.setInt(5, emp.getEmployeeId());  // employeeId comes last in the query

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete an employee by ID
    public void deleteEmployee(int employeeId) {
        String sql = Query.DELETE_EMPLOYEE;
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, employeeId);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
