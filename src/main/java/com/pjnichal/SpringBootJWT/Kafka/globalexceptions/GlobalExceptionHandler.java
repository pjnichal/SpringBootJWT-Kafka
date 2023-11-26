package com.pjnichal.SpringBootJWT.Kafka.globalexceptions;

import com.pjnichal.SpringBootJWT.Kafka.exceptions.UserAlreadyExists;
import com.pjnichal.SpringBootJWT.Kafka.exceptions.UserNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import  com.pjnichal.SpringBootJWT.Kafka.globalexceptions.CustomErrorResponse;
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value
            = UserNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody CustomErrorResponse
    handleUserNotFoundException(UserNotFound ex)
    {
        return new CustomErrorResponse(
                HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }
    @ExceptionHandler(value
            = UserAlreadyExists.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody CustomErrorResponse
    handleUserAlreadyExistsException(UserAlreadyExists ex1)
    {
        System.out.println(ex1);
        System.out.println(ex1.getMessage());
        return new CustomErrorResponse(
                HttpStatus.CONFLICT.value(), ex1.getMessage());
    }
}
