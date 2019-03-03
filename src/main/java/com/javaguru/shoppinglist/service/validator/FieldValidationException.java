package com.javaguru.shoppinglist.service.validator;

public class FieldValidationException extends RuntimeException{
    public FieldValidationException(String message){
        super(message);
    }
}
