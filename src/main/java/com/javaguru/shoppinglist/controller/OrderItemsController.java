package com.javaguru.shoppinglist.controller;

import com.javaguru.shoppinglist.domain.OrderItems;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.OrderItemDTO;
import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.service.OrderItemService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order_items")
public class OrderItemsController {

    private final OrderItemService orderItemService;

    public OrderItemsController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }
    /* wrong
    public ProductDTO fff(@PathVariable("id") Long id) {
        List<Product> listOfProducts = orderItemService.allProductsInShoppingCart(id); //OrderItems
        //int size = listOfProducts.size();
        //OrderItems orderItems = listOfProducts.get(0);
        Product product = listOfProducts.get(1);
      //  ProductDTO productDTO = new ProductDTO(product.getId(), product.getName())
        return new ProductDTO(product.getId(), product.getName(), product.getPrice(), product.getCategory(),
                product.getDiscount(), product.getDescription());
       // OrderItemDTO orderItemDTO = new OrderItemDTO(orderItems.getId(), orderItems.getCount());
        //return orderItemDTO;
    }*/

    /*public List<ProductDTO> allProductsInShoppingCart(@PathVariable("id") Long id) { //List<ProductDTO>
        List<Product> listOfProducts = orderItemService.allProductsInShoppingCart(id);
        //int size = listOfProducts.size();
        List<ProductDTO> listOfProductsDTO = new ArrayList<ProductDTO>();

        for (int i = 0; i<listOfProducts.size(); i++) {
            Product product = listOfProducts.get(i);
            ProductDTO productDTO = new ProductDTO(product.getId(), product.getName(),
                    product.getPrice(), product.getCategory(), product.getDiscount(), product.getDescription());
            listOfProductsDTO.add(productDTO);
        }
        return listOfProductsDTO;
    }*/
    /* last version - good
    @GetMapping("/{id}")
    public List<OrderItemDTO> allProductsInShoppingCart(@PathVariable("id") Long id) {
        List<OrderItems> listOfProducts = orderItemService.allProductsInShoppingCart(id);
        List<OrderItemDTO> listOfProductsDTO = new ArrayList<OrderItemDTO>();
        for (int i = 0; i<listOfProducts.size(); i++) {
            OrderItems orderItems = listOfProducts.get(i);
            OrderItemDTO orderItemDTO = new OrderItemDTO(orderItems.getId(), orderItems.getProduct(),
                    orderItems.getCount(), orderItems.getShoppingCart());
            listOfProductsDTO.add(orderItemDTO);
        }
        return listOfProductsDTO;
    }*/

}
