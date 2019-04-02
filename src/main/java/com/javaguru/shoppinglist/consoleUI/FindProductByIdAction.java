package com.javaguru.shoppinglist.consoleUI;

import com.javaguru.shoppinglist.database.Product;
import com.javaguru.shoppinglist.service.DefaultProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class FindProductByIdAction implements Action {

    private static final String ACTION_NAME = "Find by ID";

    private final DefaultProductService productService;

    //@Autowired
    public FindProductByIdAction(DefaultProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id: ");
        Long id = scanner.nextLong();

        Product response = productService.findByID(id);
        System.out.println("Response: " + response);
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
