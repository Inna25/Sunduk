package com.javaguru.shoppinglist.service.validator;

import com.javaguru.shoppinglist.database.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class MaxDiscountValidator implements Validation {
    private final int MIN_DISCOUNT = 0;
    private final int MAX_DISCOUNT = 100;

    @Override
    public void validate(Product newProduct) {
        BigDecimal discount = newProduct.getDiscount();
        if (discount.floatValue()<MIN_DISCOUNT || MAX_DISCOUNT<discount.floatValue()) {
            throw new FieldValidationException("Discount must be more than " + MIN_DISCOUNT +
                    "% and less than " + MAX_DISCOUNT + "%");
        }
    }
}

