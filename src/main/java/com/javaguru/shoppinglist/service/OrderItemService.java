package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.database.HibernateOrderItemsDB;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.OrderItems;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public Long assignProduct(Long productId, Long shoppingCartId, int count) {
        Product product = productService.findByID(productId);
        ShoppingCart shoppingCart = shoppingCartService.findShoppingCartById(shoppingCartId);
        OrderItems orderItem = new OrderItems();
        orderItem.setProduct(product);
        orderItem.setCount(count);
        orderItem.setShoppingCart(shoppingCart);
        return orderItemsDB.createOrderItem(orderItem);
    }

   //To do
    // public List<Product> allProductsInShoppingCart(Long cartId) {  //OrderItems
       // return orderItemsDB.findAllProductsByCartId(cartId);
    //}
}
