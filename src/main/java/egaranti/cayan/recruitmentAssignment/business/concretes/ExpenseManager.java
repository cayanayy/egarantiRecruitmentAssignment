package egaranti.cayan.recruitmentAssignment.business.concretes;

import egaranti.cayan.recruitmentAssignment.business.abstracts.ExpenseService;
import egaranti.cayan.recruitmentAssignment.dataaccess.ExpenseRepository;
import egaranti.cayan.recruitmentAssignment.entities.Expense;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExpenseManager implements ExpenseService {
    private final ExpenseRepository expenseRepository;

    @Override
    public void add(Expense expense) {
        expenseRepository.save(expense);
    }
}
