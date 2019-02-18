package com.javaguru.shoppinglist.Validator;

import com.javaguru.shoppinglist.Product;

public class MaxDiscount extends AbstractValidator{
    @Override
    public void validate (Product newProduct){
        if (assertNotNull(newProduct)) {
            if (newProduct.getDiscount().floatValue() > 100) {
                throw new FieldsValidationException ("Discount must be less than 100%");
            }
        }
    }
}
