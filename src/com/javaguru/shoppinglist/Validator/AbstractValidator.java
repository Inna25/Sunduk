package com.javaguru.shoppinglist.Validator;

abstract class AbstractValidator implements Validation {
    boolean assertNotNull(String arg){
        return arg != null && !arg.isEmpty();
    }
}
