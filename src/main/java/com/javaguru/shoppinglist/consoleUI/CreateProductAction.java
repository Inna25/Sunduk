package com.javaguru.shoppinglist.consoleUI;

import com.javaguru.shoppinglist.database.Product;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.validator.FieldValidationException;

import java.math.BigDecimal;
import java.util.Scanner;

public class CreateProductAction implements Action {

    private static final String ACTION_NAME = "Create Product";

    private final ProductService productService;

    public CreateProductAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        String name;
        BigDecimal price;
        String category;
        BigDecimal discount;
        String description;

        System.out.println("Enter product name: ");
        name = scanner.nextLine();

        System.out.println("Enter product price: ");
        price = correctBigDecimal(scanner.nextLine());

        System.out.println("Enter product category: ");
        category = scanner.nextLine();

        System.out.println("Enter product discount: ");
        discount = correctBigDecimal(scanner.nextLine());

        System.out.println("Enter product description: ");
        description = scanner.nextLine();

        try {
            Product product = new Product();
            product.setName(name);
            product.setPrice(price);
            product.setCategory(category);
            product.setDiscount(discount);
            product.setDescription(description);

            Long response = productService.create(product);
        } catch (FieldValidationException e) {
            System.out.println("Error occured: " + e.getMessage());
        }
    }

    private BigDecimal correctBigDecimal(String stringValue) {
        BigDecimal correctValue;
        if (stringValue == null || stringValue.equals("")){
            correctValue = new BigDecimal(0);
        } else {
            correctValue = new BigDecimal(stringValue);
        }
        return correctValue;
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }

}
