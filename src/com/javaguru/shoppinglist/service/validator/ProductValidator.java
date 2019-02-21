package com.javaguru.shoppinglist.service.validator;

import com.javaguru.shoppinglist.database.Product;

public class ProductValidator extends AbstractValidator {
    private Validation[] validations;

    public ProductValidator(Validation[] validations) {
        this.validations = validations;
    }

    @Override
    public void validate(Product newProduct) {
        if (newProduct == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        for (Validation element : validations) {
            element.validate(newProduct);
        }
    }
}
