package egaranti.cayan.recruitmentAssignment.business.responses.store;

import egaranti.cayan.recruitmentAssignment.business.responses.employee.EmployeeResponse;
import egaranti.cayan.recruitmentAssignment.business.responses.expense.ExpenseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreResponse {
    private Long id;
    private String name;
    private List<EmployeeResponse> employees;
    private List<ExpenseResponse> expenses;
}
