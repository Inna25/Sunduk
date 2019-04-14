package com.javaguru.shoppinglist.controller;

import com.javaguru.shoppinglist.service.OrderItemService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class OrderItems {

    private final OrderItemService orderItemService;

    public OrderItems(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }
    /*@GetMapping("/{id}")
    public ProductDTO findByID(@PathVariable("id") Long id) {
        Product product = productService.findByID(id);
        return new ProductDTO(product.getId(), product.getName(), product.getPrice(), product.getCategory(),
                product.getDiscount(), product.getDescription());
    }*/
}
