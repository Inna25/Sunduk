package com.javaguru.shoppinglist.dto;

public class OrderItemDTO {
    private Long id;
    private Long productId;
    private int count;
    private Long cartId;

    public OrderItemDTO() {

    }

    public OrderItemDTO(Long id, Long productId, int count, Long cartId) {
        this.id = id;
        this.productId = productId;
        this.count = count;
        this.cartId = cartId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }
}
