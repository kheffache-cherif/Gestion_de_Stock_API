package com.kheffache.gestionDeStock.handlers;

import com.kheffache.gestionDeStock.Exceptions.EntityNotFondException;
import com.kheffache.gestionDeStock.Exceptions.InvalidEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    /// pour EntityNotFondException
    @ExceptionHandler(EntityNotFondException.class)
    public ResponseEntity<ErrorDto> handleException(EntityNotFondException exception, WebRequest webRequest){


        final HttpStatus notFound = HttpStatus.NOT_FOUND;
        final ErrorDto errorDto =ErrorDto.builder()

                .errorCodes(exception.getErrorCodes())
                .httpCode(notFound.value())
                .message(exception.getMessage())
                .build();
        return  new ResponseEntity<>(errorDto,notFound);



    }
    /// pour InvalidEntityException

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ErrorDto>handleException(InvalidEntityException exception, WebRequest webRequest) {
        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        final ErrorDto errorDto =ErrorDto.builder()
                .errorCodes(exception.getErrorCodes())
                .httpCode(badRequest.value())
                .message(exception.getMessage())
                .build();
        return  new ResponseEntity<>(errorDto,badRequest);


    }
}
