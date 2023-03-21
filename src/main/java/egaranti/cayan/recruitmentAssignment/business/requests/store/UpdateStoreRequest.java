package egaranti.cayan.recruitmentAssignment.business.requests.store;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStoreRequest {
    @NotNull
    private Long id;

    //This should be @NotNull for now but in the future. Is it not necessary.
    @NotNull
    private String name;
}
