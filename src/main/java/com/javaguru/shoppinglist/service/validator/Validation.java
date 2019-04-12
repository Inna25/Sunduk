package com.javaguru.shoppinglist.service.validator;

import com.javaguru.shoppinglist.domain.Product;

public interface Validation {
    void validate(Product product);

    default boolean assertNotNull(String arg) {
        return arg != null && !arg.isEmpty();
    }
}
