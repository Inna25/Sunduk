package com.javaguru.shoppinglist.service.validator;

import com.javaguru.shoppinglist.domain.Product;

import org.springframework.stereotype.Component;

@Component
public class NameLengthValidator implements Validation {
    private final int MIN_NAME_LENGTH = 3;
    private final int MAX_NAME_LENGTH = 32;

    @Override
    public void validate(Product newProduct) {
        String productName = newProduct.getName();
        if (assertNotNull(productName)) {
            productNameLength(productName);
        } else {
            throw new FieldValidationException("The field Product name can't be empty");
        }
    }

    private void productNameLength(String productName) {
        if (productName.length() < MIN_NAME_LENGTH || MAX_NAME_LENGTH < productName.length()) {
            throw new FieldValidationException("The field's Name length must be more than " + MIN_NAME_LENGTH +
                    " symbols and less than " + MAX_NAME_LENGTH);
        }
    }

}
