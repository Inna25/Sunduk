package com.javaguru.shoppinglist.service.validator;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ProductValidator implements Validation {
    private Validation[] validations;

    @Autowired
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
