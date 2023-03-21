package egaranti.cayan.recruitmentAssignment.business.abstracts;

import egaranti.cayan.recruitmentAssignment.business.requests.employee.CreateEmployeeRequest;
import egaranti.cayan.recruitmentAssignment.business.requests.employee.UpdateEmployeeRequest;
import egaranti.cayan.recruitmentAssignment.entities.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();

    Employee get(Long id);

    void create(CreateEmployeeRequest createEmployeeRequest);

    void delete(Long id);

    void update(UpdateEmployeeRequest updateEmployeeRequest);

    void addToStore(Long employeeId, Long storeId);

    void removeFromStore(Long employeeId, Long storeId);
}
