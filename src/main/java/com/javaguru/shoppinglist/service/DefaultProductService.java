package com.javaguru.shoppinglist.service;

//import com.javaguru.shoppinglist.database.InMemoryDatabase;
import com.javaguru.shoppinglist.database.ProductDatabase;
import com.javaguru.shoppinglist.service.validator.ProductValidator;
import com.javaguru.shoppinglist.database.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultProductService implements ProductService {

    private final ProductDatabase database;
    private final ProductValidator productValidator;

@Autowired
    public DefaultProductService(ProductValidator productValidator, ProductDatabase database) {
        this.productValidator = productValidator;
        this.database = database;
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

    @Override
    public Product findByID(Long id) {
        return database.getByID(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found, id: " + id));
    }

    @Override
    public void findAll() {
        database.returnAll();
    }
}
