package com.javaguru.shoppinglist.service.validator;

import com.javaguru.shoppinglist.database.Product;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

public class MaxDiscountValidatorTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();
    private MaxDiscountValidator victim = new MaxDiscountValidator();
    private Product input;

    @Test
    public void shouldThrowDiscountValidationException() {
        input = product(new BigDecimal("110"));
        expectedException.expect(FieldValidationException.class);
        expectedException.expectMessage("Discount must be less than 100%");
        victim.validate(input);
    }

    @Test
    public void shouldValidateSuccess() {
        input = product(new BigDecimal("5"));
        victim.validate(input);
    }

    private Product product(BigDecimal discount) {
        Product product = new Product();
        product.setDiscount(discount);
        return product;
    }

}