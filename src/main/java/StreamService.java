import com.example.streamAPI.Employee;
import com.example.streamAPI.exception.EmployeeNotFoundException;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface StreamService {
    Employee findEmployeeWithMaxSalary(int departament) throws EmployeeNotFoundException;

    Employee findEmployeeWithMinSalary(int departament) throws EmployeeNotFoundException;

    Map<Integer, List<Employee>> findEmployeeesByDepartamentSortByName();

    Collection<Employee> findEmployeeesByDepartamentSortByName(Integer departament);
}
