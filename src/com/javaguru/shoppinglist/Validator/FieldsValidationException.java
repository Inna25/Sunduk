package com.javaguru.shoppinglist.Validator;

public class FieldsValidationException extends RuntimeException{
    public FieldsValidationException(String message){
        super(message);
    }
}
