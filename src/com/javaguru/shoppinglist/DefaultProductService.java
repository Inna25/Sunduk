package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.Validator.ProductValidator;

import java.util.HashMap;
import java.util.Map;

public class DefaultProductService implements ProductService {

    private Map<Long, Product> database = new HashMap<>();
    private Long productIdSequence = 0L;
    private final ProductValidator productValidator;

    public DefaultProductService(ProductValidator productValidator) {
        this.database = database;
        this.productIdSequence = productIdSequence;
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
        product.setId(productIdSequence);

        database.put(productIdSequence, product);
        return productIdSequence++;
    }

}
