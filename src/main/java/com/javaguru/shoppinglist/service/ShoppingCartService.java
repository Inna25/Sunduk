package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.database.HibernateShoppingCartDB;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.dto.ShoppingCartDTO;
import com.javaguru.shoppinglist.mapper.ShoppingCartConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartService {

    private final HibernateShoppingCartDB shoppingCartDB;
    private final ShoppingCartConverter shoppingCartConverter;

    @Autowired
    public ShoppingCartService(HibernateShoppingCartDB shoppingCartDB, ShoppingCartConverter shoppingCartConverter) {
        this.shoppingCartDB = shoppingCartDB;
        this.shoppingCartConverter = shoppingCartConverter;
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

    public List<ShoppingCartDTO> findAll() {
        List<ShoppingCart> listOfCarts = shoppingCartDB.findAll()
                .orElseThrow(() -> new IllegalArgumentException("List of products is empty"));
        List<ShoppingCartDTO> listOfCartsDTO = new ArrayList<ShoppingCartDTO>();
        for (int i = 0; i < listOfCarts.size(); i++) {
            ShoppingCartDTO productDTO = shoppingCartConverter.convert(listOfCarts.get(i));
            listOfCartsDTO.add(productDTO);
        }
        return listOfCartsDTO;
    }

    public void updateShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        ShoppingCart shoppingCart = shoppingCartConverter.convert(shoppingCartDTO);
        shoppingCartDB.update(shoppingCart);
    }

    @Transactional
    public void deleteShoppingCart(Long id) {
        shoppingCartDB.getByID(id).ifPresent(shoppingCartDB::delete);
    }
}
