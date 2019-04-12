package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
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

    private final BigDecimal PRICE = new BigDecimal("5");
    private final BigDecimal DISCOUNT = new BigDecimal("1");
    private final long ID = 1;
    private final String PRODUCT_NAME = "Apple";
    private final String CATEGORY = "Fruit";
    private final String DESCRIPTION = "Tasty";

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
        when(database.getByID(ID)).thenReturn(java.util.Optional.ofNullable(product()));
        Product result = victim.findByID(ID);
        assertEquals(product, result);
    }

    private Product product() {
        Product newProduct = new Product();
        newProduct.setId(ID);
        newProduct.setName(PRODUCT_NAME);
        newProduct.setPrice(PRICE);
        newProduct.setCategory(CATEGORY);
        newProduct.setDiscount(DISCOUNT);
        newProduct.setDescription(DESCRIPTION);
        return newProduct;
    }

}