package com.javaguru.shoppinglist.service.validator;

import com.javaguru.shoppinglist.database.Product;

public class NameLength extends AbstractValidator {
    private final int minNameLength = 3;
    private final int maxNameLength = 32;

    @Override
    public void validate(Product newProduct) {
        String productName = newProduct.getName();
        if (assertNotNull(productName)) {
            productNameLength(productName);
        } else {
            throw new FieldsValidationException("The field Product name can't be empty");
        }
    }

    private void productNameLength(String productName) {
        if (productName.length() < minNameLength || maxNameLength < productName.length()) {
            throw new FieldsValidationException("The field's Name length must be more than 3 symbols and less than 32.");
        }
    }

}
