package be.ucll.da.doctorservice.web;

import be.ucll.da.doctorservice.api.model.ApiError;
import be.ucll.da.doctorservice.domain.NoFieldOfExpertiseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({NoFieldOfExpertiseException.class})
    public ResponseEntity<ApiError> handleNoFieldOfExpertiseException() {
        ApiError error = new ApiError();
        error.setCode("12");
        error.setMessage("FieldOfExpertise should not be empty");

        return ResponseEntity.badRequest().body(error);
    }
}
