package egaranti.cayan.recruitmentAssignment.business.rules;

import egaranti.cayan.recruitmentAssignment.core.utilities.exceptions.BusinessException;
import egaranti.cayan.recruitmentAssignment.core.utilities.exceptions.NotFoundException;
import egaranti.cayan.recruitmentAssignment.dataaccess.EmployeeRepository;
import egaranti.cayan.recruitmentAssignment.entities.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeBusinessRules {
    private EmployeeRepository employeeRepository;

    public void isEmployeeExists(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new NotFoundException("Employee does not exits!");
        }
    }

    public void isEmployeeSuitableForAdding(Long storeId, Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        if (employee.getStore() != null) {
            if (employee.getStore().getId().equals(storeId)) {
                throw new BusinessException("This employee already working for this store!");
            } else {
                throw new BusinessException("This employee is already working at an other store");
            }
        }
    }

    public void isEmployeeSuitableForRemoving(Long storeId, Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        if (!employee.getStore().getId().equals(storeId)) {
            throw new BusinessException("This employee is not working at this store!");
        }
    }
}
