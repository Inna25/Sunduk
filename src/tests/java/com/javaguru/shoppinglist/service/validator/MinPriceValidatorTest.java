package com.javaguru.shoppinglist.service.validator;

import com.javaguru.shoppinglist.database.Product;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.math.BigDecimal;

public class MinPriceValidatorTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();
    private MinPriceValidator victim = new MinPriceValidator();
    private Product input;

    @Test
    public void shouldThrowPriceValidationException() {
        input = product(new BigDecimal("0"));
        expectedException.expect(FieldValidationException.class);
        expectedException.expectMessage("Price must be more than 0");
        victim.validate(input);
    }

    @Test
    public void shouldValidateSuccess() {
        input = product(new BigDecimal("5"));
        victim.validate(input);
    }

    private Product product(BigDecimal price) {
        Product product = new Product();
        product.setPrice(price);
        return product;
    }
}