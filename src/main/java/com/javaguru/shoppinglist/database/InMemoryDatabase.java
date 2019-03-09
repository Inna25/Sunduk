package com.javaguru.shoppinglist.database;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InMemoryDatabase {
    private Map<Long, Product> database = new HashMap<>();
    private Long productIdSequence = 0L;

    public Map<Long, Product> getDatabase() {
        return database;
    }

    public long createProduct(Product product) {
        product.setId(productIdSequence);
        database.put(productIdSequence, product);
        return productIdSequence++;
    }

    public Product getByID(Long id) {
        return database.get(id);
    }

}
