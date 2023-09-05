package com.example.backendjavaprojectemployee.exception;

import com.example.backendjavaprojectemployee.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntity extends ResponseEntityExceptionHandler {

    @ExceptionHandler(KaryawanException.class)
    public ResponseEntity<ErrorMessage> departmentNotFoundException(KaryawanException exception, WebRequest request){
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,
                exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
