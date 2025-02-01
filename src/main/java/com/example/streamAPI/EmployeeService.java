package com.example.streamAPI;

import com.example.streamAPI.exception.EmployeeAlreadyExistsException;
import com.example.streamAPI.exception.EmployeeNotFoundException;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String surname, String lastName, int department, int salary) throws EmployeeAlreadyExistsException;

    Employee remove(String surname, String lastName) throws EmployeeNotFoundException;

    Employee find(String surname, String lastName) throws EmployeeNotFoundException;

    Collection<Employee> findall();
}
