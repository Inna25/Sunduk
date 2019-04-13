package com.javaguru.shoppinglist.controller;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.dto.ShoppingCartDTO;
import com.javaguru.shoppinglist.service.ShoppingCartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopping_carts")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping
    public ResponseEntity<ShoppingCart> create(@RequestBody ShoppingCartDTO shoppingCartDTO) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCustomerName(shoppingCartDTO.getCustomerName());
        shoppingCartService.createShoppingCart(shoppingCart);
        return ResponseEntity.ok(shoppingCart);
    }

    @GetMapping("/{id}")
    public ShoppingCartDTO findByID(@PathVariable("id") Long id) {
        ShoppingCart shoppingCart = shoppingCartService.findShoppingCartById(id);
        return new ShoppingCartDTO(shoppingCart.getId(), shoppingCart.getCustomerName());
    }
}
