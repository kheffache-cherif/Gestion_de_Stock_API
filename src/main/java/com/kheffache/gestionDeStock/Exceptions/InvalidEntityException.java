package com.kheffache.gestionDeStock.Exceptions;

import lombok.Getter;

import java.util.List;

public class InvalidEntityException extends RuntimeException{
    @Getter
    private ErrorCodes errorCodes;
    @Getter
    private List<String>errors;



    public InvalidEntityException(String message) {
        super(message); // pour lever une exception juste avec un  message

    }
    public InvalidEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidEntityException(String message,Throwable cause, ErrorCodes errorCodes) {
        super(message, cause);
        this.errorCodes = errorCodes;
    }
    public InvalidEntityException(String message, ErrorCodes errorCodes) {
        super(message);
        this.errorCodes = errorCodes;
    }

    private InvalidEntityException(String message, ErrorCodes errorCodes,List<String> errors){
        super(message);
        this.errorCodes = errorCodes;
        this.errors =errors;


    }

}
