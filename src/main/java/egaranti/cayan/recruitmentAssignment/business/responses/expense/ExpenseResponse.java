package egaranti.cayan.recruitmentAssignment.business.responses.expense;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseResponse {
    private Long id;
    private String expenseDetails;
    private Long expenseValue;
}
