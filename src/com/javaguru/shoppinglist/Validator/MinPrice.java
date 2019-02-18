package com.javaguru.shoppinglist.Validator;

import com.javaguru.shoppinglist.Product;

public class MinPrice extends AbstractValidator {
    @Override
    public void validate (Product newProduct){
        if (assertNotNull(newProduct)) {
            if (newProduct.getPrice().signum()!=1) {
                throw new FieldsValidationException ("Price must be more than 0");
            }
        }
    }

}
