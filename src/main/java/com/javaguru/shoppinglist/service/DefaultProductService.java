package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.database.InMemoryDatabase;
import com.javaguru.shoppinglist.service.validator.ProductValidator;
import com.javaguru.shoppinglist.database.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultProductService implements ProductService {

    private final InMemoryDatabase database;
    private final ProductValidator productValidator;
@Autowired
    public DefaultProductService(InMemoryDatabase database, ProductValidator productValidator) {
        this.database = database;
        this.productValidator = productValidator;
    }

    public Product findByID(Long id) {
        return database.getByID(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found, id: " + id));
    }

    @Override
    public Long create(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Cannot be null");
        }
        productValidator.validate(product);
        Long response = database.createProduct(product);

        return response;
    }

    public void findAll() {
        database.returnAll();
    }
}
