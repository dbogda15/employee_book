package me.dbogda.employee_book.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String first_name;
    private String last_name;
    private String gender;
    private int age;
    private Integer city_id;

    public Employee(){
    }

    public Employee(String first_name, String last_name, String gender, int age, Integer city_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
        this.city_id = city_id;
    }

    public Employee(int id, String first_name, String last_name, String gender, int age, Integer city_id) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
        this.city_id = city_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && age == employee.age && Objects.equals(first_name, employee.first_name) && Objects.equals(last_name, employee.last_name) && Objects.equals(gender, employee.gender) && Objects.equals(city_id, employee.city_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, gender, age, city_id);
    }

    @Override
    public String toString() {
        return getId() + ". " + getFirst_name() + " " +  getLast_name() +
                ", gender: " + getGender() + ", age = " + getAge() + ", city id: " + getCity_id();
    }
}
