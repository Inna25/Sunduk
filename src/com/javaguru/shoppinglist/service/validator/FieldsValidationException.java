package com.javaguru.shoppinglist.service.validator;

public class FieldsValidationException extends RuntimeException{
    public FieldsValidationException(String message){
        super(message);
    }
}
