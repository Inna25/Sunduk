package com.javaguru.shoppinglist.database;

import java.util.Optional;
import com.javaguru.shoppinglist.database.Product;

public interface ProductDatabase {
    Long createProduct(Product product);
    Optional <Product> getByID(Long id);
    boolean existsByName(String name);
    void returnAll();
}
