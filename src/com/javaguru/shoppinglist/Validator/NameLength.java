package com.javaguru.shoppinglist.Validator;

import com.javaguru.shoppinglist.Product;

public class NameLength extends AbstractValidator{
    @Override
    public void validate (Product newProduct){
        if (assertNotNull(newProduct)) {
            int nameLength = newProduct.getName().length();
            if (nameLength < 3 || 32 < nameLength) {
                throw new FieldsValidationException ("The field's Name length must be more than 3 symbols and less than 32.");
            }
        }
    }
}
