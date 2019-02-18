package com.javaguru.shoppinglist.Validator;

import com.javaguru.shoppinglist.Product;

public class ProductValidator extends AbstractValidator{
    private Validation[] validations;

    public ProductValidator(Validation[] validations) {
        this.validations = validations;
    }
    @Override
    public void validate(Product newProduct) {
        //assertNotNull(product);
        if (newProduct == null) {
            throw new IllegalArgumentException("Cannot be null");
        }
        for (Validation element: validations){
            element.validate(newProduct);
        }
    }
}
