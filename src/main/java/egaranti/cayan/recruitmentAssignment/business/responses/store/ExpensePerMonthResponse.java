package egaranti.cayan.recruitmentAssignment.business.responses.store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpensePerMonthResponse {
    private Long employeeExpense;
    private Long totalExpense;
}
