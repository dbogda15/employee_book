package me.dbogda.employee_book.DAO.impl;

import me.dbogda.employee_book.DAO.EmployeeDAO;
import me.dbogda.employee_book.model.City;
import me.dbogda.employee_book.model.Employee;
import me.dbogda.employee_book.utils.HibernateSessionFactoryUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void create(Employee employee) {
        Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession();
      try (session){
          Transaction transaction = session.beginTransaction();
          session.save(employee);
          transaction.commit();
      }
    }

    @Override
    public Employee getEmployeeById(int id) {
        Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession();
        try (session){
            return session.get(Employee.class, id);
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession();
        try(session) {
            return session.createQuery("from Employee").list();
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession();
        try (session){
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    @Override
    public void deleteEmployee(Employee employee) {
        Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession();
        try (session){
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }
}
