package me.dbogda.employee_book.DAO;

import me.dbogda.employee_book.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    void create(Employee employee);
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployee ();
    void updateEmployeeById(int id, Employee employee);
    void deleteEmployeeById(int id);
}
