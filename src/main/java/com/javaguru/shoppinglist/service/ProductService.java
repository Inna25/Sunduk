package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.database.Product;

public interface ProductService {

    Long create(Product product);

    Product findByID(Long id);

    void findAll();

}
