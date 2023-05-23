package me.dbogda.employee_book;

import me.dbogda.employee_book.DAO.EmployeeDAO;
import me.dbogda.employee_book.DAO.impl.EmployeeDAOImpl;
import me.dbogda.employee_book.model.Employee;

import java.sql.SQLException;

public class EmployeeBookApplication {
    public static void main(String[] args) throws SQLException {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        //создание и добавление нового сотрудника
        Employee dima = new Employee("Dima", "Tarasov", "male", 37,3);
        employeeDAO.create(dima);
        System.out.println(dima);

        //вывод всех сотрудников
        employeeDAO.getAllEmployee().forEach(System.out::println);

        //редактирование информации о сотруднике по id
        Employee artur = employeeDAO.getEmployeeById(5);
        artur.setFirst_name("Artur");
        employeeDAO.updateEmployeeById(5, artur);
        System.out.println(employeeDAO.getEmployeeById(5));

        //удаление сотрудника по id
        employeeDAO.deleteEmployeeById(8);

        //вывод всех сотрудников
        employeeDAO.getAllEmployee().forEach(System.out::println);

    }
}
