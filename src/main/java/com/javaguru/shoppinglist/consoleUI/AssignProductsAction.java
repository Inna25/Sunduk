package com.javaguru.shoppinglist.consoleUI;

import com.javaguru.shoppinglist.service.OrderItemService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AssignProductsAction implements Action {

    private static final String ACTION_NAME = "Assign products to shopping cart";

    private final OrderItemService orderItemService;

    AssignProductsAction(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter shopping cart ID:");
        Long shoppingCartId = scanner.nextLong();
        System.out.println("Enter product ID: ");
        Long productId = scanner.nextLong();
        System.out.println("Enter count of product's items: ");
        int count = scanner.nextInt();

        Long response = orderItemService.assignProduct(productId, shoppingCartId, count);
        System.out.println("Products was assigned.");
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
