package com.javaguru.shoppinglist.service;

import static org.junit.Assert.*;

import com.javaguru.shoppinglist.database.Product;
import com.javaguru.shoppinglist.database.InMemoryDatabase;
import com.javaguru.shoppinglist.service.validator.ProductValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class DefaultProductServiceTest {

    @Mock
    private InMemoryDatabase database;

    @Mock
    private ProductValidator validationService;

    @InjectMocks
    private DefaultProductService victim;

    @Captor
    private ArgumentCaptor<Product> productCaptor;

    @Test
    public void shouldCreateProduct() {
        Product product = product();
        when(database.createProduct(product)).thenReturn(product.getId());
        Long result = victim.create(product);
        verify(validationService).validate(productCaptor.capture());
        Product captorResult = productCaptor.getValue();
        assertEquals(captorResult, product);
        assertEquals(product.getId(), result);
    }

    @Test
    public void shouldFindProduct() {
        Product product = product();
        when(database.getByID(1L)).thenReturn(product);
        Product result = victim.findByID(1L);
        assertEquals(product(), result);
    }

    private Product product() {
        Product newProduct = new Product();
        newProduct.setId(2L);
        newProduct.setName("Apple");
        newProduct.setPrice(new BigDecimal("5"));
        newProduct.setCategory("Fruit");
        newProduct.setDiscount(new BigDecimal("1"));
        newProduct.setDescription("tasty");
        return newProduct;
    }

}