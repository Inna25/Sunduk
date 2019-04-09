package com.javaguru.shoppinglist.consoleUI;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.service.ShoppingCartService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CreateCartAction implements Action {

    private static final String ACTION_NAME = "Create shopping cart";

    private final ShoppingCartService shoppingCartService;

    public CreateCartAction(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter customer name:");
        String customerName = scanner.nextLine();

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCustomerName(customerName);

        Long response = shoppingCartService.createShoppingCart(shoppingCart);
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
