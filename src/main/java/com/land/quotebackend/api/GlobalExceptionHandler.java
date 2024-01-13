package com.land.quotebackend.api;

import com.land.quotebackend.excepiton.ErrorMessage;
import com.land.quotebackend.excepiton.QuoteNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {QuoteNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage entityNotFoundException(QuoteNotFoundException ex, HttpServletRequest request) {
        return new ErrorMessage(HttpStatus.NOT_FOUND, Instant.now(), String.format("Data not found with id = %s",ex.getMessage()), request.getRequestURI());
    }
}
