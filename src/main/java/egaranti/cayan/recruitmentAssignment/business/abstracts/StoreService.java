package egaranti.cayan.recruitmentAssignment.business.abstracts;

import egaranti.cayan.recruitmentAssignment.business.requests.store.*;
import egaranti.cayan.recruitmentAssignment.business.responses.store.ExpensePerEmployeeResponse;
import egaranti.cayan.recruitmentAssignment.business.responses.store.ExpensePerMonthResponse;
import egaranti.cayan.recruitmentAssignment.entities.Store;

import java.util.List;

public interface StoreService {
    List<Store> getAll();

    Store get(Long id);

    void create(CreateStoreRequest createStoreRequest);

    void delete(Long id);

    void update(UpdateStoreRequest updateStoreRequest);

    ExpensePerMonthResponse calculateExpensesPerMonth(Long storeId);

    List<ExpensePerEmployeeResponse> calculateExpensesPerEmployee(Long storeId);

    void addExpense(AddExpenseToStoreRequest addExpenseToStoreRequest);
}
