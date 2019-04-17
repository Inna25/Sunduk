package com.javaguru.shoppinglist.controller;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.OrderItemDTO;
import com.javaguru.shoppinglist.service.OrderItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order_items")
public class OrderItemsController {

    private final OrderItemService orderItemService;

    public OrderItemsController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @PostMapping
    public ResponseEntity<Product> create (@RequestBody OrderItemDTO orderItemDTO){
        Product product = new Product();
        orderItemService.assignProduct(orderItemDTO);
        return ResponseEntity.ok(product);
    }
}
