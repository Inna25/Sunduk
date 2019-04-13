package com.javaguru.shoppinglist.service;


import com.javaguru.shoppinglist.database.HibernateShoppingCartDB;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class ShoppingCartService {

    private final HibernateShoppingCartDB shoppingCartDB; //or InMemoryDatabase

    @Autowired
    public ShoppingCartService(HibernateShoppingCartDB shoppingCartDB) {
        this.shoppingCartDB = shoppingCartDB;
    }

    @Transactional
    public Long createShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartDB.createShoppingCart(shoppingCart);
    }

    public ShoppingCart findShoppingCartById(Long shoppingCartId) {
        return shoppingCartDB.getByID(shoppingCartId)
                .orElseThrow(() -> new IllegalArgumentException("Shopping cart with id: " +
                        shoppingCartId + " not found"));
    }
//    public Product findByID(Long id) {
//        return database.getByID(id)
//                .orElseThrow(() -> new IllegalArgumentException("Product not found, id: " + id));
}
