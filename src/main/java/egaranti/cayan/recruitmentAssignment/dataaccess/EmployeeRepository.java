package egaranti.cayan.recruitmentAssignment.dataaccess;

import egaranti.cayan.recruitmentAssignment.entities.Employee;
import egaranti.cayan.recruitmentAssignment.entities.Store;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Employee employee SET employee.store = ?2 WHERE employee.id = ?1")
    void addToStore(Long employeeId, Store store);

    @Transactional
    @Modifying
    @Query("UPDATE Employee employee SET employee.store = null WHERE employee.id = ?1")
    void removeFromStore(Long employeeId);
}
