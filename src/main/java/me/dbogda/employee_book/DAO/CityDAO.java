package me.dbogda.employee_book.DAO;

import me.dbogda.employee_book.model.City;

import java.util.List;

public interface CityDAO {
    void create(City city);
    void deleteById(int id);
    List<City> getAllCity();
}
