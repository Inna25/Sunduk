package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    Long create(ProductDTO productDTO);

    Product findByID(Long id);

    List<ProductDTO> findAll();

    void deleteProduct(Long id);

    void updateProduct(ProductDTO productDTO);
}
