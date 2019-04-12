package com.javaguru.shoppinglist.service.validator;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DiscountAvailable implements Validation {
    private final int PRICE_VALUE_FOR_DISCOUNT = 20;

    @Override
    public void validate(Product newProduct) {
        if (newProduct.getPrice().floatValue() < PRICE_VALUE_FOR_DISCOUNT && newProduct.getDiscount()
                .compareTo(BigDecimal.ZERO) != 0) {
            throw new FieldValidationException("For this price discount isn't available.");
        }
    }
}
