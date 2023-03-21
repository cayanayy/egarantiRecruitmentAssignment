package egaranti.cayan.recruitmentAssignment.business.concretes;

import egaranti.cayan.recruitmentAssignment.business.abstracts.EmployeeService;
import egaranti.cayan.recruitmentAssignment.business.requests.employee.CreateEmployeeRequest;
import egaranti.cayan.recruitmentAssignment.business.requests.employee.UpdateEmployeeRequest;
import egaranti.cayan.recruitmentAssignment.business.rules.EmployeeBusinessRules;
import egaranti.cayan.recruitmentAssignment.business.rules.StoreBusinessRules;
import egaranti.cayan.recruitmentAssignment.core.utilities.mappers.ModelMapperManager;
import egaranti.cayan.recruitmentAssignment.dataaccess.EmployeeRepository;
import egaranti.cayan.recruitmentAssignment.entities.Employee;
import egaranti.cayan.recruitmentAssignment.entities.Role;
import egaranti.cayan.recruitmentAssignment.entities.Store;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeBusinessRules employeeBusinessRules;
    private final StoreBusinessRules storeBusinessRules;
    private final ModelMapperManager modelMapperManager;
    private final StoreManager storeManager;
    private final RoleManager roleManager;

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee get(Long id) {
        employeeBusinessRules.isEmployeeExists(id);
        return employeeRepository.findById(id).get();
    }

    @Override
    public void create(CreateEmployeeRequest createEmployeeRequest) {
        Employee employee = modelMapperManager.forRequest().map(createEmployeeRequest, Employee.class);

        Role role = new Role();
        role.setRole(createEmployeeRequest.getRole());
        roleManager.assignRoleToEmployee(role);

        employee.setRole(role);
        employee.setStore(null);
        employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
        employeeBusinessRules.isEmployeeExists(id);
        employeeRepository.deleteById(id);
    }

    @Override
    public void update(UpdateEmployeeRequest updateEmployeeRequest) {
        Employee employee = get(updateEmployeeRequest.getId());
        modelMapperManager.forUpdateRequest().map(updateEmployeeRequest, employee);
        employeeRepository.save(employee);
    }

    @Override
    public void addToStore(Long employeeId, Long storeId) {
        storeBusinessRules.isStoreExists(storeId);
        employeeBusinessRules.isEmployeeExists(employeeId);
        employeeBusinessRules.isEmployeeSuitableForAdding(storeId, employeeId);
        Store store = storeManager.get(storeId);
        employeeRepository.addToStore(employeeId, store);
    }

    @Override
    public void removeFromStore(Long employeeId, Long storeId) {
        storeBusinessRules.isStoreExists(storeId);
        employeeBusinessRules.isEmployeeExists(employeeId);
        employeeBusinessRules.isEmployeeSuitableForRemoving(storeId, employeeId);
        employeeRepository.removeFromStore(employeeId);
    }
}
