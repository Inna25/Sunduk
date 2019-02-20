package com.javaguru.shoppinglist.database;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDatabase {
    private Map<Long, Product> database = new HashMap<>();
    private Long productIdSequence = 0L;

    public Map<Long, Product> getDatabase() {
        return database;
    }
    //    public InMemoryDatabase(Map<Long, Product> database, Long productIdSequence) {
//        this.database = database;
//        this.productIdSequence = productIdSequence;
//    }

    public long createProduct (Product product){
        product.setId(productIdSequence);
        database.put(productIdSequence, product);
        return productIdSequence++;
    }

}
