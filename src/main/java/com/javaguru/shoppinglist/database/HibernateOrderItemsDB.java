package com.javaguru.shoppinglist.database;

import com.javaguru.shoppinglist.domain.OrderItems;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class HibernateOrderItemsDB {

    private final SessionFactory sessionFactory;

    public HibernateOrderItemsDB(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long createOrderItem(OrderItems orderItem) {
        sessionFactory.getCurrentSession().save(orderItem);
        return orderItem.getId();
    }
}
