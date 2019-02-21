package com.javaguru.shoppinglist.service.validator;

import com.javaguru.shoppinglist.database.Product;

import java.math.BigDecimal;

public class MinPrice extends AbstractValidator {
    @Override
    public void validate(Product newProduct) {
        BigDecimal price = newProduct.getPrice();
        if (assertNotNull(price.toString())) {
            minPrice(price);
        } else {
            throw new FieldsValidationException("The field Price can't be empty");
        }
    }

    private void minPrice(BigDecimal price) {
        if (price.signum() != 1) {
            throw new FieldsValidationException("Price must be more than 0");
        }
    }
}
