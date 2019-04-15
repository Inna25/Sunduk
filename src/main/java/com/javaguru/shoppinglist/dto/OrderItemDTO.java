package com.javaguru.shoppinglist.dto;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;

public class OrderItemDTO {
    private Long id;
    private Product product;
    private int count;
    private ShoppingCart shoppingCart;

    public OrderItemDTO() {

    }

    public OrderItemDTO(Long id, Product product, int count, ShoppingCart shoppingCart) {
        this.id = id;
        this.product = product;
        this.count = count;
        this.shoppingCart = shoppingCart;
    }

    /*public OrderItemDTO(Long id, int count) {
        this.id = id;
        this.count = count;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {     return product;}

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ShoppingCart getShoppingCart() {return shoppingCart;}

    public void setShoppingCart(ShoppingCart shoppingCart) {this.shoppingCart = shoppingCart;}

}
