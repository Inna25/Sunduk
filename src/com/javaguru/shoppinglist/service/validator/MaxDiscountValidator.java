package com.javaguru.shoppinglist.service.validator;

import com.javaguru.shoppinglist.database.Product;

import java.math.BigDecimal;

public class MaxDiscountValidator implements Validation{

    @Override
    public void validate(Product newProduct) {
        BigDecimal discount = newProduct.getDiscount();
        if (assertNotNull(discount.toString())) {
            maxDiscount(discount);
        }
    }

    private void maxDiscount(BigDecimal discount) {
        if (discount.floatValue() > 100) {
            throw new FieldValidationException("Discount must be less than 100%");
        }
    }

}
