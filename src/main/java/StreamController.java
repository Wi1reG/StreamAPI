import com.example.streamAPI.Employee;
import com.example.streamAPI.exception.EmployeeNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departament")

public class StreamController {

    private final StreamService streamService;

    public StreamController(StreamService streamService) {
        this.streamService = streamService;
    }
    
    @GetMapping ("/max-salary")
    public Employee findEmployeeWithMaxSalary (@RequestParam Integer departament) throws EmployeeNotFoundException {
        
        return streamService.findEmployeeWithMaxSalary(departament);
    }

    @GetMapping ("/min-salary")
    public Employee findEmployeeWithMinSalary (@RequestParam Integer departament) throws EmployeeNotFoundException {

        return streamService.findEmployeeWithMinSalary(departament);
    }

    @GetMapping ("/all")
    public Map<Integer, List<Employee>> findEmployees() {

        return streamService.findEmployeeesByDepartamentSortByName();
    }
    
}
