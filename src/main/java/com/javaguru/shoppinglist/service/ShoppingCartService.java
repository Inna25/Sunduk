package com.javaguru.shoppinglist.service;


import com.javaguru.shoppinglist.database.HibernateShoppingCartDB;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class ShoppingCartService {

    private final HibernateShoppingCartDB shoppingCartDB;

    @Autowired
    public ShoppingCartService(HibernateShoppingCartDB shoppingCartDB) {
        this.shoppingCartDB = shoppingCartDB;
    }

    public Long createShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartDB.createShoppingCart(shoppingCart);
    }

    public ShoppingCart findShoppingCartById(Long shoppingCartId) {
        return shoppingCartDB.getByID(shoppingCartId)
                .orElseThrow(() -> new NoSuchElementException("Shopping cart with id: " +
                        shoppingCartId + " not found"));
    }
}
