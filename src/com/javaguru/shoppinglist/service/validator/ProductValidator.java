package com.javaguru.shoppinglist.service.validator;

import com.javaguru.shoppinglist.database.Product;

import java.util.Arrays;

public class ProductValidator implements Validation{
    private Validation[] validations;

    public ProductValidator(Validation[] validations) {
        this.validations = validations;
    }

    @Override
    public void validate(Product newProduct) {
        if (newProduct == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        Arrays.stream(validations).forEach(validation -> validation.validate(newProduct));
    }
}
