package com.javaguru.shoppinglist.config;

import com.javaguru.shoppinglist.consoleUI.Action;
import com.javaguru.shoppinglist.consoleUI.ConsoleUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ConfigForConsole {
    private final Action createProductAction;
    private final Action findProductByIdAction;
    private final Action outputAllProducts;
    private final Action createCartAction;
    private final Action assignProductsAction;
    private final Action toExitAction;

    public ConfigForConsole(Action createProductAction, Action findProductByIdAction, Action outputAllProducts,
                            Action createCartAction, Action assignProductsAction, Action toExitAction) {
        this.createProductAction = createProductAction;
        this.findProductByIdAction = findProductByIdAction;
        this.outputAllProducts = outputAllProducts;
        this.createCartAction = createCartAction;
        this.assignProductsAction = assignProductsAction;
        this.toExitAction = toExitAction;
    }

    @Autowired

    @Bean
    ConsoleUI consoleUI() {
        List<Action> actions = new ArrayList<>();
        actions.add(createProductAction);
        actions.add(findProductByIdAction);
        actions.add(outputAllProducts);
        actions.add(createCartAction);
        actions.add(assignProductsAction);
        actions.add(toExitAction);
        return new ConsoleUI(actions);
    }
}
