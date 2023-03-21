package egaranti.cayan.recruitmentAssignment.business.requests.employee;

import egaranti.cayan.recruitmentAssignment.enums.RoleEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeRequest {
    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private RoleEnum role;
}
