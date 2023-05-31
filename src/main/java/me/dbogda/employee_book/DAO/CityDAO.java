package me.dbogda.employee_book.DAO;

import me.dbogda.employee_book.model.City;

import java.util.List;

public interface CityDAO {
    void create(City city);
    City getCityById(int id);
    List<City> getAllCity();
    void updateCity(City city);
    void deleteCity(City city);
}
