package com.javaguru.shoppinglist.service.validator;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.database.ProductDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueNameRule implements Validation {

    private final ProductDatabase database;

    @Autowired
    public UniqueNameRule(ProductDatabase database) {
        this.database = database;
    }

    @Override
    public void validate(Product product) {
        if (database.existsByName(product.getName())) {
            throw new FieldValidationException("Product name must be unique.");
        }
    }
}
