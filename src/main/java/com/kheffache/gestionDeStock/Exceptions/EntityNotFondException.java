package com.kheffache.gestionDeStock.Exceptions;

import lombok.Getter;

public class EntityNotFondException extends RuntimeException{
    @Getter
    private ErrorCodes errorCodes;


    public EntityNotFondException(String message) {
        super(message); // pour lever une exception juste avec un  message

    }
    public EntityNotFondException(String message, Throwable cause) {
            super(message, cause);
        }

    public EntityNotFondException(String message,Throwable cause, ErrorCodes errorCodes) {
            super(message, cause);
            this.errorCodes = errorCodes;
        }
        public EntityNotFondException(String message, ErrorCodes errorCodes) {
            super(message);
            this.errorCodes = errorCodes;
        }
    }