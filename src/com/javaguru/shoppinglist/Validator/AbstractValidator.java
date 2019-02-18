package com.javaguru.shoppinglist.Validator;

import com.javaguru.shoppinglist.Product;

abstract class AbstractValidator implements Validation {
    boolean assertNotNull(Product arg){
        return arg != null;
    }
}
