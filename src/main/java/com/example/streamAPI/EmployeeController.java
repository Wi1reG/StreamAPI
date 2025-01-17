package com.example.streamAPI;

import com.example.streamAPI.exception.EmployeeAlreadyExistsException;
import com.example.streamAPI.exception.EmployeeNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employees")

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping ("/add")
    public Employee add (@RequestParam String surname, @RequestParam String lastname, @RequestParam int department, @RequestParam int salary) throws EmployeeAlreadyExistsException {
        return employeeService.add(surname, lastname, department, salary);
    }

    @GetMapping ("/remove")
    public Employee remove (@RequestParam String surname, @RequestParam String lastName) throws EmployeeNotFoundException {
        return employeeService.remove(surname, lastName);
    }

    @GetMapping ("/find")
    public Employee find (@RequestParam String surname, @RequestParam String lastName) throws EmployeeNotFoundException {
        return employeeService.find(surname, lastName);
    }

    @GetMapping("/findall")
    public Collection<Employee> findall (@RequestParam String surname, @RequestParam String lastName) {
        return employeeService.findall();
    }



}
