package com.javaguru.shoppinglist.database;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

@Component
@Profile("inmemorydb")
public class InMemoryDatabase implements ProductDatabase {
    private Map<Long, Product> database = new HashMap<>();
    private Long productIdSequence = 0L;

    public Map<Long, Product> getDatabase() {
        return database;
    }

    @Override
    public Long createProduct(Product product) {
        product.setId(productIdSequence);
        database.put(productIdSequence, product);
        return productIdSequence++;
    }

    @Override
    public Optional<Product> getByID(Long id) {
        return Optional.ofNullable(database.get(id));
    }

    @Override
    public boolean existsByName(String name) {
        return getDatabase().values().stream().anyMatch(product ->
                product.getName().equalsIgnoreCase(name));
    }

    @Override
    public Optional<List<Product>> findAll() {
        if (database.size() == 0) {
            return Optional.empty();
        } else {
            List<Product> List = new ArrayList<Product>(database.values());
            return Optional.ofNullable(List);
        }
    }

}
