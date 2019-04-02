package com.javaguru.shoppinglist.consoleUI;

import com.javaguru.shoppinglist.database.Product;
import com.javaguru.shoppinglist.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OutputAllProducts implements Action {

    private static final String ACTION_NAME = "Get list of products";
    private final DefaultProductService productService;

    //@Autowired
    public OutputAllProducts(DefaultProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        System.out.println("Product information:");
        List<Product> response = productService.findAll();
        for (int i=0; i<response.size(); i++) {
            System.out.println(response.get(i));
        }
    }
    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
