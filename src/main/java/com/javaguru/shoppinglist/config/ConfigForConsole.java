package com.javaguru.shoppinglist.config;

import com.javaguru.shoppinglist.consoleUI.Action;
import com.javaguru.shoppinglist.consoleUI.ConsoleUI;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ConfigForConsole {
    private final Action createProductAction;
    private final Action findProductByIdAction;
    private final Action outputAllProducts;
    private final Action toExitAction;

    @Autowired

    public ConfigForConsole(Action createProductAction, Action findProductByIdAction, Action outputAllProducts,
                            Action toExitAction) {
        this.createProductAction = createProductAction;
        this.findProductByIdAction = findProductByIdAction;
        this.outputAllProducts = outputAllProducts;
        this.toExitAction = toExitAction;
    }
    @Bean
    ConsoleUI consoleUI() {
        List<Action> actions = new ArrayList<>();
        actions.add(createProductAction);
        actions.add(findProductByIdAction);
        actions.add(outputAllProducts);
        actions.add(toExitAction);
        return new ConsoleUI(actions);
    }
}
