package com.javaguru.shoppinglist.service.validator;

import com.javaguru.shoppinglist.database.Product;

import java.math.BigDecimal;

public class MinPriceValidator implements Validation {
    @Override
    public void validate(Product newProduct) {
        BigDecimal price = newProduct.getPrice();
        if (assertNotNull(price.toString())) {
            minPrice(price);
        } else {
            throw new FieldValidationException("The field Price can't be empty");
        }
    }

    private void minPrice(BigDecimal price) {
        if (price.signum() != 1) {
            throw new FieldValidationException("Price must be more than 0");
        }
    }
}
