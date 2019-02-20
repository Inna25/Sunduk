package com.javaguru.shoppinglist.service.validator;

abstract class AbstractValidator implements Validation {
    boolean assertNotNull(String arg){
        return arg != null && !arg.isEmpty();
    }
}
