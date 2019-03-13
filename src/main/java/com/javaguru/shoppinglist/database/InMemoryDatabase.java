package com.javaguru.shoppinglist.database;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

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

    public Optional<Product> getByID(Long id) {
        return Optional.ofNullable(database.get(id));
    }

    public void returnAll() {
        int countOfProducts = database.size();
        if (countOfProducts == 0) {
            System.out.println("List of products is empty");
        } else {
            List<Product> List = new ArrayList<Product>(database.values());
            System.out.println("Product information:");
            for (int i = 0; i < countOfProducts; i++) {
                System.out.println(List.get(i));
            }
        }
    }

}
