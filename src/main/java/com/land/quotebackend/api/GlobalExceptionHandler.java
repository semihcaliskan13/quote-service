package com.land.quotebackend.api;

import com.amazonaws.services.acmpca.model.AWSACMPCAException;
import com.land.quotebackend.excepiton.AwsS3BucketNotExist;
import com.land.quotebackend.excepiton.ErrorMessage;
import com.land.quotebackend.excepiton.QuoteNotFoundException;
import com.land.quotebackend.excepiton.RoleNotFoundException;
import com.land.quotebackend.excepiton.UserNotFoundException;
import com.land.quotebackend.excepiton.UserProfileNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {QuoteNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage entityNotFoundException(QuoteNotFoundException ex, HttpServletRequest request) {
        return new ErrorMessage(HttpStatus.NOT_FOUND, Instant.now(), String.format("Data not found with id = %s",ex.getMessage()), request.getRequestURI());
    }

    @ExceptionHandler(value = {UserNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage userNotFoundException(UserNotFoundException ex, HttpServletRequest request){
        return new ErrorMessage(HttpStatus.NOT_FOUND, Instant.now(), String.format(ex.getMessage()),request.getRequestURI());
    }

    @ExceptionHandler(value = {RoleNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage roleNotFoundException(RoleNotFoundException ex, HttpServletRequest request){
        return new ErrorMessage(HttpStatus.NOT_FOUND, Instant.now(), String.format(ex.getMessage()),request.getRequestURI());
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, List<String>>> constraintContentSizeException(MethodArgumentNotValidException ex,HttpServletRequest request){

        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {AwsS3BucketNotExist.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage awsS3BucketNotFoundException(AwsS3BucketNotExist ex, HttpServletRequest request){
        return new ErrorMessage(HttpStatus.NOT_FOUND, Instant.now(), String.format(ex.getMessage()),request.getRequestURI());
    }

    @ExceptionHandler(value = {UserProfileNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage userProfileNotFoundException(UserProfileNotFoundException ex, HttpServletRequest request){
        return new ErrorMessage(HttpStatus.NOT_FOUND, Instant.now(), String.format(ex.getMessage()),request.getRequestURI());
    }

    private Map<String, List<String>> getErrorsMap(List<String> errors) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
}
}
