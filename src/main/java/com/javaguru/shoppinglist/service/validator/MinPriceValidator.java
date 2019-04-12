package com.javaguru.shoppinglist.service.validator;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class MinPriceValidator implements Validation {
    private final int MIN_PRICE_LIMIT = 0;

    @Override
    public void validate(Product newProduct) {
        if (newProduct.getPrice().signum() != 1) {
            throw new FieldValidationException("Price must be more than " + MIN_PRICE_LIMIT);
        }
    }
}
