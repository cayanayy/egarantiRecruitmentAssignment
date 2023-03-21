package egaranti.cayan.recruitmentAssignment.business.concretes;

import egaranti.cayan.recruitmentAssignment.business.abstracts.StoreService;
import egaranti.cayan.recruitmentAssignment.business.requests.store.AddExpenseToStoreRequest;
import egaranti.cayan.recruitmentAssignment.business.requests.store.CreateStoreRequest;
import egaranti.cayan.recruitmentAssignment.business.requests.store.UpdateStoreRequest;
import egaranti.cayan.recruitmentAssignment.business.responses.store.ExpensePerEmployeeResponse;
import egaranti.cayan.recruitmentAssignment.business.responses.store.ExpensePerMonthResponse;
import egaranti.cayan.recruitmentAssignment.business.rules.StoreBusinessRules;
import egaranti.cayan.recruitmentAssignment.core.utilities.mappers.ModelMapperManager;
import egaranti.cayan.recruitmentAssignment.dataaccess.StoreRepository;
import egaranti.cayan.recruitmentAssignment.entities.Expense;
import egaranti.cayan.recruitmentAssignment.entities.Store;
import egaranti.cayan.recruitmentAssignment.enums.RoleEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StoreManager implements StoreService {
    private final StoreRepository storeRepository;
    private final StoreBusinessRules storeBusinessRules;
    private final ModelMapperManager modelMapperManager;
    private final ExpenseManager expenseManager;

    @Override
    public List<Store> getAll() {
        return storeRepository.findAll();
    }

    @Override
    public Store get(Long id) {
        storeBusinessRules.isStoreExists(id);
        return storeRepository.findById(id).get();
    }

    @Override
    public void create(CreateStoreRequest createStoreRequest) {
        Store store = modelMapperManager.forRequest().map(createStoreRequest, Store.class);
        storeRepository.save(store);
    }

    @Override
    public void delete(Long id) {
        storeBusinessRules.isStoreExists(id);
        storeRepository.deleteById(id);
    }

    @Override
    public void update(UpdateStoreRequest updateStoreRequest) {
        Store store = get(updateStoreRequest.getId());
        modelMapperManager.forUpdateRequest().map(updateStoreRequest, store);
        storeRepository.save(store);
    }

    @Override
    public ExpensePerMonthResponse calculateExpensesPerMonth(Long storeId) {
        ExpensePerMonthResponse expensePerMonthResponse = new ExpensePerMonthResponse();
        Store store = get(storeId);
        if (!store.getEmployees().isEmpty()) {
            List<Long> employeeExpenses = new ArrayList<>();
            store.getEmployees().stream().forEach(employee -> {
                // Salary is fixed in here for now. But in the future it can be provided from table or something else.
                Long salary = employee.getRole().getRole() == RoleEnum.ADMIN ? 1000L * 2L : 1000L;
                employeeExpenses.add(salary);
            });
            Long employeeExpense = employeeExpenses.stream().mapToLong(Long::longValue).sum();
            expensePerMonthResponse.setEmployeeExpense(employeeExpense);
        } else {
            expensePerMonthResponse.setEmployeeExpense(0L);
        }

        if (!store.getExpenses().isEmpty()) {
            List<Long> expenses = new ArrayList<>();
            store.getExpenses().stream().forEach(expense -> {
                expenses.add(expense.getExpenseValue());
            });
            Long totalExpense = expenses.stream().mapToLong(Long::longValue).sum();
            expensePerMonthResponse.setTotalExpense(totalExpense);
        } else {
            expensePerMonthResponse.setTotalExpense(0L);
        }

        return expensePerMonthResponse;
    }

    @Override
    public List<ExpensePerEmployeeResponse> calculateExpensesPerEmployee(Long storeId) {
        Store store = get(storeId);
        List<ExpensePerEmployeeResponse> expensePerEmployeeResponseList = new ArrayList<>();
        store.getEmployees().stream().forEach(employee -> {
            // Salary is fixed in here for now. But in the future it can be provided from table or something else.
            Long salary = employee.getRole().getRole() == RoleEnum.ADMIN ? 1000L * 2L : 1000L;
            expensePerEmployeeResponseList.add(new ExpensePerEmployeeResponse(employee.getFirstName(), employee.getLastName(), salary));
        });

        return expensePerEmployeeResponseList;
    }

    @Override
    public void addExpense(AddExpenseToStoreRequest addExpenseToStoreRequest) {
        Store store = get(addExpenseToStoreRequest.getStoreId());
        Expense expense = modelMapperManager.forRequest().map(addExpenseToStoreRequest, Expense.class);
        expense.setStore(store);
        expenseManager.add(expense);
    }
}
