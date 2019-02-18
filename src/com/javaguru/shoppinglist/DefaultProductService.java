package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.Validator.ProductValidator;
import com.javaguru.shoppinglist.Validator.Validation;

import java.util.HashMap;
import java.util.Map;

public class DefaultProductService implements ProductService {

    private Map<Long, Product> database = new HashMap<>();
    private Long PRODUCT_ID_SEQUENCE = 0L;
    private final ProductValidator productValidator;

    public DefaultProductService(ProductValidator productValidator) {
        this.database = database;
        this.PRODUCT_ID_SEQUENCE = PRODUCT_ID_SEQUENCE;
        this.productValidator = productValidator;
    }

    public Product findBy(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must be not null");
        }
        return database.get(id);
    }

    @Override
    public Long create(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Cannot be null");
        }
        productValidator.validate(product);
        product.setId(PRODUCT_ID_SEQUENCE);

        database.put(PRODUCT_ID_SEQUENCE, product);
        return PRODUCT_ID_SEQUENCE++;
    }

}
