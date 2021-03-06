package com.javaguru.shoppinglist.service.validator;

import com.javaguru.shoppinglist.domain.Product;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class NameLengthValidatorTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();
    private NameLengthValidator victim = new NameLengthValidator();
    private Product input;
    private final int MIN_NAME_LENGTH = 3;
    private final int MAX_NAME_LENGTH = 32;

    @Test
    public void shouldThrowExceptionAboutEmpty() {
        input = product(null);
        expectedException.expect(FieldValidationException.class);
        expectedException.expectMessage("The field Product name can't be empty");
        victim.validate(input);
    }

    @Test
    public void shouldThrowExceptionAboutMin() {
        input = product("Ap");
        expectedException.expect(FieldValidationException.class);
        expectedException.expectMessage("The field's Name length must be more than " + MIN_NAME_LENGTH +
                                                 " symbols and less than " + MAX_NAME_LENGTH);
        victim.validate(input);
    }

    @Test
    public void shouldThrowExceptionAboutMax() {
        input = product("Very big - red and beautiful and tasty apple");
        expectedException.expect(FieldValidationException.class);
        expectedException.expectMessage("The field's Name length must be more than " + MIN_NAME_LENGTH +
                                                 " symbols and less than " + MAX_NAME_LENGTH);
        victim.validate(input);
    }

    @Test
    public void shouldValidateSuccess() {
        input = product("Apple");
        victim.validate(input);
    }

    private Product product(String name) {
        Product product = new Product();
        product.setName(name);
        return product;
    }
}