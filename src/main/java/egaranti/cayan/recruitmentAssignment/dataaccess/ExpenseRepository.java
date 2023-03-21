package egaranti.cayan.recruitmentAssignment.dataaccess;

import egaranti.cayan.recruitmentAssignment.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
