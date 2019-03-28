package com.javaguru.shoppinglist.consoleUI;

import com.javaguru.shoppinglist.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OutputAllProducts implements Action {

    private static final String ACTION_NAME = "Get list of products";
    private final DefaultProductService productService;

    @Autowired
    public OutputAllProducts(DefaultProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        productService.findAll();
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
