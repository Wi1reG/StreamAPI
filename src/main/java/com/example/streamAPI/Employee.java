package com.example.streamAPI;

import java.util.Objects;
import java.util.Objects;
import java.util.Objects;
import java.util.ArrayList;
import java.util.List;


public class Employee {
    private String surname;
    private String lastName;
    private int department;
    private double salary;
    private int id;

    public Employee(String surname, String lastName, int department, int salary) {
        this.surname = surname;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }

    public String getSurname() {
        return surname;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return department == employee.department && salary == employee.salary && id == employee.id && Objects.equals(surname, employee.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, department, salary, id);
    }

    public String toString() {
        return "ID: " + id + ", ФИО: " + surname + " " + lastName + " " + "Отдел: " + department + ", Зарплата: " + salary;
    }


}




