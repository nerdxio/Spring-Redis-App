package io.nerd.springredis.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RecordNotFoundExecution.class)
    public ResponseEntity<ExceptionResponse> handleRecordNotFoundException(RecordNotFoundExecution execution, HttpServletRequest request) {
        return new ResponseEntity<ExceptionResponse>(
                new ExceptionResponse(
                        LocalDateTime.now(),
                        HttpStatus.NOT_FOUND,
                        execution.getMessage(),
                        request.getRequestURI()
                ), HttpStatus.NOT_FOUND
        );
    }

}
