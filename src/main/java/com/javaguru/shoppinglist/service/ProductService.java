package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.database.Product;

import java.util.List;

public interface ProductService {

    Long create(Product product);

    Product findByID(Long id);

    List<Product> findAll();

}
