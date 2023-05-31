package me.dbogda.employee_book.DAO.impl;

import me.dbogda.employee_book.DAO.CityDAO;
import me.dbogda.employee_book.model.City;
import me.dbogda.employee_book.utils.HibernateSessionFactoryUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CityDAOImpl implements CityDAO {
    @Override
    public void create(City city) {
        Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession();
        try (session) {
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        }
    }
        @Override
        public City getCityById(int id) {
            Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession();
            try (session){
                return session.get(City.class, id);
            }
        }

    @Override
    public List<City> getAllCity() {
        Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession();
        try (session){
            return session.createQuery("from City").list();
        }
    }

    @Override
    public void updateCity(City city) {
        Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession();
        try (session){
            Transaction transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();
        }
    }

    @Override
    public void deleteCity(City city) {
        Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession();
        try (session){
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
        }
    }
}
