package com.javaguru.shoppinglist.Validator;

import com.javaguru.shoppinglist.Product;

public class ProductValidator extends AbstractValidator{
    private Validation[] validations;

    public ProductValidator(Validation[] validations) {
        this.validations = validations;
    }
    @Override
    public void validate(Product newProduct) {
        if (newProduct == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        for (Validation element: validations){
            element.validate(newProduct);
        }
    }
}
