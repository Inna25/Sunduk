package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.database.ProductDatabase;
import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.mapper.ProductConverter;
import com.javaguru.shoppinglist.service.validator.ProductValidator;
import com.javaguru.shoppinglist.domain.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultProductService implements ProductService {

    private final ProductDatabase database;
    private final ProductValidator productValidator;
    private final ProductConverter productConverter;

    @Autowired
    public DefaultProductService(ProductDatabase database, ProductValidator productValidator,
                                 ProductConverter productConverter) {
        this.database = database;
        this.productValidator = productValidator;
        this.productConverter = productConverter;
    }

    @Transactional
    public Long create(ProductDTO productDTO) {
        if (productDTO == null) {
            throw new IllegalArgumentException("Cannot be null");
        }
        Product product = productConverter.convert(productDTO);
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
    public List<Product> findAll() {
        return database.findAll()
                .orElseThrow(() -> new IllegalArgumentException("List of products is empty"));
    }

    @Override
    public void updateProduct(ProductDTO productDTO) {
        Product product = productConverter.convert(productDTO);
        database.update(product);
    }

    @Transactional
    @Override
    public void deleteProduct(Long id) {
        database.getByID(id).ifPresent(database::delete);
    }

}
