package egaranti.cayan.recruitmentAssignment.business.requests.store;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddExpenseToStoreRequest {
    @NotNull
    private Long storeId;

    @NotNull
    private String expenseDetails;

    @NotNull
    private Long expenseValue;
}
