package egaranti.cayan.recruitmentAssignment.business.requests.employee;

import egaranti.cayan.recruitmentAssignment.enums.RoleEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeRequest {
    @NotNull
    private Long id;

    private String firstName;

    private String lastName;

    private RoleEnum role;
}
