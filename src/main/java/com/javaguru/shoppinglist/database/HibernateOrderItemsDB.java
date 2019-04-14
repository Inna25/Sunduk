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

    public List<Product> findAllProductsByCartId(Long cartId) {
        return sessionFactory.getCurrentSession().createQuery("select p from OrderItems it, Product p join it.shoppingCart s where s.id = :cartId")
                .setParameter("cartId", cartId)
                .list();
    }
}
