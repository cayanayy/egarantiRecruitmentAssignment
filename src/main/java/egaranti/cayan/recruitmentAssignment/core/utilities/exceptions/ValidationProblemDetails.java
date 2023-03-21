package egaranti.cayan.recruitmentAssignment.core.utilities.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationProblemDetails extends ExceptionProblemDetails {
    private Map<String, String> validationErrors;
}
