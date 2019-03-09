package com.javaguru.shoppinglist.service.validator;

import com.javaguru.shoppinglist.database.Product;

import org.springframework.stereotype.Component;

@Component
public class MinPriceValidator implements Validation {
    @Override
    public void validate(Product newProduct) {
        if (newProduct.getPrice().signum() != 1) {
            throw new FieldValidationException("Price must be more than 0");
        }
    }
}
