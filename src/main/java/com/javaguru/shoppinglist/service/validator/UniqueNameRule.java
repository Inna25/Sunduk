package com.javaguru.shoppinglist.service.validator;

import com.javaguru.shoppinglist.database.InMemoryDatabase;
import com.javaguru.shoppinglist.database.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueNameRule implements Validation{

    private final InMemoryDatabase database;

    @Autowired
    public UniqueNameRule(InMemoryDatabase database) {
        this.database = database;
    }

    @Override
    public void validate(Product product) {
        if (database.existsByName(product.getName())) {
            throw new FieldValidationException("Product name must be unique.");
        }
    }
}
