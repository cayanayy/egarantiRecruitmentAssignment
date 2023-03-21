package egaranti.cayan.recruitmentAssignment.controllers;

import egaranti.cayan.recruitmentAssignment.business.concretes.EmployeeManager;
import egaranti.cayan.recruitmentAssignment.business.requests.employee.CreateEmployeeRequest;
import egaranti.cayan.recruitmentAssignment.business.requests.employee.UpdateEmployeeRequest;
import egaranti.cayan.recruitmentAssignment.business.responses.employee.EmployeeResponse;
import egaranti.cayan.recruitmentAssignment.core.utilities.mappers.ModelMapperManager;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
@AllArgsConstructor
@CrossOrigin("*")
public class EmployeeController {
    private final EmployeeManager employeeManager;
    private final ModelMapperManager modelMapperManager;

    @GetMapping("/all")
    public List<EmployeeResponse> getEmployees() {
        List<EmployeeResponse> employees = employeeManager.getAll().stream().map(employee -> modelMapperManager.forResponse().map(employee, EmployeeResponse.class)).toList();
        return employees;
    }

    @GetMapping()
    public EmployeeResponse getEmployee(@RequestParam("id") Long id) {
        EmployeeResponse employeeResponse = modelMapperManager.forResponse().map(employeeManager.get(id), EmployeeResponse.class);
        return employeeResponse;
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createEmployee(@Valid @RequestBody CreateEmployeeRequest createEmployeeRequest) {
        employeeManager.create(createEmployeeRequest);
    }

    @DeleteMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteEmployee(@Valid @RequestParam Long id) {
        employeeManager.delete(id);
    }

    @PutMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public void updateEmployee(@Valid @RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
        employeeManager.update(updateEmployeeRequest);
    }
}
