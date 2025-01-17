import com.example.streamAPI.Employee;
import com.example.streamAPI.EmployeeService;
import com.example.streamAPI.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@Service
public class StreamServiceImpl implements StreamService {

    private final EmployeeService employeeService;


    public StreamServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findEmployeeWithMaxSalary(int departament) throws EmployeeNotFoundException {

        return employeeService
                .findall()
                .stream()
                .filter(e -> e.getDepartment() == departament)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);

    }

    @Override
    public Employee findEmployeeWithMinSalary(int departament) throws EmployeeNotFoundException {
        return employeeService
                .findall()
                .stream()
                .filter(e -> e.getDepartment() == departament)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Map<Integer, List<Employee>> findEmployeeesByDepartamentSortByName() {

        return employeeService
                .findall()
                .stream()
                .collect(groupingBy(Employee::getDepartment));

    }

    @Override
    public Collection<Employee> findEmployeeesByDepartamentSortByName (Integer departament) {

        return employeeService
                .findall()
                .stream()
                .filter(e -> e.getDepartment() == departament)
                .collect(toList());
    }
}




