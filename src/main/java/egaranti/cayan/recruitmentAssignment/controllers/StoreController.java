package egaranti.cayan.recruitmentAssignment.controllers;

import egaranti.cayan.recruitmentAssignment.business.concretes.EmployeeManager;
import egaranti.cayan.recruitmentAssignment.business.concretes.StoreManager;
import egaranti.cayan.recruitmentAssignment.business.requests.store.AddExpenseToStoreRequest;
import egaranti.cayan.recruitmentAssignment.business.requests.store.CreateStoreRequest;
import egaranti.cayan.recruitmentAssignment.business.requests.store.ManageEmployeeRequest;
import egaranti.cayan.recruitmentAssignment.business.requests.store.UpdateStoreRequest;
import egaranti.cayan.recruitmentAssignment.business.responses.store.ExpensePerEmployeeResponse;
import egaranti.cayan.recruitmentAssignment.business.responses.store.ExpensePerMonthResponse;
import egaranti.cayan.recruitmentAssignment.business.responses.store.StoreResponse;
import egaranti.cayan.recruitmentAssignment.core.utilities.mappers.ModelMapperManager;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/store")
@AllArgsConstructor
@CrossOrigin("*")
public class StoreController {
    private final StoreManager storeManager;
    private final ModelMapperManager modelMapperManager;
    private final EmployeeManager employeeManager;

    @GetMapping("/all")
    public List<StoreResponse> getStores() {
        List<StoreResponse> stores = storeManager.getAll().stream().map(store -> modelMapperManager.forResponse().map(store, StoreResponse.class)).toList();
        return stores;
    }

    @GetMapping()
    public StoreResponse getStore(@RequestParam("id") Long id) {
        StoreResponse storeResponse = modelMapperManager.forResponse().map(storeManager.get(id), StoreResponse.class);
        return storeResponse;
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createStore(@Valid  @RequestBody CreateStoreRequest createStoreRequest) {
        storeManager.create(createStoreRequest);

    }

    @DeleteMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteStore(@Valid @RequestParam("id") Long id) {
        storeManager.delete(id);
    }

    @PutMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public void updateStore(@Valid @RequestBody UpdateStoreRequest updateStoreRequest) {
        storeManager.update(updateStoreRequest);
    }

    @PostMapping(path = "/add-employee")
    @ResponseStatus(code = HttpStatus.OK)
    public void addEmployee(@Valid @RequestBody ManageEmployeeRequest manageEmployeeRequest) {
        employeeManager.addToStore(manageEmployeeRequest.getEmployeeId(), manageEmployeeRequest.getStoreId());
    }

    @PostMapping(path = "/remove-employee")
    @ResponseStatus(code = HttpStatus.OK)
    public void removeEmployee(@Valid @RequestBody ManageEmployeeRequest manageEmployeeRequest) {
        employeeManager.removeFromStore(manageEmployeeRequest.getEmployeeId(), manageEmployeeRequest.getStoreId());
    }

    @GetMapping(path = "/expense/per-month")
    public ExpensePerMonthResponse calculateExpensePerMonth(@RequestParam("storeId") Long storeId) {
        return storeManager.calculateExpensesPerMonth(storeId);
    }

    @GetMapping(path = "/expense/per-employee")
    public List<ExpensePerEmployeeResponse> calculateExpensesPerEmployee(@RequestParam("storeId") Long storeId) {
        return storeManager.calculateExpensesPerEmployee(storeId);
    }

    @PostMapping(path = "/expense")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addExpenseToStore(@Valid @RequestBody AddExpenseToStoreRequest addExpenseToStoreRequest) {
        storeManager.addExpense(addExpenseToStoreRequest);
    }
}
