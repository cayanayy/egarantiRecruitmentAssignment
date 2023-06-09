package egaranti.cayan.recruitmentAssignment.business.responses.employee;

import egaranti.cayan.recruitmentAssignment.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private Long storeId;
    private RoleEnum role;
}
