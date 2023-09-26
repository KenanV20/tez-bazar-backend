package com.ads.advertisement.controller.exception;

import com.ads.advertisement.exception.ExceptionDto;
import com.ads.advertisement.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ExceptionDto handle(NotFoundException exception) {
        log.info("ActionLog.handle.error NotFoundException handled");
        return new ExceptionDto(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    List<ExceptionDto> handle(MethodArgumentNotValidException exception){
        List<ExceptionDto> errors= new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach(e->errors.add(new ExceptionDto(e.getDefaultMessage())));
        return  errors;
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionDto paramsValidationHandler(ConstraintViolationException exception) {
        return new ExceptionDto(exception.getMessage());
    }
}
