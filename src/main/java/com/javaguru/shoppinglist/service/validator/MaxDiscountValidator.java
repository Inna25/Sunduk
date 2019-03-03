package com.javaguru.shoppinglist.service.validator;

import com.javaguru.shoppinglist.database.Product;

public class MaxDiscountValidator implements Validation {

    @Override
    public void validate(Product newProduct) {
        if (newProduct.getDiscount().floatValue()>100) {
            throw new FieldValidationException("Discount must be less than 100%");
        }
    }
}

