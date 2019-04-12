package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;

import java.util.List;

public interface ProductService {

    Long create(Product product);

    Product findByID(Long id);

    List<Product> findAll();

}
