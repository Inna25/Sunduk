package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.Validator.*;
import java.util.ArrayList;
import java.util.List;

class ShoppingListApplication {

    public static void main(String[] args) {
        Validation[] validations = new Validation[]{
                new MinPrice(),
                new MaxDiscount(),
                new NameLength()
        };

        ProductValidator productValidator = new ProductValidator(validations);
        ProductService productService = new DefaultProductService(productValidator);

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