package com.example.streamAPI;

import com.example.streamAPI.exception.EmployeeAlreadyExistsException;
import com.example.streamAPI.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;


    public EmployeeServiceImpl(Map<String, Employee> employees) {
        this.employees = employees;
    }

    @Override
    public Employee add(String surname, String lastName, int department, int salary) throws EmployeeAlreadyExistsException {

        Employee newEmployee = new Employee(
                surname,
                lastName,
                department,
                salary

        );

        if (employees.containsKey(getKey(surname, lastName))) {
            throw new EmployeeAlreadyExistsException();
        }

        employees.put(getKey(surname, lastName), newEmployee);
        return newEmployee;
    }

    @Override
    public Employee remove(String surname, String lastName) throws EmployeeNotFoundException {

        if (!employees.containsKey(getKey(surname, lastName))) {
            throw new EmployeeNotFoundException();
        }

        return employees.remove(getKey(surname, lastName));
    }

    @Override
    public Employee find(String surname, String lastName) throws EmployeeNotFoundException {

        if (!employees.containsKey(getKey(surname, lastName))) {
            throw new EmployeeNotFoundException();
        }

        return employees.get(getKey(surname, lastName));
    }

    @Override
    public Collection<Employee> findall() {

        return Collections.unmodifiableCollection(employees.values());

    }



    private String getKey(String surname, String lastName) {
        return (surname + " " + lastName).toLowerCase();
    }
}
