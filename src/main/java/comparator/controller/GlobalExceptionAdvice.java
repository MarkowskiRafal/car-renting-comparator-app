package comparator.controller;

import comparator.exception.ErrorDetails;
import comparator.exception.ResourceNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.invoke.MethodHandles;

@RestControllerAdvice
public class GlobalExceptionAdvice {

    private static final Logger log = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private static final String ERROR = "error";

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException ex) {
        final ErrorDetails errorDetails = new ErrorDetails(ERROR, ex.getMessage());
        log.error(ex.getMessage(), ex);
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}