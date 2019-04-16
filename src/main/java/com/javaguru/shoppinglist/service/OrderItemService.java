package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.database.HibernateOrderItemsDB;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.OrderItems;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.dto.OrderItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderItemService {
    private final ProductService productService;
    private final ShoppingCartService shoppingCartService;
    private final HibernateOrderItemsDB orderItemsDB;

    @Autowired
    public OrderItemService(ProductService productService, ShoppingCartService shoppingCartService,
                            HibernateOrderItemsDB orderItemsDB) {
        this.productService = productService;
        this.shoppingCartService = shoppingCartService;
        this.orderItemsDB = orderItemsDB;
    }

    public Long assignProduct(OrderItemDTO orderItemDTO) {

        Product product = productService.findByID(orderItemDTO.getProductId());
        ShoppingCart shoppingCart = shoppingCartService.findShoppingCartById(orderItemDTO.getCartId());
        OrderItems orderItem = new OrderItems();
        orderItem.setProduct(product);
        orderItem.setCount(orderItemDTO.getCount());
        orderItem.setShoppingCart(shoppingCart);
        return orderItemsDB.createOrderItem(orderItem);
    }
}
