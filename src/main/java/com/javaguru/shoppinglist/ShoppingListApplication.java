package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.database.InMemoryDatabase;
import com.javaguru.shoppinglist.service.DefaultProductService;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.validator.*;
import com.javaguru.shoppinglist.consoleUI.*;

import java.util.ArrayList;
import java.util.List;

class ShoppingListApplication {

    public static void main(String[] args) {
        InMemoryDatabase database = new InMemoryDatabase();
        Validation[] validations = new Validation[]{
                new MinPriceValidator(),
                new MaxDiscountValidator(),
                new NameLengthValidator()
        };

        ProductValidator productValidator = new ProductValidator(validations);
        ProductService productService = new DefaultProductService(database, productValidator);

        Action exitAction = new ExitAction();
        Action createUserAction = new CreateProductAction(productService);
        Action findUserByIdAction = new FindProductByIdAction(productService);

        List<Action> actions = new ArrayList<>();
        actions.add(findUserByIdAction);
        actions.add(createUserAction);
        actions.add(exitAction);

        ConsoleUI ui = new ConsoleUI(actions);
        ui.start();
    }
}