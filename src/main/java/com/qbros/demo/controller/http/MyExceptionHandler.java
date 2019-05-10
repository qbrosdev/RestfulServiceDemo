package com.qbros.demo.controller.http;

import com.qbros.demo.controller.exceptions.ControllerException;
import com.qbros.demo.controller.exceptions.ExceptionResponse;
import com.qbros.demo.service.exceptions.ServerEntityConflictException;
import com.qbros.demo.service.exceptions.ServerEntityNotFoundException;
import com.qbros.demo.service.exceptions.ServerException;
import com.qbros.demo.springstuff.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
@Component
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

    //to not expose sensitive information through exception messages
    private String UNHANDLED_EXCEPTION_MSG = "Unhandled Exception At server :(";
    private String VALIDATION_EXCEPTION_MSG = "invalid client input";

    @ExceptionHandler(value = {ServerException.class})
    protected ResponseEntity<ExceptionResponse> handleServerExceptions(Exception ex) {
        if (ex instanceof ServerEntityNotFoundException) {
            return generateExceptionResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
        } else if (ex instanceof ServerEntityConflictException) {
            return generateExceptionResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
        } else {
            return generateExceptionResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ExceptionHandler(value = {ControllerException.class})
    protected ResponseEntity<ExceptionResponse> handleControllerException(Exception ex) {
        return generateExceptionResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    protected ResponseEntity<ExceptionResponse> handleConflict1(ConstraintViolationException ex) {
        return generateExceptionResponseEntity(VALIDATION_EXCEPTION_MSG + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<ExceptionResponse> handleRemainingExceptions(Exception ex) {
        return generateExceptionResponseEntity(UNHANDLED_EXCEPTION_MSG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
//    protected ResponseEntity<ExceptionResponse> handleConflict2(MethodArgumentNotValidException ex) {
//        return generateExceptionResponseEntity(ex.getMessage(),HttpStatus.BAD_REQUEST);
//    }

    //---------------------------------------------------------------------------------------
    private ResponseEntity<ExceptionResponse> generateExceptionResponseEntity(String message, HttpStatus httpStatus) {
        ExceptionResponse exceptionResponse = generateExceptionResponse(message);
        return new ResponseEntity<>(exceptionResponse, httpStatus);
    }

    private ExceptionResponse generateExceptionResponse(String userErrorMsg) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setUserErrorMsg(userErrorMsg, Utils.getServerTime());
        return exceptionResponse;
    }

}
