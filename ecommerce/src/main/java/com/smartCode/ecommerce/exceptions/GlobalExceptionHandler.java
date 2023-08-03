package com.smartCode.ecommerce.exceptions;

import com.smartCode.ecommerce.util.ApiError;
import com.sun.jdi.request.DuplicateRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiError> handleValidationException(HttpServletRequest req, ValidationException e) {
        return buildResponse(HttpStatus.BAD_REQUEST, e.getMessage(), req.getRequestURI());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiError> handleRuntimeExceptionException(HttpServletRequest req, RuntimeException e) {
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "something went wrong", req.getRequestURI());
    }

    @ExceptionHandler(DuplicateRequestException.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<ApiError> handleRuntimeExceptionException(HttpServletRequest req, DuplicateRequestException e) {
        return buildResponse(HttpStatus.CONFLICT, e.getMessage(), req.getRequestURI());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiError> handleResourceNotFoundException(HttpServletRequest req, ResourceNotFoundException e) {
        return buildResponse(HttpStatus.NOT_FOUND, e.getMessage(), req.getRequestURI());
    }

    @ExceptionHandler(VerificationException.class)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ApiError> handleVerificationException(HttpServletRequest req, VerificationException e) {
        return buildResponse(HttpStatus.UNAUTHORIZED, e.getMessage(), req.getRequestURI());
    }

    private ResponseEntity<ApiError> buildResponse(HttpStatus status, String message, String requestURI) {
        Map<String, String> errors = new HashMap<>();
        errors.put("message", message);
        ApiError apiError = new ApiError(status.value(), requestURI, errors);
        return ResponseEntity.status(status).body(apiError);
    }
}
