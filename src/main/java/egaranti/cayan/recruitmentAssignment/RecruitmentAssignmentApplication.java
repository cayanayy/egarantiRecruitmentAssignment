package egaranti.cayan.recruitmentAssignment;

import egaranti.cayan.recruitmentAssignment.core.utilities.exceptions.BusinessException;
import egaranti.cayan.recruitmentAssignment.core.utilities.exceptions.ExceptionProblemDetails;
import egaranti.cayan.recruitmentAssignment.core.utilities.exceptions.NotFoundException;
import egaranti.cayan.recruitmentAssignment.core.utilities.exceptions.ValidationProblemDetails;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@SpringBootApplication
@RestControllerAdvice
@EnableJpaAuditing
public class RecruitmentAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecruitmentAssignmentApplication.class, args);
    }

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ExceptionProblemDetails handleNotFoundException(NotFoundException notFoundException) {
        ExceptionProblemDetails exceptionProblemDetails = new ExceptionProblemDetails();
        exceptionProblemDetails.setMessage(notFoundException.getMessage());
        return exceptionProblemDetails;
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ExceptionProblemDetails handleBusinessException(BusinessException businessException) {
        ExceptionProblemDetails exceptionProblemDetails = new ExceptionProblemDetails();
        exceptionProblemDetails.setMessage(businessException.getMessage());
        return exceptionProblemDetails;
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ExceptionProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
        ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
        validationProblemDetails.setMessage("Validation exception! Fields does not satisfy needs.");
        validationProblemDetails.setValidationErrors(new HashMap<>());

        for (FieldError fieldError : methodArgumentNotValidException.getFieldErrors()) {
            validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return validationProblemDetails;
    }
}
