package com.javaguru.shoppinglist.database;

import com.javaguru.shoppinglist.domain.OrderItems;
import com.javaguru.shoppinglist.domain.Product;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public List<OrderItems> findAllProductsByCartId(Long id) {
        return sessionFactory.getCurrentSession().createQuery("select p, count from OrderItem it, Product p join it.shoppingCart s where s.id = :id")
                .setParameter("id", id) //"cartId", cartId
                .list();
    }
}
