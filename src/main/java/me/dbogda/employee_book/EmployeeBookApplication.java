package me.dbogda.employee_book;

import me.dbogda.employee_book.DAO.CityDAO;
import me.dbogda.employee_book.DAO.EmployeeDAO;
import me.dbogda.employee_book.DAO.impl.CityDAOImpl;
import me.dbogda.employee_book.DAO.impl.EmployeeDAOImpl;
import me.dbogda.employee_book.model.City;
import me.dbogda.employee_book.model.Employee;


import java.sql.SQLException;

public class EmployeeBookApplication {
    public static void main(String[] args) throws SQLException {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        CityDAO cityDAO = new CityDAOImpl();

        //Создание нового города
        City city = new City("London");
        cityDAO.create(city);

        // Создание новых сотрудников из нового города
        Employee employee1 = new Employee("Petr", "Semenov", "male", 19, cityDAO.getCityById(12));
        employeeDAO.create(employee1);

        Employee employee2 = new Employee("Masha", "Semenova", "female", 18, cityDAO.getCityById(12));
        employeeDAO.create(employee2);

        //Удаление города с последующим/каскадным удалением жителей
        cityDAO.deleteCity(cityDAO.getCityById(12));

        //Вывод всех сотрудников и городов
        employeeDAO.getAllEmployee().forEach(System.out::println);
        cityDAO.getAllCity().forEach(System.out::println);

        //Поиск сотрудника/города по id
        System.out.println(employeeDAO.getEmployeeById(18));
        System.out.println(cityDAO.getCityById(4));

        //Список жителей конкретного города
        cityDAO.getCityById(3).getEmployeeList().forEach(System.out::println);
    }
}
