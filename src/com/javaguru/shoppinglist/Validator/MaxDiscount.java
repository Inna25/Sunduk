package com.javaguru.shoppinglist.Validator;

import com.javaguru.shoppinglist.Product;

import java.math.BigDecimal;

public class MaxDiscount extends AbstractValidator{

    @Override
    public void validate (Product newProduct){
        BigDecimal discount = newProduct.getDiscount();
        if (assertNotNull(discount.toString())) {
            maxDiscount(discount);
        }
    }
    private void maxDiscount(BigDecimal discount) {
        if (discount.floatValue() > 100) {
            throw new FieldsValidationException ("Discount must be less than 100%");
        }
    }

}
